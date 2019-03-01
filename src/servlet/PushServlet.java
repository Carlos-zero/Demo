package servlet;

import Dao.impl.EasySqlDaoImpl;
import DataHand.DataJson;
import net.sf.json.JSONArray;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class PushServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        int user_id= Integer.parseInt(request.getParameter("user_id"));
        EasySqlDaoImpl easySqlDao=new EasySqlDaoImpl();
        DataJson json=new DataJson();
        try {
            JSONArray jsonArray=json.changeJsonArray(easySqlDao.push(user_id));
            out.write(jsonArray.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
