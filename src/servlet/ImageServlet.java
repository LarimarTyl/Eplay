package servlet;


import util.RandomNum;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Create by czq
 * time on 2019/7/23  11:05
 */
@WebServlet(name = "ImageServlet", urlPatterns = "/ImageServlet")
public class ImageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置浏览器不要缓存此图片
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);


        BufferedImage bi = new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        Random random = new Random();
        Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        g.setColor(color);
        g.fillRect(0, 0, 68, 22);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            char c = RandomNum.getString();
            g.setColor(new Color(random.nextInt(88), random.nextInt(188), random.nextInt(255)));
            g.drawString(String.valueOf(c), (i * 15 + 3), 16);
            stringBuilder.append(c);
        }

        for (int i = 0; i < 4; i++) {
            Color color1 = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
            g.setColor(color1);
            final int x = random.nextInt(68);
            final int y = random.nextInt(22);
            final int w = random.nextInt(20);
            final int h = random.nextInt(20);
            final int signA = random.nextBoolean() ? 1 : -1;
            final int signB = random.nextBoolean() ? 1 : -1;
            g.drawLine(x, y, x + w * signA, y + h * signB);
        }
        //发布服务器生成的数字等会与前台传来的code进行对比
        request.getSession().setAttribute("picCode", stringBuilder.toString());
        //输出
        ImageIO.write(bi, "JPG", response.getOutputStream());
    }
}
