public abstract class Product {

    String ID;
    String exchange;

    public Product(String ID, String exchange) {
        this.ID = ID;
        this.exchange = exchange;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }
    public abstract  double getPrice();

}
