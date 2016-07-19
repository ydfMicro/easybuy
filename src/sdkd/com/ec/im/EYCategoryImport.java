package sdkd.com.ec.im;

import sdkd.com.ec.model.EYCategory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ydf_m on 2016/7/7.
 */
public class EYCategoryImport extends Execute{
    public List<EYCategory> getCategoryMessage(){
        List<EYCategory> categoryList = new ArrayList<EYCategory>();
        String sql = "select * from easybuy_product_category;";

        try {
            ResultSet rs = this.executeSearch(sql,null);
            while (rs.next()){
                EYCategory cate = new EYCategory();
                cate.setEpc_id(rs.getInt("epc_id"));
                cate.setEpc_name(rs.getString("epc_name"));
                cate.setEpc_parent_id(rs.getInt("epc_parent_id"));
                cate.setEpc_type_id(rs.getInt("epc_type_id"));

                categoryList.add(cate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return categoryList;
    }
}
