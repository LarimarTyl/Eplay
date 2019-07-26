package dao.impl;

import bean.RelationshipBean;
import dao.RelationshipDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.C3P0Util;

import java.sql.SQLException;
import java.util.List;


/**
 * @author Mr Wu
 * @create: 2019-07-25 15:27
 */
public class RelationshipDaoImpl implements RelationshipDao {

    QueryRunner qr;

    public RelationshipDaoImpl() {
        qr = new QueryRunner(C3P0Util.getDs());
    }

    @Override
    public boolean addRelationShip(String staffName, RelationshipBean relationship) {

//        String sql = "select id from user where staffName=user.staffName;"
        String sql = "insert into relationship(userID, playerID, status)  set userID=?,playerID=?,status=?";
        try {
            qr.update(sql, relationship.getUserID(), relationship.getPlayerID(), relationship.getStatus());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delRelationShip(String userName, RelationshipBean relationship) {

        String sql = "delete from relationship where userID=? and playerID=?";
        try {
            qr.update(sql, relationship.getUserID(), relationship.getPlayerID());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateRelationShip(String staffName, RelationshipBean relationship) {
        String sql = "update relationship set status=? where userID=? and playerID=?";
        try {
            qr.update(sql, relationship.getStatus(), relationship.getUserID(), relationship.getPlayerID());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<RelationshipBean> selectAllRelationship(String username) {
        String sql = " select u.loginName as userName,u1.playName,u.photoPath,r.id,r.playerID,r.userID,r.status,g.gameName,p.introduce,p.picPath from user as u,gamelist as g,player as p, relationship as r,(select u2.loginName as playName,u2.id as id_2 from user as u2 where status=3) as u1 where g.id=p.gameID and r.playerID=p.id and p.playerID=u1.id_2 and u.id=r.userID";
        List<RelationshipBean> result;
        try {
            result = qr.query(sql, new BeanListHandler<RelationshipBean>(RelationshipBean.class));
            return result;
        } catch (SQLException e) {
            System.out.println("查询失败" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<RelationshipBean> selectAllRelationshipByStatus(String username, int status) {
        String sql = " select u.loginName as userName,u1.playName,u.photoPath,r.id,r.playerID,r.userID,r.status,g.gameName,p.introduce,p.picPath from user as u,gamelist as g,player as p, relationship as r,(select u2.loginName as playName,u2.id as id_2 from user as u2 where status=3) as u1 where g.id=p.gameID and r.playerID=p.id and p.playerID=u1.id_2 and u.id=r.userID and r.status=?";
        List<RelationshipBean> result;
        try {
            result = qr.query(sql, new BeanListHandler<RelationshipBean>(RelationshipBean.class), status);
            return result;
        } catch (SQLException e) {
            System.out.println("根据状态查询失败" + e.getMessage());
        }
        return null;
    }

}