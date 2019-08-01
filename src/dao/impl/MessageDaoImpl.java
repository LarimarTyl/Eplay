package dao.impl;

import bean.MessageBean;
import dao.MessageDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import util.C3P0Util;
import util.DateUtil;

import java.math.BigInteger;
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
    public int addMessage(MessageBean message) {
        LocalDateTime now = LocalDateTime.now();
        String date = DateUtil.convert(now);
        String sql = "insert into message values(default,?,?,?,?,?)";
        int i = 0;
        try {
//          i = qr.update(sql, message.getUserID(), message.getMessage(), message.getStatus(), message.getType(), date);
            ScalarHandler<BigInteger> rsh = new ScalarHandler<>();
            i = qr.insert(sql, rsh, message.getUserID(), message.getMessage(), message.getStatus(), message.getType(), date).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public boolean delMessage(MessageBean message) {
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
    public boolean updateMessage(MessageBean message) {
        String sql = "update message set status=1 where id=?";
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
    public MessageBean queryMessageByOrderId(int id) {
        String sql="select * from message where id=?";
        MessageBean message = null;
        try {
            message = qr.query(sql, new BeanHandler<>(MessageBean.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return message;
    }

    @Override
    public List<MessageBean> queryMessageByUserId(int userid) {
        String sql="select * from message where userID=?";
        List<MessageBean> messages = null;
        try {
            messages = qr.query(sql, new BeanListHandler<>(MessageBean.class), userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }

    @Override
    public List<MessageBean> queryMessage(int id, int status) {
        String sql = "select * from message where userid=? and status=?";
        List<MessageBean> message = null;
        try {
            message = qr.query(sql, new BeanListHandler<>(MessageBean.class), id, status);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return message;
    }

    @Override
    public List<MessageBean> selectAllMessages(String username) {
        String sql = "select message.*,user.staffName from message,user where userid=user.ID and user.staffName=?";
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
        String sql = "select message.*,user.staffName from message,user where userid=user.ID and user.staffName=? and message.status=?";
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
        String sql = "select message.*,user.staffName from message,user where userid=user.ID and user.staffName=? and message.type=?";
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
        String sql = "select message.*,user.staffName from message,user where userid=user.ID and user.staffName=? and message.time=?";
        List<MessageBean> messages = null;
        try {
            messages = qr.query(sql, new BeanListHandler<>(MessageBean.class), username, date);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }
}
