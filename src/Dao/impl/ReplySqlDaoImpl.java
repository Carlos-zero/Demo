package Dao.impl;

import Dao.JdbcUtils;
import Dao.ReplySqlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReplySqlDaoImpl implements ReplySqlDao {
    JdbcUtils conn=new JdbcUtils();
    @Override
    public Integer sendReply(int comment_id, String content, int from_user_id, int to_user_id) throws SQLException {
        Connection connection=conn.getConnection();
        PreparedStatement statement=null;
        String sql="insert into reply (comment_id,content,from_user_id,to_user_id) value (?,?,?,?)";
        connection.prepareStatement(sql);
        statement.setInt(1,comment_id);
        statement.setString(2,content);
        statement.setInt(3,from_user_id);
        statement.setInt(4,to_user_id);
        Integer a=statement.executeUpdate();
        return a;
    }

    @Override
    public Integer sendToReply(int reply_id, String content, int from_user_id, int to_user_id) throws SQLException {
        Connection connection=conn.getConnection();
        PreparedStatement statement=null;
        String sql="insert into reply (reply_id,content,from_user_id,to_user_id) value (?,?,?,?)";
        connection.prepareStatement(sql);
        statement.setInt(1,reply_id);
        statement.setString(2,content);
        statement.setInt(3,from_user_id);
        statement.setInt(4,to_user_id);
        Integer a=statement.executeUpdate();
        return a;
    }
}
