package View;

public class Validate {

    public boolean isCodeValid(String code) {
        return code.matches(".*[a-zA-Z].*|.*\\d.*");
    }

    public boolean isNameValid(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public boolean isSpecializationValid(String specialization) {
        return specialization.matches("[a-zA-Z]+");
    }

    public boolean isAvailabilityValid(String availability) {
        return availability.matches("\\d+");
    }

}
