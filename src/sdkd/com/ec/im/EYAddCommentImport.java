package sdkd.com.ec.im;

/**
 * Created by ydf_m on 2016/7/14.
 */
public class EYAddCommentImport extends Execute{
    public void setComment(String geustName, String guestContent,String time){
        String sql = "insert into easybuy_comment(ec_nick_name, ec_content,ec_create_time) values('" + geustName + "', '"+ guestContent + "','"+ time + "')";

        this.executeModify(sql, null);
    }
}
