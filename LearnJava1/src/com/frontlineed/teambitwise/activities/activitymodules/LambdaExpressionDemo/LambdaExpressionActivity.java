package com.frontlineed.teambitwise.activities.activitymodules.LambdaExpressionDemo;

import com.frontlineed.teambitwise.activities.IActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by rconroy on 5/9/2017.
 */
public class LambdaExpressionActivity implements IActivity {
    public String title = "Lambda Expression Demo";
    public String description = "This activity demonstrates lambda expressions introduced with Java 8.";

    @Override
    public void run()
    {
        System.out.println(description);
        ArrayList<MyCollectionClass> theCollection = new ArrayList<>();
        theCollection.add(new MyCollectionClass("Test", "123"));
        theCollection.add(new MyCollectionClass("Ron", "Conroy"));
        theCollection.add(new MyCollectionClass("Merrick Road", "Rockville Centre"));
        theCollection.add(new MyCollectionClass("Test", "456"));

        System.out.println("Demonstration of forEach with lambda expression to print out all of the keys & values in the collection");
        theCollection.forEach(coll -> System.out.println(String.format("Key: %s | Value: %s", coll.getKey(), coll.getValue())));

        System.out.println("Demonstration of filtering out the collection with a lambda expression filtering the collection for key = 'Test'");
        Collection<MyCollectionClass> filteredCollection = CollectionFilter.filterCollection(coll -> coll.getKey().equals("Test"), theCollection);
        filteredCollection.forEach(coll -> System.out.println(String.format("Key: %s | Value: %s", coll.getKey(), coll.getValue())));

        System.out.println("Demonstration of removeIf with lambda expression to remove all instances where the key is 'Test'");
        theCollection.removeIf(coll -> coll.getKey().equals("Test"));
        theCollection.forEach(coll -> System.out.println(String.format("Key: %s | Value: %s", coll.getKey(), coll.getValue())));

        System.out.println("Demonstration of method reference & chaining consumers");
        List<String> theList = Arrays.asList("First", "Second", "Third", "Fourth");
        List<String> newList = new ArrayList<>();
        //forEach takes a Consumer, so let's create two with method references:
        //Regular lambda:
        Consumer<String> consumer1 = c -> System.out.println(c);
        //Method reference:
        Consumer<String> consumer1methodref = System.out::println;

        //Regular lambda:
        Consumer<String> consumer2 = c -> newList.add(c);
        //Method reference:
        Consumer<String> consumer2methodref = newList::add;
        theList.forEach(consumer1methodref.andThen(consumer2methodref));
        newList.forEach(System.out::println);
    }
}
