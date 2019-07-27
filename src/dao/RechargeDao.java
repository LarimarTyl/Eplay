package dao;

import bean.RechargeBean;

import java.util.Date;
import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 16:21
 */
public interface RechargeDao {
    public boolean saveRecharge(double RechargeMoney, RechargeBean recharge);
    public boolean delRecharge(String userName,RechargeBean recharge);
    public boolean updateRecharge(String userName,RechargeBean recharge);
    public List<RechargeBean> selectAllRechers(String userName);//查找某个用户的全部充值订单
    public List<RechargeBean> pageAllRechers(String userName,int currentPage,int pageSize);//分页查找某个用户的全部充值订单
    public List<RechargeBean> selectRechersByType(int type);//根据充值方式查找充值订单
    public List<RechargeBean> pageRechersByType(int type,int currentPage,int pageSize);//根据充值方式分页查找充值订单
    public List<RechargeBean> selectRechersByDate(String date);//根据日期查找充值信息
    public List<RechargeBean> pageRechersByDate(String date,int currentPage,int pageSize);//根据日期分页查找充值信息
    public double selectMoneyById(int id);//查询充值金额

}
