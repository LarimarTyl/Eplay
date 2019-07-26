package test;

import bean.RelationshipBean;
import dao.RelationshipDao;
import org.junit.Test;
import util.Factory;

import java.util.List;

/**
 * @author Mr Wu
 * @create: 2019-07-26 09:28
 */
public class TestRelationship {


    private static RelationshipDao relationshipDao;


    static {
        relationshipDao= Factory.getInstance("relationshipDao",RelationshipDao.class);
    }


    @Test
    public  void select1(){
        List<RelationshipBean> relationshipBeans = relationshipDao.selectAllRelationship("test");
        for (RelationshipBean r:relationshipBeans){
            System.out.println(r);
        }
    }

    @Test
    public  void select2(){
        List<RelationshipBean> relationshipBeans = relationshipDao.selectAllRelationshipByStatus("test", 0);
        for (RelationshipBean r:relationshipBeans){
            System.out.println(r);
        }
    }

    @Test
    public void insert(){
        boolean b = relationshipDao.addRelationShip("1", new RelationshipBean(1,3,0));
        String result = b ? "插入成功" : "插入失败" ;
        System.out.println(result);
    }

    @Test

    public void delete(){
        boolean b = relationshipDao.delRelationShip("1", new RelationshipBean(1, 3, 0));
        String result= b ? "删除成功" :"删除失败";
        System.out.println(result);
    }


    @Test

    public void update(){

        boolean b = relationshipDao.updateRelationShip("1", new RelationshipBean(1, 3, 1));
        String result= b ? "更新成功 " :"更新失败";
        System.out.println(result);

    }


}
