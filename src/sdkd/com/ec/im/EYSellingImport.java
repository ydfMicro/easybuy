package sdkd.com.ec.im;

import com.sun.org.apache.xpath.internal.SourceTree;
import sdkd.com.ec.model.EYProduct;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ydf_m on 2016/7/6.
 */
public class EYSellingImport extends Execute{
    public EYProduct getSellingDetil(int id){
        String sql = "select * from easybuy_product where ep_id=?";
        List<Object> params = new ArrayList<Object>();
        params.add(id+"");
        EYProduct selling = new EYProduct();
        try {
            ResultSet rs = this.executeSearch(sql,params);
            while (rs.next()){
                selling.setEp_id(rs.getInt("ep_id"));
                selling.setEp_name(rs.getString("ep_name"));
                selling.setEp_price(rs.getDouble("ep_price"));
                selling.setEp_stock(rs.getInt("ep_stock"));
                selling.setEp_picture(rs.getString("ep_picture"));
                selling.setEp_description(rs.getString("ep_description"));
                selling.setEpc_child_id(rs.getInt("epc_child_id"));
                selling.setEp_bargin(rs.getInt("ep_bargin"));
                selling.setEpc_views(rs.getInt("epc_views"));

            }
            //rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        }
        return selling;
    }
    public List<EYProduct> getHotSelling(){
        List<EYProduct> sellingList = new ArrayList<EYProduct>();
        String sql = "select * from easybuy_product order by epc_views desc limit 0,12;";
        try {
            ResultSet rs = this.executeSearch(sql,null);
            while (rs.next()){
                EYProduct selling = new EYProduct();
                selling.setEp_id(rs.getInt("ep_id"));
                selling.setEp_name(rs.getString("ep_name"));
                selling.setEp_price(rs.getDouble("ep_price"));
                selling.setEp_stock(rs.getInt("ep_stock"));
                selling.setEp_picture(rs.getString("ep_picture"));
                //添加到集合中
                sellingList.add(selling);
            }
            //rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return sellingList;
    }

    /**
     * 更新商品库存
     */
    public void updateStock(int proid,int quantity){
        String sql = "update easybuy_product set ep_stock=ep_stock-? where ep_id=?";
        List<Object> params = new ArrayList<Object>();
        params.add(quantity+"");
        params.add(proid+"");
        this.executeModify(sql,params);
    }

    public List<EYProduct> getProductPager(int pageIndex,int pageSize, String parent_id, String type_id){
        //pageIndex 1 2 3 4 5 6
        List<EYProduct> productList = new ArrayList<EYProduct>();
        String sql = "select * from easybuy_product where epc_id = ? and epc_child_id  = ? limit ?,?";
        ResultSet rs = null;
        List list = new ArrayList();
        try {
            int start = (pageIndex * pageSize)-pageSize;
            list.add(parent_id);
            list.add(type_id);
            list.add(start);
            list.add(pageSize);
            rs = this.executeSearch(sql, list);

            while(rs.next()){
                EYProduct product = new EYProduct();
                product.setEp_id(rs.getInt("epc_id"));
                product.setEpc_child_id(rs.getInt("epc_child_id"));
                product.setEp_description(rs.getString("ep_description"));
                product.setEp_bargin(rs.getInt("ep_bargin"));
                product.setEp_picture(rs.getString("ep_picture"));
                product.setEp_id(rs.getInt("ep_id"));
                product.setEp_name(rs.getString("ep_name"));
                product.setEp_price(rs.getDouble("ep_price"));
                product.setEp_stock(rs.getInt("ep_stock"));
                product.setEpc_views(rs.getInt("epc_views"));
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    /**
     * 所有商品数量
     * @return
     */
    public int getProductCount(String parent_id, String type_id){
        int count = 0;
        String sql = "select count(ep_id) from easybuy_product where epc_id = ? and epc_child_id  = ? ";
        List list = new ArrayList();
        list.add(parent_id);
        list.add(type_id);
        ResultSet rs = this.executeSearch(sql,list);
        try {
            if(rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 商品详情
     * @param id
     * @return
     */
    public EYProduct getProductById(int id){
        EYProduct ebProduct = null;
        List<EYProduct> productList = (List<EYProduct>) this.getSellingDetil(id);
        if(productList!=null && productList.size()>0){
            ebProduct = productList.get(0);
        }
        return ebProduct;
    }
    public List<EYProduct> getProductPage(int pageIndex,int pageSize){
        List<EYProduct> productList = new ArrayList<EYProduct>();
        String sql = "select * from easybuy_product limit ?,?";
        ResultSet rs = null;
        List list = new ArrayList();
        try {
            int start = (pageIndex * pageSize)-pageSize;
            list.add(start);
            list.add(pageSize);
            rs = this.executeSearch(sql, list);
            while(rs.next()){
                EYProduct product = new EYProduct();
                product.setEp_id(rs.getInt("ep_id"));
                product.setEp_picture(rs.getString("ep_picture"));
                product.setEp_name(rs.getString("ep_name"));
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }
    public int getAllProductCount(){
        int count = 0;
        String sql = "select count(ep_id) from easybuy_product";
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

    public void ModifySellingDetil(int id,String name,int epc_id,double price,String description,int stock){
        String sql = "update easybuy_product set ep_name=?,epc_id=?,ep_price=?,ep_description=?,ep_stock=? where ep_id=?";
        List<Object> p= new ArrayList<Object>();
        p.add(name);
        p.add(epc_id+"");
        p.add(price+"");
        p.add(description);
        p.add(stock+"");
        p.add(id+"");
        this.executeModify(sql,p);
    }
    public void removeproductById(int id){
        String sql="delete from easybuy_product where ep_id='"+id+"'";
        this.executeModify(sql,null);
    }
    public void AddProduct(String name,int epc_id,String picture,double price,String description,int stock){
        String sql = "insert into easybuy_product(ep_name,epc_id,ep_picture,ep_price,ep_description,ep_stock) values(?,?,?,?,?,?)";
        List<Object> p= new ArrayList<Object>();
        p.add(name);
        p.add(epc_id+"");
        p.add(picture);
        p.add(price+"");
        p.add(description);
        p.add(stock+"");
        this.executeModify(sql,p);
    }
}
