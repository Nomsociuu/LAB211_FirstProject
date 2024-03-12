package LoginSystem.Utils;

import java.util.Scanner;

import LoginSystem.Common.*;

public class Util {
    final Validate val = new Validate();
    public String getStringRegex(String ms, String pattern, String msg) {
        String inp;
        do {
            System.out.print(ms);
            inp = val.checkString();
            if (inp.matches(pattern))
                return inp;
            System.out.println(msg);
        } while(true);
    }
}
