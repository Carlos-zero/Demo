package Dao.impl;

import Dao.JdbcUtils;
import Dao.LoveSqlDao;

import java.sql.*;

public class LoveSqlDaoImpl implements LoveSqlDao {
    public static JdbcUtils conn=new JdbcUtils();
    Connection connection;
    {
        try {
            connection = conn.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    PreparedStatement statement=null;
    @Override
    public Integer newLikeUser(int user_id, int like_user_id) throws SQLException {
        String sql="insert into love(user_id,like_user_id)value(?,?)";
        statement=connection.prepareStatement(sql);
        statement.setInt(1,user_id);
        statement.setInt(2,like_user_id);
        Integer a=statement.executeUpdate();
        connection.close();
        return a;
    }

    @Override
    public ResultSet likedUser(int user_id) throws SQLException {
//        String sql="select like_user_id from love where user_id=?";
        String sql="select * from user where id in (select like_user_id from love where user_id=?)";
        statement=connection.prepareStatement(sql);
        statement.setInt(1,user_id);
        ResultSet resultSet=statement.executeQuery();
        return resultSet;
    }

    @Override
    public Integer deleteLikeUser(int user_id, int like_user_id) throws SQLException {
        String sql="delete from love where user_id=? and like_user_id=?";
        statement=connection.prepareStatement(sql);
        statement.setInt(1,user_id);
        statement.setInt(2,like_user_id);
        Integer a=statement.executeUpdate();
        connection.close();;
        return a;
    }

    @Override
    public Integer newLikeEasy(int user_id, int like_easy_id) throws SQLException {
        String sql="insert into love(user_id,like_easy_id)value(?,?)";
        statement=connection.prepareStatement(sql);
        statement.setInt(1,user_id);
        statement.setInt(2,like_easy_id);
        Integer a=statement.executeUpdate();
        connection.close();
        return a;
    }

    @Override
    public ResultSet likedEasy(int user_id) throws SQLException {
        String sql="select * from easy where id in (select like_easy_id from love where user_id=?)";
        statement=connection.prepareStatement(sql);
        statement.setInt(1,user_id);
        ResultSet resultSet=statement.executeQuery();
        return resultSet;
    }

    @Override
    public Integer deleteLikeEasy(int user_id, int like_easy_id) throws SQLException {
        String sql="delete from love where user_id=? and like_easy_id=?";
        statement=connection.prepareStatement(sql);
        statement.setInt(1,user_id);
        statement.setInt(2,like_easy_id);
        Integer a=statement.executeUpdate();
        connection.close();;
        return a;
    }

    @Override
    public Integer praiseComment(int user_id, int praise_comment_id) throws SQLException {
        String sql="select * from love where user_id=? and praise_comment_id=?";
        statement=connection.prepareStatement(sql);
        statement.setInt(1,user_id);
        statement.setInt(2,praise_comment_id);
        ResultSet rs=statement.executeQuery();
        if (rs.next()){
            String sql0="delete from love where user_id=? and praise_comment_id=?";
            statement=connection.prepareStatement(sql0);
            statement.setInt(1,user_id);
            statement.setInt(2,praise_comment_id);
            statement.executeUpdate();
            return 0;
        }else {
            String sql1="insert into love(user_id,praise_comment_id) value (?,?)";
            statement=connection.prepareStatement(sql1);
            statement.setInt(1,user_id);
            statement.setInt(2,praise_comment_id);
            statement.executeUpdate();
            return 1;
        }
    }

    @Override
    public Integer praiseEasy(int user_id, int praise_easy_id) throws SQLException {
        String sql="select * from love where user_id=? and praise_Easy=?";
        statement=connection.prepareStatement(sql);
        statement.setInt(1,user_id);
        statement.setInt(2,praise_easy_id);
        ResultSet rs=statement.executeQuery();
        if (rs.next()){
            String sql2="delete from love where user_id=? and praise_easy_id=?";
            statement=connection.prepareStatement(sql2);
            statement.setInt(1,user_id);
            statement.setInt(2,praise_easy_id);
            statement.executeUpdate();
            return 2;
        }else {
            String sql3="insert into love(user_id,praise_easy_id) value (?,?)";
            statement=connection.prepareStatement(sql3);
            statement.setInt(1,user_id);
            statement.setInt(2,praise_easy_id);
            statement.executeUpdate();
            return 3;
        }
    }

    @Override
    public ResultSet likeUserNum(int user_id) throws SQLException {
        String sql="select count(user_id) as likeUserNum from love where user_id=?";
        statement=connection.prepareStatement(sql);
        statement.setInt(1,user_id);
        ResultSet resultSet=statement.executeQuery();
        return resultSet;
        /*Integer a=null;
        while (resultSet.next()) {
            a=resultSet.getInt("likeUserNum");
        }
        return a;*/
    }

    @Override
    public ResultSet likedUserNum(int like_user_id) throws SQLException {
        String sql="select count(like_user_id) as likedUserNum from love where like_user_id=?";
        statement=connection.prepareStatement(sql);
        statement.setInt(1,like_user_id);
        ResultSet resultSet=statement.executeQuery();
        return resultSet;
        /*Integer a=null;
        while (resultSet.next()){
            a=resultSet.getInt("likedUserNum");
        }
        return a;*/
    }

    @Override
    public ResultSet praiseEasyNum(int praise_easy_id) throws SQLException {
        String sql="select count(praise_easy_id) as praiseEasyId from love where praise_easy_id=?";
        statement=connection.prepareStatement(sql);
        statement.setInt(1,praise_easy_id);
        ResultSet resultSet=statement.executeQuery();
        return resultSet;
        /*Integer a=null;
        while (resultSet.next()){
            a=resultSet.getInt("praiseEasyId");
        }
        return a;*/
    }

    @Override
    public ResultSet praiseCommentNum(int praise_comment_id) throws SQLException {
        String sql="select count(praise_comment_id) as praiseCommentNum from love where praise_comment_id=?";
        statement=connection.prepareStatement(sql);
        statement.setInt(1,praise_comment_id);
        ResultSet resultSet=statement.executeQuery();
        return resultSet;
        /*Integer a=null;
        while (resultSet.next()){
            a=resultSet.getInt("praiseCommentNum");
        }
        return a;*/
    }
}
