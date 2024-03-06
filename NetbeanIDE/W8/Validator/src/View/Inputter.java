package View;

import Model.*;
import Common.*;

public class Inputter {
    final Validate val = new Validate();

    public Model inputter() {
        String phone = val.checkString("Enter phone: ");
        val.checkPhone(phone);
        String email = val.checkString("Enter email: ");
        val.checkEmail(email);
        String date = val.checkString("Enter date: ");
        val.checkDate(date);
        return new Model(phone, email, date);
    }
}
