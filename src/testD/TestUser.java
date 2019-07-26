package testD;

import bean.UserBean;
import dao.UserDao;
import org.junit.Test;
import util.Factory;

import java.util.List;

/**
 * @author Mr Wu
 * @create: 2019-07-25 11:27
 */
public class TestUser {

    private static UserDao userDao;

    static{
        userDao= Factory.getInstance("userDao",UserDao.class);
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
}
