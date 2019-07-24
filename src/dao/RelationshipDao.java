package dao;

import bean.RechargeBean;
import bean.RelationshipBean;

import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 16:21
 */
public interface RelationshipDao {
    public boolean addRelationShip(String userName, RelationshipBean relationship);
    public boolean delRelationShip(String userName, RelationshipBean relationship);
    public boolean updateRelationShip(String userName, RelationshipBean relationship);
    public List<RelationshipBean> selectAllRelationship(String username);
    public List<RelationshipBean> selectAllRelationshipByStatus(String username,int status);//根据状态查看关系表（0关注、1拉黑）默认关注
}
