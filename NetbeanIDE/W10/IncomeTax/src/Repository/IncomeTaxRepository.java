
package Repository;

import View.TaxView;
import java.util.List;
import model.Children;
import model.Parent;
import model.Person;

public class IncomeTaxRepository implements IIncomeTaxRepository {
    TaxView view = new TaxView();
    @Override
    public void inputData(Person person, List<Children> childrens, List<Parent> parents) {
        view.inputData(childrens, parents);
    }

    @Override
    public void detailOfDeduction(List<Children> childrens, List<Parent> parents) {
        view.detailOfDeduction(childrens, parents);
    }

}
