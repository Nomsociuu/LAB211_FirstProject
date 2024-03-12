package LoginSystem.Model;

public class Model {

    private String accountNumber;
    private String password;

    public Model(String accountNumber, String password) {
        this.accountNumber = accountNumber;
        this.password = password;
    }
    public Model(){}

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
