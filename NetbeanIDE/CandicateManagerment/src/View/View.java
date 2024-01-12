package View;


import Model.Candidate;
import Model.ExperienceCandidate;
import Model.FresherCandidate;
import Model.InternCandidate;
import Model.Validate;
import java.util.ArrayList;
import java.util.Scanner;

public class View {
    Validate vali = new Validate();
    static Scanner sc = new Scanner(System.in);
    private ArrayList<Candidate> candidates = new ArrayList<>();

    public static void displayMainMenu() {
        System.out.println("CANDIDATE MANAGEMENT SYSTEM");
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Intern");
        System.out.println("4. Searching");
        System.out.println("5. Exit");
        System.out.print("Please choose (1-5): ");
    }

    public static int getUserChoice(int min, int max) {
        int choice;
        do {
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }
            choice = sc.nextInt();
            if (choice < min || choice > max) {
                System.out.println("Invalid choice. Please choose between " + min + " and " + max + ".");
            }
        } while (choice < min || choice > max);

        return choice;
    }

    public void createExperienceCandidate() {
        do {
            System.out.println("____Creating Experience Candidate____");

            System.out.print("Enter ID: ");
            String candidateId = sc.next();
            String firstname = vali.getUnliString("Enter First Name: ");
            String lastname = vali.getUnliString("Enter Last Name: ");
            String address = vali.getUnliString("Enter Address: ");

            int expInYear = vali.getNumberInRange("Enter Year of Experience: ", 0, 100);
            String proSkill = vali.getUnliString("Enter Professional Skill: ");

            candidates.add(new ExperienceCandidate(candidateId,
                    firstname, lastname,
                    vali.checkBirthDay(),
                    address,
                    vali.getPhone(),
                    vali.getEmail(),
                    expInYear,
                    proSkill));

        } while (askToContinue());

    }

    public void createFresherCandidate() {
        String birthD;
        String graduationDate;
        boolean isValid;
        do {
            System.out.println("____Creating Fresher Candidate____");

            System.out.print("Enter ID: ");
            String candidateId = sc.next();
            String firstname = vali.getUnliString("Enter First Name: ");
            String lastname = vali.getUnliString("Enter Last Name: ");
            String address = vali.getUnliString("Enter Address: ");

            do {
                birthD = vali.checkBirthDay();
                System.out.print("Enter Graduation Date: ");
                graduationDate = sc.next();
                isValid = vali.checkTime(birthD, graduationDate);

                if (!isValid) {
                    System.out.println("Invalid input.Enter again ");
                }
            } while (!isValid);

            System.out.print("Enter Graduation Rank (Excellence/Good/Fair/Poor): ");
            String graduationRank = Validate.getValidGraduationRank();
            String education = vali.getUnliString("Enter University Name: ");

            candidates.add(new FresherCandidate(candidateId,
                    firstname, lastname,
                    birthD,
                    address,
                    vali.getPhone(),
                    vali.getEmail(),
                    graduationDate,
                    graduationRank,
                    education));
        } while (askToContinue());

    }

    public void createInternCandidate() {
        do {
            System.out.println("____Creating Intern Candidate____");

            System.out.print("Enter ID: ");
            String candidateId = sc.next();
            String firstname = vali.getUnliString("Enter First Name: ");
            String lastname = vali.getUnliString("Enter Last Name: ");
            String address = vali.getUnliString("Enter Address: ");

            String majors = vali.getUnliString("Enter Majors: ");
            int semester = vali.getNumberInRange("Enter Semester: ", 0, 4);
            String universityName = vali.getUnliString("Enter University Name: ");

            candidates.add(new InternCandidate(candidateId,
                    firstname, lastname,
                    vali.checkBirthDay(),
                    address,
                    vali.getPhone(),
                    vali.getEmail(),
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
    public void searchCandidates() {
        System.out.println("Searching Candidates:");
        displayAllCandidates();

        System.out.print("Input Candidate name (First name or Last name): ");
        String candidateName = sc.next().toLowerCase();
        System.out.print("Input type of candidate (0 for Experience, 1 for Fresher, 2 for Intern): ");
        int candidateType = View.getUserChoice(0, 2);

        System.out.println("-----------------------------");
        System.out.println("The candidates found:");
        for (Candidate candidate : candidates) {
            if ((candidate.getFirstName().toLowerCase().contains(candidateName)
                    || candidate.getLastName().toLowerCase().contains(candidateName))
                    && candidate.getCandidateType() == candidateType) {
                System.out.println(candidate.getCandidateInfo());

            }
        }
        System.out.println("-----------------------------");
    }
    
    //Display trước khi search 1 
    private void displayAllCandidates() {
        System.out.println("===========EXPERIENCE CANDIDATE============");
        displayCandidatesByType(0);
        System.out.println("===========FRESHER CANDIDATE===============");
        displayCandidatesByType(1);
        System.out.println("===========INTERN CANDIDATE================");
        displayCandidatesByType(2);
    }

//Display sau khi enter no
    public void displayCandidates() {
        System.out.println("-----------------------------");
        System.out.println("All candicate has been entered:   ");
        for (Candidate candidate : candidates) {
            System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
        }
        System.out.println("-----------------------------");
    }

//Display trước khi search 1 kéo theo
    private void displayCandidatesByType(int candidateType) {
        for (Candidate candidate : candidates) {
            if (candidate.getCandidateType() == candidateType) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
    }
}

