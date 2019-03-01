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

//主页面分类文章的显示

public class ClassifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        String str="%"+request.getParameter("classify")+"%";                //接受用户选择的分类关键字
        EasySqlDaoImpl easySqlDao=new EasySqlDaoImpl();                         //实例化
        try {
            ResultSet resultSet=easySqlDao.classify(str);                       //调用查询分类方法
            DataJson dataJson=new DataJson();                                   //转JSON
            JSONArray jsonArray=dataJson.changeJsonArray(resultSet);
            out.write(jsonArray.toString());                                    //向前端返回分类的数据
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
