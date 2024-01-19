package LAB211.FruitShop.Model;

public class Model {
    private String FruitID;
    private String FruitName;
    private double FruitPrice;
    private int FruitQuantity;
    private String Origin;

    public Model() {

    }
    
    public Model(String FruitID, String FruitName, double FruitPrice, int FruitQuantity, String Origin) {
        this.FruitID = FruitID;
        this.FruitName = FruitName;
        this.FruitPrice = FruitPrice;
        this.FruitQuantity = FruitQuantity;
        this.Origin = Origin;
    }
    
    public String getFruitID() {
        return FruitID;
    }
    
    public void setFruitID(String FruitID) {
        this.FruitID = FruitID;
    }
    
    public String getFruitName() {
        return FruitName;
    }
    
    public void setFruitName(String FruitName) {
        this.FruitName = FruitName;
    }
    
    public double getFruitPrice() {
        return FruitPrice;
    }
    
    public void setFruitPrice(double FruitPrice) {
        this.FruitPrice = FruitPrice;
    }
    
    public int getFruitQuantity() {
        return FruitQuantity;
    }
    
    public void setFruitQuantity(int FruitQuantity) {
        this.FruitQuantity = FruitQuantity;
    }
    
    public String getOrigin() {
        return Origin;
    }
    
    public void setOrigin(String Origin) {
        this.Origin = Origin;
    }
}
