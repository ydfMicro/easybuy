package sdkd.com.ec.model;

/**
 * Created by ydf_m on 2016/7/7.
 */
public class EYProduct {
    private int ep_id;
    private String ep_name;
    private String ep_description;
    private double ep_price;
    private int ep_stock;
    private int epc_id;
    private int epc_child_id;
    private String ep_file_name;
    private int ep_sales;
    private String ep_picture;
    private int ep_bargin;
    private int epc_parent_id;
    private int epc_views;

    public void setEp_id(int ep_id) {
        this.ep_id = ep_id;
    }

    public void setEp_name(String ep_name) {
        this.ep_name = ep_name;
    }

    public void setEp_description(String ep_description) {
        this.ep_description = ep_description;
    }


    public void setEp_stock(int ep_stock) {
        this.ep_stock = ep_stock;
    }

    public void setEpc_id(int epc_id) {
        this.epc_id = epc_id;
    }

    public void setEpc_child_id(int epc_child_id) {
        this.epc_child_id = epc_child_id;
    }

    public void setEp_file_name(String ep_file_name) {
        this.ep_file_name = ep_file_name;
    }

    public void setEp_sales(int ep_sales) {
        this.ep_sales = ep_sales;
    }

    public void setEp_picture(String ep_picture) {
        this.ep_picture = ep_picture;
    }

    public void setEp_bargin(int ep_bargin) {
        this.ep_bargin = ep_bargin;
    }

    public void setEpc_parent_id(int epc_parent_id) {
        this.epc_parent_id = epc_parent_id;
    }

    public void setEpc_views(int epc_views) {
        this.epc_views = epc_views;
    }

    public int getEp_id() {
        return ep_id;
    }

    public String getEp_name() {
        return ep_name;
    }

    public String getEp_description() {
        return ep_description;
    }


    public int getEp_stock() {
        return ep_stock;
    }

    public int getEpc_id() {
        return epc_id;
    }

    public int getEpc_child_id() {
        return epc_child_id;
    }

    public String getEp_file_name() {
        return ep_file_name;
    }

    public int getEp_sales() {
        return ep_sales;
    }

    public String getEp_picture() {
        return ep_picture;
    }

    public int getEp_bargin() {
        return ep_bargin;
    }

    public int getEpc_parent_id() {
        return epc_parent_id;
    }

    public int getEpc_views() {
        return epc_views;
    }

    public double getEp_price() {
        return ep_price;
    }

    public void setEp_price(double ep_price) {
        this.ep_price = ep_price;
    }

}
