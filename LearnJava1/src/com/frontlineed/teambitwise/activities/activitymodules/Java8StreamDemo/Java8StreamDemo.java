package com.frontlineed.teambitwise.activities.activitymodules.Java8StreamDemo;

import com.frontlineed.teambitwise.activities.IActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by rconroy on 6/14/2017.
 * Streams provide a very optimized way of processing data. Streams can process data in parallel and do the processing
 * in one pass, so it is very fast.
 */
public class Java8StreamDemo implements IActivity {
    public String title = "Java 8 Stream Demo";
    public String description = "This activity demonstrates streams within Java 8 to process data.";

    @Override
    public void run() {
        List<String> theList = Arrays.asList("First", "Second", "Third", "Fourth", "Fifth", "Sixth");
        List<String> newList = new ArrayList<>();
        Predicate<String> predicate1 = p -> p.length() > 5;
        Predicate<String> predicate2 = p -> !p.startsWith("F");

        System.out.println("theList:");
        //I am creating a stream() object directly on theList and not putting it in it's own variable because once
        //the stream has been used to process data, it cannot be used again. So the above pattern of using:
        //theList.stream().... is definitely the way to go as you avoid using it twice my mistake.
        theList.stream().peek(System.out::println)
                        .filter(predicate1.and(predicate2))
                        .forEach(newList::add);
        System.out.println("newList:");
        newList.forEach(System.out::println);

        List<MathStudent> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(Java8StreamDemo.class.getResourceAsStream("mathclassroster.txt")));
             Stream<String> stream = br.lines();)
        {
            stream.map(line -> {
                String[] lineContents = line.split(" ");
                MathStudent student = new MathStudent(lineContents[0], Integer.parseInt(lineContents[1]));
                students.add(student);
                return student;
            })
                    .forEach(System.out::println);

            Map<Integer, List<MathStudent>> theInterestingMap =
                students.stream()
                        .collect(Collectors.groupingBy(MathStudent::getStudentAge));

            System.out.println(theInterestingMap);
        }
        catch(IOException e)
        {
            System.out.println("Error in try, error is:" + e.getMessage());
        }
    }
}
