package dao.impl;

import bean.RechargeBean;
import dao.RechargeDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.C3P0Util;
import util.DateUtil;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Create by czq
 * time on 2019/7/26  9:31
 */
public class RechargeDaoImpl implements RechargeDao {
    QueryRunner qr;

    public RechargeDaoImpl() {
        qr = new QueryRunner(C3P0Util.getDs());
    }

    @Override
    public boolean saveRecharge(String userName, RechargeBean recharge) {
        String sql = "insert into recharge values (default,?,?,?,?)";
        LocalDateTime now = LocalDateTime.now();
        String date = DateUtil.convert(now);
        boolean flag = false;
        try {
            int update = qr.update(sql, recharge.getUserID(), recharge.getMoney(), recharge.getType(), date);
            if (update == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean delRecharge(String userName, RechargeBean recharge) {
        String sql = "delete from recharge where id=?";
        boolean flag = false;
        try {
            int update = qr.update(sql, recharge.getId());
            if (update == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateRecharge(String userName, RechargeBean recharge) {
        String sql = "update recharge set type=? where id=?";
        boolean flag = false;
        try {
            int update = qr.update(sql, recharge.getType(), recharge.getId());
            if (update == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<RechargeBean> selectAllRechers(String userName) {
        String sql = "select recharge.*,user.staffName from recharge,user where userid=user.ID and user.staffName=?";
        List<RechargeBean> recharges = null;
        try {
            recharges = qr.query(sql, new BeanListHandler<>(RechargeBean.class), userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recharges;
    }

    @Override
    public List<RechargeBean> pageAllRechers(String userName, int currentPage, int pageSize) {
        String sql = "select recharge.*,user.staffName from recharge,user where userid=user.ID and user.staffName=? limit ?,?";
        List<RechargeBean> recharges = null;
        try {
            recharges = qr.query(sql, new BeanListHandler<>(RechargeBean.class), userName, (currentPage - 1) * pageSize, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recharges;
    }

    @Override
    public List<RechargeBean> selectRechersByType(int type) {
        String sql = "select recharge.*,user.staffName from recharge,user where userid=user.ID and recharge.type=?";
        List<RechargeBean> recharges = null;
        try {
            recharges = qr.query(sql, new BeanListHandler<>(RechargeBean.class), type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recharges;
    }

    @Override
    public List<RechargeBean> pageRechersByType(int type, int currentPage, int pageSize) {
        String sql = "select recharge.*,user.staffName from recharge,user where userid=user.ID and recharge.type=? limit ?,?";
        List<RechargeBean> recharges = null;
        try {
            recharges = qr.query(sql, new BeanListHandler<>(RechargeBean.class), type, (currentPage - 1) * pageSize, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recharges;
    }

    @Override
    public List<RechargeBean> selectRechersByDate(String date) {
        String sql = "select recharge.*,user.staffName from recharge,user where userid=user.ID and recharge.time=?";
        List<RechargeBean> recharges = null;
        try {
            recharges = qr.query(sql, new BeanListHandler<>(RechargeBean.class), date);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recharges;
    }

    @Override
    public List<RechargeBean> pageRechersByDate(String date, int currentPage, int pageSize) {
        String sql = "select recharge.*,user.staffName from recharge,user where userid=user.ID and recharge.time=? limit ?,?";
        List<RechargeBean> recharges = null;
        try {
            recharges = qr.query(sql, new BeanListHandler<>(RechargeBean.class), date, (currentPage - 1) * pageSize, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recharges;
    }
}
