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

//查询评论的点赞数
public class QueryPraiseCommentNumServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        int praise_comment_id= Integer.parseInt(req.getParameter("praise_comment_id"));
        LoveSqlDaoImpl loveSqlDao=new LoveSqlDaoImpl();
        DataJson json=new DataJson();
        try {
            JSONArray jsonArray=json.changeJsonArray(loveSqlDao.praiseCommentNum(praise_comment_id));
            out.write(jsonArray.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
