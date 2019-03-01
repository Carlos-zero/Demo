package servlet;
import Dao.impl.EasySqlDaoImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

//发送新文章

public class SendEasyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        int easy_pid= Integer.parseInt(request.getParameter("easy_pid"));
        String easy_name=request.getParameter("easy_name");
        String easy_class=request.getParameter("easy_class");
        String easy_content=request.getParameter("easy_content");
        EasySqlDaoImpl easySqlDao=new EasySqlDaoImpl();
        try {
            Integer a= easySqlDao.sendEasy(easy_pid,easy_name,easy_class,easy_content);
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
