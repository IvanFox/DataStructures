package dataStructures.trees.binary.object;

/**
 * Created by IvanLis on 13/11/15.
 * Student No: c00185055
 * All rights reserved
 */
public class Person {

    private String name;
    private String company;
    private String position;


    public Person(String name, String company, String position) {
        this.name = name;
        this.company = company;
        this.position = position;
    }


    @Override
    public String toString() {
        return "Name: " + name + "\nCompany: " + company + "\nPosition: " + position + "\n";
    }
}
