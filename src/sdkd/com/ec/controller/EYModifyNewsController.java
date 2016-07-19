package sdkd.com.ec.controller;

import sdkd.com.ec.im.*;
import sdkd.com.ec.model.EYNews;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ydf_m on 2016/7/14.
 */
@WebServlet(name = "EYModifyController")
public class EYModifyNewsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        String flag = request.getParameter("action");
        if("add".equals(flag)){
            AddNews(request, response);
        }else if("delete".equals(flag)){
            DeleteNews(request, response);
        }else if("update".equals(flag)){
            UpdateNews(request, response);
        }else if("get".equals(flag)){
            GetNews(request, response);
        }
    }

    /**
     * 添加新闻
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void AddNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();

        List<Object> news = new ArrayList<Object>();
        news.add(title);
        news.add(content);
        news.add(sdf.format(date));

        EYModifyNewsImport addnews = new EYModifyNewsImport();
        addnews.addNews(news);

        request.getRequestDispatcher("/manage/manage-result.jsp").forward(request,response);
    }

    /**
     * 删除新闻
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void DeleteNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        List newsid = new ArrayList();
        newsid.add(id);

        EYModifyNewsImport deletenews = new EYModifyNewsImport();
        deletenews.deletenews(newsid);

        request.getRequestDispatcher("/modifynews.do?action=get").forward(request,response);
    }

    /**
     * 更新新闻
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void UpdateNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        List<Object> newsList = new ArrayList<Object>();
        newsList.add(title);
        newsList.add(content);
        newsList.add(sdf.format(date));
        newsList.add(id);

        EYModifyNewsImport updatenews = new EYModifyNewsImport();
        updatenews.updatenews(newsList);
        request.getRequestDispatcher("/manage/manage-result.jsp").forward(request,response);
    }

    /**
     * 获取新闻
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void GetNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EYModifyNewsImport getNews = new EYModifyNewsImport();
        List<EYNews> list = getNews.getNews();
        request.setAttribute("getnews", list);

        request.getRequestDispatcher("/manage/news.jsp").forward(request,response);
    }
}
