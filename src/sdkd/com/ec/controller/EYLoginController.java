package sdkd.com.ec.controller;

import sdkd.com.ec.im.EYLoginImport;
import sdkd.com.ec.model.EYLogin;
import sdkd.com.ec.model.EYUser;

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
@WebServlet(name = "EYLoginController")
public class EYLoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean vertify = false;
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");

        EYLoginImport loginimport = new EYLoginImport();
        List<EYUser> list = loginimport.getUserMessage();
        EYUser user = null;
        for(int i = 0; i < list.size(); i++){
            user = (EYUser)list.get(i);
            if(user.getEu_user_name().equals(userName) && user.getEu_password().equals(passWord)){
                vertify = true;
                break;
            }
        }
        HttpSession session = request.getSession(true);
        EYLogin login = null;

        if(vertify){
            login = new EYLogin();
            login.setName(userName);
            session.setAttribute("vertify", login);
            if(user.getEu_status() == 1){
                request.getRequestDispatcher("/log-result.jsp").forward(request,response);
            }else{
                request.getRequestDispatcher("/manage-log-result.jsp").forward(request,response);
            }

        }else{
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
