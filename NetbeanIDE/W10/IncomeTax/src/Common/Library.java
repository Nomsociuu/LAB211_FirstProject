package Common;

import java.util.Scanner;

public class Library {

    public final Scanner sc = new Scanner(System.in);

    public String inputString(String title) {
        System.out.print(title);
        return sc.nextLine();
    }
    public int checkPositiveNum(String title){
        System.out.println(title);
        return sc.nextInt();
    }

}
