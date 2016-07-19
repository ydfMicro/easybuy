package sdkd.com.ec.im;

import sdkd.com.ec.tomysql.UsingMySql;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 操作父类
 * Created by sdust on 2016/7/6.
 */
public class Execute {
    private static String sql = null;     //mysql操作语句
    private UsingMySql usingsql = null;
    private static ResultSet rs = null;

    /*
    *CUD
     */
    public int executeModify(String sql, List<Object> values) {
        int result=0;
        usingsql = new UsingMySql(sql);
        try {
            if (values != null && values.size() > 0) {
                for (int i = 0; i < values.size(); i++) {
                    Object obj = values.get(i);
                    String typeName = obj.getClass().getName();
                    if("java.lang.Integer".equals(typeName)){
                        usingsql.ps.setInt((i+1),Integer.parseInt(obj.toString()));
                    }else if("java.lang.String".equals(typeName)){
                        usingsql.ps.setString((i+1),obj.toString());
                    }else if("java.sql.Date".equals(typeName)){
                        usingsql.ps.setDate((i+1), Date.valueOf(obj.toString()));
                    }
                }
            }
            result=usingsql.ps.executeUpdate();      //执行语句
            rs = usingsql.ps.getGeneratedKeys();
            if(rs.next()){
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /*
    *R
     */
    public ResultSet executeSearch(String sql, List<Object> values) {
        usingsql = new UsingMySql(sql);
        try {
            if (values != null && values.size() > 0) {
                for (int i = 0; i < values.size(); i++) {
                    Object obj = values.get(i);
                    String typeName = obj.getClass().getName();
                    if("java.lang.Integer".equals(typeName)){
                        usingsql.ps.setInt((i+1),Integer.parseInt(obj.toString()));
                    }else if("java.lang.String".equals(typeName)){
                        usingsql.ps.setString((i+1),obj.toString());
                    }else if("java.sql.Date".equals(typeName)){
                        usingsql.ps.setDate((i+1), Date.valueOf(obj.toString()));
                    }
                }
            }
            rs = usingsql.ps.executeQuery();      //执行语句


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void close(){
        if(rs != null) try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        usingsql.close();
    }
}
