package Dao;

import java.sql.SQLException;

public interface CommentSqlDao {
    Integer sendComment(int easy_id,String content,int from_user_id)throws SQLException;
}
