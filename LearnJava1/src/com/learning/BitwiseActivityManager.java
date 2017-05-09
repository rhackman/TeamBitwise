package com.learning;

import com.learning.activities.*;
import com.learning.activities.ReadAlphabetFile.*;
import com.learning.activities.LambdaExpressionDemo.*;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

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
                    IActivity bitwiseAnd = new BitwiseAndActivity();
                    bitwiseAnd.run();
                    break;
                case GOJOGGING:
                    IActivity goJoggingActivity = new GoJoggingActivity();
                    goJoggingActivity.run();
                    break;
                case TEMPERATURECONVERT:
                    IActivity temperatureConvertActivity = new TemperatureConvertActivity();
                    temperatureConvertActivity.run();
                    break;
                case GETALLACTIVITIES:
                    IActivity GetAllActivitiesActivity = new GetAllActivitiesActivity();
                    GetAllActivitiesActivity.run();
                    break;
                case TICTACTOE:
                    IActivity TicTacToeActivity = new TicTacToeActivity();
                    TicTacToeActivity.run();
                    break;
                case READALPHABETFILE:
                    IActivity ReadAlphabetActivity = new ReadAlphabetFileActivity();
                    ReadAlphabetActivity.run();
                    break;
                case READALPHABETFILEWITHNIO:
                    IActivity ReadAlphabetWithNIOActivity = new ReadAlphabetFileWithNIOActivity();
                    ReadAlphabetWithNIOActivity.run();
                    break;
                case READALPHABETFILETRYWITHRESOURCES:
                    IActivity ReadAlphabetTryWithResourcesActivity = new ReadAlphabetFileTryWithResourcesActivity();
                    ReadAlphabetTryWithResourcesActivity.run();
                    break;
                case LAMBDAEXPRESSIONDEMO:
                    IActivity LambdaExpressionDemoActivity = new LambdaExpressionActivity();
                    LambdaExpressionDemoActivity.run();
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
        System.out.println("List of Activities:");
        List<ActivityType> activitiesList = new ArrayList<ActivityType>(EnumSet.allOf(ActivityType.class));
        activitiesList.remove(0);
        for(ActivityType value : activitiesList)
        {
            System.out.println(value.name());
        }
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
