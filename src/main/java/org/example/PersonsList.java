package org.example;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class PersonsList {
    public static List<Person> listOfPerson = new ArrayList<>();

    public Person findByName(String name) {
        String[] nameParts = name.split(" ");

        if (nameParts.length != 2) {
            throw new IllegalArgumentException("Name should be in the \"firstName lastName\" format");
        }
        for (Person person : listOfPerson) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        throw new IllegalArgumentException("Person with name '" + name + "' not found");
    }


    public Person clone(Person person) throws Exception {
        int random = (int) (Math.random()*1000 - 1) + 1;
        while (random == person.getId()){
            random = (int) Math.random();
        }
        Person newPerson = new Person(random,person.getName(), person.getAge(), person.getOccupation());
        return newPerson;
    }

    public void writeToFile(Person person) {
        try {
            FileWriter myWriter = new FileWriter("Person Information.txt",true);
            myWriter.write(person.toString()+"\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file");
        } catch (Exception e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}
