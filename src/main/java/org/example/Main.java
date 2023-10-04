package org.example;

import java.io.FileWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        Person person1 = new Person(4,"Arijj Qadah",50,"Student");
        Person person2 = new Person(7,"Sara Ali",40,"Doctor");
        Person person3 = new Person(9,"Omar Mosa",30,"Engineer");
        Person person4 = new Person(9,"Jack Jack",3,"Engineer");

        try {
            person4.setAge(-1);
        } catch (Exception e) {
            System.out.println("Exception "+ e.getMessage());
        }

        PersonsList.listOfPerson.add(person1);
        PersonsList.listOfPerson.add(person2);
        PersonsList.listOfPerson.add(person3);

        PersonsList list = new PersonsList();

        try {
            list.findByName("Arijj yousef");
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException "+ e.getMessage());
        }

        Person newPerson1 = list.clone(person1);
        System.out.println((newPerson1).toString());
        Person newPerson2 = list.clone(person2);
        System.out.println((newPerson2).toString());

        list.writeToFile(person1);
        list.writeToFile(person2);
        list.writeToFile(person3);

    }
}