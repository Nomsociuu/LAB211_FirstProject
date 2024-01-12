package Controller;

import Model.Candidate;
import View.View;
import java.util.ArrayList;

public class Controller {

    private ArrayList<Candidate> candidates = new ArrayList<>();
    View view = new View();

    public void run() {
        while (true) {
            int choice;
            do {
                View.displayMainMenu();
                choice = View.getUserChoice(1, 5);

                switch (choice) {
                    case 1:
                        view.createExperienceCandidate();
                        view.displayCandidates();
                        break;
                    case 2:
                        view.createFresherCandidate();
                        view.displayCandidates();
                        break;
                    case 3:
                        view.createInternCandidate();
                        view.displayCandidates();
                        break;
                    case 4:
                        view.searchCandidates();
                        break;
                    case 5:
                        System.out.println("Exiting program. Goodbye!");
                        System.exit(0);
                }
            } while (choice > 0 && choice <= 5);

        }
    }

}
