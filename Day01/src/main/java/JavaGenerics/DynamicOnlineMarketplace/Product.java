package JavaGenerics.DynamicOnlineMarketplace;


// Generic Product Class
class Product<T> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public T getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + " - " + price;
    }
}
