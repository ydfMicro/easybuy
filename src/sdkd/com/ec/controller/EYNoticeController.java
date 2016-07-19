package sdkd.com.ec.controller;

import sdkd.com.ec.im.EYNoticeImport;
import sdkd.com.ec.model.EYNotice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by ydf_m on 2016/7/7.
 */
@WebServlet(name = "EYNoticeController")
public class EYNoticeController extends HttpServlet {

    EYNoticeImport noticeImport = new EYNoticeImport();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String flag=request.getParameter("action");
        if("detil".equals(flag)){
            NoticesDetil(request,response);
        }else{
            notices(request,response);
        }
    }

    public void notices(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<EYNotice> list = noticeImport.getNotices();
        HttpSession session = request.getSession(true);
        session.setAttribute("noticesList",list);

        //跳转
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    public void NoticesDetil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String n_id = request.getParameter("id");
        int id=Integer.parseInt(n_id);
        EYNotice e=noticeImport.getNoticesDetil(id);
        request.setAttribute("notice",e);
        request.getRequestDispatcher("/notices-view.jsp").forward(request,response);
    }
}
