package homework01;

public class Tea {

    private String name;
    private String price;
    private String description;

    public Tea(String name, String price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public String getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }
}
