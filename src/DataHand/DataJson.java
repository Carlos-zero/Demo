package DataHand;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import servlet.User;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DataJson {
    public JSONArray changeJsonArray(ResultSet resultSet)throws SQLException{
        ResultSetMetaData MetaData=resultSet.getMetaData();         //取得数据库中表的字段名
        int num=MetaData.getColumnCount();
        JSONArray array=new JSONArray();
        while (resultSet.next()){
            JSONObject mapOfColvalues=new JSONObject();

            for (int i=1;i<=num;i++){
                mapOfColvalues.put(MetaData.getColumnName(i),resultSet.getObject(i));
//                System.out.println(mapOfColvalues.toString());

            }
            array.add(mapOfColvalues);
        }
        return array;
    }
    public JSONArray changeJsonArrayUser(User user)throws SQLException{
        JSONArray array=new JSONArray();
        JSONObject jsonObject=JSONObject.fromObject(user);
        array.add(jsonObject);
        return array;
    }

}
