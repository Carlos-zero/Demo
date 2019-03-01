package Dao;

import java.sql.SQLException;

public interface ReplySqlDao {
    //对评论进行回复
    Integer sendReply(int comment_id,String content,int from_user_id,int to_user_id) throws SQLException;
    //对回复进行回复
    Integer sendToReply(int reply_id,String content,int from_user_id,int to_user_id) throws SQLException;
}
