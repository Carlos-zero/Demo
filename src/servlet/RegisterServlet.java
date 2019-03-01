package servlet;
import Dao.impl.UserSqlDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

//注册系统

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String telephone=request.getParameter("telephone");
        String user_name=request.getParameter("user_name");
        String password=request.getParameter("password");
        String sex=request.getParameter("sex");
        String birthday=request.getParameter("birthday");
        String location=request.getParameter("location");
        String hobby=request.getParameter("hobby");
        UserSqlDaoImpl userSql=new UserSqlDaoImpl();
        PrintWriter out=response.getWriter();               //直接返回字符串
        try {
            Integer id=userSql.insertUser(telephone,user_name,password,sex,birthday,location,hobby);
            if (id!=null){
                //注册成功  跳转到登录页面
//                response.sendRedirect(request.getContextPath()+"/login.jsp");
                out.write("1");

//                response.sendRedirect(request.getContextPath()+"/servlet.jsp");
            }else {
                out.write("register failure！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
