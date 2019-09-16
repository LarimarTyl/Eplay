package servlet;

import bean.MessageBean;
import bean.OrderBean;
import bean.UserBean;
import cn.dsna.util.images.ValidateCode;
import com.alibaba.fastjson.JSON;
import dao.UserDao;
import service.UserService;
import util.Factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Mr Wu
 * @create: 2019-07-31 14:40
 */
@WebServlet("*.user")
public class UserServlet extends HttpServlet {

    private UserService userService;
    private UserDao userDao;

    public UserServlet(){
        userService= Factory.getInstance("userService",UserService.class);
        userDao = Factory.getInstance("userDao",UserDao.class);
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
            System.out.println("执行登录操作");
            doLogin(request,response);
        }else if(servletPath.contains("register")){
            System.out.println("执行注册操作");
            doRegister(request,response);
        }else if(servletPath.contains("active")){
            System.out.println("执行激活操作");
            doActive(request,response);
        }else if(servletPath.contains("order")){
            System.out.println("执行订单操作");
            doOrder(request,response);
        }else if(servletPath.contains("comment")){
            System.out.println("执行评论操作");
            doComment(request,response);
        }else if(servletPath.contains("recharrge")){
            System.out.println("执行充值操作");
            doCharge(request,response);
        }else if(servletPath.contains("Focus")){
            System.out.println("执行关注有关得操作");
            doFocus(request,response);
        }else if(servletPath.contains("selectCusConsumption")){
            System.out.println("执行查看用户消费的操作");
            doSelectOrder(request,response);
        }else if(servletPath.contains("selectPlayerIncome")){
            System.out.println("执行查询主播收入的操作");
            doSelectPlayerIncome(request,response);
        }else if(servletPath.contains("updatePsw")){
            System.out.println("执行修改密码操作");
            doUpdatePsw(request,response);
        }else if(servletPath.contains("bePlayer")){
            System.out.println("执行申请成为主播的操作");
            doBePlayer(request,response);
        }else if(servletPath.contains("modifyInfo")){
            System.out.println("执行修改用户信息的操作");
            doModifyInfo(request,response);
        }else if(servletPath.contains("loveGame")){
            System.out.println("执行游戏偏好的操作");
            doLoveGame(request,response);
        }else if(servletPath.contains("BlackList")){
            System.out.println("执行黑名单的操作");
            doBlackList(request,response);
        }else if (servletPath.contains("exitLogin")){
            System.out.println("退出登录。");
            doExit(request,response);
        }
        else if(servletPath.contains("checkCode")){
            System.out.println("验证码生成");
            doCode(request,response);
        }else if (servletPath.contains("disPlaymessage")) {
            doDisPlayMessage(request, response);
        } else if (servletPath.contains("messageContent")) {
            doDisPlayMessageContent(request, response);
        } else if (servletPath.contains("deleteMessage")) {
            doDeleteMessage(request, response);
        } else if (servletPath.contains("rejectOrder")) {
            doRejectOrder(request, response);
        } else if (servletPath.contains("acceptOrder")) {
            doAcceptOrder(request, response);
        }else if (servletPath.contains("CommentOrder")) {
            doCommentOrder(request, response);
        }
    }
    /*退出登录*/
    private void doExit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("loginMsg");
        request.getRequestDispatcher("/public/html/index/index.jsp").forward(request,response);
    }

    /**
     * 生成验证码的方法
     */
    private void doCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ValidateCode vc = new ValidateCode(90, 30, 4, 9);
        request.getSession().setAttribute("scode",vc.getCode());
        vc.write(response.getOutputStream());
    }


    /**
     * 执行登录的操作
     * */
    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String checkCode = (String)request.getSession().getAttribute("checkCode");
        /*先验证码验证*/
        if (!code.equalsIgnoreCase(checkCode)){
        System.out.println(code+":"+checkCode+" "+code.equalsIgnoreCase(checkCode));
            request.getSession().setAttribute("loginMsg","验证码错误");
            request.getSession().removeAttribute("registerMsg");
            request.getRequestDispatcher("/public/html/index/index.jsp").forward(request,response);
        }else {
            /*登录验证*/
            String loginName = request.getParameter("loginName");
            String loginPwd = request.getParameter("loginPwd");
            /*判断用户是否存在*/
            if (userDao.selectUserByLoginName(loginName)!=null){
                /*登录验证判断*/
                if (userDao.loginCheck(loginName,loginPwd)!=null) {
                    /*判断是否激活*/
                    if(userDao.selectRegisterStatusByLoginName(loginName)==1){
                        request.getSession().setAttribute("user",userDao.selectUserByLoginName(loginName));
                        request.getSession().removeAttribute("registerMsg");
                        System.out.println("我要跳了哦");
                        request.getRequestDispatcher("/public/html/index/index.jsp").forward(request,response);
                    }else {
                        request.getSession().setAttribute("loginMsg","请先去邮箱激活");
                        request.getSession().removeAttribute("registerMsg");
                        request.getRequestDispatcher("/public/html/index/index.jsp").forward(request,response);
                    }
                }else {
                    request.getSession().setAttribute("loginMsg","用户名或密码错误");
                    request.getSession().removeAttribute("registerMsg");
                    request.getRequestDispatcher("/public/html/index/index.jsp").forward(request,response);
                }
            }
            else {
                request.getSession().setAttribute("loginMsg","用户名或密码错误");
                request.getSession().removeAttribute("registerMsg");
                request.getRequestDispatcher("/public/html/index/index.jsp").forward(request,response);
            }

        }

    }
    /**
     * 执行注册操作
     * */
    private void doRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginName = request.getParameter("loginName");
        String loginPwd = request.getParameter("loginPwd");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String qq = request.getParameter("QQ");
        UserBean userBean = new UserBean(loginName, loginPwd, gender, email, telephone, qq);
        System.out.println(userBean);
        if (userDao.saveUser(userBean)) {
            request.getSession().setAttribute("registerMsg","注册成功请登录。");
        }else {
            request.getSession().setAttribute("registerMsg","注册失败。");
        }
        request.getRequestDispatcher("/public/html/index/index.jsp").forward(request,response);
    }
    /**
     *执行激活操作
     * */
    private void doActive(HttpServletRequest request, HttpServletResponse response) {
    }
    /**
     *执行订单相关的操作
     * */
    private void doOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //模拟注册一个用户
        UserBean user = new UserBean(1, "宋远桥", "syq", null, "宋远桥", "1963-06-27 13:23:09", "男", "234593591@qq.com", "14592380123", "ia_10027.jpg", 0, 0, "234593591", "2013-06-27 12:00:00");


