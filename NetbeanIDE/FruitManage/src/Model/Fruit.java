package Model;

public class Fruit {

    private int id;
    private String name;
    private String origin;
    private int price;
    private int quantity;

    public Fruit(int id, String name, String origin, int price) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.price = price;
        this.quantity = 0;
    }

    public Fruit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double calculateAmount() {
        return quantity * price;
    }
}
