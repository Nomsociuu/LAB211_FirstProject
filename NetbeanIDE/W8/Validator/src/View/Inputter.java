package View;

import Model.*;
import Common.*;

public class Inputter {
    final String emailRegex = "^[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";
    final String phoneRegex = "\\d{10}";
    final Validate val = new Validate();

    public Model inputter() {
        String phone, email, date;
        do {
            phone = val.checkString("Enter phone: ");
            phone = val.checkPhone(phone);
        } 
        while (!phone.matches(phoneRegex));
        do {
            email = val.checkString("Enter email: ");
            email = val.checkEmail(email);
        }   
        while (!email.matches(emailRegex));
        do {
            date = val.checkString("Enter date: ");
            date = val.checkDate(date);
        }
        while (date == null);
        return new Model(phone, email, date);
    }
}

