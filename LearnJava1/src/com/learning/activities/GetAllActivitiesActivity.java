package com.learning.activities;

import com.learning.IActivity;
import org.reflections.Reflections;

import java.util.Set;

/**
 * Created by rconroy on 4/13/2017.
 * Wanted to grab a package from Maven, and use it in some fashion
 * org.Reflections library was retrieved with Maven
 */
public class GetAllActivitiesActivity implements IActivity {
    public String title = "Get Classes that implement IActivity";
    public String description = "Printing all classes that implement the interface IActivity, using the org.reflections library imported from Maven";

    @Override
    public void run()
    {
        System.out.println(description);
        Reflections reflections = new Reflections("com.learning");
        Set<Class<? extends IActivity>> classesThatImplementIActivity = reflections.getSubTypesOf(IActivity.class);
        for (Class theActivityClass : classesThatImplementIActivity)
        {
            System.out.println("Full Name: " + theActivityClass.getName() + " Friendly Name: " + theActivityClass.getSimpleName());
        }
    }
}
