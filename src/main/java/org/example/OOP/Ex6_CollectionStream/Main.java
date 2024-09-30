package org.example.OOP.Ex6_CollectionStream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("John", 25));
        people.add(new Person("Jane", 22));
        people.add(new Person("Adam", 30));


        Comparator<Person> ageComparator = Comparator.comparingInt(Person::getAge);


        List<Person> sortedPeople = people.stream()
                .sorted(ageComparator)
                .collect(Collectors.toList());


        sortedPeople.stream()
                .filter(person -> person.getAge() > 23)
                .forEach(System.out::println);
    }
}