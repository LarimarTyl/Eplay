package service;


import bean.PlayerBean;
import bean.UserBean;

import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 17:18
 */
public interface AdminService {
    public List<UserBean> selectTopSpentUser();//查看高消费用户
    public boolean checkPlayer();//审核陪玩信息
    public List<PlayerBean> listNewPlayers();//新秀陪玩
    public List<PlayerBean> listTopPricePlayers();//高收入陪玩
    public List<PlayerBean> listTopOrderPlayers();//订单量大陪玩

}
