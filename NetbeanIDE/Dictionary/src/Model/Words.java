package Model;

public class Words {
    private String English;
    private String Vietnamese;

    public Words() {}
    public Words(String English, String Vietnamese) {
        this.English = English;
        this.Vietnamese = Vietnamese;
    }

    public void setEnglish(String English) {
        this.English = English;
    }

    public String getEnglish() {
        return English;
    }

    public void setVietnamese(String Vietnamese) {
        this.Vietnamese = Vietnamese;
    }

    public String getVietnamese() {
        return Vietnamese;
    }

    // @Override
    // public String toString() {
    //     return English;
    // }
}
