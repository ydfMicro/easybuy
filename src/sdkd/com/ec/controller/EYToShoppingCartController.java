package sdkd.com.ec.controller;

import sdkd.com.ec.model.EYLogin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ydf_m on 2016/7/12.
 */
@WebServlet(name = "EYToShoppingCartController")
public class EYToShoppingCartController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EYLogin user = (EYLogin) request.getSession().getAttribute("vertify");
        if(user==null){
            response.sendRedirect("/login.jsp");
            return;
        }

        request.getRequestDispatcher("/shopping.jsp").forward(request,response);
    }
}
