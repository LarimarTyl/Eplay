package service.impl;

import bean.OrderBean;
import bean.RechargeBean;
import bean.UserBean;
import dao.RechargeDao;
import dao.impl.RechargeDaoImpl;
import service.UserService;

import java.util.List;

/**
 * Create by mysteriousTime
 * time on 2019/7/26  14:34
 */
public class UserServiceImpl implements UserService {
    RechargeDaoImpl rechargeDao;
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

    @Override
    public boolean recharge(String userName, RechargeBean recharge) {

        rechargeDao.saveRecharge(userName,recharge);
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
