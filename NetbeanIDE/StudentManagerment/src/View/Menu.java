package View;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu {

    protected String title;
    protected ArrayList<String> list = new ArrayList();
    Scanner sc = new Scanner(System.in);

    public Menu() {
    }

    public Menu(String title, String[] s) {
        this.title = title;
        for (String item : s) {
            list.add(item);
        }
    }

    public void display() {
        System.out.println(title);
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    public int getChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter selection: ");
        int choice = scanner.nextInt();
        return choice;
    }

    public abstract void execute(int choice);

    public void run() {
        int choice;
        do {
            display();//list the content of menu
            choice = getChoice();
            execute(choice);
        } while (choice > 0 && choice < list.size());

    }
    
    public String courseMenu() {
        String course = null;
        System.out.println("1. Java");
        System.out.println("2. .Net");
        System.out.println("3. C/C++");
        System.out.print("Enter your course: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                course = "Java";
                break;
            case 2:
                course = ".Net";
                break;
            case 3:
                course = "C/C++";
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        return course;
    }

}
