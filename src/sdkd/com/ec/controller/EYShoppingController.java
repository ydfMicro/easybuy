package sdkd.com.ec.controller;

import sdkd.com.ec.im.EYSellingImport;
import sdkd.com.ec.model.*;
import sdkd.com.ec.service.EYOrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ydf_m on 2016/7/9.
 */
@WebServlet(name = "EYShoppingController")
public class EYShoppingController extends HttpServlet {

    EYSellingImport shproduct = new EYSellingImport();
    EYOrderService orderService = new EYOrderService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op=request.getParameter("operation");
        if("add".equals(op)){
            addCart(request,response);
        }else if("pay".equals(op)) {
            payCart(request, response);
        }else if("remove".equals(op)){
            removeCart(request,response);
        }else{
            modifyCart(request,response);
        }
    }
    /**
     * 点击购买添加至购物车
     */
    public void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean issame = false;
        EYLogin user = (EYLogin) request.getSession().getAttribute("vertify");
        if(user==null){
            response.sendRedirect("/login.jsp");
            return;
        }

        //1.获取商品ID
        String params_id = request.getParameter("id");
        int id = 0;
        if(params_id != null && !"".equals(params_id)){
            id = Integer.parseInt(params_id);
        }
        EYProduct product = shproduct.getSellingDetil(id);

        if(product.getEp_stock() == 0){
            response.sendRedirect("/noproduct-result.jsp");
            return;
        }

        ShoppingCart cart = (ShoppingCart)request.getSession().getAttribute("cart");
        if(cart == null){
            cart = new ShoppingCart();
            cart.addItem(product, 1);
        }else{
            //查找有无相同的产品
            List<ShoppingCartItem> items = cart.getItems();
            if(items!=null && items.size()>0){
                for(ShoppingCartItem item : items){
                    EYProduct itemPro = item.getProduct();
                    if(itemPro.getEp_id()==id){
                        item.setQuantity(item.getQuantity()+1);
                        issame = true;  //标识
                    }
                }
            }
            //若不存在，则直接添加，数量默认为1
            if(!issame) {
                cart.addItem(product, 1);
            }
        }
        request.getSession().setAttribute("cart",cart);
        response.sendRedirect("/shopping.jsp");
    }
    /**
     * 结算
     */
    public void payCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO 判断用户是否登录
        EYLogin user = (EYLogin) request.getSession().getAttribute("vertify");
        ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
        if(cart.getItems().size()==0){
            response.sendRedirect("/NoProduct_result.jsp");
            return;
        }

        else{
            orderService.payOrder(cart,user);
            cart.getItems().clear();
        }
        response.sendRedirect("/shopping-result.jsp");

    }

    /**
     * 购物车页面进行修改
     */
    public void modifyCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        int number=Integer.parseInt(request.getParameter("number"));
        EYProduct product = shproduct.getSellingDetil(id);
        ShoppingCart cart = (ShoppingCart)request.getSession().getAttribute("cart");
        List<ShoppingCartItem> items = cart.getItems();
        if(number==0){
            int i=1;
            int index=-1;
            if(items!=null && items.size()>0){
                for(ShoppingCartItem item : items){
                    EYProduct itemPro = item.getProduct();
                    if(itemPro.getEp_id()==id){
                        index=i-1;
                    }
                    i++;
                }
            }
            items.remove(index);
        }else{
            if(items!=null && items.size()>0) {
                for (ShoppingCartItem item : items) {
                    EYProduct itemPro = item.getProduct();
                    if (itemPro.getEp_id() == id) {
                        int stock=itemPro.getEp_stock();
                        if(number>stock){
                            response.sendRedirect("/numberSpilled_result.jsp");
                            return;
                        }
                        else {
                            item.setQuantity(number);
                        }
                    }
                }
            }
        }
            request.getSession().setAttribute("cart",cart);
        response.sendRedirect("/shopping.jsp");

    }
    public void removeCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        EYProduct product = shproduct.getSellingDetil(id);
        ShoppingCart cart = (ShoppingCart)request.getSession().getAttribute("cart");
        List<ShoppingCartItem> items = cart.getItems();
        int i=1;
        int index=-1;
        if(items!=null && items.size()>0){
            for(ShoppingCartItem item : items){
                EYProduct itemPro = item.getProduct();
                if(itemPro.getEp_id()==id){
                    index=i-1;
                }
                i++;
            }
        }
        items.remove(index);
        request.getSession().setAttribute("cart",cart);
        response.sendRedirect("/shopping.jsp");

    }
}
