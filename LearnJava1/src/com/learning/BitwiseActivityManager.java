package com.learning;

import com.learning.activities.BitwiseAndActivity;

/**
 * Created by Robert on 4/12/2017.
 */
public class BitwiseActivityManager
{

    public void StartProgram()
    {
        String noActivityYet = "This activity is not available yet.";
        String unknownActivity = "This activity does not exist.";

        showWelcome();

        ActivityType nextActivity = whatActivityNext();

        while (nextActivity != ActivityType.EXIT)
        {
            switch (nextActivity)
            {
                case ANIMALRACE:
                    System.out.println(noActivityYet);
                    break;
                case BITWISE_AND:
                    IActivity bitwiseOr = new BitwiseAndActivity();
                    bitwiseOr.run();
                    break;
                case UNKNOWN:
                    System.out.println(unknownActivity);
                    break;
                default:
                    break;
            }

            nextActivity = whatActivityNext();
        }

        showFarewell();
        return;
    }

    private ActivityType whatActivityNext()
    {
        QuestionAndAnswer<String> whatNext = new QuestionAndAnswer<>();
        whatNext.ask("What activity would you like to do next?");
        whatNext.getUserInput();
        ActivityType userActivity = whatNext.parseUserInput(ActivityType.class);
        if(userActivity == null) userActivity = ActivityType.UNKNOWN;

        return userActivity;
    }

    private void showWelcome()
    {
        System.out.println("---------------------------------------");
        System.out.println("Welcome to the Bitwise Activity Center!");
        System.out.println("---------------------------------------");
    }

    private void showFarewell()
    {
        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println("Farewell from the Bitwise Activity Center!");
        System.out.println("------------------------------------------");
    }
}
