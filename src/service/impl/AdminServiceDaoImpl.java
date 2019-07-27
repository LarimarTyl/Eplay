package service.impl;

import bean.PlayerBean;
import bean.UserBean;
import dao.UserDao;
import service.AdminService;
import util.Factory;
import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/26 星期五 15:50
 */
public class AdminServiceDaoImpl implements AdminService {


    /**
    *@author Larimar
    */
    @Override
    public List<UserBean> selectTopSpentUser() {
        UserDao userDao = Factory.getInstance("userDao",UserDao.class);
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
