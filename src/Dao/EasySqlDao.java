package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface EasySqlDao {
    //用于返回用户关键字的搜索结果      属于搜索功能，从数据库easy表的easy_name,easy_content中进行搜索
    ResultSet search(String string) throws SQLException;
    //用于主页中的分类显示              属于分类功能，从数据库easy表的easy_class中进行查询
    ResultSet classify(String string) throws SQLException;
    //用于发送微博
    Integer sendEasy(int easy_pid,String easy_class,String easy_name,String easy_content) throws SQLException;
    //用于返回用户收藏的微博

    //用于返回用户极其关注的人的微博
    ResultSet push(int user_id)throws SQLException;
}
