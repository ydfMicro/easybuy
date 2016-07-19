package sdkd.com.ec.model;

/**
 * Created by duye123 on 2016/7/9.
 */
public class ShoppingCartItem {
    private EYProduct product;
    private Long quantity;
    private double cost;
    public ShoppingCartItem(EYProduct product,long quantity){
        this.product=product;
        this.quantity=quantity;
        this.cost=product.getEp_price()*quantity;
    }

    public EYProduct getProduct() {
        return product;
    }

    public void setProduct(EYProduct product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
        this.cost=product.getEp_price()*quantity;
    }
    public double getCost(){
        return cost;
    }
}
