package dao;

import bean.RechargeBean;
import bean.RelationshipBean;

import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 16:21
 */
public interface RelationshipDao {
    public boolean addRelationShip(String staffName, RelationshipBean relationship);
    public boolean delRelationShip(String staffName, RelationshipBean relationship);
    public boolean updateRelationShip(String staffName, RelationshipBean relationship);
//    public boolean updateRelationShipStatus( int id);//将其添加为关注
    public List<RelationshipBean> selectAllRelationship(String staffName);
    public List<RelationshipBean> selectAllRelationshipByStatus(String staffName,int status);//根据状态查看关系表（0关注、1拉黑）默认关注
    /**
     * 对某个用户的具体的关注进行查询
     * @param username 用户名
     * @param  playerName 陪玩主播名
     * @param status 状态
     * @return 集合
     * */
    public RelationshipBean selectRelationshipByStatus(String username,String playerName,int status);
}
