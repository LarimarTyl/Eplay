package dao.impl;

import bean.UserBean;
import dao.UserDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.C3P0Util;
import util.Constant;
import util.DateUtil;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author Mr Wu
 * @create: 2019-07-25 10:26
 */
public class UserDaoImpl implements UserDao {

    private static QueryRunner qr = new QueryRunner(C3P0Util.getDs());

    @Override
    public boolean saveUser(UserBean user) {
        String sql="insert into user(loginName, loginPwd, staffNumber, staffName, birthday, gender, email, telephone, photoPath, price, QQ, registerTime, code) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            qr.update(sql,new Object[]{user.getLoginName(),user.getLoginPwd(),Integer.valueOf(200+user.getTelephone().substring(user.getTelephone().length()-3)),user.getLoginName(),user.getBirthday(),user.getGender(),user.getEmail(),user.getTelephone(),"user.JPEG",user.getPrice(),user.getQQ(), DateUtil.convert(LocalDateTime.now()),"123456"});
//            qr.update(sql,new Object[]{user.getLoginName(),user.getLoginPwd(),user.getStaffNumber(),user.getStaffName(),user.getBirthday(),user.getGender(),user.getEmail(),user.getTelephone(),user.getPhotoPath(),user.getPrice(),user.getQQ(),user.getRegisterTime(),user.getCode()});
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delUser(UserBean user) {
        String sql="delete from user where id=?";
        try {
            qr.update(sql,user.getId());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUser(UserBean user) {
        String sql="update user set loginName=?,loginPwd=?,staffName=?,staffName=?,birthday=?,gender=?,email=?,telephone=?,photoPath=?,price=?,QQ=?,registerTime=?,code=? where id=?";
        try {
            qr.update(sql,new Object[]{user.getLoginName(),user.getLoginPwd(),user.getStaffNumber(),user.getStaffName(),user.getBirthday(),user.getGender(),user.getEmail(),user.getTelephone(),user.getPhotoPath(),user.getPrice(),user.getQQ(),user.getRegisterTime(),user.getCode(),user.getId()});
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
/**
* @author zwd
* */
    @Override
    public UserBean loginCheck(String loginName, String loginPwd) {
        String sql="select * from user where (loginName=? or staffNumber=?) and loginPwd=?";
        try {
            UserBean userBean=qr.query(sql,new BeanHandler<UserBean>(UserBean.class),loginName,loginName,loginPwd);
            System.out.println("登录验证成功");
            return userBean;
        } catch (SQLException e) {
            System.out.println("登录验证失败");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserBean selectUserByCode(String code) {
        String sql="select * from user where code=?";
        try {
            UserBean userBean=qr.query(sql,new BeanHandler<UserBean>(UserBean.class),code);
            return userBean;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserBean selectUserByName(String name) {
        String sql="select * from user where staffName=?";
        try {
            UserBean userBean=qr.query(sql,new BeanHandler<UserBean>(UserBean.class),name);
            return userBean;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserBean selectUserByUserID(int userId) {
        String sql="select * from user where id=?";
        try {
            UserBean userBean=qr.query(sql,new BeanHandler<UserBean>(UserBean.class),userId);
            return userBean;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserBean selectUserByLoginName(String loginName) {
        String sql="select * from user where loginName=?";
        try {
            UserBean userBean=qr.query(sql,new BeanHandler<UserBean>(UserBean.class),loginName);
            System.out.println(userBean);
            return userBean;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
    * @author zwd
     */
    @Override
    public int selectRegisterStatusByLoginName(String loginName) {
        String sql="select * from user where loginName=?";
        try {
            UserBean userBean=qr.query(sql,new BeanHandler<UserBean>(UserBean.class),loginName);
            return userBean.getRegisterStatus();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    /**
     * @author zwd
     */
    @Override
    public int selectStatusByStaffNumber(String staffNumber) {
        String sql="select * from user where staffNumber=?";
        try {
            UserBean userBean=qr.query(sql,new BeanHandler<UserBean>(UserBean.class),staffNumber);
            return userBean.getStatus();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }
    @Override
    public List<UserBean> selectAllUser() {
        String sql="select * from user";
        try {
            List<UserBean> list= null;
                list = qr.query(sql,new BeanListHandler<UserBean>(UserBean.class));
                return list;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return null;
    }
    @Override
    public List<UserBean> pageAllUser(int currentPage, int pageSize) {
        String sql="select * from user limit ?,?";
        List<UserBean> users;
        try {
            users=qr.query(sql,new BeanListHandler<UserBean>(UserBean.class),new Object[]{(currentPage-1)*pageSize,pageSize});
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<UserBean> selectUsersByRegisterStatus(int registerStatus) {
    String sql="select * from user where registerStatus=?";
        try {
            List<UserBean> list= null;

                list = qr.query(sql,new BeanListHandler<UserBean>(UserBean.class),registerStatus);
                return list;
            } catch (SQLException e) {
                e.printStackTrace();}
        return null;
    }

    @Override
    public List<UserBean> pageUsersByRegisterStatus(int registerStatus, int currentPage, int pageSize) {
        String sql="select * from user where registerStatus =? limit ?,?";
        List<UserBean> users;
        try {
            users=qr.query(sql,new BeanListHandler<UserBean>(UserBean.class),new Object[]{registerStatus,(currentPage-1)*pageSize,pageSize});
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }

                  return null;
    }

    @Override
    public List<UserBean> selectUsersBySpend() {
        String sql="select * from user order by price desc limit 0,10";
        try {
            List<UserBean> list=qr.query(sql,new BeanListHandler<UserBean>(UserBean.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<UserBean> selectUsersByender(String gender) {
            String sql="select * from user where gender=?";
            List<UserBean> users;
            try {
                users=qr.query(sql,new BeanListHandler<UserBean>(UserBean.class),gender);
                return users;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

    @Override
    public double selectMoneyById(int id) {
            UserBean user;
        String sql="select money from user where id=?";

        try {
           user= qr.query(sql,new BeanHandler<UserBean>(UserBean.class),id);
            System.out.println("-----------");
            if (user!=null){
                double b=user.getMoney();
                return b;
            }
        } catch (SQLException e) {
            System.out.println("根据用户id查余额失败："+e.getMessage());
        }
        return 0;
    }
    @Override
    public List<UserBean> selectUsersByStatus(int status) {
        String sql="select * from user where status=?";
        List<UserBean> users;
        try {
            users=qr.query(sql,new BeanListHandler<UserBean>(UserBean.class),status);
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
        }

    @Override
    public List<UserBean> pageUsersByStatus(int status, int currentPage, int pageSize) {
        String sql="select * from user where status =? limit ?,?";
        List<UserBean> users;
        try {
            users=qr.query(sql,new BeanListHandler<UserBean>(UserBean.class),new Object[]{status,(currentPage-1)*pageSize,pageSize});
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public boolean updateMoneyById(UserBean user) {
        String sql="update user set money=? where id=?";
        try {
           int a= qr.update(sql,user.getMoney(),user.getId());
            if (a!=0){
                return true;
            }
        } catch (SQLException e) {
            System.out.println("修改余额从成功："+e.getMessage());
        }
        return false;
    }

}
