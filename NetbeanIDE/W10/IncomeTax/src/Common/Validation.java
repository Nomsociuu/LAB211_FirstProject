package Common;

public class Validation {

    public boolean checkInt(String s, int min, int max) {
            try {
                int number = Integer.parseInt(s);
                if (number < min || number > max) {
                    System.out.println("Please input number between " + min + " - " + max +"!");
                    return false;
                }
                return true;
            } catch (NumberFormatException e) {
                System.out.println("Please input an integer number !");
                return false;
            }
    }

    public boolean checkDouble(String s, double min) {
        try {
            double number = Double.parseDouble(s);
            if (number < min) {
                System.out.println("Please input nunmber >" + min + "!");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Please input an integer number !");
            return false;
        }
    }

    public boolean checkName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Name cannot be null or empty!");
            return false;
        }
        if (!name.matches("[a-zA-Z\\s-]+")) {
            System.out.println("Name should contain only letters, spaces!");
            return false;
        }
        return true;
    }
}
