package sdkd.com.ec.controller;

import sdkd.com.ec.im.EYSellingImport;
import sdkd.com.ec.model.EYProduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;

/**
 * Created by duye123 on 2016/7/13.
 */
@MultipartConfig(location="G:\\coding\\SoftwareDevelopment\\easybuy\\web\\images\\product")
public class EYProductManagement extends HttpServlet {
    EYSellingImport esi=new EYSellingImport();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String flag=request.getParameter("flag");
        if("add".equals(flag)){
            upload(request,response);
        }else if("remove".equals(flag)){
            removeProduct(request,response);
        }else if("modify".equals(flag)){
            modifyProduct(request,response);
        }else{
            viewProduct(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    public void removeProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        int eid=Integer.parseInt(id);
        esi.removeproductById(eid);
        response.sendRedirect("/mpro.do");
    }
    public void modifyProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        int eid=Integer.parseInt(id);
        String name=request.getParameter("productName");
        String pId=request.getParameter("parentId");
        int epId=Integer.parseInt(pId);
        String Price=request.getParameter("productPrice");
        double price=Double.parseDouble(Price);
        String Desciption=request.getParameter("productDesciption");
        String Stock=request.getParameter("productStock");
        int stock=Integer.parseInt(Stock);
        esi.ModifySellingDetil(eid,name,epId,price,Desciption,stock);
        response.sendRedirect("/mpro.do");

    }
    public void viewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageIndexParam = request.getParameter("PpageIndex");
        String pageSizeParam = request.getParameter("PpageSize");
        int pageIndex  = 1;
        int pageSize = 4;
        if(pageIndexParam!=null && !"".equals(pageIndexParam)){
            pageIndex = Integer.parseInt(pageIndexParam);
        }
        if(pageSizeParam!=null && !"".equals(pageSizeParam)){
            pageSize = Integer.valueOf(pageSizeParam);
        }
        List<EYProduct> productList = esi.getProductPage(pageIndex,pageSize);
        int count = esi.getAllProductCount();
        int totalPage  = count % pageSize == 0 ?(count/pageSize):((count/pageSize)+1);

        request.setAttribute("PproductList",productList);
        request.setAttribute("PtotalPage",totalPage);  //总记录数
        request.setAttribute("PpageIndex", pageIndex);

        //跳转页面
        request.getRequestDispatcher("/manage/product.jsp").forward(request,response);
    }
    private void upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part part=request.getPart("photo");
        String header=part.getHeader("Content-Disposition");
        String fileName=header.substring(header.indexOf("filename=\"")+10,header.lastIndexOf("\""));
        String[] fp=fileName.split("\\.");
        part.write(fileName);
        String name=request.getParameter("productName");
        String pId=request.getParameter("parentId");
        int id=Integer.parseInt(pId);
        String price=request.getParameter("productPrice");
        double Price=Double.parseDouble(price);
        String description=request.getParameter("productDescription");
        String stock=request.getParameter("productStock");
        int Stock=Integer.parseInt(stock);
        esi.AddProduct(name,id,fp[0],Price,description,Stock);
        response.sendRedirect("/mpro.do");
    }
}
