package Dao;

import servlet.User;

import java.sql.SQLException;

public interface UserSqlDao {
    //该方法用于新用户的注册功能；
    Integer insertUser(String telephone,String user_name,String password,String sex,String birthday,String location,String hobby) throws SQLException;
    //该方法用于用户登录的验证功能；
    User login(String telephone,String password) throws SQLException;
    //该方法用于用户修改个人数据
    Integer updateUser(int telephone, String user_name, String sex, String birthday, String location, String personalized_signature, int qq, String email, String relationship_staus) throws SQLException;
}
