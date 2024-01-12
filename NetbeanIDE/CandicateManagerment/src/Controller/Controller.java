package Controller;

// CandidateManagementController.java
import Model.Candidate;
import Model.ExperienceCandidate;
import Model.FresherCandidate;
import Model.InternCandidate;
import Model.Validate;
import View.View;
import static View.View.getUserChoice;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    private ArrayList<Candidate> candidates = new ArrayList<>();
    ExperienceCandidate expca = new ExperienceCandidate();
    static final Scanner sc = new Scanner(System.in);

    public void run() {
        while (true) {
            int choice;
            do {
                View.displayMainMenu();
                choice = View.getUserChoice(1, 5);

                switch (choice) {
                    case 1:
                        createExperienceCandidate();
                        displayCandidates();
                        break;
                    case 2:
                        createFresherCandidate();
                        displayCandidates();
                        break;
                    case 3:
                        createInternCandidate();
                        displayCandidates();
                        break;
                    case 4:
                        searchCandidates();
                        break;
                    case 5:
                        System.out.println("Exiting program. Goodbye!");
                        System.exit(0);
                }
            } while (choice > 0 && choice <= 5);

        }
    }

    private void createExperienceCandidate() {
        do {
            System.out.println("____Creating Experience Candidate____");

            System.out.print("Enter Candidate ID: ");
            String candidateId = sc.next();
            System.out.print("Enter First Name: ");
            String firstname = sc.next();
            System.out.print("Enter Last Name: ");
            String lastname = sc.next();
            System.out.print("Enter Address: ");
            String address = sc.next();

            System.out.print("Enter Year of Experience: ");
            int expInYear = getUserChoice(0, 100);
            System.out.print("Enter Professional Skill: ");
            String proSkill = sc.next();

            candidates.add(new ExperienceCandidate(candidateId,
                    firstname,lastname,
                    Validate.getBirthDate(),
                    address,
                    Validate.getPhone(),
                    Validate.getEmail(),
                    expInYear,
                    proSkill));

        } while (askToContinue());

    }

    private void createFresherCandidate() {
        do {
            System.out.println("____Creating Fresher Candidate____");

            System.out.print("Enter Candidate ID: ");
            String candidateId = sc.next();
            System.out.print("Enter First Name: ");
            String firstname = sc.next();
            System.out.print("Enter Last Name: ");
            String lastname = sc.next();
            System.out.print("Enter Address: ");
            String address = sc.next();

            System.out.print("Enter Graduation Date: ");
            String graduationDate = sc.next();
            System.out.print("Enter Graduation Rank (Excellence/Good/Fair/Poor): ");
            String graduationRank = Validate.getValidGraduationRank();
            System.out.print("Enter University Name: ");
            String education = sc.next();

            candidates.add(new FresherCandidate(candidateId,
                    firstname,lastname,
                    Validate.getBirthDate(),
                    address,
                    Validate.getPhone(),
                    Validate.getEmail(),
                    graduationDate,
                    graduationRank,
                    education));
        } while (askToContinue());

    }

    private void createInternCandidate() {
        do {
            System.out.println("____Creating Intern Candidate____");

            System.out.print("Enter Candidate ID: ");
            String candidateId = sc.next();
            System.out.print("Enter First Name: ");
            String firstname = sc.next();
            System.out.print("Enter Last Name: ");
            String lastname = sc.next();
            System.out.print("Enter Address: ");
            String address = sc.next();

            System.out.print("Enter Majors: ");
            String majors = sc.next();
            System.out.print("Enter Semester: ");
            String semester = sc.next();
            System.out.print("Enter University Name: ");
            String universityName = sc.next();

            candidates.add(new InternCandidate(candidateId,
                    firstname,lastname,
                    Validate.getBirthDate(),
                    address,
                    Validate.getPhone(),
                    Validate.getEmail(),
                    majors,
                    semester,
                    universityName));

        } while (askToContinue());

    }

    private boolean askToContinue() {
        System.out.print("Do you want to continue (Y/N)? ");
        String continueChoice = sc.next().toLowerCase();

        return continueChoice.equals("y");
    }

    private void searchCandidates() {
        System.out.println("Searching Candidates:");
        displayAllCandidates();

        // Take input for searching
        System.out.print("Input Candidate name (First name or Last name): ");
        String candidateName = sc.next().toLowerCase();
        System.out.print("Input type of candidate (0 for Experience, 1 for Fresher, 2 for Intern): ");
        int candidateType = View.getUserChoice(0, 2);

        // Search and display result
        System.out.println("The candidates found:");
        for (Candidate candidate : candidates) {
            if ((candidate.getFirstName().toLowerCase().contains(candidateName)
                    || candidate.getLastName().toLowerCase().contains(candidateName))
                    && candidate.getCandidateType() == candidateType) {
                System.out.println(candidate.getCandidateInfo());
            }
        }
    }
//Hàm nhập 1 String không giới hạn , kí tự khác số
    public String getStringUnli(String prompt) {
        String str;
        boolean check = true;
        do {
            System.out.print(prompt);

            while (!sc.hasNextLine()) {
                System.out.print(prompt);
                sc.next();
            }

            str = sc.nextLine();

            for (char c : str.toCharArray()) {
                if (!Character.isDigit(c)) {
                    check = false;
                    break;
                }
            }
        } while (!check);

        return str;
    }
    

    private void displayAllCandidates() {
        System.out.println("===========EXPERIENCE CANDIDATE============");
        displayCandidatesByType(0);
        System.out.println("===========FRESHER CANDIDATE===============");
        displayCandidatesByType(1);
        System.out.println("===========INTERN CANDIDATE================");
        displayCandidatesByType(2);
    }

    private void displayCandidates() {
        System.out.println("-----------------------------");
        System.out.println("All candicate has been entered:   ");
        for (Candidate candidate : candidates) {
            System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
        }
        System.out.println("-----------------------------");
    }

    private void displayCandidatesByType(int candidateType) {
        for (Candidate candidate : candidates) {
            if (candidate.getCandidateType() == candidateType) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
    }

}
