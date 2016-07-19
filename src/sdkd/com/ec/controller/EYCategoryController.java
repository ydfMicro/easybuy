package sdkd.com.ec.controller;

import sdkd.com.ec.im.EYCategoryImport;
import sdkd.com.ec.model.EYCategory;

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
@WebServlet(name = "EYCategoryController")
public class EYCategoryController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EYCategoryImport cateImport = new EYCategoryImport();

        List<EYCategory> list = cateImport.getCategoryMessage();
        HttpSession session = request.getSession(true);
        session.setAttribute("category",list);

        request.getRequestDispatcher("/notice.do").forward(request,response);
    }
}
