package test;

import bean.RechargeBean;
import dao.RechargeDao;
import dao.impl.RechargeDaoImpl;
import org.junit.Test;
import util.C3P0Util;
import util.Factory;

import java.util.List;

/**
 * Create by czq
 * time on 2019/7/26  9:36
 */
public class TestRecharge {
    static RechargeDao rechargeDao = Factory.getInstance("rechargeDao", RechargeDao.class);

//    @Test
//    public void testSave() {
//        boolean b = rechargeDao.saveRecharge("123", new RechargeBean(2, "123", 100, 2, "123"));
//        System.out.println(b);
//    }

    @Test
    public void testDelete() {
        boolean b = rechargeDao.delRecharge("123", new RechargeBean(2,2, "123", 100, 2, "123"));
        System.out.println(b);
    }

    @Test
    public void testUpdate() {
        boolean b = rechargeDao.updateRecharge("123", new RechargeBean(1,2, "123", 100, 1, "123"));
        System.out.println(b);
    }

    @Test
    public void testAll() {
        List<RechargeBean> recharges = rechargeDao.selectAllRechers("test");
        System.out.println(recharges);
    }
    @Test
    public void testAllPage() {
        List<RechargeBean> recharges = rechargeDao.pageAllRechers("test",1,2);
        System.out.println(recharges);
    }

    @Test
    public void testByType() {
        List<RechargeBean> recharges = rechargeDao.selectRechersByType(2);
        System.out.println(recharges);
    }

    @Test
    public void testByTypePage() {
        List<RechargeBean> recharges = rechargeDao.pageRechersByType(1,1,2);
        System.out.println(recharges);
    }
    @Test
    public void testByDate() {
        List<RechargeBean> recharges = rechargeDao.selectRechersByDate("2019-07-26 10:02:49");
        System.out.println(recharges);
    }
    @Test
    public void testByDatePage() {
        List<RechargeBean> recharges = rechargeDao.pageRechersByDate("2019-07-26 10:02:49",1,2);
        System.out.println(recharges);
    }
}
