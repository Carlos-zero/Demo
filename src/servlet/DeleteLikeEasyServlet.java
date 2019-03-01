package servlet;
import Dao.impl.LoveSqlDaoImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

//文章收藏的取消

public class DeleteLikeEasyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        int user_id= Integer.parseInt(request.getParameter("user_id"));
        int like_easy_id= Integer.parseInt(request.getParameter("like_easy_id"));
        LoveSqlDaoImpl loveSqlDao=new LoveSqlDaoImpl();             //实例化对象
        try {
            Integer a=loveSqlDao.deleteLikeEasy(user_id,like_easy_id);      //调用方法并返回结果
            if (a!=0){
                out.write("取消收藏成功！");
            }else {
                out.write("取消收藏失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
