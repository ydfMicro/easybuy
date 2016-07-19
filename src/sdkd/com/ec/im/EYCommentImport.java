package sdkd.com.ec.im;

import sdkd.com.ec.model.EYComment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ydf_m on 2016/7/14.
 */
public class EYCommentImport extends Execute{

    public List<EYComment> getComment() {
        List<EYComment> commentsList = new ArrayList<EYComment>();
        String sql = "select * from easybuy_comment ";
        try {
            ResultSet rs = this.executeSearch(sql, null);
            while (rs.next()) {
                EYComment comment = new EYComment();
                comment.setEc_content(rs.getString("ec_content"));
                comment.setEc_nick_name(rs.getString("ec_nick_name"));
                comment.setEc_create_time(rs.getDate("ec_create_time"));
                comment.setEc_reply(rs.getString("ec_reply"));
                //添加到集合中
                commentsList.add(comment);
            }
            //rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return commentsList;
    }
    /**
     * 所有留言列表（分页）
     * @return
     */
    public List<EYComment> getProductPager(int pageIndex,int pageSize){
        //pageIndex 1 2 3 4 5 6
        List<EYComment> productList = new ArrayList<EYComment>();
        String sql = "select * from easybuy_comment limit ?,?";
        ResultSet rs = null;
        List list = new ArrayList();
        try {

            // PreparedStatement ps = con.prepareStatement(sql);
            int start = (pageIndex * pageSize)-pageSize;
            list.add(start);
            list.add(pageSize);
            rs = this.executeSearch(sql, list);
            try {
                while(rs.next()){
                    EYComment product = new EYComment();
                    product.setEc_reply(rs.getString("ec_reply"));
                    product.setEc_content(rs.getString("ec_content"));
                    product.setEc_nick_name(rs.getString("ec_nick_name"));
                    product.setEc_create_time(rs.getDate("ec_create_time"));

                    productList.add(product);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productList;
    }

    /**
     * 所有商品数量
     * @return
     */
    public int getProductCount(){
        int count = 0;
        String sql = "select count(ec_id) from easybuy_comment";
        ResultSet rs = this.executeSearch(sql,null);
        try {
            if(rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
