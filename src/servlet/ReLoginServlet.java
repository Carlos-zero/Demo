package servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//退出登录

public class ReLoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        HttpSession session=request.getSession(false);              //防止创建session
        if (session==null){
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return;
        }
        session.removeAttribute("user");
        response.sendRedirect(request.getContextPath()+"/login.jsp");
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws  IOException,ServletException{

    }
}
