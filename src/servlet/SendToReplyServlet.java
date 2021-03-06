package servlet;

import Dao.impl.ReplySqlDaoImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

//实现对回复进行回复的功能
public class SendToReplyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        int reply_id=Integer.parseInt(request.getParameter("reply_id"));
        String content=request.getParameter("content");
        int from_user_id= Integer.parseInt(request.getParameter("from_user_id"));
        int to_user_id= Integer.parseInt(request.getParameter("to_user_id"));
        ReplySqlDaoImpl replySqlDao=new ReplySqlDaoImpl();
        try {
            Integer a=replySqlDao.sendToReply(reply_id,content,from_user_id,to_user_id);
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
