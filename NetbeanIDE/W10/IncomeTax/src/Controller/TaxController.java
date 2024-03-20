
package Controller;

import Repository.IncomeTaxRepository;
import View.Menu;
import java.util.ArrayList;
import java.util.List;
import model.Children;
import model.Parent;
import model.Person;


public class TaxController extends Menu {
    Person person;
    List<Children> childrens;
    List<Parent> parents;
    IncomeTaxRepository repo;

    public TaxController () {
        super("========Income Tax Program=========", new String[]{"Input data", "Print detail Of Deduction", "Exit"});
        person =  new Person();
        childrens = new ArrayList<>();
        parents = new ArrayList<>();
        repo = new IncomeTaxRepository();
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                repo.inputData(person, childrens, parents);
                break;
            case 2:
                repo.detailOfDeduction(childrens, parents);
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
    
}

