package service.impl;

import bean.OrderBean;
import bean.RechargeBean;
import bean.RelationshipBean;
import bean.UserBean;
import dao.RechargeDao;
import dao.UserDao;
import dao.impl.RechargeDaoImpl;
import dao.impl.RelationshipDaoImpl;
import dao.impl.UserDaoImpl;
import service.UserService;

import java.util.List;

/**
 * Create by mysteriousTime
 * time on 2019/7/26  14:34
 */
public class UserServiceImpl implements UserService {
    UserDaoImpl userDao;
    RechargeDaoImpl rechargeDao;
    RelationshipDaoImpl relationshipDao;

    @Override
    public boolean regiser(String name, String passWord, String phone, String qq, String code) {
        return false;
    }

    @Override
    public boolean login(String name, String passWord, String code) {
        return false;
    }

    @Override
    public boolean takeOrder(String player, String game) {
        return false;
    }

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
