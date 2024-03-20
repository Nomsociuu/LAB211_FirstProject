package DAO;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.Children;
import model.Parent;
import model.Person;

public class IncomeTaxDao {

    public int deductionForChildrens(List<Children> childrens) {
        for (Children children : childrens) {
            if (children.getAge() <= 18) {
                children.setDeduction(4400000);
            } else if (children.getAge() > 18 && children.getIsStudying() == 1) {
                children.setDeduction(6000000);
            } else if (children.getAge() > 18 && children.getIsStudying() == 0 || children.getAge() > 22) {
                children.setDeduction(0);
            }
        }
        //If there are more than 2 children, the deduction will be applied to the 2 children with the highest deduction amount.
        Collections.sort(childrens, Comparator.comparingInt(Children::getDeduction).reversed());

        int deduction = 0;
        for (int i = 0; i < Math.min(2, childrens.size()); i++) {
            deduction += childrens.get(i).getDeduction();
        }

        return deduction;
    }

    public int deductionForParents(Person person, List<Parent> parents, int numSib) {
        int deduction = 0;
        int totalSon = numSib + 1;

        for (Parent parent : parents) {
            if ((parent.getSex() == 1 && parent.getAge() >= 60)
                    || (parent.getSex() == 0 && parent.getAge() >= 55)) {
                parent.setDeduction(4400000);
                deduction = deduction + parent.getDeduction();
            }
        }
        return deduction / totalSon;
    }

    public int deductionTotal(int deduction_for_children, int deduction_for_parents) {
        int deduction = 11000000 + deduction_for_children + deduction_for_parents;
        return deduction;
    }

    public double calculateIncomeTax(double income, int deduction) {
        double incomeTax = income - deduction;
        if (incomeTax <= 0) {
            return 0;
        }
        return incomeTax;
    }

    public double calculatePaid(double income, int deduction) {
        double taxIncome = (income - deduction) / 1000000;
        double amoutPaid = 0;

        if (income <= 11000000) {
            amoutPaid = 0;
        } else {
            while (taxIncome > 0) {
                if (taxIncome > 10) {
                    amoutPaid += 0.2 * (taxIncome - 10);
                    taxIncome = 10;
                }

                if (taxIncome > 6 && taxIncome <= 10) {
                    amoutPaid += 0.1 * (taxIncome - 6);
                    taxIncome = 6;
                }

                if (taxIncome > 4 && taxIncome <= 6) {
                    amoutPaid += 0.05 * (taxIncome - 4);
                    taxIncome = 4;
                }

                if (taxIncome <= 4) {
                    amoutPaid += 0.02 * taxIncome;
                    taxIncome = 0;
                }

            }
        }
        return amoutPaid*1000000;
    }
}


