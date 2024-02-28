package Model;

public class Order {
    private String fruitID;
    private String fruitName;
    private double fruitPrice;
    private int fruitQuantity;

    public Order (String fruitID, String fruitName, int fruitQuantity, double fruitPrice) {
        this.fruitID = fruitID;
        this.fruitName = fruitName;
        this.fruitQuantity = fruitQuantity;
        this.fruitPrice = fruitPrice;
    }
    
    public String getFruitID() {
        return fruitID;
    }
    
    public void setFruitID(String fruitID) {
        this.fruitID = fruitID;
    }
    
    public String getFruitName() {
        return fruitName;
    }
    
    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }
    
    public int getFruitQuantity() {
        return fruitQuantity;
    }
    
    public void setFruitQuantity(int fruitQuantity) {
        this.fruitQuantity = fruitQuantity;
    }
    
    public double getFruitPrice() {
        return fruitPrice;
    }
    
    public void setFruitPrice(double fruitPrice) {
        this.fruitPrice = fruitPrice;
    }
}
