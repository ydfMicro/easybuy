package sdkd.com.ec.im;

import sdkd.com.ec.model.EYNews;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ydf_m on 2016/7/14.
 */
public class EYModifyNewsImport extends Execute{
    /**
     * 添加新闻
     * @param news
     */
    public void addNews(List<Object> news){
        String sql = "insert into easybuy_news(en_title, en_content, en_create_time) values(?,?,?)";

        this.executeModify(sql, news);
    }

    /**
     * 删除新闻
     * @param list
     */
    public void deletenews(List list){
        String sql = "delete from easybuy_news where en_id=?";

        this.executeModify(sql, list);
    }

    /**
     * 获取新闻
     * @return
     */
    public List<EYNews> getNews(){
        List<EYNews> newsList = new ArrayList<EYNews>();
        String sql = "select * from easybuy_news;";
        try {
            ResultSet rs = this.executeSearch(sql,null);
            while (rs.next()){
                EYNews news = new EYNews();
                news.setEn_id(rs.getInt("en_id"));
                news.setEn_title(rs.getString("en_title"));
                news.setEn_content(rs.getString("en_content"));
                news.setEn_create_time(rs.getDate("en_create_time"));

                newsList.add(news);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return newsList;
    }

    /**
     * 更新新闻
     * @param list
     */
    public void updatenews(List<Object> list){
        String sql = "update easybuy_news set en_title=?,en_content=?,en_create_time=? where en_id=?;";

        this.executeModify(sql, list);
    }
}
