package service.impl;

import bean.OrderBean;
import bean.PlayerBean;
import bean.UserBean;
import dao.OrderDao;
import dao.PlayerDao;
import dao.UserDao;
import service.UserService;
import util.Factory;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao;
    OrderDao orderDao;
    PlayerDao playerDao;
public UserServiceImpl(){
    userDao= Factory.getInstance("userDao",UserDao.class);
    orderDao=Factory.getInstance("orderDao",OrderDao.class);
    playerDao=Factory.getInstance("playerDao",PlayerDao.class);
}
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
    public List<OrderBean> selectOrders(String userName) {
        List<OrderBean> list=orderDao.selectOrdersByUser(userName);
        return list;
    }

    @Override
    public List<OrderBean> selectIncome(String player) {
        List<OrderBean> list=orderDao.selectOrdersByPlayer(player);
        return list;
    }

    @Override
    public boolean changePsw(UserBean userBean) {
        boolean flag=userDao.updateUser(userBean);
        return flag;
    }

    @Override
    public boolean bePlayer(UserBean userBean,PlayerBean playerBean) {
        userDao.updateUser(userBean);
        boolean flag= playerDao.savePlayer(playerBean);
        return flag;
    }

    @Override
    public boolean modefyInfo(UserBean userBean){
        Boolean flag=userDao.updateUser(userBean);
        return flag;
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
