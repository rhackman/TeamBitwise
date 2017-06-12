package com.frontlineed.teambitwise.activities.activitymodules.AnnotationDemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by rconroy on 5/25/2017.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MessageToDisplayCustomAnnotation
{
    String theMessage();
}
