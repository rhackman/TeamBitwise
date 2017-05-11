package com.learning.activities;

import com.learning.IActivity;
import com.learning.QuestionAndAnswer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 5/11/2017.
 */
public class GetOrganizedActivity implements IActivity
{
    public String title = "Get Organized";
    public String description = "Shabana's First Java App";
    public List<QuestionAndAnswer> questionList = new ArrayList<QuestionAndAnswer>();
    public Integer score = 0;

    @Override
    public void run()
    {
        System.out.println("Hello Get Organized");

        // Write a Java program to print the addition, multiply, subtract, divide and remainder of two numbers//

        int value1 = 10;
        int value2 = 20;
        int value3 = 5;

        //Addition//
        int result1 = value1 + value2;
        System.out.println("Addition : " + result1);

        //Subtraction//
        int result2 = value1 - value2;
        System.out.println("Subtraction : " + result2);

        //Multiplication//
        int result3 = value1 * value2;
        System.out.println("Multiplication : " + result3);

        // Division//
        int result4 = value2 / value1;
        System.out.println("Division : " + result4);

        //Remainder//
        int result5 = (value1 - value2) / value3;
        int result6 = (value2 - value3) % value1;

        System.out.println("Remainder : " + result5);
        System.out.println("Remainder : " + result6);


        //Write a program using relational operators//

        int num1 = 25;
        int num2 = 52;
        int num3 = 7;

        if (num1 == num2)
        {
            System.out.println("Num1 and Num2 are equal");

        }
        if (num1 < num3)

        {
            System.out.println("Num1 is not greater than Num3");

        }
        else
        {
            System.out.println("This is not a good exercise!");
        }

        // A java program to print JAVA!//

        {
            System.out.println("    J    a   v     v    a  ");
            System.out.println("    J   a a   v   v    a a ");
            System.out.println("J   J  aaaaa   v v    aaaaa ");
            System.out.println(" JJ   a      a  v    a      a ");
        }

    }
}
