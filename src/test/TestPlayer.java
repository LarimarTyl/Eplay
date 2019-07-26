package test;

import bean.PlayerBean;
import dao.PlayerDao;
import dao.impl.PlayerDaoimpl;
import org.junit.Test;
import util.Factory;

import java.util.List;

/**
 * Create by czq
 * time on 2019/7/25  9:19
 */
public class TestPlayer {
    //6.
    static PlayerDao PlayerDao = Factory.getInstance("PlayerDaoimpl", PlayerDaoimpl.class);

    @Test

    public void testPrice() {
        List<PlayerBean> players = PlayerDao.selectPlayersByPrice(30);
        Factory.getInstance("PlayerDaoimpl", PlayerDaoimpl.class);
        System.out.println(players);
    }

    @Test
    public void testPricePage() {
        List<PlayerBean> players = PlayerDao.pagePlayersByPrice(30, 1, 2);
        System.out.println(players);
    }

    @Test
    public void testGameName() {
        List<PlayerBean> players = PlayerDao.selectPlayersByGame("绝地求生");
        System.out.println(players);
    }

    @Test
    public void testGameNamePage() {
        List<PlayerBean> players = PlayerDao.pagePlayersByGame("绝地求生", 1, 2);
        System.out.println(players);
    }

    @Test
    public void testGender() {
        List<PlayerBean> players = PlayerDao.selectPlayersByGender("女");
        System.out.println(players);
    }

    @Test
    public void testGenderPage() {
        List<PlayerBean> players = PlayerDao.pagePlayersByGender("男", 1, 2);
        System.out.println(players);
    }

    @Test
    public void testGameNaneAndLevel() {
        List<PlayerBean> players = PlayerDao.selectPlayersByGameAndLevel("绝地求生", "500分以下");
        System.out.println(players);
    }

    @Test
    public void testGameNaneAndLevelPage() {
        List<PlayerBean> players = PlayerDao.pagePlayersByGameAndLevel("王者荣耀", "钻石", 1, 1);
        System.out.println(players);
    }

    @Test
    public void testGameNaneAndLevelAndGender() {
        List<PlayerBean> players = PlayerDao.selectPlayersByGameAndLevelAndGender("绝地求生", "500分以下","男");
        System.out.println(players);
    }

    @Test
    public void testGameNaneAndLevelAndGenderPage() {
        List<PlayerBean> players = PlayerDao.pagePlayersByGameAndLevelAndGender("绝地求生", "500分以下","女",1,1);
        System.out.println(players);
    }

    @Test
    public void testName() {
        PlayerBean players = PlayerDao.selectPlayByName("Admin");
        System.out.println(players);
    }

    @Test
    public void testPlayId() {
        PlayerBean players = PlayerDao.selectPlayById(1);
        System.out.println(players);
    }



}
