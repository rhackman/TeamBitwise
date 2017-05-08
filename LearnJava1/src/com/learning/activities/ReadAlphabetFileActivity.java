package com.learning.activities;

import com.learning.IActivity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by rconroy on 5/8/2017.
 * This activity just outlines the basic operation of opening up a file with a BufferedReader
 * This idea will be extended in later activities where I'll be using the try-with-resources language construct to automatically close the BufferedReader object
 */
public class ReadAlphabetFileActivity implements IActivity {
    public String title = "Read from file";
    public String description = "This activity reads the alphabet.txt file.";

    @Override
    public void run()
    {
        System.out.println(description);
        System.out.println("Contents of file alphabet.txt:");
        try
        {
            ReadAlphabetFile();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private void ReadAlphabetFile() throws IOException
    {
        BufferedReader buffer = new BufferedReader(new FileReader("LearnJava1\\src\\com\\learning\\alphabet.txt"));
        try
        {
            String bufferData;
            while((bufferData = buffer.readLine()) != null)
            {
                System.out.println(bufferData);
            }
        }
        catch (IOException e)
        {
            System.out.println(String.format("Error in class: %s | The error is: %s", e.getClass().getSimpleName(), e.getMessage()));
        }
        finally
        {
            buffer.close();
        }
    }
}
