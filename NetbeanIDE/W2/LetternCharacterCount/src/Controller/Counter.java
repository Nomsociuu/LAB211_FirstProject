/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.Controller;
import java.util.*;

import Model.*;
import View.*;

public class Counter extends Menu{
    private static final Scanner scanner = new Scanner(System.in);
    public Counter (){
        super("\n>Character Count<", new String[]{"Add String", "Count Character", "Word Count", "Exit"});

    }
    Controller control = new Controller();
    Model models = new Model();

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                control.inpuutString();
                break;
            case 2:
                control.charCount();
                //System.out.println(models.getCharCount());
                break;
            case 3:
                control.wCount();
                //System.out.println(models.getWordCount());
                break;
            case 4:
                System.exit(0);
                break;
        }
    }

    public void runner() {
        Counter count = new Counter();
        count.run();
    }
}
