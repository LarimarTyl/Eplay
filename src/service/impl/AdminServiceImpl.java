package service.impl;

import bean.OrderBean;
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
        return playerDao.selectNewPlayers();
    }

    @Override
    public boolean checkPlayer(PlayerBean player){
        UserBean user = userDao.selectUserByUserID(player.getPlayerID());
        int i = playerDao.selectPlayerStatus(player.getPlayerID());
        if (i!=1){
            user.setStatus(3);
            System.out.println("更改用户状态从待审核状态改为审核通过状态");
            if (userDao.saveUser(user)){
                System.out.println("更改成功");
            return true;
            }
        }
        return false;
    }

    @Override
    public List<PlayerBean> listTopPricePlayers() {
        List<OrderBean> orderBeans = orderDao.selectTopPrice();
        List<PlayerBean> topPricePlayer=null;
        for (OrderBean orderBean:orderBeans) {
            int playerID = orderBean.getPlayerID();
            PlayerBean playerBean = playerDao.selectPlayById(playerID);
            topPricePlayer.add(playerBean);
        }
        return topPricePlayer;
    }

    @Override
    public List<PlayerBean> listTopOrderPlayers() {
        List<OrderBean> orderBeans = orderDao.selectTopOrder();
        List<PlayerBean> topOrderPlayer=null;
        for (OrderBean orderBean:orderBeans) {
            int playerID = orderBean.getPlayerID();
            PlayerBean playerBean = playerDao.selectPlayById(playerID);
            topOrderPlayer.add(playerBean);
        }
        return topOrderPlayer;
    }
}
