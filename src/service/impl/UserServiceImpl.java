package service.impl;

import bean.*;
import dao.*;
import dao.impl.RechargeDaoImpl;
import service.UserService;
import bean.OrderBean;
import bean.RechargeBean;
import bean.RelationshipBean;
import bean.UserBean;
import dao.RechargeDao;
import dao.UserDao;
import dao.impl.RechargeDaoImpl;
import dao.impl.RelationshipDaoImpl;
import dao.impl.UserDaoImpl;
import bean.UserBean;
import service.UserService;
import util.DateUtil;
import util.Factory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.LockSupport;

/**
 * Create by czq
 * time on 2019/7/26  14:33
 */
public class UserServiceImpl implements UserService {
    UserDaoImpl userDao;
    RechargeDaoImpl rechargeDao;
    RelationshipDaoImpl relationshipDao;

    OrderDao orderDao = null;
    UserDao userDao = null;
    MessageDao messageDao = null;
    PlayerDao playerDao = null;
    LoveGameDao loveGameDao = null;
    RelationshipDao relationshipDao = null;

    public UserServiceImpl() {
        orderDao = Factory.getInstance("orderDao", OrderDao.class);
        userDao = Factory.getInstance("userDao", UserDao.class);
        messageDao = Factory.getInstance("message", MessageDao.class);
        playerDao = Factory.getInstance("playerDao", PlayerDao.class);
        loveGameDao = Factory.getInstance("loveGameDao", LoveGameDao.class);
        relationshipDao = Factory.getInstance("relationshipDao", RelationshipDao.class);
    }

    @Override
    public boolean regiser(String name, String passWord, String phone, String qq, String code) {
        return false;
    }

    @Override
    public boolean login(String name, String passWord, String code) {
        return false;
    }

    /**
     * 订单
     *
     * @param player
     * @param
     * @return
     * @author czq
     */
    @Override
    public boolean takeOrder(UserBean user, PlayerBean player, OrderBean order) {

        //1.0给陪玩发送订单请求
        //用户点击订单请求的时候发送给陪玩的消息
        String info = "客户" + user.getStaffName() + "提交了订单请求，请读阅~";

        //创建消息对象存入消息表
        MessageBean message = new MessageBean(player.getPlayerID(), player.getStaffName(), info, 0, 1);

        //放回值是刚刚插入消息的id
        messageDao.addMessage(message);

        //添加订单信息
        orderDao.saveOrder(order);
        return false;
    }

    /**
     * @param order
     * @return
     * @author czq
     */
    @Override
    public boolean addMyOrder(OrderBean order) {
        UserBean userBean = userDao.selectUserByUserID(order.getUserID());
        PlayerBean player = playerDao.selectPlayById(order.getPlayerID());
        String info = "陪玩" + player.getStaffName() + "接收了您的订单请求，祝你游戏愉快~";
        MessageBean message = new MessageBean(player.getPlayerID(), player.getStaffName(), info, 0, 1);
        orderDao.upDateOrder(order);
        if (order.getPayWay() == 2) {
            userBean.setPrice(userBean.getPrice() + order.getPrice());
            userBean.setMoney(userBean.getMoney() - order.getPrice());
        } else if (order.getPayWay() == 1) {
            userBean.setPrice(userBean.getPrice() + order.getPrice());
        }
        userDao.updateUser(userBean);
        messageDao.addMessage(message);
        return false;
    }

    /**
     * @param order
     * @return
     * @author czq
     */
    @Override
    public boolean delOrder(OrderBean order) {
        OrderDao orderDao = Factory.getInstance("orderDao", OrderDao.class);
        orderDao.delOrder(order);
        return false;
    }

    /**
     * 有了订单才可以评论
     *
     * @return
     * @author czq
     */
    @Override
    public boolean comment() {
        return false;
    }

    /*
     * 充值方法
     * */
    @Override
    public boolean recharge(RechargeBean recharge, UserBean user, double rechargeMoney) {
        boolean flag = false;
        double money = userDao.selectMoneyById(user.getId());//先查询账户余额
        rechargeDao.saveRecharge(rechargeMoney, recharge);//插入一条充值记录
        double money1 = rechargeDao.selectMoneyById(user.getId());//查找充值表中的金额
        user.setMoney(money + money1);//User对象里将money修改
        if (userDao.updateMoneyById(user) == true) {
            System.out.println("充值成功");
            flag = true;
        } else {
            System.out.println("充值失败");
        }
        return flag;
    }

    /*
     *增加关注
     * */
    @Override
    public boolean addFocous(String staffName, RelationshipBean relationship) {
        int status = relationshipDao.selectStatusById(relationship);//先查询是否被关注
        if (status == 0) {
            System.out.println("已关注");
            return true;
        } else {
            relationship.setStatus(0);//将其设置为关注状态
            boolean flag = relationshipDao.updateRelationShip(staffName, relationship);
            System.out.println("将其添加为关注状态：" + flag);
            return flag;
        }
    }

    /*
     * 移除关注
     * */
    @Override
    public boolean removeFocous(String staffName, RelationshipBean relationship) {
        int status = relationshipDao.selectStatusById(relationship);//先查询是否被关注
        if (status == 0) {
            System.out.println("已关注");
            relationshipDao.delRelationShip(staffName, relationship);
            return true;
        } else {
            System.out.println("你未关注该陪玩");
        }
        return false;
    }

    @Override
    public List<OrderBean> selectOrders(String userName) {
        List<OrderBean> list = orderDao.selectOrdersByUser(userName);
        return list;
    }

    @Override
    public List<OrderBean> selectIncome(String player) {
        List<OrderBean> list = orderDao.selectOrdersByPlayer(player);
        return list;
    }

    @Override
    public boolean changePsw(UserBean userBean) {
        boolean flag = userDao.updateUser(userBean);
        return flag;
    }

    @Override
    public boolean bePlayer(UserBean userBean, PlayerBean playerBean) {
        userDao.updateUser(userBean);
        boolean flag = playerDao.savePlayer(playerBean);
        return flag;
    }

    @Override
    public boolean modefyInfo(UserBean userBean) {
        Boolean flag = userDao.updateUser(userBean);
        return flag;
    }

    @Override
    public boolean addLoveGames(LoveGameBean loveGameBean) {
        boolean b = loveGameDao.addLoveGame(loveGameBean.getStaffName(), loveGameBean);
        return b;
    }

    @Override
    public boolean removeLoveGames(LoveGameBean loveGameBean) {
        boolean b = loveGameDao.delLoveGame(loveGameBean.getStaffName(), loveGameBean);
        return b;
    }

    @Override
    public boolean addBlackList(RelationshipBean relationshipBean) {
        RelationshipBean result = relationshipDao.selectRelationshipByStatus(relationshipBean.getStaffName(), relationshipBean.getPlayerName(), relationshipBean.getStatus());
        boolean black = false;
        if (!result.equals("")) {
            if (result.getStatus() == 0) {
                boolean b = relationshipDao.updateRelationShip(relationshipBean.getStaffName(), relationshipBean);
                return b;
            } else {
                System.out.println("你已经拉黑了给主播");
            }
        } else {
            boolean b = relationshipDao.addRelationShip(relationshipBean.getStaffName(), relationshipBean);
            return b;
        }
        return black;
    }

    @Override
    public boolean removeBlackList(RelationshipBean relationshipBean) {
        boolean result = relationshipDao.delRelationShip(relationshipBean.getStaffName(), relationshipBean);
        return result;
    }

}
