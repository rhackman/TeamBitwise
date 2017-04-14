package com.learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by rconroy on 4/13/2017.
 */
public class CommonUtilities {
    public static String GetUserInput(String messageToAskUser)
    {
        try
        {
            System.out.println(messageToAskUser);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return br.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return "There was a problem reading the user's input.";
        }
    }

    public static int GenerateRandomNumber(int minimum, int maximum)
    {
        Random rand = new Random();
        return rand.nextInt((maximum - minimum) + 1) + 1;
    }
}
