package Controller;

import Model.Candidate;
import Model.ExperienceCandidate;
import Model.FresherCandidate;
import Model.InternCandidate;
import Model.Validate;
import View.View;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    private ArrayList<Candidate> candidates = new ArrayList<>();
    Validate vali = new Validate();
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

            System.out.print("Enter ID: ");
            String candidateId = sc.next();
            String firstname = vali.getUnliString("Enter First Name: ");
            String lastname = vali.getUnliString("Enter Last Name: ");
            String address = vali.getUnliString("Enter Address: ");

            int expInYear = vali.getNumberInRange("Enter Year of Experience: ",0,100);
            String proSkill = vali.getUnliString("Enter Professional Skill: ");

            candidates.add(new ExperienceCandidate(candidateId,
                    firstname, lastname,
                    vali.getBirthDate(),
                    address,
                    vali.getPhone(),
                    vali.getEmail(),
                    expInYear,
                    proSkill));

        } while (askToContinue());

    }

    private void createFresherCandidate() {
        do {
            System.out.println("____Creating Fresher Candidate____");

            System.out.print("Enter ID: ");
            String candidateId = sc.next();
            String firstname = vali.getUnliString("Enter First Name: ");
            String lastname = vali.getUnliString("Enter Last Name: ");
            String address = vali.getUnliString("Enter Address: ");

            System.out.print("Enter Graduation Date: ");
            String graduationDate = sc.next();
            System.out.print("Enter Graduation Rank (Excellence/Good/Fair/Poor): ");
            String graduationRank = Validate.getValidGraduationRank();
            String education = vali.getUnliString("Enter University Name: ");

            candidates.add(new FresherCandidate(candidateId,
                    firstname, lastname,
                    vali.getBirthDate(),
                    address,
                    vali.getPhone(),
                    vali.getEmail(),
                    graduationDate,
                    graduationRank,
                    education));
        } while (askToContinue());

    }

    private void createInternCandidate() {
        do {
            System.out.println("____Creating Intern Candidate____");

            System.out.print("Enter ID: ");
            String candidateId = sc.next();
            String firstname = vali.getUnliString("Enter First Name: ");
            String lastname = vali.getUnliString("Enter Last Name: ");
            String address = vali.getUnliString("Enter Address: ");

            String majors = vali.getUnliString("Enter Majors: ");
            int semester = vali.getNumberInRange("Enter Semester: ",0,4);
            String universityName = vali.getUnliString("Enter University Name: ");

            candidates.add(new InternCandidate(candidateId,
                    firstname, lastname,
                    vali.getBirthDate(),
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

    private void searchCandidates() {
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
    private void displayCandidates() {
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
