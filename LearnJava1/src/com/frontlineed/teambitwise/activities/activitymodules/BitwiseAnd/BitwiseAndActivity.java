package com.frontlineed.teambitwise.activities.activitymodules.BitwiseAnd;

import com.frontlineed.teambitwise.activities.YesNoType;
import com.frontlineed.teambitwise.activities.IActivity;
import com.frontlineed.teambitwise.activities.QuestionAndAnswer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 4/13/2017.
 */
public class BitwiseAndActivity implements IActivity
{
    public String title = "Bitwise And";
    public String description = "Guess the result of the Bitwise And operation(s) below.";
    public List<QuestionAndAnswer> questionList = new ArrayList<QuestionAndAnswer>();
    public Integer score = 0;

    @Override
    public void run()
    {
        System.out.println("'" + title + "' Activity is starting...");

        QuestionAndAnswer<YesNoType> q1 = new QuestionAndAnswer<>(YesNoType.YES,"Is 2 & 3 == 2?");
        q1.ask();
        q1.getUserInput();
        q1.parseUserInput(YesNoType.class);

        if(q1.userAnsweredCorrectly())
        {
            System.out.println("Correct! Good job");
        }
        else
        {
            System.out.println("Sorry! Incorrect");
        }

        System.out.println("'" + title + "' Activity is ending...");
    }
}
