package sdkd.com.ec.im;

import sdkd.com.ec.model.EYUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ydf_m on 2016/7/6.
 */
public class EYLoginImport extends Execute{
    public List<EYUser> getUserMessage(){
        List<EYUser> userList = new ArrayList<EYUser>();
        String sql = "select eu_user_name, eu_password, eu_status from easybuy_user;";

        try {
            ResultSet rs = this.executeSearch(sql,null);
            while (rs.next()){
                EYUser user = new EYUser();
                user.setEu_user_name(rs.getString("eu_user_name"));
                user.setEu_password(rs.getString("eu_password"));
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
}
