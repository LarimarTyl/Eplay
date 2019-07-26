package test;

import bean.PlayerBean;
import dao.PlayerDao;
import org.junit.Test;
import util.Factory;

import java.util.List;

/**
 * Create by czq
 * time on 2019/7/25  9:19
 */
public class TestPlayer {
    //6.
    private static PlayerDao playerDao = Factory.getInstance("playerDao", PlayerDao.class);

    @Test

    public void testPrice() {
        List<PlayerBean> players = playerDao.selectPlayersByPrice(30);
        System.out.println(players);
    }

    @Test
    public void testPricePage() {
        List<PlayerBean> players = playerDao.pagePlayersByPrice(30, 1, 2);
        System.out.println(players);
    }

    @Test
    public void testGameName() {
        List<PlayerBean> players = playerDao.selectPlayersByGame("绝地求生");
        System.out.println(players);
    }

    @Test
    public void testGameNamePage() {
        List<PlayerBean> players = playerDao.pagePlayersByGame("绝地求生", 1, 2);
        System.out.println(players);
    }

    @Test
    public void testGender() {
        List<PlayerBean> players = playerDao.selectPlayersByGender("女");
        System.out.println(players);
    }

    @Test
    public void testGenderPage() {
        List<PlayerBean> players = playerDao.pagePlayersByGender("男", 1, 2);
        System.out.println(players);
    }

    @Test
    public void testGameNaneAndLevel() {
        List<PlayerBean> players = playerDao.selectPlayersByGameAndLevel("绝地求生", "500分以下");
        System.out.println(players);
    }

    @Test
    public void testGameNaneAndLevelPage() {
        List<PlayerBean> players = playerDao.pagePlayersByGameAndLevel("王者荣耀", "钻石", 1, 1);
        System.out.println(players);
    }

    @Test
    public void testGameNaneAndLevelAndGender() {
        List<PlayerBean> players = playerDao.selectPlayersByGameAndLevelAndGender("绝地求生", "500分以下","男");
        System.out.println(players);
    }

    @Test
    public void testGameNaneAndLevelAndGenderPage() {
        List<PlayerBean> players = playerDao.pagePlayersByGameAndLevelAndGender("绝地求生", "500分以下","女",1,1);
        System.out.println(players);
    }

    @Test
    public void testName() {
        PlayerBean players = playerDao.selectPlayByName("Admin");
        System.out.println(players);
    }

    @Test
    public void testPlayId() {
        PlayerBean players = playerDao.selectPlayById(1);
        System.out.println(players);
    }



}
