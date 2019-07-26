package testD;

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
        List<RelationshipBean> relationshipBeans = relationshipDao.selectAllRelationship("1");
        for (RelationshipBean r:relationshipBeans){
            System.out.println(r);
        }
    }

    @Test
    public  void select2(){
        List<RelationshipBean> relationshipBeans = relationshipDao.selectAllRelationshipByStatus("1", 0);
        for (RelationshipBean r:relationshipBeans){
            System.out.println(r);
        }
    }

}
