
import View.View;

public class Controller {

    private View view = new View();

    public void run() {
        while (true) {
            int option = view.getMenuOption();

            switch (option) {
                case 1:
                    view.addCountryInformation();
                    break;
                case 2:
                    view.displayRecentlyEnteredInformation();
                    break;
                case 3:
                    view.searchInformationByName();
                    break;
                case 4:
                    view.sortInformationByAscendingOrder();
                    break;
                case 5:
                    view.displayMessage("Exiting program.");
                    System.exit(0);
                    break;
                default:
                    view.displayMessage("Invalid option. Please try again.");
            }
        }
    }

}
