package service.impl;

import bean.OrderBean;
import bean.RechargeBean;
import bean.UserBean;
import dao.RechargeDao;
import dao.impl.RechargeDaoImpl;
import service.UserService;
import bean.LoveGameBean;
import bean.OrderBean;
import bean.RelationshipBean;
import bean.UserBean;
import dao.LoveGameDao;
import dao.RelationshipDao;
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
    RechargeDaoImpl rechargeDao;
    private RelationshipDao relationshipDao;
    private LoveGameDao loveGameDao;
public UserServiceImpl(){
    userDao= Factory.getInstance("userDao",UserDao.class);
    orderDao=Factory.getInstance("orderDao",OrderDao.class);
    playerDao=Factory.getInstance("playerDao",PlayerDao.class);
    relationshipDao=Factory.getInstance("relationshipDao",RelationshipDao.class);
    loveGameDao=Factory.getInstance("loveGameDao",LoveGameDao.class);
}
>>>>>>> upstream/master
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
<<<<<<< HEAD
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
    public boolean addLoveGames(LoveGameBean loveGameBean) {
        boolean b = loveGameDao.addLoveGame(loveGameBean.getStaffName(), loveGameBean);
        return b;
    }
    @Override
    public boolean removeLoveGames(LoveGameBean loveGameBean) {
        boolean b = loveGameDao.delLoveGame(loveGameBean.getStaffName(),loveGameBean);
        return b;
    }

    @Override
    public boolean addBlackList(RelationshipBean relationshipBean) {
        RelationshipBean result = relationshipDao.selectRelationshipByStatus(relationshipBean.getStaffName(), relationshipBean.getPlayerName(), relationshipBean.getStatus());
        boolean black=false;
        if(!result.equals("")){
            if(result.getStatus()==0){
                boolean b = relationshipDao.updateRelationShip(relationshipBean.getStaffName(), relationshipBean);
                return b;
            }else{
                System.out.println("你已经拉黑了给主播");
            }
        }else{
            boolean b = relationshipDao.addRelationShip(relationshipBean.getStaffName(), relationshipBean);
            return  b;
        }
        return black;
    }

    @Override
    public boolean removeBlackList(RelationshipBean relationshipBean) {
        boolean result = relationshipDao.delRelationShip(relationshipBean.getStaffName(), relationshipBean);
        return result;
    }





    @Override
    public boolean addLoveGames(LoveGameBean loveGameBean) {
        boolean b = loveGameDao.addLoveGame(loveGameBean.getStaffName(), loveGameBean);
        return b;
    }

    @Override
    public boolean removeLoveGames(LoveGameBean loveGameBean) {
        boolean b = loveGameDao.delLoveGame(loveGameBean.getStaffName(),loveGameBean);
        return b;
    }

    @Override
    public boolean addBlackList(RelationshipBean relationshipBean) {
        RelationshipBean result = relationshipDao.selectRelationshipByStatus(relationshipBean.getStaffName(), relationshipBean.getPlayerName(), relationshipBean.getStatus());
        boolean black=false;
        if(!result.equals("")){
            if(result.getStatus()==0){
                boolean b = relationshipDao.updateRelationShip(relationshipBean.getStaffName(), relationshipBean);
                return b;
            }else{
                System.out.println("你已经拉黑了给主播");
            }
        }else{
            boolean b = relationshipDao.addRelationShip(relationshipBean.getStaffName(), relationshipBean);
            return  b;
        }
        return black;
    }

    @Override
    public boolean removeBlackList(RelationshipBean relationshipBean) {
        boolean result = relationshipDao.delRelationShip(relationshipBean.getStaffName(), relationshipBean);
        return result;
    }

}
