package servlet;

import javax.servlet.http.HttpServlet;

public class UpdateUserServlet extends HttpServlet {
    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        int telephone= Integer.parseInt(request.getParameter("telephone"));
        String user_name=request.getParameter("user_name");
        String sex=request.getParameter("sex");
        String birthday=request.getParameter("birthday");
        String location=request.getParameter("location");
        String personalized_signature=request.getParameter("personalized_signature");
        int qq= Integer.parseInt(request.getParameter("qq"));
        String email=request.getParameter("email");
        String relationship_status=request.getParameter("relationship_status");
        UserSqlDaoImpl userSqlDao=new UserSqlDaoImpl();
        try {
            Integer a=userSqlDao.updateUser(telephone,user_name,sex,birthday,location,personalized_signature,qq,email,relationship_status);
            if (a!=0){
                out.write("更新成功！");
            }else {
                out.write("更新失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}
