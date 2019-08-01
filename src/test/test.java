package test;

import bean.UserBean;
import dao.PlayerDao;
import dao.UserDao;
import org.junit.Test;
import service.PlayerService;
import util.Factory;

/**
 * @author Larimar
 * @time 2019/8/1 周四 17:26
 */
public class test {
    static PlayerService playerService;
    static PlayerDao playerDao;
    static {
        playerService= Factory.getInstance("playerService",PlayerService.class);
        playerDao= Factory.getInstance("playerDao",PlayerDao.class);
    }
    @Test
    public void test(){
        System.out.println(playerDao.selectPlayById(1));
    }
}
