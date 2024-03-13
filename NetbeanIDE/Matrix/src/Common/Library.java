package Common;

import java.util.Scanner;
//Hàm nhập:
public class Library {

    private Scanner sc = new Scanner(System.in);

    public int getInt(String mes) {
        System.out.println(mes);
        return sc.nextInt();
    }
    
    public double getDouble(String mes) {
        System.out.println(mes);
        return sc.nextDouble();
    }

    public String getString(String mes) {
        System.out.println(mes);
        return sc.nextLine();
    }
}
