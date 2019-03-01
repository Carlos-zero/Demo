package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void service(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        //判断上传表单是否为multipart/form-data类型
        HttpSession session=request.getSession();
        User user =(User) session.getAttribute("user");

//        if (ServletFileUpload)
    }
}
