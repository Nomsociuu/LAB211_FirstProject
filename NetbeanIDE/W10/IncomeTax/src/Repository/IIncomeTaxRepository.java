
package Repository;

import java.util.List;
import model.Children;
import model.Parent;
import model.Person;

public interface IIncomeTaxRepository {
    void detailOfDeduction(List<Children> childrens, List<Parent> parents);

    void inputData(Person person, List<Children> childrens, List<Parent> parents);
    
}
