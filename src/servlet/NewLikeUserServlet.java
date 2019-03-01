package servlet;
import Dao.impl.LoveSqlDaoImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

//关注新用户

public class NewLikeUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        int user_id= Integer.parseInt(request.getParameter("user_id"));
        int like_user_id= Integer.parseInt(request.getParameter("like_user_id"));
        LoveSqlDaoImpl loveSqlDao=new LoveSqlDaoImpl();
        try {
            Integer a=loveSqlDao.newLikeUser(user_id,like_user_id);
            if (a!=0){
                out.write("关注成功！");
            }else {
                out.write("关注失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
