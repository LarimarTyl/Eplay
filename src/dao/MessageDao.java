package dao;

import bean.MessageBean;

import java.util.Date;
import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 16:20
 */
public interface MessageDao {
    /**
     * 添加消息
     *
     * @param message 消息对象
     * @return 返回添加状态
     */
    public int addMessage(MessageBean message);

    /**
     * 删除消息
     *
     * @param message 消息对象
     * @return 返回删除状态
     */
    public boolean delMessage(MessageBean message);

    /**
     * 更新消息
     *
     * @param message 消息对象（可以再对象内改信息再更新）
     * @return 返回更新状态
     */
    public boolean updateMessage(MessageBean message);

    /**
     * 查询某个消息对象是否存在某个状态（已读）
     *
     * @param id     消息id
     * @param status 状态
     * @return 返回消息是否存在
     */
    public List<MessageBean> queryMessage(int id, int status);


    /**
     * 根据订单id返回订单对象
     * @param id
     * @return
     */
    public MessageBean queryMessageByOrderId(int id);


    public List<MessageBean> queryMessageByUserId(int userid);
    /**
     * 查询某个用户的消息列表
     *
     * @param username 用户名
     * @return 返回用户的消息集合
     */
    public List<MessageBean> selectAllMessages(String username);//查询某个用户的消息

    /**
     * 根据状态（默认0未读，1是已读）查某个用户的消息
     *
     * @param username 用户名
     * @param status   状态
     * @return 返回用户改状态的所有消息
     */
    public List<MessageBean> selectMessagesByStatus(String username, int status);//根据状态（默认0未读，1是已读）查某个用户的消息

    /**
     * /根据类型查某个用户的信息
     *
     * @param username 用户名
     * @param type     消息类型 （默认0系统消息，1用户消息）
     * @return 返回用户该类型的所有消息
     */
    public List<MessageBean> selectMessagesByType(String username, int type);//根据类型（默认0系统消息，1用户消息）查某个用户的信息

    /**
     * //根据日期查询消息
     *
     * @param username 用户名
     * @param date     日期
     * @return 返回符合日期的消息数据
     */
    public List<MessageBean> selectMessagesByDate(String username, String date);
}
