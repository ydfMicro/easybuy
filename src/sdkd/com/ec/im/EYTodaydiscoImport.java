package sdkd.com.ec.im;

import sdkd.com.ec.model.EYNews;
import sdkd.com.ec.model.EYProduct;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ydf_m on 2016/7/6.
 */
public class EYTodaydiscoImport extends Execute{
    public List<EYProduct> getTodaydisco(){
        List<EYProduct> discoList = new ArrayList<EYProduct>();
        String sql = "select * from easybuy_product where ep_bargin = 1;";
        try {
            ResultSet rs = this.executeSearch(sql,null);
            while (rs.next()){
                EYProduct disco = new EYProduct();
                disco.setEp_id(rs.getInt("ep_id"));
                disco.setEp_name(rs.getString("ep_name"));
                disco.setEp_price(rs.getDouble("ep_price"));
                disco.setEp_picture(rs.getString("ep_picture"));
                //添加到集合中
                discoList.add(disco);
            }
            //rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return discoList;
    }
}
