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

        System.out.println("'" + title + "' Activity is ending...");
    }
}