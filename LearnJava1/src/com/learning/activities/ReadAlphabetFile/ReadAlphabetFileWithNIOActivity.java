package com.learning.activities.ReadAlphabetFile;

import com.learning.IActivity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by rconroy on 5/9/2017.
 */
public class ReadAlphabetFileWithNIOActivity implements IActivity {
    public String title = "Read from file";
    public String description = "This activity reads the alphabet.txt file with method from java.nio.file class.";

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

    public void ReadAlphabetFile() throws IOException
    {
        //The following line opens the file, reads all of the lines from it and populates the String list, and closes it... all in one method call
        List<String> lines = Files.readAllLines(Paths.get("LearnJava1\\src\\com\\learning\\activities\\ReadAlphabetFile\\alphabet.txt"));
        for (String line : lines)
        {
            System.out.println(line);
        }
    }
}
