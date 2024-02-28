package Common;

public class Validation {
    Inputter input = new Inputter();
    public double checkInputDouble(String mess) {
        while (true) {
            try {
                System.out.print(mess);
                double result = Double.parseDouble(input.inputStr());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please input again!");
            }
        }
    }
}