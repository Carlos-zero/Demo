package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface LoveSqlDao {
    //增加新的关注用户
    Integer newLikeUser(int user_id,int like_user_id) throws SQLException;
    //查询已关注的用户
    ResultSet likedUser(int user_id) throws SQLException;
    //取消关注
    Integer deleteLikeUser(int user_id, int like_user_id) throws SQLException;
    //增加新的收藏文章
    Integer newLikeEasy(int user_id,int like_easy_id) throws SQLException;
    //查询已收藏的文章
    ResultSet likedEasy(int user_id) throws SQLException;
    //取消收藏
    Integer deleteLikeEasy(int user_id, int like_easy_id) throws SQLException;
    //点赞与取消点赞——评论
    Integer praiseComment(int user_id,int praise_comment_id)throws SQLException;
    //点赞与取消点赞——文章
    Integer praiseEasy(int user_id,int praise_easy_id)throws SQLException;
    //返回关注用户的数量
    ResultSet likeUserNum(int user_id) throws SQLException;
    //返回粉丝数量
    ResultSet likedUserNum(int like_user_id) throws SQLException;
    //返回文章点赞的数量
    ResultSet praiseEasyNum(int praise_easy_id) throws SQLException;
    //返回评论点赞数量
    ResultSet praiseCommentNum(int praise_comment_id) throws SQLException;

}
