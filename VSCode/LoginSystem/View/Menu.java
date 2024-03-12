package LoginSystem.View;

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

import LoginSystem.Utils.*;
import LoginSystem.Model.*;

public class Menu {

    private final String character="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private String accountNumber, password;
    private ResourceBundle lang;
    private Locale loc;

    final Model mods = new Model();
    final Util utils = new Util();

    public void display() {

        System.out.println("\n ---------- Login System ----------");
        if (showMenu()) {
            return;
        }
        //with locale ( language , country )
        //search for Bundle with name : basename_language_country
        lang = ResourceBundle.getBundle("LoginSystem.Lang.lang", loc);
        this.accountNumber = utils.getStringRegex(this.lang.getString("account"), "^[0-9]{10}$", this.lang.getString("accountError"));
        mods.setAccountNumber(this.accountNumber);
        this.password = utils.getStringRegex(this.lang.getString("password"), "^(?=.*?[0-9])(?=.*[a-zA-Z])[0-9a-zA-Z]{8,31}$", this.lang.getString("passwordError"));
        mods.setPassword(this.password);
        String captcha = createCaptcha(6);
        System.out.println(this.lang.getString("captcha") + captcha);
        String captchaInput;
        do {
            captchaInput = utils.getStringRegex(this.lang.getString("captchaInput"), "^[0-9a-zA-Z]+$", this.lang.getString("captchaInputError"));
            if(captcha.contains(captchaInput))
                break;
            System.out.println(this.lang.getString("captchaInputError"));
        } while(true);
    }

    @SuppressWarnings("deprecation")
    public boolean showMenu() {
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        int choice = Integer.parseInt(utils.getStringRegex("Please enter choice option: ", "^[1-3]{1}$","Please enter from 1 to 3!"));
        /// Locale(language, country)
        if (choice == 1) {
            this.loc = new Locale("vi","VN");
            return false;
        }
        if (choice == 2) {
            this.loc = new Locale("en","US");
            return false;
        }
        return true;
    }

    public String createCaptcha(int n) {
        Random rand = new Random();
        String res="";
        do{
            int randValue = rand.nextInt(62);
            //turn on for unique character captcha 
            //if (Character.toString(character.charAt(randValue)).matches("^[^"+res+" ]$")) {
                res=res+ character.charAt(randValue);
            //}
        } while(res.length()<n);
        return res;
    }
}