package com.frontlineed.teambitwise.activities.activitymodules.DefaultInterfaceDemo;

/**
 * Created by rconroy on 6/14/2017.
 */
public class NormalCar implements IVehicle {
    @Override
    public String honkHorn() {
        return "Beep!";
    }

    @Override
    public void turnOnStereo() {
        System.out.println("Channel 102.3 FM");
    }
}
