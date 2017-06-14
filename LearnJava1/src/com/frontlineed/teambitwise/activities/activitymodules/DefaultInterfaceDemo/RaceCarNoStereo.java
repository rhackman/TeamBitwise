package com.frontlineed.teambitwise.activities.activitymodules.DefaultInterfaceDemo;

/**
 * Created by rconroy on 6/14/2017.
 */
public class RaceCarNoStereo implements IVehicle {
    @Override
    public String honkHorn() {
        return "Honk!";
    }

    //Notice, there is no implementation of the turnOnStereo method. This is because the interface is defining
    //the method as default, so we do not have to provide any implementation
}
