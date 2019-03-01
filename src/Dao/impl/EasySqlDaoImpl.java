package Dao.impl;

import Dao.EasySqlDao;
import Dao.JdbcUtils;

import java.sql.*;

public class EasySqlDaoImpl implements EasySqlDao {
    public static JdbcUtils coon=new JdbcUtils();               // 实例化连接数据库的类
    @Override
    public ResultSet search(String string) throws SQLException {
        Connection connection=coon.getConnection();               //连接数据库
        PreparedStatement statement=null;
        String sql="select * from easy where easy_name like ? or easy_content like ?";
        statement=connection.prepareStatement(sql);               //预处理该sql语句
        statement.setString(1,string);              //为第一个问号赋值
        statement.setString(2,string);
        ResultSet resultSet=statement.executeQuery();               //执行查询
        return resultSet;
    }

    @Override
    public ResultSet classify(String string) throws SQLException {
        Connection connection=coon.getConnection();
        PreparedStatement statement=null;
        String sql="select * from easy where easy_class like ?";
        statement=connection.prepareStatement(sql);
        statement.setString(1,string);
        ResultSet resultSet=statement.executeQuery();
        return resultSet;
    }

    @Override
    public Integer sendEasy(int easy_pid, String easy_class, String easy_name, String easy_content) throws SQLException {
        Connection connection=coon.getConnection();
        PreparedStatement statement=null;
        String sql="insert into easy (easy_pid,easy_class,easy_name,easy_content) value(?,?,?,?)";
        statement=connection.prepareStatement(sql);
        statement.setInt(1,easy_pid);
        statement.setString(2,easy_class);
        statement.setString(3,easy_name);
        statement.setString(4,easy_content);
        Integer a=statement.executeUpdate();
        connection.close();
        return a;
    }

    @Override
    public ResultSet push(int user_id) throws SQLException {
        Connection connection=coon.getConnection();
        PreparedStatement statement=null;
        String sql="select * from easy where easy_pid in(select like_user_id from love where user_id=?) or easy_pid=?";
        statement=connection.prepareStatement(sql);
        statement.setInt(1,user_id);
        statement.setInt(2,user_id);
        ResultSet resultSet=statement.executeQuery();
        return resultSet;
    }
}
