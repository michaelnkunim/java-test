public class Future  extends Product{

    double price;
    String contractCode;
    int contractMonth;
    int contractYear;
    private final ProductPricingService productPricingService;

    public Future(String ID, String exchange, String contractCode, int contractMonth, int contractYear, ProductPricingService productPricingService) {
        super(ID, exchange);
        this.contractCode = contractCode;
        this.contractMonth = contractMonth;
        this.contractYear = contractYear;
        this.productPricingService = productPricingService;
    }

    public double getPrice() {
        price = productPricingService.price(this.exchange,contractCode,contractMonth,contractYear);
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getContractCode(){
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public int getContractMonth() {
        return contractMonth;
    }

    public void setContractMonth(int contractMonth) {
        this.contractMonth = contractMonth;
    }

    public int getContractYear() {
        return contractYear;
    }

    public void setContractYear(int contractYear) {
        this.contractYear = contractYear;
    }

}
