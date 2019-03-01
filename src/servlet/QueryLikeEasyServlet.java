package servlet;
                //查询收藏的文章信息
import Dao.impl.LoveSqlDaoImpl;
import DataHand.DataJson;
import net.sf.json.JSONArray;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

//查询用户喜欢的文章
public class QueryLikeEasyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        int user_id= Integer.parseInt(request.getParameter("user_id"));
        LoveSqlDaoImpl loveSqlDao=new LoveSqlDaoImpl();
        try {
            ResultSet resultSet=loveSqlDao.likedEasy(user_id);
            DataJson dataJson=new DataJson();
            JSONArray jsonArray=dataJson.changeJsonArray(resultSet);
            out.write(jsonArray.toString());
            out.flush();
            out.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
