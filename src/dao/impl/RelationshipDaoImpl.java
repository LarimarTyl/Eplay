package dao.impl;

import bean.RelationshipBean;
import dao.RelationshipDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
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

        String sql = "insert into relationship(userID, playerID, status)  values(?,?,?)";
        try {
            qr.update(sql, relationship.getUserID(), relationship.getPlayerID(), relationship.getStatus());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delRelationShip(String staffName, RelationshipBean relationship) {

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
        String sql = " select u.loginName as userName,u1.playName,u.photoPath,r.id,r.playerID,r.userID,r.status,g.gameName,p.introduce,p.picPath from user as u,gamelist as g,player as p, relationship as r,(select u2.loginName as playName,u2.id as id_2 from user as u2 where status=3) as u1 where g.id=p.gameID and r.playerID=p.id and p.playerID=u1.id_2 and u.id=r.userID and u.loginName=?";
        List<RelationshipBean> result;
        try {
            result = qr.query(sql, new BeanListHandler<RelationshipBean>(RelationshipBean.class),username);
            return result;
        } catch (SQLException e) {
            System.out.println("查询失败" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<RelationshipBean> selectAllRelationshipByStatus(String username, int status) {
        String sql = " select u.loginName as userName,u1.playName,u.photoPath,r.id,r.playerID,r.userID,r.status,g.gameName,p.introduce,p.picPath from user as u,gamelist as g,player as p, relationship as r,(select u2.loginName as playName,u2.id as id_2 from user as u2 where status=3) as u1 where g.id=p.gameID and r.playerID=p.id and p.playerID=u1.id_2 and u.id=r.userID and r.status=? and u.loginName=?";
        List<RelationshipBean> result;
        try {
            result = qr.query(sql, new BeanListHandler<RelationshipBean>(RelationshipBean.class), status,username);
            return result;
        } catch (SQLException e) {
            System.out.println("根据状态查询失败" + e.getMessage());
        }
        return null;
    }

    @Override
    public RelationshipBean selectRelationshipByStatus(String username,String playerName,int status) {
        String sql = " select u.loginName as userName,u1.playName,u.photoPath,r.id,r.playerID,r.userID,r.status,g.gameName,p.introduce,p.picPath from user as u,gamelist as g,player as p, relationship as r,(select u2.loginName as playName,u2.id as id_2 from user as u2 where status=3) as u1 where g.id=p.gameID and r.playerID=p.id and p.playerID=u1.id_2 and u.id=r.userID and r.status=? and u.loginName=? and u1.playerName=?";
        RelationshipBean result;
        try {
           result = qr.query(sql, new BeanHandler<RelationshipBean>(RelationshipBean.class), new Object[]{status, username, playerName});
            return  result;
        } catch (SQLException e) {
            System.out.println("具体的查询失败" + e.getMessage());
        }
        return null;
    }
    public int selectStatusById( RelationshipBean relationship){

        String sql="select status from relationship where userid=? and playerid=?";
        try {
           relationship=qr.query(sql,new BeanHandler<>(RelationshipBean.class),relationship.getUserID(),relationship.getPlayerID());
           if (relationship!=null){
              int status= relationship.getStatus();
              return status;
           }
        } catch (SQLException e) {
            System.out.println("通过id查询状态异常："+e.getMessage());
        }
        return -1;
    }
    /*
    *关注
    * */
//    @Override
//    public boolean updateRelationShipStatus( int id) {
//        boolean flag=false;
//        String sql = "update relationship set status=0 where ID=?";
//        try {
//          int a=qr.update(sql,  id);
//            if (a!=0){
//                flag=true;
//            }
//        } catch (SQLException e) {
//            System.out.println("updateRelationShipStatus异常"+e.getMessage());
//        }
//        return flag;
//    }
}