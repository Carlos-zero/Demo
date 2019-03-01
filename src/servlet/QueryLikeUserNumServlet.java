package servlet;

import Dao.impl.LoveSqlDaoImpl;
import DataHand.DataJson;
import net.sf.json.JSONArray;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


//查询用户的粉丝数量
public class QueryLikeUserNumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        int user_id= Integer.parseInt(request.getParameter("user_id"));
        LoveSqlDaoImpl loveSqlDao=new LoveSqlDaoImpl();
        DataJson json=new DataJson();
        try {
            JSONArray jsonArray=json.changeJsonArray(loveSqlDao.likeUserNum(user_id));
            out.write(jsonArray.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
