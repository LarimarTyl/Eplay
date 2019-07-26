package test;

import bean.MessageBean;
import dao.MessageDao;
import dao.UserDao;
import dao.impl.MessageDaoimpl;
import org.junit.Test;
import util.Factory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * Create by czq
 * time on 2019/7/25  15:59
 */
public class TestMessage {
    private static MessageDao messageDao = Factory.getInstance("MessageDaoimpl", MessageDaoimpl.class);

    @Test
    public void testAdd() {
        boolean b = messageDao.addMessage("123", new MessageBean(1, "蔡泽球", "欢迎来到王者荣耀", 0, 0));
        System.out.println(b);
    }

    @Test
    public void testDel() {
        boolean b = messageDao.delMessage("123", new MessageBean(12, "123", 1, 1, "123"));
        System.out.println(b);
    }

    @Test
    public void testUpdate() {
        boolean b = messageDao.updateMessage("123", new MessageBean(13, "123", 1, 1, "123"));
        System.out.println(b);
    }

    @Test
    public void testMessageAllByName() {
        List<MessageBean> messages = messageDao.selectAllMessages("test");
        System.out.println(messages);
    }

    @Test
    public void testMessageAllByNameAndStatus() {
        List<MessageBean> messages = messageDao.selectMessagesByStatus("test", 1);
        System.out.println(messages);
    }

    @Test
    public void testMessageAllByNameAndType() {
        List<MessageBean> messages = messageDao.selectMessagesByType("test", 1);
        System.out.println(messages);
    }
    @Test
    public void testMessageAllByNameAndDate() {
        List<MessageBean> messages = messageDao.selectMessagesByDate("test", "2019-07-25 19:36:26");
        System.out.println(messages);
    }
}
