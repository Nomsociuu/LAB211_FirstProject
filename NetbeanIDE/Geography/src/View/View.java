
package View;

import Model.EastAsiaCountries;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class View {

    private Scanner scanner = new Scanner(System.in);
    private List<EastAsiaCountries> countriesList = new ArrayList<>();


    public int getMenuOption() {
        System.out.println("MENU");
        System.out.println("==========================================================================");
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries sorted by name in ascending order");
        System.out.println("5. Exit");
        System.out.println("==========================================================================");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public EastAsiaCountries getCountryInformation() {
        System.out.println("Enter information for a country:");
        System.out.print("Country Code: ");
        String code = scanner.next();
        System.out.print("Country Name: ");
        String name = scanner.next();
        System.out.print("Total Area: ");
        float area = scanner.nextFloat();
        System.out.print("Terrain: ");
        String terrain = scanner.next();

        return new EastAsiaCountries(code, name, area, terrain);
    }

    public String getSearchName() {
        System.out.print("Enter the country name to search: ");
        return scanner.next();
    }

    public void displayCountryInformation(List<EastAsiaCountries> countries) {
        System.out.printf("%-15s %-15s %-15s %-15s%n", "ID", "Name", "Total Area", "Terrain");
        for (EastAsiaCountries country : countries) {
            System.out.println(country);
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
    
    public void addCountryInformation() {
        try {
            EastAsiaCountries country = getCountryInformation();
            countriesList.add(country);
            displayMessage("Country information added successfully.");
        } catch (Exception e) {
            displayMessage("Invalid input. Please try again.");
            // Consume the remaining newline character
            displayMessage("Invalid input. Please try again.");
        }
    }

    public void displayRecentlyEnteredInformation() {
        try {
            EastAsiaCountries recentCountry = getRecentlyEnteredInformation();
            displayMessage("Recently Entered Country Information:");
            displayCountryInformation(Arrays.asList(recentCountry));
        } catch (Exception e) {
            displayMessage("No recently entered information.");
        }
    }

    private EastAsiaCountries getRecentlyEnteredInformation() throws Exception {
        if (countriesList.isEmpty()) {
            throw new Exception("No recently entered information.");
        }
        return countriesList.get(countriesList.size() - 1);
    }

    public void searchInformationByName() {
        try {
            String searchName = getSearchName();
            EastAsiaCountries[] result = searchInformationByName(searchName);
            displayMessage("Search Result:");
            displayCountryInformation(Arrays.asList(result));
        } catch (Exception e) {
            displayMessage("No matching country found.");
        }
    }

    private EastAsiaCountries[] searchInformationByName(String name) throws Exception {
        List<EastAsiaCountries> result = new ArrayList<>();
        for (EastAsiaCountries country : countriesList) {
            if (country.getCountryName().equalsIgnoreCase(name)) {
                result.add(country);
            }
        }
        if (result.isEmpty()) {
            throw new Exception("No matching country found.");
        }
        return result.toArray(new EastAsiaCountries[0]);
    }

    public void sortInformationByAscendingOrder() {
        try {
            EastAsiaCountries[] sortedList = getSortedInformationByAscendingOrder();
            displayMessage("Information Sorted by Country Name (Ascending Order):");
            displayCountryInformation(Arrays.asList(sortedList));
        } catch (Exception e) {
            displayMessage("No information to display.");
        }
    }

    private EastAsiaCountries[] getSortedInformationByAscendingOrder() throws Exception {
        if (countriesList.isEmpty()) {
            throw new Exception("No information to display.");
        }

        List<EastAsiaCountries> sortedList = new ArrayList<>(countriesList);
        Collections.sort(sortedList, Comparator.comparing(EastAsiaCountries::getCountryName));

        return sortedList.toArray(new EastAsiaCountries[0]);
    }
}

