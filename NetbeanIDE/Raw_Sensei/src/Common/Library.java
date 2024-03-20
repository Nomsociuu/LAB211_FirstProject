package Common;

import java.util.InputMismatchException;
import java.util.Scanner;
//Hàm nhập:
public class Library {

    private Scanner sc = new Scanner(System.in);

    public int getInt(String mes) {
        System.out.print(mes);
        return sc.nextInt();
    }
    
    public double getDouble(String mes) {
        System.out.print(mes);
        return sc.nextDouble();
    }

    public String getString(String mes) {
        System.out.print(mes);
        return sc.nextLine();
    }
    
    public int getIntInRange(String msg, int m, int n) { //re-enter int till in range
        int number;
        while (true) {
            System.out.print(String.format("%s", msg));

//            if String replace with List<String> then the line above replace with
//            for (int i = 0; i < msg.size(); i++) {
//            System.out.println((i + 1) + ". " + msg.get(i));
            try {
                number = sc.nextInt();
                if (number >= m && number <= n) {
                    break;
                } else {
                    System.err.println("Please enter a number from " + m + " to " + n);
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong format !!");
                sc.next();
            }
        }
        return number;
    }
}
