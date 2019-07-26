package service.impl;

import bean.LoveGameBean;
import bean.OrderBean;
import bean.RelationshipBean;
import bean.UserBean;
import dao.LoveGameDao;
import dao.RelationshipDao;
import dao.UserDao;
import service.UserService;
import util.Factory;

import java.util.List;

/**
 * @author Mr Wu
 * @create: 2019-07-26 14:43
 */
public class UserServiceImpl implements UserService {

    private RelationshipDao relationshipDao;
    private LoveGameDao loveGameDao;

    private UserServiceImpl(){

        relationshipDao=Factory.getInstance("relationshipDao",RelationshipDao.class);
        loveGameDao=Factory.getInstance("loveGameDao",LoveGameDao.class);
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
