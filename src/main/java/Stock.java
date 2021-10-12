public class Stock extends  Product {

    String ticker;
    double price;
    private final ProductPricingService productPricingService;

    public Stock(String ID, String exchange, String ticker, ProductPricingService productPricingService) {
        super(ID, exchange);
        this.ticker = ticker;
        this.productPricingService = productPricingService;
    }

    public double getPrice() {
        price  =  productPricingService.price(this.exchange,this.ticker);
        return price;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
