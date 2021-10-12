public class Option  extends  Product{

       String  ticker;
       int validForDays;
       double price;
       private final  ProductPricingService productPricingService;

    public Option(String ID, String exchange, String ticker, int validForDays, ProductPricingService productPricingService) {
        super(ID, exchange);
        this.ticker = ticker;
        this.validForDays = validForDays;
        this.productPricingService = productPricingService;
    }

    public double getPrice() {
        price = productPricingService.price(this.exchange,this.ticker,this.validForDays);
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public int getValidityTime() {
        return validForDays;
    }

    public void setValidityTime(int validityTime) {
        this.validForDays = validForDays;
    }
}
