package sdkd.com.ec.controller;

import com.sun.org.apache.xpath.internal.SourceTree;
import sdkd.com.ec.im.EYOrderImport;
import sdkd.com.ec.model.EYOrder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by duye123 on 2016/7/13.
 */
public class EYOrderManagement extends HttpServlet {
    EYOrderImport ei=new EYOrderImport();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String flag=request.getParameter("flag");
        if("modify".equals(flag)){
            modifyOrder(request,response);
        }else if("remove".equals(flag)){
            removeOrder(request,response);
        }else if("select".equals(flag)){
            selectOrder(request,response);
        } else{
            OrderView(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    public void OrderView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageIndexParam = request.getParameter("pageIndex");
        String pageSizeParam = request.getParameter("pageSize");
        int pageIndex  = 1;
        int pageSize = 2;
        if(pageIndexParam!=null && !"".equals(pageIndexParam)){
            pageIndex = Integer.parseInt(pageIndexParam);
        }
        if(pageSizeParam!=null && !"".equals(pageSizeParam)){
            pageSize = Integer.valueOf(pageSizeParam);
        }
        List<EYOrder> eo = ei.getOrderBypage(pageIndex, pageSize);
        int count = ei.getTotal();
        int totalPage = count % pageSize == 0 ? (count / pageSize) : ((count / pageSize) + 1);

        request.setAttribute("orderlist", eo);
        request.setAttribute("totalPage", totalPage);  //总页数
        request.setAttribute("pageIndex", pageIndex);

        //跳转页面
        request.getRequestDispatcher("/manage/order.jsp").forward(request, response);
    }
    public void modifyOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oid=request.getParameter("orderId");
        String status=request.getParameter("status");
        String address=request.getParameter("address");
        int id=Integer.parseInt(oid);
        int s=Integer.parseInt(status);
        ei.getOrderById(id,address,s);
        response.sendRedirect("/morder.do");
    }
    public void removeOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eid=request.getParameter("id");
        int id=Integer.parseInt(eid);
        ei.removeOrderById(id);
        String f=request.getParameter("f");
        if("select".equals(f)) {
            response.sendRedirect("/manage/order-select.jsp");
        }else{
            response.sendRedirect("/morder.do");
        }
    }
    public void selectOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eid=request.getParameter("orderId");
        String ename=request.getParameter("userName");
        List<EYOrder> eo=ei.SelectOrderBypage(eid,ename);
        request.setAttribute("orderlist",eo);
        request.getRequestDispatcher("/manage/order-select.jsp").forward(request,response);
    }
}
