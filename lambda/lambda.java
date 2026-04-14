package lambda;


import lambda.interfaceClass.NumberProcessor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class MyUtils{
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}

public class lambda {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(11, 22, 33, 44, 55, 66);

        List<Integer> evenNumbers = numbers.stream().filter(
                (a)->MyUtils.isEven(a)
        ).collect(Collectors.toList());

        System.out.println(evenNumbers);


        List<String> words = Arrays.asList("hello", "world", "java");
        // Your code here: Convert words to uppercase using String::toUpperCase
        List<String> upperCaseWords = words.stream().map(
                String::toUpperCase
//                (s)-> s.toUpperCase()
        ).collect(Collectors.toList()); // Replace null with your solution
        System.out.println("Uppercase words: " + upperCaseWords);

    }


}
