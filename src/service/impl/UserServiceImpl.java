package service.impl;

import bean.OrderBean;
import bean.UserBean;
import dao.UserDao;
import service.UserService;
import util.Factory;

import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/26 星期五 14:38
 */
public class UserServiceImpl implements UserService {
private static UserDao userDao = Factory.getInstance("userDao",UserDao.class);

    @Override
    public boolean regiser(UserBean register,String code) {
        boolean b = userDao.saveUser(register);
        UserBean userBean = userDao.selectUserByCode(register);
        if (userBean.getRegisterStatus()!=1){
            /*验证过程*/
            if (code==userBean.getCode()){
                userBean.setRegisterStatus(1);
                boolean b1 = userDao.updateUser(userBean);
                if (b1){
                    System.out.println("注册并激活成功");
                    return true;
                }else {
                    System.out.println("激活失败");
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public boolean login(String name, String passWord, String code) {
        UserBean selectUserByName = userDao.selectUserByName(name);
        if (selectUserByName!=null){
        }else {
            System.out.println("用户名或密码错误（用户名不存在）");
        }
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
