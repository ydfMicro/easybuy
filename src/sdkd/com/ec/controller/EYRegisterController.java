package sdkd.com.ec.controller;

import sdkd.com.ec.im.EYRegisterImport;
import sdkd.com.ec.model.EYLogin;
import sdkd.com.ec.model.EYUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by ydf_m on 2016/7/6.
 */
@WebServlet(name = "EYRegisterController")
public class EYRegisterController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        if("".equals(userName) || "".equals(passWord)){
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
        else{
            EYRegisterImport registerimport = new EYRegisterImport();
            registerimport.setUser(userName, passWord);

            HttpSession session = request.getSession(true);
            EYLogin login = new EYLogin();
            login.setName(userName);
            session.setAttribute("vertify", login);

            request.getRequestDispatcher("/reg-result.jsp").forward(request,response);
        }
    }
}
