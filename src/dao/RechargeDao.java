package dao;

import bean.RechargeBean;

import java.util.Date;
import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 16:21
 */
public interface RechargeDao {
    /**
     * 保存充值
     * @param RechargeMoney 充值金额
     * @param recharge 充值对象
     * @return 充值状态
     */
    public boolean saveRecharge(double RechargeMoney, RechargeBean recharge);

    /**
     * 删除充值信息
     * @param userName 用户名
     * @param recharge 充值对象
     * @return 删除特定用户的充值信息
     */
    public boolean delRecharge(String userName,RechargeBean recharge);

    /**
     * 更新充值信息
     * @param userName 用户名
     * @param recharge 充值对象
     * @return 返回更新特定用户的充值状态
     */
    public boolean updateRecharge(String userName,RechargeBean recharge);

    /**
     * 查找某个用户的全部充值订单
     * @param userName 用户名
     * @return 全部充值订单
     */
    public List<RechargeBean> selectAllRechers(String userName);

    /**
     * 分页查找某个用户的全部充值订单
     * @param userName 用户名
     * @param currentPage 当前页
     * @param pageSize 页面大小
     * @return 分页后用户的全部订单
     */
    public List<RechargeBean> pageAllRechers(String userName,int currentPage,int pageSize);

    /**
     * 根据充值方式查找充值订单
     * @param type 充值类型
     * @return 该充值方式的充值订单
     */
    public List<RechargeBean> selectRechersByType(int type);

    /**
     * 根据充值方式分页查找充值订单
     * @param type 类型
     * @param currentPage 当前页
     * @param pageSize 页面大小
     * @return 返回分页后特定充值方式的订单
     */
    public List<RechargeBean> pageRechersByType(int type,int currentPage,int pageSize);

    /**
     * 根据日期查找充值信息
     * @param date 日期
     * @return 返回指定日期的充值信息
     */
    public List<RechargeBean> selectRechersByDate(String date);

    /**
     * 根据日期分页查找充值信息
     * @param date 日期
     * @param currentPage 当前页面
     * @param pageSize 页面大小
     * @return 特定日期的充值信息
     */
    public List<RechargeBean> pageRechersByDate(String date,int currentPage,int pageSize);

    /**
     * 查询充值金额
     * @param id 冲值表id
     * @return 返回充值金额
     */
    public double selectMoneyById(int id);

}
