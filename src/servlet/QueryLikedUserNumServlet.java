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

//查询用户关注的用户数量
public class QueryLikedUserNumServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        int like_user_id= Integer.parseInt(req.getParameter("like_user_id"));
        LoveSqlDaoImpl loveSqlDao=new LoveSqlDaoImpl();
        DataJson json=new DataJson();
        try {
            JSONArray jsonArray=json.changeJsonArray(loveSqlDao.likedUserNum(like_user_id));
            out.write(jsonArray.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
