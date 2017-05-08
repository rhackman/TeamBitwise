package com.learning.activities;

import com.learning.IActivity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by rconroy on 5/8/2017.
 * This activity expands the idea that was captured in the ReadAlphabetFileActivity class
 * We will be performing the same operations, except we will use the try-with-resouces language construct to automatically clean up the BufferedReader
 */
public class ReadAlphabetFileTryWithResourcesActivity implements IActivity {
    public String title = "Read from file";
    public String description = "This activity reads the alphabet.txt file with try-with-resources construct.";

    @Override
    public void run()
    {
        System.out.println(description);
        System.out.println("Contents of file alphabet.txt:");
        try
        {
            ReadAlphabetFileTryWithResources();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private void ReadAlphabetFileTryWithResources() throws IOException
    {
        //Notice that the BufferedReader instance creation is INSIDE the parenthesis of the try declaration
        try (BufferedReader buffer = new BufferedReader(new FileReader("LearnJava1\\src\\com\\learning\\alphabet.txt")))
        {
            //Now the buffer variable is accessable going forward
            //***NO NEED FOR A FINALLY BLOCK WITH A CALL TO close() METHOD
            //THIS LANGUAGE CONSTRUCT AUTOMATICALLY CALLS close()
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
    }
}
