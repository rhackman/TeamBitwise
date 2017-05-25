package com.frontlineed.teambitwise.activities.activitymodules.AnnotationDemo;

import com.frontlineed.teambitwise.activities.IActivity;

/**
 * Created by rconroy on 5/25/2017.
 */
public class CustomAnnotationDemo implements IActivity {
    public String title = "Custom Annotation Demo";
    public String description = "Demonstrate the use of a custom annotation - please view source code";

    @Override
    public void run()
    {
        System.out.println(description);
        System.out.println("The string value on the class is:");
        //To access the annotation value on the CustomAnnotationDemoWorker, we use reflection to fetch it
        MessageToDisplayCustomAnnotation theAnnotation = CustomAnnotationDemoWorker.class.getAnnotation(MessageToDisplayCustomAnnotation.class);
        System.out.println(theAnnotation.theMessage());
    }
}
