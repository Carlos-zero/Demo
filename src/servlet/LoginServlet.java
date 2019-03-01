package servlet;

import Dao.impl.UserSqlDaoImpl;
import DataHand.DataJson;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

//登录信息的验证

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        //接收请求的参数
        String telephone=request.getParameter("telephone");
        String password=request.getParameter("password");

        UserSqlDaoImpl userSql=new UserSqlDaoImpl();
        PrintWriter out=response.getWriter();
        try {
            User user=userSql.login(telephone,password);
            DataJson dataJson=new DataJson();
            JSONArray array=dataJson.changeJsonArrayUser(user);
            if (user!=null){
                out.write(array.toString());                                            //像前端返回用户个人信息
                request.getSession().setAttribute("user",user);
//                response.sendRedirect(request.getContextPath()+"/mainPage.jsp");     //页面跳转至留言板
            }else {
                out.write("");
//                response.sendRedirect(request.getContextPath()+"/servlet.jsp");       //密码错误，重新登录
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
