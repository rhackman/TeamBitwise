package com.frontlineed.teambitwise.activities.activitymodules.TemperatureConvert;

import com.frontlineed.teambitwise.activities.CommonUtilities;
import com.frontlineed.teambitwise.activities.IActivity;

/**
 * Created by rconroy on 4/13/2017.
 */
public class TemperatureConvertActivity implements IActivity {
    public String title = "Temperature Converter";
    public String description = "Convert to Celcius/Fahrenheit";

    @Override
    public void run()
    {
        System.out.println(description);
        String temperatureScale = CommonUtilities.GetUserInput("What scale will you use? (C/F)").toUpperCase();
        String temperature = CommonUtilities.GetUserInput("Enter temperature (" + temperatureScale + ")");
        if (temperatureScale.equals("F"))
        {
            System.out.println(((Double.parseDouble(temperature) - 32) * 5) / 9);
        }
        else if (temperatureScale.equals("C"))
        {
            System.out.println(9 * (Double.parseDouble(temperature) / 5) + 32);
        }
        else
        {
            System.out.println("You did not enter a valid temperature scale");
        }
    }
}
