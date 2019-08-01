package test;

import bean.UserBean;
import dao.UserDao;
import org.junit.Test;
import util.Factory;

import java.util.Date;
import java.util.List;

public class testUserDao {
    static UserDao userDao;
    static {
        userDao= Factory.getInstance("userDao",UserDao.class);
    }
//    @Test
//    public void saveUser(){
//        //int id, String loginName, String loginPwd, String staffNumber, String staffName, String birthday, String gender, String email, String telephone, String picturePath, double price, double money, String QQ, Date registerTime
//        userDao.saveUser(new UserBean(6,"test", "test", "1001489", "Larimar", "1998-05-06", "男", "565203943@qq.com", "13617004500", "img/user/photo/test",150.00, 2411699,"1727032340",new Date()));
//    }
//    @Test
//    public void delUser(){
//        userDao.delUser(new UserBean(11, "test", "test", "1001724156", "Larimar", "1998-05-06", "男", "565203943@qq.com", "13617004500", "img/user/photo/test",150.00, 2411699,"1727032340",new Date()));
//    }
//    @Test
//    public void update(){
//        userDao.updateUser(new UserBean(3, "test222", "test111", "10056", "Larimar", "1998-05-06", "男", "565203943@qq.com", "13617004500", "img/user/photo/test",150.00, 2411699,"1727032340",new Date()));
//    }
//    @Test
//    public void selectUserByCode(){
//       UserBean userBean=userDao.selectUserByCode(new UserBean(3, "test111", "test111", "10056", "Larimar", "1998-05-06", "男", "565203943@qq.com", "13617004500", "img/user/photo/test",150.00, 2411699,"1727032340",new Date(),1,"test",1));
//        System.out.println(userBean);
//    }
    @Test
    public void selectUserByName(){
        UserBean userBean=userDao.selectUserByName("Larimar");
        System.out.println(userBean);
    }
    @Test
    public void selectUserByUserID(){
        UserBean userBean=userDao.selectUserByUserID(2);
        System.out.println(userBean);
    }
    @Test
    public void selectAllUser(){
        List<UserBean> list=userDao.selectAllUser();
        System.out.println(list.size());
    }
    @Test
    public void selectUsersByRegisterStatus(){
        List<UserBean> userBeans=userDao.selectUsersByRegisterStatus(1);
        System.out.println(userBeans.size());
    }
    @Test
    public void selectUsersBySpend(){
        List<UserBean> userBeans=userDao.selectUsersBySpend();
        System.out.println(userBeans.get(1));
    }
    @Test
    public void selectUsersByStatus(){
        List<UserBean> list=userDao.selectUsersByStatus(0);
        System.out.println(list.get(0));
    }
    @Test
    public void selectUsersByender(){
        List<UserBean> list=userDao.selectUsersByender("男");
        System.out.println(list.size());
    }
    @Test
    public  void select(){
        List<UserBean> users = userDao.selectUsersByender("男");
        for (UserBean u:users){
            System.out.println(u);
        }
    }
    @Test
    public void select1(){
        List<UserBean> userBeans = userDao.selectUsersByStatus(0);
        for (UserBean u:userBeans){
            System.out.println(u);
        }
    }
    @Test
    public void select2(){
        List<UserBean> userBeans = userDao.pageUsersByStatus(0, 1, 3);
        for (UserBean u:userBeans){
            System.out.println(u);
        }
    }
    @Test
    public void select3(){
        List<UserBean> userBeans = userDao.pageAllUser(1, 4);
        for(UserBean u:userBeans){
            System.out.println(u);
        }
    }
    @Test
    public void select4(){
        List<UserBean> userBeans = userDao.pageUsersByRegisterStatus(0, 1, 3);
        for(UserBean u:userBeans){
            System.out.println(u);
        }

    }
    @Test
    public void selectUserByLoginName(){
        UserBean userBean=userDao.selectUserByLoginName("player");
        System.out.println(userBean);
    }
    @Test
    public void testById(){
        userDao.selectMoneyById(1);
    }
    @Test
    public void testByName(){
        UserBean test = userDao.selectUserByLoginName("张三丰");
        System.out.println(test);
    }
}
