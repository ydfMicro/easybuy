package sdkd.com.ec.im;

import sdkd.com.ec.model.EYUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ydf_m on 2016/7/14.
 */
public class EYModifyUserImport extends Execute{

    /**
     * 添加用户
     * @param list
     */
    public void updateUser(List<Object> list){
        String sql = "insert into easybuy_user(eu_user_name, eu_password, eu_sex, eu_birthday, eu_identity_code, " +
                "eu_email, eu_mobile, eu_address, eu_status) values(?,?,?,?,?,?,?,?,?);";
        executeModify(sql, list);
    }

    /**
     * 获取用户
     * @return
     */
    public List<EYUser> GetUser(){
        List<EYUser> userList = new ArrayList<EYUser>();
        String sql = "select * from easybuy_user;";
        try {
            ResultSet rs = this.executeSearch(sql,null);
            while (rs.next()){
                EYUser user = new EYUser();
                user.setEu_user_id(rs.getInt("eu_user_id"));
                user.setEu_user_name(rs.getString("eu_user_name"));
                user.setEu_password(rs.getString("eu_password"));
                user.setEu_sex(rs.getString("eu_sex"));
                user.setEu_birthday(rs.getDate("eu_birthday"));
                user.setEu_identity_code(rs.getString("eu_identity_code"));
                user.setEu_mail(rs.getString("eu_email"));
                user.setEu_mobile(rs.getString("eu_mobile"));
                user.setEu_address(rs.getString("eu_address"));
                user.setEu_status(rs.getInt("eu_status"));

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return userList;
    }

    /**
     * 删除用户
     * @param list
     */
    public void deleteUser(List list){
        String sql = "delete from easybuy_user where eu_user_id=?";
        this.executeModify(sql, list);
    }

    /**
     * 更新用户
     * @param list
     */
    public void updateInfo(List<Object> list){
        String sql = "update easybuy_user set eu_user_name=?,eu_password=?," +
                "eu_identity_code=?,eu_email=?,eu_mobile=?,eu_address=?" +
                "where eu_user_id=?";
        this.executeModify(sql, list);
    }
}
