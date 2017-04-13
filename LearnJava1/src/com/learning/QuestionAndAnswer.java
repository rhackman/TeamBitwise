package com.learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Robert on 4/12/2017.
 */
public class QuestionAndAnswer<T>
{
    private String questionText = "";
    private String userInput = "";
    private T userAnswer = null;
    private T correctAnswer = null;

    public QuestionAndAnswer() {}

    public QuestionAndAnswer(T correctAnswer)
    {
        this.correctAnswer = correctAnswer;
    }

    public QuestionAndAnswer(String questionText)
    {
        this.questionText = questionText;
    }

    public QuestionAndAnswer(T correctAnswer, String questionText)
    {
        this.correctAnswer = correctAnswer;
        this.questionText = questionText;
    }

    public void ask()
    {
        ask(questionText);
    }

    public void ask(String s)
    {
        this.questionText = s;
        System.out.println(s);
    }

    public void getUserInput()
    {
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            userInput = br.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public <U extends Enum<U>> U parseUserInput(Class<U> enumType)
    {
        U returnValue;

        try
        {
            returnValue = U.valueOf(enumType, userInput.toUpperCase());
        }
        catch(Exception e)
        {
            returnValue = null;
        }

        userAnswer = (T) returnValue;
        return returnValue;
    }

    public Boolean userAnsweredCorrectly()
    {
        Boolean returnBool = true;

        if(!userAnswer.equals(correctAnswer) && correctAnswer != null)
            returnBool = false;

        return returnBool;
    }
}
