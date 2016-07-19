package sdkd.com.ec.im;

import sdkd.com.ec.model.EYOrderDetil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ydf_m on 2016/7/11.
 */
public class EYOrderDetilImport extends Execute{
    /**
     * 保存订单详情
     * @param detail
     */
    public void saveOrderDetail(EYOrderDetil detail){
        String sql = "insert into easybuy_order_detail(eo_id,ep_id,eod_quantity,eod_cost) values(?,?,?,?)";
        List<Object> params = new ArrayList<Object>();
        params.add(detail.getEo_id()+"");
        params.add(detail.getEp_id()+"");
        params.add(detail.getEod_quantity()+"");
        params.add(detail.getEod_cost()+"");
        this.executeModify(sql,params);
    }

}
