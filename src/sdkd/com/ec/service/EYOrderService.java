package sdkd.com.ec.service;

import sdkd.com.ec.im.EYOrderDetilImport;
import sdkd.com.ec.im.EYOrderImport;
import sdkd.com.ec.im.EYSellingImport;
import sdkd.com.ec.im.Execute;
import sdkd.com.ec.model.*;
import sdkd.com.ec.tomysql.UsingMySql;
import sdkd.com.ec.util.ConstantUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by ydf_m on 2016/7/11.
 */
public class EYOrderService extends Execute{
    //调用EbOrderDao & EbOrderDetailDao
    EYOrderImport orderDao = new EYOrderImport();
    EYOrderDetilImport orderDetailDao = new EYOrderDetilImport();
    EYSellingImport productDao = new EYSellingImport();

    /**
     * 支付订单
     * @param cart
     * @param user
     */
    public void payOrder(ShoppingCart cart, EYLogin user){

        String sql = "select * from easybuy_user where eu_user_name = '" + user.getName() + "';";

        ResultSet rs = this.executeSearch(sql,null);
        EYUser eyuser = new EYUser();
        try {
            while (rs.next()){

                eyuser.setEu_user_id(rs.getInt("eu_user_id"));
                eyuser.setEu_user_name(rs.getString("eu_user_name"));
                eyuser.setEu_address(rs.getString("eu_address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        EYOrder order = new EYOrder();
        order.setEo_user_id(eyuser.getEu_user_id());
        order.setEo_user_name(eyuser.getEu_user_name());
        order.setEo_user_address(eyuser.getEu_address());
        order.setEo_cost(cart.getTotalCoast());
        order.setEo_create_time(new Date());
        order.setEo_status(ConstantUtil.ORDER);
        order.setEo_type(ConstantUtil.ONLINEPAY);
        int genId = orderDao.saveOrder(order);   //保存订单?

        if(cart.getItems()!=null && cart.getItems().size()>0) {
            for(ShoppingCartItem item : cart.getItems()) {
                EYOrderDetil detail = new EYOrderDetil();
                detail.setEo_id(genId);   //?能否取到Order_id?
                detail.setEod_cost(item.getCost());
                detail.setEod_quantity(Integer.parseInt(item.getQuantity().toString()));
                detail.setEp_id(item.getProduct().getEp_id());
                orderDetailDao.saveOrderDetail(detail);   //保存订单详情
                //更新库存
                productDao.updateStock(item.getProduct().getEp_id(), Integer.parseInt(item.getQuantity().toString()));
//                System.out.println(Integer.parseInt(item.getQuantity().toString()));
            }
        }
    }
}
