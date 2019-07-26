package dao.impl;

import bean.LoveGameBean;
import dao.LoveGameDao;

import org.junit.Test;
import util.Factory;

import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/26 星期五 0:55
 */

public class LoveGameImplTest {
    private static LoveGameDao loveGameDao = Factory.getInstance("loveGameDao",LoveGameDao.class);

    @Test
    public void addLoveGame() {
        LoveGameBean loveGameBean = new LoveGameBean();
        loveGameBean.setStaffName("Larimar");
        loveGameBean.setUserID(1);
        loveGameBean.setGameID(2);
        boolean b = loveGameDao.addLoveGame(loveGameBean.getStaffName(), loveGameBean);
        if (b){
            System.out.println("测试添加游戏偏好成功");
        }else {
            System.out.println("测试添加游戏偏好失败");
        }

    }

    @Test
    public void upDateLoveGame() {
        LoveGameBean loveGameBean = new LoveGameBean();
        loveGameBean.setStaffName("Larimar");
        loveGameBean.setUserID(1);
        loveGameBean.setGameID(3);
        boolean b = loveGameDao.upDateLoveGame(loveGameBean.getStaffName(), loveGameBean);
        if (b){
            System.out.println("测试修改游戏偏好成功");
        }else {
            System.out.println("测试修改游戏偏好失败");
        }
    }
    @Test
    public void delLoveGame() {
        LoveGameBean loveGameBean = new LoveGameBean();
        loveGameBean.setGameName("Larimar");
        loveGameBean.setUserID(1);
        loveGameBean.setGameID(3);
        boolean b = loveGameDao.delLoveGame(loveGameBean.getStaffName(), loveGameBean);
        if (b){
            System.out.println("测试删除游戏偏好成功");
        }else {
            System.out.println("测试删除游戏偏好失败");
        }
    }


    @Test
    public void selectLoveGames() {
        List<LoveGameBean> larimar = loveGameDao.selectLoveGames("Larimar");
        if (larimar.size()>0){
            System.out.println(larimar.toString());
            System.out.println("测试查看所有游戏偏好成功");
        }else {
            System.out.println("测试查看所有游戏偏好失败");
        }
    }
}
