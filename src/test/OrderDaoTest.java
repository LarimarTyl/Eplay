package test;

import bean.OrderBean;
import dao.OrderDao;

import org.junit.Test;
import util.Factory;
import java.util.List;


/**
 * @author Larimar
 * @time 2019/7/25 星期四 23:33
 */

public class OrderDaoTest {
    OrderDao orderDao= Factory.getInstance("orderDao",OrderDao.class);

    @Test
//    有点问题
    public void saveOrder() {
        OrderBean orderBean = new OrderBean();
        orderBean.setGameID(1);
        orderBean.setUserID(4);
        orderBean.setPlayerID(1);
        orderBean.setContact("V:13617004500");
        orderBean.setPayWay(0);
        orderBean.setStarttime("2019-07-24 18:30:00");
        orderBean.setEndtime("2019-07-24 20:30:00");
        orderBean.setPrice(60);
        orderBean.setAppraise(null);
        orderBean.setRemark(null);
        boolean save = orderDao.saveOrder(orderBean);
        if (save){
            System.out.println("测试保存成功");
        }else {
            System.out.println("测试保存失败");
        }
    }
    @Test
    public void upDateOrder() {
        OrderBean orderBean = new OrderBean();
        orderBean.setId(1);
        orderBean.setGameID(2);
        orderBean.setUserID(2);
        orderBean.setPlayerID(1);
        orderBean.setContact("2411699692");
        orderBean.setPayWay(0);
        orderBean.setStarttime("2019-07-25 18:30:00");
        orderBean.setEndtime("2019-07-25 20:30:00");
        orderBean.setPrice(60);
        orderBean.setAppraise("测试更新成功");
        orderBean.setRemark(null);
        boolean update = orderDao.upDateOrder(orderBean);
        if (update){
            System.out.println("测试更新成功");
        }else {
            System.out.println("测试更新失败");
        }
    }
    @Test
    public void delOrder() {
        OrderBean orderBean = new OrderBean();
        orderBean.setId(3);
        orderBean.setGameID(2);
        orderBean.setUserID(3);
        orderBean.setPlayerID(1);
        orderBean.setContact("565203943");
        orderBean.setPayWay(0);
        orderBean.setStarttime("2019-07-25 18:30:00");
        orderBean.setEndtime("2019-07-25 20:30:00");
        orderBean.setPrice(60);
        orderBean.setAppraise("可还行");
        orderBean.setRemark(null);
        boolean del = orderDao.delOrder(orderBean);
        if (del){
            System.out.println("测试删除成功");
        }else {
            System.out.println("测试删除失败");
        }
    }


    @Test
    public void selectOrderById() {
        OrderBean orderBean = orderDao.selectOrderById(3);
        if (orderBean!=null){
            System.out.println(orderBean.toString());
            System.out.println("测试id查询成功");
        }else {
            System.out.println("测试id查询失败");
        }
    }

    @Test
    public void selectAllOrders() {
        List<OrderBean> orderBeans = orderDao.selectAllOrders();
        if (orderBeans!=null){
            System.out.println(orderBeans.toString());
            System.out.println("测试查询所有用户成功！");
        }else {
            System.out.println("测试查询所有用户失败，更改代码后重试");
        }
    }


    @Test
    public void pageAllOrders() {
        List<OrderBean> orderBeans = orderDao.pageAllOrders(1, 2);
        if (orderBeans.size()>0){
            System.out.println(orderBeans.toString());
            System.out.println("测试分页查询所有用户成功");
        }else {
            System.out.println("测试分页查询所有用户失败");
        }
    }

    @Test
    public void selectOrdersByUser() {
        List<OrderBean> larimar = orderDao.selectOrdersByUser("宋远桥");
        if (larimar.size()>0){
            System.out.println(larimar.toString());
            System.out.println("测试查询用户订单成功");
        }else {
            System.out.println("测试查询用户订单失败");
        }
    }

    @Test
    public void pageOrdersByUser() {
        List<OrderBean> pageLarimar = orderDao.pageOrdersByUser("宋远桥", 1, 2);
        if (pageLarimar.size()>0){
            System.out.println(pageLarimar.toString());
            System.out.println("测试分页查询用户订单成功");
        }else {
            System.out.println("测试分页查询用户订单失败");
        }
    }

    @Test
    public void selectOrdersByGame() {
        List<OrderBean> game = orderDao.selectOrdersByGame("王者荣耀");
        if (game.size()>0){
            System.out.println(game.toString());
            System.out.println("测试查询游戏订单成功");
        }else {
            System.out.println("测试查询游戏订单失败");
        }
    }

    @Test
    public void pageOrdersByGame() {
        List<OrderBean> game = orderDao.pageOrdersByGame("王者荣耀",1,2);
        if (game.size()>0){
            System.out.println(game.toString());
            System.out.println("测试分页查询游戏订单成功");
        }else {
            System.out.println("测试分页查询游戏订单失败");
        }
    }

    @Test
    public void selectOrdersByDate() {
        List<OrderBean> orderBeans = orderDao.selectOrdersByDate("2019-07-25 18:20:00");
        if (orderBeans.size()>0) {
            System.out.println(orderBeans.toString());
            System.out.println("测试指定日期前订单成功");
        }else {
            System.out.println("测试指定日期前订单失败");
        }
    }

    @Test
    public void pageOrdersByDate() {
        List<OrderBean> orderBeans = orderDao.pageOrdersByDate("2019-07-25 18:20:00",1,2);
        if (orderBeans.size()>0) {
            System.out.println(orderBeans.toString());
            System.out.println("测试分页指定日期前订单成功");
        }else {
            System.out.println("测试分页指定日期前订单失败");
        }
    }

    @Test
    public void selectOrdersByPayWay() {
        List<OrderBean> orderBeans = orderDao.selectOrdersByPayWay(0);
        if (orderBeans.size()>0) {
            System.out.println(orderBeans.toString());
            System.out.println("测试指定支付方式的订单成功");
        }else {
            System.out.println("测试指定支付方式的订单失败");
        }
    }

    @Test
    public void pageOrdersByPayWay() {
        List<OrderBean> orderBeans = orderDao.pageOrdersByPayWay(0,1,2);
        if (orderBeans.size()>0) {
            System.out.println(orderBeans.toString());
            System.out.println("测试分页指定支付方式的订单成功");
        }else {
            System.out.println("测试分页指定支付方式的订单失败");
        }
    }

    @Test
    public void selectOrdersByPoints() {
        List<OrderBean> orderBeans = orderDao.selectOrdersByPayWay(0);
        if (orderBeans.size()>0) {
            System.out.println(orderBeans.toString());
            System.out.println("测试评价大于指定参数的订单成功");
        }else {
            System.out.println("测试评价大于指定参数的订单失败");
        }
    }

    @Test
    public void pageOrdersByPoints() {
        List<OrderBean> orderBeans = orderDao.pageOrdersByPayWay(0,1,5);
        if (orderBeans.size()>0) {
            System.out.println(orderBeans.toString());
            System.out.println("测试分页评价大于指定参数的订单成功");
        }else {
            System.out.println("测试分页评价大于指定参数的订单失败");
        }
    }
    @Test
    public void order(){
        List<OrderBean> list = orderDao.selectOrdersByPlayer("咕咕乐ღ");
        System.out.println(list);
    }
}
