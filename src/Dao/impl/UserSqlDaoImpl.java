package Dao.impl;

import Dao.JdbcUtils;
import Dao.UserSqlDao;
import servlet.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSqlDaoImpl implements UserSqlDao {
    public static JdbcUtils conn=new JdbcUtils();        //实例化数据库的连接类

    @Override
    public Integer insertUser(String telephone, String user_name, String password, String sex, String birthday, String location, String hobby) throws SQLException {
        Connection connection=conn.getConnection();
        PreparedStatement statement=null;
        String sql="insert into user(telephone,user_name,password,sex,birthday,location,hobby)value(?,?,?,?,?,?,?)";
        statement=connection.prepareStatement(sql);
        statement.setString(1,telephone);
        statement.setString(2,user_name);
        statement.setString(3,password);
        statement.setString(4,sex);
        statement.setString(5,birthday);
        statement.setString(6,location);
        statement.setString(7,hobby);
        statement.executeUpdate();
        sql="select @@identity newId";
        statement=connection.prepareStatement(sql);
        ResultSet resultSet=statement.executeQuery();
        Integer id=null;
        if (resultSet.next()){
            id=resultSet.getInt("newId");
        }
        JdbcUtils.close(connection,statement,resultSet);
        return id;
    }

    public User login(String telephone, String password) throws SQLException{
        User user=null;
        Connection connection=conn.getConnection();
        PreparedStatement statement=null;
        String sql="select * from user where telephone=? and password=?";
        statement=connection.prepareStatement(sql);
        statement.setString(1,telephone);
        statement.setString(2,password);
        ResultSet resultSet=statement.executeQuery();
        if (resultSet.next()){
            user=new User();
            user.setId(resultSet.getInt("id"));
            user.setTelephone(resultSet.getString("telephone"));
            user.setUser_name(resultSet.getString("user_name"));
            user.setPassword(resultSet.getString("password"));
            user.setSex(resultSet.getString("sex"));
            user.setBirthday(resultSet.getString("birthday"));
            user.setLocation(resultSet.getString("location"));
            user.setPersonalized_signature(resultSet.getString("personalized_signature"));
            user.setQq(resultSet.getString("qq"));
            user.setEmail(resultSet.getString("email"));
            user.setRelationship_status(resultSet.getString("relationship_status"));
//            user.setAttention(resultSet.getString("attention"));
//            user.setFans(resultSet.getString("fans"));
//            user.setMicro_blog(resultSet.getString("micro_blog"));
            user.setHobby(resultSet.getString("hobby"));
        }
        JdbcUtils.close(connection,statement,resultSet);
        return user;
    }

    @Override
    public Integer updateUser(int telephone, String user_name, String sex, String birthday, String location, String personalized_signature, int qq, String email, String relationship_staus) throws SQLException {
        Connection connection=conn.getConnection();
        PreparedStatement statement=null;
        String sql="update user set user_name=?,sex=?,birthday=?,location=?,personalized_signature=?,qq=?,email=?,relationship_status=? where telephone=?";
        statement=connection.prepareStatement(sql);
        statement.setString(1,user_name);
        statement.setString(2,sex);
        statement.setString(3,birthday);
        statement.setString(4,location);
        statement.setString(5,relationship_staus);
        statement.setInt(6,qq);
        statement.setString(7,email);
        statement.setString(8,relationship_staus);
        statement.setInt(9,telephone);
        /*ResultSet resultSet=statement.executeQuery();
        return resultSet;*/
        Integer a=statement.executeUpdate();
        return a;
    }
}



/*public Integer insertUser(String user_name,String password,String sex,String birthday,String location)throws SQLException{
        Connection connection=conn.getConnection();         //连接数据库
        PreparedStatement statement=null;
        String sql="insert into user(user_name,password,sex,birthday,location)value(?,?,?,?,?)";
        statement=connection.prepareStatement(sql);
        statement.setString(1,user_name);
        statement.setString(2,password);
        statement.setString(3,sex);
        statement.setString(4,birthday);
        statement.setString(5,location);
        statement.executeUpdate();
        sql="select @@identity newId";
        statement=connection.prepareStatement(sql);
        ResultSet resultSet=statement.executeQuery();
        Integer id=null;
        if (resultSet.next()){
            id=resultSet.getInt("newId");
        }
        JdbcUtils.close(connection,statement,resultSet);
        return id;
    }*/