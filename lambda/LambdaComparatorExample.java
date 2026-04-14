package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Person {
    String name;
    int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class LambdaComparatorExample {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));
        people.add(new Person("David", 25));
        System.out.println("Original list: " + people);
        // Sorting by age using a lambda expression
        // The Comparator interface is a functional interface with a single abstract method compare(T o1, T o2)
        Collections.sort(people, (p1, p2) -> p1.age - p2.age);
        System.out.println("Sorted by age: " + people);
        // Sorting by name using a lambda expression
        Collections.sort(people, (p1, p2) -> p1.name.compareTo(p2.name));
        System.out.println("Sorted by name: " + people);
    }
}

