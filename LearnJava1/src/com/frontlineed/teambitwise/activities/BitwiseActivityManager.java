package com.frontlineed.teambitwise.activities;

import com.frontlineed.teambitwise.activities.activitymodules.AnnotationDemo.CustomAnnotationDemo;
import com.frontlineed.teambitwise.activities.activitymodules.BitwiseAnd.BitwiseAndActivity;
import com.frontlineed.teambitwise.activities.activitymodules.DefaultInterfaceDemo.DefaultInterfaceActivity;
import com.frontlineed.teambitwise.activities.activitymodules.GetAllActivities.GetAllActivitiesActivity;
import com.frontlineed.teambitwise.activities.activitymodules.GetOrganized.GetOrganizedActivity;
import com.frontlineed.teambitwise.activities.activitymodules.GoJogging.GoJoggingActivity;
import com.frontlineed.teambitwise.activities.activitymodules.Java8StreamDemo.Java8StreamDemo;
import com.frontlineed.teambitwise.activities.activitymodules.LambdaExpressionDemo.LambdaExpressionActivity;
import com.frontlineed.teambitwise.activities.activitymodules.ReadAlphabetFile.ReadAlphabetFileActivity;
import com.frontlineed.teambitwise.activities.activitymodules.ReadAlphabetFile.ReadAlphabetFileTryWithResourcesActivity;
import com.frontlineed.teambitwise.activities.activitymodules.ReadAlphabetFile.ReadAlphabetFileWithNIOActivity;
import com.frontlineed.teambitwise.activities.activitymodules.TemperatureConvert.TemperatureConvertActivity;
import com.frontlineed.teambitwise.activities.activitymodules.ThreadingDemo.ConcurrencyFixActivity;
import com.frontlineed.teambitwise.activities.activitymodules.ThreadingDemo.ConcurrencyIssueActivity;
import com.frontlineed.teambitwise.activities.activitymodules.ThreadingDemo.DirectThreadingActivity;
import com.frontlineed.teambitwise.activities.activitymodules.ThreadingDemo.ThreadingWithThreadPoolActivity;
import com.frontlineed.teambitwise.activities.activitymodules.TicTacToe.TicTacToeActivity;
import com.frontlineed.teambitwise.activities.activitymodules.AnimalRace.AnimalRaceActivity;

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
                    IActivity animalRace = new AnimalRaceActivity();
                    animalRace.run();
//                    System.out.println(noActivityYet);
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
                case GETORGANIZED:
                    IActivity GetOrganizedActivity = new GetOrganizedActivity();
                    GetOrganizedActivity.run();
                    break;
                case DIRECTTHREADING:
                    IActivity DirectThreadingActivity = new DirectThreadingActivity();
                    DirectThreadingActivity.run();
                    break;
                case THREADINGWITHTHREADPOOL:
                    IActivity ThreadingWithThreadPoolActivity = new ThreadingWithThreadPoolActivity();
                    ThreadingWithThreadPoolActivity.run();
                    break;
                case CONCURRENCYISSUE:
                    IActivity ConcurrencyIssueActivity = new ConcurrencyIssueActivity();
                    ConcurrencyIssueActivity.run();
                    break;
                case CONCURRENCYFIX:
                    IActivity ConcurrencyFixActivity = new ConcurrencyFixActivity();
                    ConcurrencyFixActivity.run();
                    break;
                case CUSTOMANNOTATIONDEMO:
                    IActivity CustomAnnotationDemoActivity = new CustomAnnotationDemo();
                    CustomAnnotationDemoActivity.run();
                    break;
                case DEFAULTINTERFACEDEMO:
                    IActivity DefaultInterfaceActivity = new DefaultInterfaceActivity();
                    DefaultInterfaceActivity.run();
                    break;
                case JAVA8STREAMDEMO:
                    IActivity Java8StreamDemo = new Java8StreamDemo();
                    Java8StreamDemo.run();
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
