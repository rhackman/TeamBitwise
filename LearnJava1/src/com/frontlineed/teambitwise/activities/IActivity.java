package com.frontlineed.teambitwise.activities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 4/12/2017.
 */
public interface IActivity
{
    public String title = "";
    public String description = "";
    public List<QuestionAndAnswer> questionList = new ArrayList<QuestionAndAnswer>();
    public Integer score = 0;

    public default void run()
    {
        System.out.println("'" + title + "' Activity is starting...");
    }
}
