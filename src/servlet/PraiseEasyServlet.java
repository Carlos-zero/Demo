package servlet;

import Dao.impl.LoveSqlDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
//文章点赞操作
public class PraiseEasyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        int user_id= Integer.parseInt(req.getParameter("user_id"));
        int praise_easy_id= Integer.parseInt(req.getParameter("praise_easy_id"));
        LoveSqlDaoImpl loveSqlDao=new LoveSqlDaoImpl();
        try {
            Integer a=loveSqlDao.praiseEasy(user_id,praise_easy_id);
            if (a==2){
                out.write("取消点赞！");
            }else {
                out.write("点赞成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
