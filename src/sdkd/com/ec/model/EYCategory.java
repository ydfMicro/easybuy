package sdkd.com.ec.model;

/**
 * Created by ydf_m on 2016/7/7.
 */
public class EYCategory {
    private int epc_id;
    private String epc_name;
    private int epc_parent_id;
    private int epc_type_id;

    public void setEpc_id(int epc_id) {
        this.epc_id = epc_id;
    }

    public void setEpc_name(String epc_name) {
        this.epc_name = epc_name;
    }

    public void setEpc_parent_id(int epc_parent_id) {
        this.epc_parent_id = epc_parent_id;
    }

    public void setEpc_type_id(int epc_type_id) { this.epc_type_id = epc_type_id; }

    public int getEpc_id() {
        return epc_id;
    }

    public String getEpc_name() {
        return epc_name;
    }

    public int getEpc_parent_id() {
        return epc_parent_id;
    }

    public int getEpc_type_id() { return epc_type_id; }
}
