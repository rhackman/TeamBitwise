package com.frontlineed.teambitwise.activities.activitymodules.DefaultInterfaceDemo;

import com.frontlineed.teambitwise.activities.IActivity;

/**
 * Created by rconroy on 6/14/2017.
 */
public class DefaultInterfaceActivity implements IActivity {
    public String title = "Default Interface Demo";
    public String description = "Demonstrate the use of Default Interface declarations - please view source code";

    @Override
    public void run()
    {
        System.out.println(description);
        System.out.println("Default methods are declared in Interfaces to avoid having to disrupt all implementations");
        NormalCar chevyCamaro = new NormalCar();
        RaceCarNoStereo mclarenP1 = new RaceCarNoStereo();
        System.out.println("Should print 102.3, as we have provided an implementation:");
        chevyCamaro.turnOnStereo();
        System.out.println("Should print 99.1, as we did not provide an implementation, default gets used:");
        mclarenP1.turnOnStereo();
    }
}
