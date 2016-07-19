package sdkd.com.ec.controller;

import sdkd.com.ec.im.EYModifyUserImport;
import sdkd.com.ec.model.EYUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ydf_m on 2016/7/14.
 */
@WebServlet(name = "EYModifyUserController")
public class EYModifyUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        String flag = request.getParameter("action");
        if("add".equals(flag)){
            AddUser(request, response);
        }else if("delete".equals(flag)){
            DeleteUser(request, response);
        }else if("get".equals(flag)){
            GetUser(request, response);
        }else if("update".equals(flag)){
            UpdateUser(request, response);
        }
    }

    /**
     * 添加用户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void AddUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        String sex = request.getParameter("sex");

        String birthday_year = request.getParameter("birthyear");
        String birthday_month = request.getParameter("birthmonth");
        String birthday_day = request.getParameter("birthday");
        String birthday = birthday_year + "-" + birthday_month + "-" + birthday_day;;

        String identity_code = request.getParameter("identity_code");

        String mail = request.getParameter("email");
        String mail_suffix = request.getParameter("email_Suffix");
        String email = mail + mail_suffix;

        String mobile = request.getParameter("mobile");
        String address = request.getParameter("address");
        String status = request.getParameter("status");

        List<Object> userList = new ArrayList<>();
        userList.add(userName);
        userList.add(passWord);
        userList.add(sex);
        userList.add(Date.valueOf(birthday));
        userList.add(identity_code);
        userList.add(email);
        userList.add(mobile);
        userList.add(address);
        userList.add(status);


        EYModifyUserImport user = new EYModifyUserImport();
        user.updateUser(userList);

        request.getRequestDispatcher("/manage/user-add.jsp").forward(request,response);
    }

    /**
     * 删除用户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void DeleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        List userid = new ArrayList();
        userid.add(id);

        EYModifyUserImport deleteUser = new EYModifyUserImport();
        deleteUser.deleteUser(userid);

        request.getRequestDispatcher("/modifyuser.do?action=get").forward(request,response);
    }

    /**
     * 获取用户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void GetUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EYModifyUserImport getuser = new EYModifyUserImport();
        List<EYUser> userList = getuser.GetUser();
        request.setAttribute("getuser", userList);

        request.getRequestDispatcher("/manage/user.jsp").forward(request,response);
    }

    /**
     * 更新用户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void UpdateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String username = request.getParameter("userName");
        String password = request.getParameter("passWord");
        String identity = request.getParameter("identity_code");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String address = request.getParameter("address");

        List<Object> updateList = new ArrayList<Object>();
        updateList.add(username);
        updateList.add(password);
        updateList.add(identity);
        updateList.add(email);
        updateList.add(mobile);
        updateList.add(address);
        updateList.add(id);

        EYModifyUserImport update = new EYModifyUserImport();
        update.updateInfo(updateList);

        request.getRequestDispatcher("/manage/manage-result.jsp").forward(request,response);
    }
}
