package Model;

import View.Menu;

public class Person {

    private String name;
    private String address;
    private double salary;

    public Person[] person = new Person[3];

    public Person(String name, String address, double salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Person[] getPerson() {
        return person;
    }

    public void setPerson(Person[] person) {
        this.person = person;
    }

    public Person inputPersonInfo(String name, String address, String salary) {
        double newSalary = 0.0;
        try {
            if (salary.isEmpty()) {
                System.out.println("You must input Salary.");
                return null;
            }
            newSalary = Double.parseDouble(salary);
            if (newSalary <= 0) {
                System.out.println("Salary must be a positive number.");
                return null;
            }
        } catch (NumberFormatException e) {
            System.out.println("You must input digidt.");
            return null;
        }
        return new Person(name, address, newSalary);
    }

    public void displayPersonInfo(Menu view, Person person) {
        view.displayPersonInfo(person);
    }

    public Person[] sortBySalary(Person[] persons) throws Exception {
        if (persons == null || persons.length == 0) {
            throw new Exception("Can't Sort Person");
        }

        int n = persons.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (persons[i - 1].getSalary() > persons[i].getSalary()) {

                    Person temp = persons[i - 1];
                    persons[i - 1] = persons[i];
                    persons[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);

        return persons;
    }
}
