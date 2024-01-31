package View;

import Model.Doctor;
import Model.DoctorHash;
import java.util.Map;
import java.util.Scanner;

public class Function {

    private final DoctorHash doctorHash = new DoctorHash();
    private static final Scanner scanner = new Scanner(System.in);
    Validate vali = new Validate();

    public void addDoctor() {
        try {
            System.out.println("--------- Add Doctor ----------");
            Doctor doctor = inputData();
            doctorHash.addDoctor(doctor);
            System.out.println("Doctor added successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateDoctor() {
        try {
            System.out.println("--------- Update Doctor ----------");
            String code = inputCode();
            Doctor doctorToUpdate = doctorHash.getDoctorMap().get(code);

            if (doctorToUpdate == null) {
                System.out.println("Doctor code " + code + " does not exist. Please try again.");
                return;
            }

            System.out.println("Current Doctor Information:");
            System.out.println(doctorToUpdate);

            Doctor updatedDoctor = inputUpdatedData(doctorToUpdate);
            doctorHash.updateDoctor(updatedDoctor);
            System.out.println("Doctor updated successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private Doctor inputUpdatedData(Doctor currentDoctor) {
        System.out.println("Enter new information (leave blank for no change):");

        System.out.print("Enter Name [" + currentDoctor.getName() + "]: ");
        String name = scanner.nextLine();

        System.out.print("Enter Specialization [" + currentDoctor.getSpecialization() + "]: ");
        String specialization = scanner.nextLine();

        System.out.print("Enter Availability [" + currentDoctor.getAvailability() + "]: ");
        String availabilityString = scanner.nextLine();

        // Use the existing values if the user leaves a field blank
        name = (name.trim().isEmpty()) ? currentDoctor.getName() : name;
        specialization = (specialization.trim().isEmpty()) ? currentDoctor.getSpecialization() : specialization;

        // Parse availability only if it's not blank
        int availability = (availabilityString.trim().isEmpty()) ? currentDoctor.getAvailability() : Integer.parseInt(availabilityString);

        return new Doctor(currentDoctor.getCode(), name, specialization, availability);
    }

    public void deleteDoctor() {
        try {
            System.out.println("--------- Delete Doctor ----------");
            String code = inputCode();
            Doctor doctorToDelete = doctorHash.getDoctorMap().get(code);

            if (doctorToDelete == null) {
                System.out.println("Doctor code " + code + " does not exist. Please try again.");
                return;
            }

            doctorHash.deleteDoctor(doctorToDelete);
            System.out.println("Doctor deleted successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void searchDoctor() {
        try {
            System.out.println("---------- Search Doctor --------");
            System.out.print("Enter text: ");
            String keyword = scanner.nextLine();

            Map<String, Doctor> searchResult = doctorHash.searchDoctor(keyword);

            if (searchResult.isEmpty()) {
                System.out.println("No matching doctors found. Enter again!");
            } else {
                System.out.println("--------- Result ------------");
                System.out.printf("%-10s %-15s %-20s %-15s%n", "Code", "Name", "Specialization", "Availability");
                for (Doctor doctor : searchResult.values()) {
                    System.out.printf("%-10s %-15s %-20s %-15d%n",
                            doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability());
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private Doctor inputData() {
    while (true) {
        try {
            System.out.print("Enter Code: ");
            String code = scanner.nextLine();

            if (!vali.isCodeValid(code)) {
                throw new Exception("Invalid Code format. Code must contain either letters or numbers.");
            }

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            if (!vali.isNameValid(name)) {
                throw new Exception("Invalid Name format. Name must contain only letters.");
            }

            System.out.print("Enter Specialization: ");
            String specialization = scanner.nextLine();
            if (!vali.isSpecializationValid(specialization)) {
                throw new Exception("Invalid Specialization format. Specialization must contain only letters.");
            }

            System.out.print("Enter Availability: ");
            String availabilityString = scanner.nextLine();
            if (!vali.isAvailabilityValid(availabilityString)) {
                throw new Exception("Invalid Availability format. Availability must contain only digits.");
            }

            int availability = Integer.parseInt(availabilityString);

            return new Doctor(code, name, specialization, availability);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


    private String inputCode() {
        System.out.print("Enter Code: ");
        return scanner.nextLine();
    }
}