//        UserBean user = (UserBean) request.getAttribute("user");
        //根据用户名查找自己的所有的订单
        List<OrderBean> userOrders = userService.selectOrders(user.getStaffName());

        //返回陪玩还没有确定接收的订单
        List<OrderBean> playOrders = userService.selectOrdersByPlayId(user.getId(), 0);

        //放回陪玩接收的订单
        List<OrderBean> acceptPlayOrders = userService.selectOrdersByPlayId(user.getId(), 1);

        request.setAttribute("userOrders", userOrders);
        request.setAttribute("playOrders", playOrders);
        request.setAttribute("acceptPlayOrders", acceptPlayOrders);

        //条状页面到order页面
        request.getRequestDispatcher("/public/html/home/orderlist.jsp").forward(request, response);
    }
    /**
     * 拒绝订单
     *
     * @param request
     * @param response
     */
    private void doRejectOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        OrderBean order = userService.queryOrderById(Integer.parseInt(id));
        userService.delOrder(order);
    }

    /**
     * 接收订单
     * @param request
     * @param response
     */
    private void doAcceptOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        OrderBean order = userService.queryOrderById(Integer.parseInt(id));
        System.out.println("123"+order);
        order.setStatus(1);

        //接收后更新订单的状态
        userService.comment(order);
        String acceptOrder = JSON.toJSONString(order);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.print(acceptOrder);
    }

    /**
     * 评论功能
     */
    private void  doCommentOrder(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String comment = request.getParameter("comment");
        OrderBean order = userService.queryOrderById(Integer.parseInt(id));
        order.setAppraise(comment);
        userService.comment(order);
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
        System.out.println("执行更新用户密码的操作");
        UserBean userBean=((UserBean)request.getSession().getAttribute("userBean"));
        String loginPsw=request.getParameter("loginPsw");
        String newLoginPwd=request.getParameter("newLoginPwd");
        String loginPwdCheck=request.getParameter("loginPwdCheck");
        if (userBean.getLoginPwd().equals(loginPsw)){
            if (newLoginPwd.equals(loginPwdCheck)){
                userBean.setLoginPwd(newLoginPwd);
                boolean flag=userService.modefyInfo(userBean);
                if (flag){
                    request.setAttribute("msg","修改密码成功");
                    request.getSession().setAttribute("userBean",userBean);
                }else {
                    request.setAttribute("msg","两次新密码相同，修改密码失败");
                }

            }else{
                request.setAttribute("msg","两次新密码不同");
            }

        }else {
            request.setAttribute("msg","原密码错误");
        }
        try {
            request.getRequestDispatcher("public/html/home/securitycenter.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        System.out.println("执行用户修改基本信息的操作");
        String staffName=request.getParameter("staffName");
        String YYYY=request.getParameter("YYYY");
        String MM=request.getParameter("MM");
        String DD=request.getParameter("DD");
        String date=YYYY+"-"+MM+"-"+DD;
        String gender=request.getParameter("gender");
        String email=request.getParameter("email");
        String telephone=request.getParameter("telephone");
        String QQ=request.getParameter("QQ");
        System.out.println(staffName+date+gender+email+telephone+QQ);
        UserBean userBean=(UserBean) request.getSession().getAttribute("userBean");
        userBean.setStaffName(staffName);
        userBean.setGender(gender);
        userBean.setEmail(email);
        userBean.setQQ(QQ);
        userBean.setTelephone(telephone);
        userBean.setBirthday(date);
        userService.modefyInfo(userBean);
        request.getSession().setAttribute("userBean",userBean);
        request.setAttribute("msg","修改成功");
        try {
            request.getRequestDispatcher("public/html/home/myprofile.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     *执行处理游戏偏好相干的操作
     * */
    private void doLoveGame(HttpServletRequest request, HttpServletResponse response) {
    }
    /**
     * 展示点击的消息的内容
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doDisPlayMessageContent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String messageId = request.getParameter("messageId");
        MessageBean message = userService.queryMessage(Integer.parseInt(messageId));
        message.setStatus(1);
        //更新该消息为已读状态
        userService.updateMessage(message);

        request.setAttribute("content", message);

        //转发去消息展示页面
        request.getRequestDispatcher("/public/html/home/messagedisplay.jsp").forward(request, response);
    }

    /**
     * 展示用户消息
     *
     * @param request
     * @param response
     */
    private void doDisPlayMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取当前登入的用户
//        UserBean user = (UserBean) request.getAttribute("user");

        //模拟注册一个用户
        UserBean user = new UserBean(1, "宋远桥", "syq", null, "宋远桥", "1963-06-27 13:23:09", "男", "234593591@qq.com", "14592380123", "ia_10027.jpg", 0, 0, "234593591", "2013-06-27 12:00:00");
        //放回该用户的全部消息
        List<MessageBean> messages = userService.queryMessageListByUserName(user.getStaffName());
        //未读消息
        List<MessageBean> NoReadermessage = userService.queryMessageListByUserNameAndStatus(user.getStaffName(), 0);
        int noRead = NoReadermessage.size();
        request.setAttribute("messages", messages);
        //未读消息长度
        request.setAttribute("noread", noRead);
        //转发页面去消息页面
        request.getRequestDispatcher("/public/html/home/message.jsp").forward(request, response);
    }

    private void doDeleteMessage(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        MessageBean message = userService.queryMessage(Integer.parseInt(id));
        userService.deleteMessage(message);
    }

    /**
     *执行黑名单的相关操作
     * */
    private void doBlackList(HttpServletRequest request, HttpServletResponse response) {
    }
}
