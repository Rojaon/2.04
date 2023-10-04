package org.example;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class PersonsListTest {
    Person person1 = new Person(4,"Arijj Qadah",50,"Student");
    PersonsList list = new PersonsList();

    PersonsListTest() throws Exception {
    }


    @Test
    public void setAge_ageLessThanZero_Exception() throws Exception {
        assertThrows(Exception.class, () -> person1.setAge(-2));
    }

    @Test
    public void findByName_correctProperlyFormattedName(){
        PersonsList.listOfPerson.add(person1);
        Person person = list.findByName("Arijj Qadah");
        assertEquals(person1, person);
    }

    @Test
    public void findByName_throwsExceptionNotProperlyFormattedName_Exception(){
        assertThrows(IllegalArgumentException.class, () -> list.findByName("Arijj"));

    }

    @Test
    public void clone_correctNewPersonWithSameProperties() throws Exception {
        Person newPerson = list.clone(person1);
        boolean isCorrect = person1.getId() != newPerson.getId() && person1.getAge() == newPerson.getAge() && Objects.equals(person1.getName(), newPerson.getName()) && Objects.equals(person1.getOccupation(), newPerson.getOccupation());
        assertEquals(true, isCorrect);
    }
}