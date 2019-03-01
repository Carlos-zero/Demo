package Dao.impl;

import Dao.CommentSqlDao;
import Dao.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommentSqlDaoImpl implements CommentSqlDao {
    public static JdbcUtils conn=new JdbcUtils();
    @Override
    public Integer sendComment(int easy_id, String content, int from_user_id) throws SQLException {
        Connection connection=conn.getConnection();
        PreparedStatement statement=null;
        String sql="insert into comment (easy_id,content,from_user_id) value (?,?,?）";
        statement=connection.prepareStatement(sql);
        statement.setInt(1,easy_id);
        statement.setString(2,content);
        statement.setInt(3,from_user_id);
        Integer a=statement.executeUpdate();
        connection.close();
        return a;
    }
}
