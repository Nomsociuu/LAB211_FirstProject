package Model;

import java.util.Scanner;

public class Model {
    private static int lastId = 0;

    private int id;
    private String name;
    private String group;
    private String address;
    private String phone;
    private String lastName;
    private String firstName;

    public Model() {}
    public Model(String name, String group, String address, String phone) {
        this.id = ++lastId;
        this.name = name;
        this.group = group;
        this.address = address;
        this.phone = phone;
        setNames();
    }

    private void setNames() {
        String[] names = name.split(" ");
        if (names.length >= 2) {
            lastName = names[names.length - 1];
            firstName = names[0];
        } else {
            lastName = "";
            firstName = name;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    

    @Override
    public String toString() {
        return String.format("%-4d%-20s%-15s%-15s%-10s%-15s%-15s", id, name, firstName, lastName, group, address, phone);
    }
}
