package sdkd.com.ec.controller;

import sdkd.com.ec.im.EYNewsImport;
import sdkd.com.ec.model.EYNews;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by ydf_m on 2016/7/6.
 */
public class EYNewsController extends HttpServlet {
    EYNewsImport newsimport = new EYNewsImport();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String flag=request.getParameter("action");
        if("detil".equals(flag)){
            newsDetil(request,response);
        }else{
            news(request,response);
        }
    }

    public void news(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EYNews> list = newsimport.getNews();
        HttpSession session = request.getSession(true);
        session.setAttribute("newList",list);
        //跳转
        request.getRequestDispatcher("/todaydisco.do").forward(request,response);
    }

    public void newsDetil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p_id=request.getParameter("id");
        int id=Integer.parseInt(p_id);
        EYNews e=newsimport.getNewsDetil(id);
        request.setAttribute("ndetil",e);
        request.getRequestDispatcher("/news-view.jsp").forward(request,response);
    }
}
