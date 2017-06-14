package com.frontlineed.teambitwise.activities.activitymodules.DefaultInterfaceDemo;

/**
 * Created by rconroy on 6/14/2017.
 */
public interface IVehicle {
    public String honkHorn();
    public default void turnOnStereo(){
        System.out.println("Channel 99.1 FM");
    };
}
