import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParisTradedProductsActual implements  ParisTradedProducts{

    List<Product> productsRegistered = new ArrayList<>();
    //product, stock and corresponding trade; sounds like map
    Map<Product,Integer>  tradesRegister  =  new HashMap<>();

    @Override
    public  void addNewProduct(Product product) throws ProductAlreadyRegisteredException {
        if(productsRegistered.contains(product)){
            throw new ProductAlreadyRegisteredException("This product already Exists");
        }else{
            productsRegistered.add(product);
        }
    }

    @Override
    public  void trade(Product product, int quantity) {
       if(!productsRegistered.contains(product)) {
           int currentQuantity = tradesRegister.get(product);
           tradesRegister.put(product,currentQuantity + quantity);
       }else{
         String Error =  "This Product has not been registered and thus cannot be traded";
       }
    }

    @Override
    public int totalTradeQuantityForDay() {
     int totalQuantity  = tradesRegister.values().stream().mapToInt(quantity -> quantity).sum();
        System.out.println(totalQuantity);
        return totalQuantity;
    }

    @Override
    public double totalValueOfDaysTradedProducts() {
        double totalTrades =  tradesRegister.keySet().stream().mapToDouble(p -> p.getPrice() * tradesRegister.get(p).doubleValue()).sum();
        System.out.println(totalTrades);
        return totalTrades;
    }


}
