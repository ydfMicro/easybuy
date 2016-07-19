package sdkd.com.ec.im;

import sdkd.com.ec.model.EYOrder;
import sdkd.com.ec.util.DateUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ydf_m on 2016/7/11.
 */
public class EYOrderImport extends Execute{
    public int saveOrder(EYOrder order){

        String sql = "insert into easybuy_order(eo_user_id,eo_user_name,eo_user_address,eo_create_time,eo_cost,eo_status,eo_type) values(?,?,?,?,?,?,?)";
        List<Object> params = new ArrayList<Object>();
        params.add(order.getEo_user_id()+"");
        params.add(order.getEo_user_name());
        params.add(order.getEo_user_address());
        params.add(DateUtil.parseDateToStr(order.getEo_create_time(),"yyyy-MM-dd HH:mm:ss"));
        params.add(order.getEo_cost()+"");
        params.add(order.getEo_status()+"");
        params.add(order.getEo_type()+"");
        return this.executeModify(sql,params);
    }
    public void removeOrderById(int id){
        String sql="delete from easybuy_order where eo_id='"+id+"'";
        this.executeModify(sql,null);
    }
    public void getOrderById(int id,String address,int status){
        String sql="update easybuy_order set eo_user_address=?,eo_status=? where eo_id=?";
        List<Object> o=new ArrayList<Object>();
        o.add(address);
        o.add(status+"");
        o.add(id+"");
        this.executeModify(sql,o);
    }
    public List<EYOrder> getOrder(){
        List<EYOrder> eo=new ArrayList<EYOrder>();
        String sql="select * from easybuy_order";
        try {
            ResultSet rs=this.executeSearch(sql,null);
            while(rs.next()){
                EYOrder o=new EYOrder();
                o.setEo_id(rs.getInt("eo_id"));
                o.setEo_user_name(rs.getString("eo_user_name"));
                o.setEo_user_address(rs.getString("eo_user_address"));
                o.setEo_status(rs.getInt("eo_status"));
                eo.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eo;
    }
    public int getTotal(){
        int count = 0;
        String sql="select * from easybuy_order";
        ResultSet rs = this.executeSearch(sql,null);
        try {
            while(rs.next()){
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    public List<EYOrder> getOrderBypage(int pagIndex,int pagSize){
        List<EYOrder> eo=new ArrayList<EYOrder>();
        String sql="select * from easybuy_order limit ?,?";
        List list=new ArrayList();
        int start=pagSize*pagIndex-pagSize;
        list.add(start);
        list.add(pagSize);
        ResultSet rs=null;
        try {
            rs=this.executeSearch(sql,list);
            while(rs.next()){
                EYOrder o=new EYOrder();
                o.setEo_id(rs.getInt("eo_id"));
                o.setEo_user_name(rs.getString("eo_user_name"));
                o.setEo_user_address(rs.getString("eo_user_address"));
                o.setEo_status(rs.getInt("eo_status"));
                eo.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eo;
    }
    public List<EYOrder> SelectOrderBypage(String id,String name){
        List<EYOrder> eo=new ArrayList<EYOrder>();
        List list=new ArrayList();
        String sql;
        if(id==""){
            sql="select * from easybuy_order where eo_user_name=?";
            list.add(name);
        }
        else if(name==""){
            sql="select * from easybuy_order where eo_id=?";
            list.add(id);
        }else {
            sql = "select * from easybuy_order where eo_id=? and eo_user_name=?";
            list.add(id);
            list.add(name);
        }
        ResultSet rs=null;
        try {
            rs=this.executeSearch(sql,list);
            while(rs.next()){
                EYOrder o=new EYOrder();
                o.setEo_id(rs.getInt("eo_id"));
                o.setEo_user_name(rs.getString("eo_user_name"));
                o.setEo_user_address(rs.getString("eo_user_address"));
                o.setEo_status(rs.getInt("eo_status"));
                eo.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eo;
    }
}
