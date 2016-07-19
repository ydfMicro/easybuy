package sdkd.com.ec.controller;

import sdkd.com.ec.im.EYSellingImport;
import sdkd.com.ec.model.EYProduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ydf_m on 2016/7/11.
 */
@WebServlet(name = "EYProductController")
public class EYProductController extends HttpServlet {
    EYSellingImport productDao = new EYSellingImport();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action != null && !"".equals(action)){
            list(request, response);
//            if("list".equals(action)){
//                list(request, response);
//            }else if("detail".equals(action)){
//                detail(request, response);
//            }
        }
    }

    /**
     * 商品详情
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String pageIndexParam = request.getParameter("pageIndex");
        String pageSizeParam = request.getParameter("pageSize");
        String parent_id = request.getParameter("parent_id");
        String type_id = request.getParameter("type_id");

        int pageIndex  = 1;
        int pageSize = 4;
        if(pageIndexParam!=null && !"".equals(pageIndexParam)){
            pageIndex = Integer.parseInt(pageIndexParam);
        }
        if(pageSizeParam!=null && !"".equals(pageSizeParam)){
            pageSize = Integer.valueOf(pageSizeParam);
        }
        List<EYProduct> productList = productDao.getProductPager(pageIndex,pageSize, parent_id, type_id);
        int count = productDao.getProductCount(parent_id, type_id);
        int totalPage  = count % pageSize == 0 ?(count/pageSize):((count/pageSize)+1);

        request.setAttribute("productList",productList);
        request.setAttribute("totalPage",totalPage);  //总记录数
        request.setAttribute("parent_id", parent_id);
        request.setAttribute("type_id", type_id);
        request.setAttribute("pageIndex", pageIndex);

        //跳转页面
        request.getRequestDispatcher("/product-list.jsp").forward(request,response);
    }

//    /**
//     * 商品详情
//     * @param request
//     * @param response
//     * @throws ServletException
//     * @throws IOException
//     */
//    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        int id = 0;
//        String paramsId = request.getParameter("id");
//        if(paramsId != null && !"".equals(paramsId)){
//            id = Integer.parseInt(paramsId);
//        }
//        EYProduct product = productDao.getProductById(id);
//        request.setAttribute("product",product);
//        //跳转页面
//        request.getRequestDispatcher("/product-view.jsp").forward(request,response);
//    }
}
