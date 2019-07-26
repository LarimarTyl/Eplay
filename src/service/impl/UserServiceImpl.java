package service.impl;

import bean.MessageBean;
import bean.OrderBean;
import bean.PlayerBean;
import bean.UserBean;
import dao.MessageDao;
import dao.OrderDao;
import dao.PlayerDao;
import dao.UserDao;
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
    OrderDao orderDao = null;
    UserDao userDao = null;
    MessageDao messageDao = null;
    PlayerDao playerDao = null;

    public UserServiceImpl() {
        orderDao = Factory.getInstance("orderDao", OrderDao.class);
        userDao = Factory.getInstance("userDao", UserDao.class);
        messageDao = Factory.getInstance("message", MessageDao.class);
        playerDao = Factory.getInstance("playerDao", PlayerDao.class);
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
    public boolean comment(OrderBean order) {
        OrderDao orderDao = Factory.getInstance("orderDao", OrderDao.class);
        orderDao.upDateOrder(order);
        return false;
    }

    @Override
    public boolean recharge() {
        return false;
    }

    @Override
    public boolean addFocous() {
        return false;
    }

    @Override
    public boolean removeFocous() {
        return false;
    }

    @Override
    public List<OrderBean> selectOrders() {
        return null;
    }

    @Override
    public List<OrderBean> selectIncome() {
        return null;
    }

    @Override
    public boolean changePsw() {
        return false;
    }

    @Override
    public boolean bePlayer() {
        return false;
    }

    @Override
    public boolean modefyInfo(UserBean user) {
        return false;
    }

    @Override
    public boolean addLoveGames() {
        return false;
    }

    @Override
    public boolean removeLoveGames() {
        return false;
    }

    @Override
    public boolean addBlackList() {
        return false;
    }

    @Override
    public boolean removeBlackList() {
        return false;
    }
}
