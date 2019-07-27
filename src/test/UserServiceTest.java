package test;

import bean.OrderBean;
import bean.PlayerBean;
import bean.UserBean;
import org.junit.Test;
import service.UserService;
import util.DateUtil;
import util.Factory;

import java.time.LocalDateTime;

/**
 * Create by czq
 * time on 2019/7/26  17:15
 */
public class UserServiceTest {
    private static UserService userService = Factory.getInstance("UserServiceImpl", UserService.class);

    @Test
    public void testTakeOrder() {
        //订单时间
        long intervalTime = 2;
        int payway = 1;
        LocalDateTime startD = LocalDateTime.now();
        String start = DateUtil.convert(startD);
        String end = DateUtil.convert(startD, intervalTime);
        PlayerBean player = new PlayerBean(1, 3, 30);
        UserBean user = new UserBean(1, "13617004500", 150, 136);
        OrderBean order = new OrderBean(player.getGameID(), user.getId(), player.getPlayerID(), user.getTelephone(), payway, start, end, player.getMoney(), null, "漂亮的小姐姐");
        userService.takeOrder(user, player, order);
    }
}
