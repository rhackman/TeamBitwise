package com.learning.activities;

import com.learning.IActivity;

/**
 * Created by rconroy on 5/8/2017.
 */
public class ReadAlphabetFileActivity implements IActivity {
    public String title = "Read from file";
    public String description = "This activity reads the alphabet.txt file.";

    @Override
    public void run()
    {
        System.out.println(description);
    }
}
