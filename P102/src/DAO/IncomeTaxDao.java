package DAO;

import java.util.Collections;
import java.util.List;
import model.Children;
import model.Parent;
import model.Person;

public class IncomeTaxDao {
    
    public int deductionForChildrens(List<Children> childrens) {
        int deduction = 0;
        for (Children children : childrens) {
            if (children.getAge() <= 18) {
                children.setDeduction(4400000);
            } else if (children.getAge() > 18 && children.getAge() <= 22 && children.getIsStudying() == 1) {
                children.setDeduction(6000000);
            } else {
                children.setDeduction(0);
            }
        }
        int count = 0;
        Collections.reverse(childrens);
        for (Children children : childrens) {
            deduction = deduction + children.getDeduction();
            count++;
            if (count >= 2) {
                break;
            }
        }
        return deduction;
    }
     public int deductionForParents (Person person, List<Parent> parents){
        int deduction = 0;
        if (person.getHasSiblingRegister() == 1){
            for (Parent parent : parents){
                if((parent.getSex() == 1 && parent.getAge() >= 60) ||
                        (parent.getSex() == 0 && parent.getAge() >= 55)){
                    parent.setDeduction(4400000);
                    deduction = deduction + parent.getDeduction();
                }
            }
        }
        return deduction;
    }
    
    public int deductionTotal(int deduction_for_children,int deduction_for_parents){
        int deduction = 11000000 + deduction_for_children + deduction_for_parents;
        return deduction;
    }
    
    public int calculateTaxRate(double income,int deduction){
        int taxRate;
        double taxableIncome = income - deduction;
        if (taxableIncome < 4000000){
            taxRate = 5;
        }
        else if (deduction >= 4000000 && deduction < 6000000){
            taxRate = 8;
        }
        else if (deduction >= 6000000 && deduction < 10000000){
            taxRate = 10;
        }
        else {
            taxRate = 20;
        }
        return taxRate;
    }
    
    public double calculateIncomeTax(double income,int deduction, int taxRate){
        double incomeTax = income - deduction;
        if (incomeTax <=0){
            incomeTax = 0;
        }
        incomeTax = incomeTax * 100 / taxRate;
        return incomeTax;
    }
}
