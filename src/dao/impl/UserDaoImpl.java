package dao.impl;

import bean.UserBean;
import dao.UserDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;
import util.C3P0Util;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Mr Wu
 * @create: 2019-07-25 10:26
 */
public class UserDaoImpl implements UserDao {

    QueryRunner qr;

    public UserDaoImpl(){
        qr=new QueryRunner(C3P0Util.getDs());
    }
    @Override
    public boolean saveUser(UserBean user) {
        String sql="insert into user(loginName, loginPwd, staffNumber, staffName, birthday, gender, email, telephone, photoPath, price, QQ, registerTime, code) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            qr.update(sql,new Object[]{user.getLoginName(),user.getLoginPwd(),user.getStaffNumber(),user.getStaffName(),user.getBirthday(),user.getGender(),user.getEmail(),user.getTelephone(),user.getPicturePath(),user.getPrice(),user.getQQ(),user.getRegisterTime(),user.getCode()});
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
            qr.update(sql,new Object[]{user.getLoginName(),user.getLoginPwd(),user.getStaffNumber(),user.getStaffName(),user.getBirthday(),user.getGender(),user.getEmail(),user.getTelephone(),user.getPicturePath(),user.getPrice(),user.getQQ(),user.getRegisterTime(),user.getCode(),user.getId()});
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public UserBean selectUserByCode(UserBean user) {
        String sql="select * from user where code=?";
        try {
            UserBean userBean=qr.query(sql,new BeanHandler<>(UserBean.class),user.getCode());
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
            UserBean userBean=qr.query(sql,new BeanHandler<>(UserBean.class),name);
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
            UserBean userBean=qr.query(sql,new BeanHandler<>(UserBean.class),userId);
            return userBean;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<UserBean> selectAllUser() {
        String sql="select * from user";
        try {
            List<UserBean> list= null;
                list = qr.query(sql,new BeanListHandler<>(UserBean.class));
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

                list = qr.query(sql,new BeanListHandler<>(UserBean.class),registerStatus);
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
        String sql="select * from user order by price desc";
        try {
            List<UserBean> list=qr.query(sql,new BeanListHandler<>(UserBean.class));
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


}
