package dao;

import bean.RelationshipBean;

import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 16:21
 */
public interface RelationshipDao {
    /**
     * 添加关系表
     * @param staffName 用户名
     * @param relationship 关系对象（0关注，1拉黑）
     * @return 返回添加状态
     */
    public boolean addRelationShip(String staffName, RelationshipBean relationship);
    /**
     * 删除关系表
     * @param staffName 用户名
     * @param relationship 关系对象（0关注，1拉黑）
     * @return 返回删除状态
     */
    public boolean delRelationShip(String staffName, RelationshipBean relationship);
    /**
     * 更新关系表
     * @param staffName 用户名
     * @param relationship 关系对象（0关注，1拉黑）
     * @return 返回更新状态
     */
    public boolean updateRelationShip(String staffName, RelationshipBean relationship);

    /**
     * 查询用户的关系表
     * @param staffName 用户名
     * @return 返回该用户的关系表
     */
    public List<RelationshipBean> selectAllRelationship(String staffName);

    /**
     * 根据状态查看关系表（0关注、1拉黑）默认关注
     * @param staffName 用户名
     * @param status 状态
     * @return 返回用户特定状态的关系（关注、拉黑）
     */
    public List<RelationshipBean> selectAllRelationshipByStatus(String staffName,int status);
    /**
     * 对某个用户的具体的关注进行查询
     * @param username 用户名
     * @param  playerName 玩家名
     * @param status 状态
     * @return 集合
     * */
    public RelationshipBean selectRelationshipByStatus(String username,String playerName,int status);

    /**
     * ？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？
     * 根据用户id返回
     * @param userId
     * @return
     */
    public int selectStatusById (int userId);
}
