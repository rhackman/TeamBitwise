package com.frontlineed.teambitwise.activities.activitymodules.AnimalRace;

import com.frontlineed.teambitwise.activities.IActivity;
import com.frontlineed.teambitwise.activities.QuestionAndAnswer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 5/11/2017.
 */
public class AnimalRaceActivity implements IActivity
{
    public String title = "Animal Race";
    public String description = "Multi-threading and inheritance demo";
    public List<QuestionAndAnswer> questionList = new ArrayList<QuestionAndAnswer>();
    public Integer score = 0;

    @Override
    public void run()
    {
        System.out.println("'" + title + "' Activity is starting...");

        int raceDistance = 50; // 100 feet
        int tortoiseRunDistance = 1; // 1 foot per second
        long tortoiseRunTime = 1; // 1 second
        int tortoiseSleepTime = 1; // 1 second
        int hareRunDistance = 5; // 5 feet per second
        long hareRunTime = 1; // 1 second
        int hareSleepTime = 10; // 10 seconds

        long raceSpeed = 200; //milliseconds

        // Start race
        Runnable tortoiseRun = () -> {
            int tortoiseCurrentLocation = 0;
            while(tortoiseCurrentLocation < raceDistance) {
                System.out.println("Tortoise is at location " + tortoiseCurrentLocation);
                tortoiseCurrentLocation = tortoiseCurrentLocation + tortoiseRunDistance;

                try {
                    Thread.sleep(tortoiseRunTime*raceSpeed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Tortoise is at location " + tortoiseCurrentLocation + ". Tortoise is done!");
        };

        Runnable hareRun = () -> {
            int hareCurrentLocation = 0;
            while(hareCurrentLocation < raceDistance) {
                System.out.println("Hare is at location " + hareCurrentLocation);
                hareCurrentLocation = hareCurrentLocation + hareRunDistance;

                try {
                    Thread.sleep(hareRunTime*raceSpeed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Hare is at location " + hareCurrentLocation + ". Hare is done!");
        };

        Thread t1 = new Thread(tortoiseRun);
        Thread t2 = new Thread(hareRun);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("'" + title + "' Activity is ending...");
    }
}
