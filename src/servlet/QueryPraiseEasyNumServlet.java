package servlet;

import Dao.impl.LoveSqlDaoImpl;
import DataHand.DataJson;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

//查询文章的点赞数量
public class QueryPraiseEasyNumServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        int praise_easy_id= Integer.parseInt(req.getParameter("praise_easy_id"));
        LoveSqlDaoImpl loveSqlDao=new LoveSqlDaoImpl();
        DataJson json=new DataJson();
        try {
            JSONArray jsonArray=json.changeJsonArray(loveSqlDao.praiseEasyNum(praise_easy_id));
            out.write(jsonArray.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
