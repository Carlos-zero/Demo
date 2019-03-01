package servlet;
import Dao.impl.EasySqlDaoImpl;
import DataHand.DataJson;
import net.sf.json.JSONArray;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

//搜索内容的返回

public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收用户搜索内容
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        String str1="%"+request.getParameter("search")+"%";
        EasySqlDaoImpl easySqlDao=new EasySqlDaoImpl();
        ResultSet resultSet= null;
        try {
            resultSet = easySqlDao.search(str1);
            DataJson dataJson=new DataJson();
            JSONArray jsonArray=dataJson.changeJsonArray(resultSet);
            out.write(jsonArray.toString());
            out.flush();
            out.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*public String getSearchEasy(HttpServletRequest request,HttpServletResponse response) throws IOException, SQLException {

        return null;
    }*/
}
