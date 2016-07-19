package sdkd.com.ec.controller;

import sdkd.com.ec.im.EYAddCommentImport;
import sdkd.com.ec.im.EYCommentImport;
import sdkd.com.ec.model.EYComment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by ydf_m on 2016/7/14.
 */
@WebServlet(name = "EYCommentController")
public class EYCommentController extends HttpServlet {

    /**
     * 乱码转码问题
     * @param x
     * @return
     */
    public  String JspStringFormat(String x){
        if(x == null)
            return  null;
        try{
            return  new String (x.getBytes("ISO-8859-1") ,"UTF-8");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return  null;
    }

    EYCommentImport commetImport = new EYCommentImport();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String name = request.getParameter("guestName");
        String geustName = JspStringFormat(name);

        String guestTitle = request.getParameter("guestTitle");

        String Content = request.getParameter("guestContent");
        String guestContent = JspStringFormat(Content);
        /**
         * 获取系统时间
         */
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        HttpSession session = request.getSession(true);



        String pageIndexParam = request.getParameter("pageIndex");
        String pageSizeParam = request.getParameter("pageSize");
        int pageIndex  = 1;
        int pageSize = 4;
        if(pageIndexParam!=null && !"".equals(pageIndexParam)){
            pageIndex = Integer.parseInt(pageIndexParam);
        }
        if(pageSizeParam!=null && !"".equals(pageSizeParam)){
            pageSize = Integer.valueOf(pageSizeParam);
        }
        List<EYComment> productList = commetImport.getProductPager(pageIndex,pageSize);
        int count = commetImport.getProductCount();
        int totalPage  = count % pageSize == 0 ?(count/pageSize):((count/pageSize)+1);

        request.setAttribute("commentList", productList);
        request.setAttribute("totalPage",totalPage);  //总页数
        request.setAttribute("pageIndex",pageIndex);
        request.getRequestDispatcher("/guestbook.jsp").forward(request,response);

        if (geustName == null || guestTitle == null || guestContent == null) {
            request.getRequestDispatcher("/guestbook.jsp").forward(request, response);
        } else {
            EYAddCommentImport AddCommentimport = new EYAddCommentImport();
            AddCommentimport.setComment(geustName, guestContent, time);
            HttpSession sesson = request.getSession(true);


            //跳转
            request.getRequestDispatcher("/news.do").forward(request, response);
            geustName = null;
            guestContent = null;
        }
    }
}
