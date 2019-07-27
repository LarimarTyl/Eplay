package service.impl;

import bean.PlayerBean;
import bean.UserBean;
import dao.OrderDao;
import dao.PlayerDao;
import dao.UserDao;
import service.AdminService;
import util.Factory;

import java.util.List;

/**
 * @author Mr Wu
 * @create: 2019-07-26 15:34
 */
public class AdminServiceImpl implements AdminService {


    private OrderDao orderDao;
    private UserDao userDao;
    private PlayerDao playerDao;

    public AdminServiceImpl(){
        orderDao= Factory.getInstance("orderDao",OrderDao.class);
        userDao=Factory.getInstance("userDao",UserDao.class);
        playerDao=Factory.getInstance("playerDao",PlayerDao.class);
    }
    @Override
    public List<UserBean> selectTopSpentUser() {
        List<UserBean> userBeans = userDao.selectUsersBySpend();
        return userBeans;
    }

    @Override
    public List<PlayerBean> listNewPlayers() {
        return null;
    }

    @Override
    public boolean checkPlayer() {
        return false;
    }

    @Override
    public List<PlayerBean> listTopPricePlayers() {

        return null;
    }

    @Override
    public List<PlayerBean> listTopOrderPlayers() {
        return null;
    }
}
