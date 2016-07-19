package sdkd.com.ec.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ydf_m on 2016/7/9.
 */
public class ShoppingCart {
    private List<ShoppingCartItem> items = new ArrayList<ShoppingCartItem>();

    public void addItem(EYProduct product, long quantity){
        items.add(new ShoppingCartItem(product, quantity));
    }

    public void removeItem(int index){
        items.remove(index);
    }

    public void modifyQuantity(int index, long quantity){
        items.get(index).setQuantity(quantity);
    }

    public double getTotalCoast(){
        double sum = 0;
        for(ShoppingCartItem item : items){
            sum = sum + item.getCost();
        }
        return sum;
    }

    public List<ShoppingCartItem> getItems(){
        return items;
    }

    public void setItems(List<ShoppingCartItem> items){
        this.items = items;
    }
}
