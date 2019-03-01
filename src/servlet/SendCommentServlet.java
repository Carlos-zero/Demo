package servlet;

import Dao.impl.CommentSqlDaoImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

//实现发送评论的功能
public class SendCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        int easy_id= Integer.parseInt(request.getParameter("easy_id"));
        String content=request.getParameter("content");
        int from_user_id= Integer.parseInt(request.getParameter("from_user_id"));
        CommentSqlDaoImpl commentSqlDao=new CommentSqlDaoImpl();
        try {
            Integer a=commentSqlDao.sendComment(easy_id,content,from_user_id);
            if (a!=0){
                out.write("发送成功！");
            }else {
                out.write("发送失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
