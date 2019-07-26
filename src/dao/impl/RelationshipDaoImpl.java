package dao.impl;

import bean.RelationshipBean;
import dao.RelationshipDao;
import org.apache.commons.dbutils.QueryRunner;
import util.C3P0Util;

import java.sql.SQLException;
import java.util.List;

public class RelationshipDaoImpl implements RelationshipDao {
    QueryRunner qr;
    public RelationshipDaoImpl() {
        qr= new QueryRunner(C3P0Util.getDs());
    }
    @Override
    public boolean addRelationShip(String staffName, RelationshipBean relationship) {

//        String sql = "select id from user where staffName=user.staffName;"
        String sql="insert into relationship(userID, playerID, status)  set userID=?,playerID=?,status=?";
        try {
            qr.update(sql,relationship.getUserID(),relationship.getPlayerID(),relationship.getStatus());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delRelationShip(String staffName, RelationshipBean relationship) {
        String sql="delete from relationship where userID=? and playerID=?";
        try {
            qr.update(sql,relationship.getUserID(),relationship.getPlayerID());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateRelationShip(String staffName, RelationshipBean relationship) {
        String sql="update relationship set status=? where userID=? and playerID=?";
        try {
            qr.update(sql,relationship.getStatus(),relationship.getUserID(),relationship.getPlayerID());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
/*
 private int id;//关系表id
    private int userID;
    private String staffName;//用户名
    private String playerName;//玩家名
    private int playerID;//玩家id
    private String photoPath;//根据玩家id拿到的玩家头像路径
    private String gameName;//玩家游戏
    private String picPath;//根据玩家id拿到的玩家图片
    private String introduce;//根据玩家id拿到的玩家介绍
    private int status;//关系状态 0关注（默认）  1（拉黑）
* */
    @Override
    public List<RelationshipBean> selectAllRelationship(String staffName) {
        String sql=" select u.loginName as userName,u1.playName,u.photoPath,r.id,r.playerID,r.userID,r.status,g.gameName,p.introduce,p.picPath from user as u,gamelist as g,player as p, relationship as r,(select u2.loginName as playName,u2.id as id_2 from user as u2 where status=3) as u1 where g.id=p.gameID and r.playerID=p.id and p.playerID=u1.id_2 and u.id=r.userID";
        return null;
    }

    @Override
    public List<RelationshipBean> selectAllRelationshipByStatus(String staffName, int status) {
        return null;
    }
}
