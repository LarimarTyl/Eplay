package dao.impl;

import bean.MessageBean;
import dao.MessageDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.C3P0Util;
import util.DateUtil;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Create by czq
 * time on 2019/7/25  15:34
 */
public class MessageDaoImpl implements MessageDao {
    QueryRunner qr;

    public MessageDaoImpl() {
        qr = new QueryRunner(C3P0Util.getDs());
    }

    @Override
    public boolean addMessage(String username, MessageBean message) {


        LocalDateTime now = LocalDateTime.now();
        String date = DateUtil.convert(now);

        String sql = "insert into message values(default,?,?,?,?,?)";
        boolean flag = false;
        try {
            int update = qr.update(sql, message.getUserID(), message.getMessage(), message.getStatus(), message.getType(), date);
            if (update == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean delMessage(String username, MessageBean message) {
        String sql = "delete from message where id=?";
        boolean flag = false;
        try {
            int update = qr.update(sql, message.getId());
            if (update == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateMessage(String username, MessageBean message) {
        String sql = "update message set statu=1 where id=?";
        boolean flag = false;
        try {
            int update = qr.update(sql, message.getId());
            if (update == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<MessageBean> selectAllMessages(String username) {
        String sql = "select message.*,user.staffName from message,user where userid=user.ID and user.loginName=?";
        List<MessageBean> messages = null;
        try {
            messages = qr.query(sql, new BeanListHandler<>(MessageBean.class), username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }

    @Override
    public List<MessageBean> selectMessagesByStatus(String username, int status) {
        String sql = "select message.*,user.staffName from message,user where userid=user.ID and user.loginName=? and message.status=?";
        List<MessageBean> messages = null;
        try {
            messages = qr.query(sql, new BeanListHandler<>(MessageBean.class), username, status);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }

    @Override
    public List<MessageBean> selectMessagesByType(String username, int type) {
        String sql = "select message.*,user.staffName from message,user where userid=user.ID and user.loginName=? and message.type=?";
        List<MessageBean> messages = null;
        try {
            messages = qr.query(sql, new BeanListHandler<>(MessageBean.class), username, type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }

    @Override
    public List<MessageBean> selectMessagesByDate(String username, String date) {
        String sql = "select message.*,user.staffName from message,user where userid=user.ID and user.loginName=? and message.time=?";
        List<MessageBean> messages = null;
        try {
            messages = qr.query(sql, new BeanListHandler<>(MessageBean.class), username, date);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }
}
