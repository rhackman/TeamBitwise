package com.learning.activities;

import com.learning.CommonUtilities;
import com.learning.IActivity;

import java.util.Random;

/**
 * Created by rconroy on 4/13/2017.
 */
public class GoJoggingActivity implements IActivity {
    public String title = "Guess The Number";
    public String description = "I'm thinking of a number between 1 & 100... 1 Lap around the office per wrong guess! (evil laugh ensues)";

    @Override
    public void run()
    {
        int winningNumber = CommonUtilities.GenerateRandomNumber(1, 100);
        int numberOfTries = 0;
        System.out.println("Guess The Number Activity Loaded Successfully");
        System.out.println(description);
        int userGuess = Integer.parseInt(CommonUtilities.GetUserInput("Please input your guess:"));
        while (userGuess != winningNumber)
        {
            numberOfTries++;
            String higherOrLower = (userGuess < winningNumber) ? "Higher" : "Lower";
            System.out.println("Nope... the winning number is " + higherOrLower + " than your guess of " + userGuess);
            userGuess = Integer.parseInt(CommonUtilities.GetUserInput("Please guess again:"));
        }
        numberOfTries++;
        System.out.println("You got it! Go jog " + numberOfTries + " laps around the office!");
        System.out.println("Guess The Number Activity Complete!");
    }
}