package servlet;

import service.UserService;
import util.Factory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mr Wu
 * @create: 2019-07-31 14:40
 */
public class UserServlet extends HttpServlet {

    private UserService userService;


    public UserServlet(){
        userService= Factory.getInstance("userService",UserService.class);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;char=utf-8");
        String servletPath = request.getServletPath();
        if(servletPath.contains("login")){
            doLogin(request,response);
            System.out.println("执行登录操作");
        }else if(servletPath.contains("register")){
            doRegister(request,response);
            System.out.println("执行注册操作");
        }else if(servletPath.contains("active")){
            doActive(request,response);
            System.out.println("执行激活操作");
        }else if(servletPath.contains("order")){
            doOrder(request,response);
            System.out.println("执行订单操作");
        }else if(servletPath.contains("comment")){
            doComment(request,response);
            System.out.println("执行评论操作");
        }else if(servletPath.contains("recharrge")){
            doCharge(request,response);
            System.out.println("执行充值操作");
        }else if(servletPath.contains("Focus")){
            doFocus(request,response);
            System.out.println("执行关注有关得操作");
        }else if(servletPath.contains("selectCusConsumption")){
            doSelectOrder(request,response);
            System.out.println("执行查看用户消费的操作");
        }else if(servletPath.contains("selectPlayerIncome")){
            doSelectPlayerIncome(request,response);
            System.out.println("执行查询主播收入的操作");
        }else if(servletPath.contains("updatePsw")){
            doUpdatePsw(request,response);
            System.out.println("执行修改密码操作");
        }else if(servletPath.contains("bePlayer")){
            doBePlayer(request,response);
            System.out.println("执行申请成为主播的操作");
        }else if(servletPath.contains("modifyInfo")){
            doModifyInfo(request,response);
            System.out.println("执行修改用户信息的操作");
        }else if(servletPath.contains("loveGame")){
            doLoveGame(request,response);
            System.out.println("执行游戏偏好的操作");
        }else if(servletPath.contains("BlackList")){
            doBlackList(request,response);
            System.out.println("执行黑名单的操作");
        }
    }


    /**
     * 执行登录的操作
     * */
    private void doLogin(HttpServletRequest request, HttpServletResponse response) {
    }
    /**
     * 执行注册操作
     * */
    private void doRegister(HttpServletRequest request, HttpServletResponse response) {
    }
    /**
     *执行激活操作
     * */
    private void doActive(HttpServletRequest request, HttpServletResponse response) {
    }
    /**
     *执行订单相关的操作
     * */
    private void doOrder(HttpServletRequest request, HttpServletResponse response) {
    }
    /**
     *执行评论相关的操作
     * */
    private void doComment(HttpServletRequest request, HttpServletResponse response) {
    }
    /**
     *执行充值相关的操作
     * */
    private void doCharge(HttpServletRequest request, HttpServletResponse response) {
    }
    /**
     *执行关注相关的操作
     * */
    private void doFocus(HttpServletRequest request, HttpServletResponse response) {
    }
    /**
     *执行查询用户消费的操作
     * */
    private void doSelectOrder(HttpServletRequest request, HttpServletResponse response) {
    }
    /**
     *执行查询主播收入的操作
     * */
    private void doSelectPlayerIncome(HttpServletRequest request, HttpServletResponse response) {
    }
    /**
     *执行更新用户密码的操作
     * */
    private void doUpdatePsw(HttpServletRequest request, HttpServletResponse response) {
    }
    /**
     *执行申请用户成为主播的操作
     * */
    private void doBePlayer(HttpServletRequest request, HttpServletResponse response) {
    }
    /**
     *执行用户修改基本信息的操作
     * */
    private void doModifyInfo(HttpServletRequest request, HttpServletResponse response) {
    }
    /**
     *执行处理游戏偏好相干的操作
     * */
    private void doLoveGame(HttpServletRequest request, HttpServletResponse response) {
    }
    /**
     *执行黑名单的相关操作
     * */
    private void doBlackList(HttpServletRequest request, HttpServletResponse response) {
    }
}
