package com.frontlineed.teambitwise.activities.activitymodules.LambdaExpressionDemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

/**
 * Created by rconroy on 5/9/2017.
 */
public class CollectionFilter {
    public static <T> Collection<T> filterCollection(Predicate<T> thePredicate, Collection<T> theItems)
    {
        Collection<T> newCollectionToReturn = new ArrayList<T>();
        for (T theListItem : theItems)
        {
            if (thePredicate.test(theListItem))
            {
                newCollectionToReturn.add(theListItem);
            }
            //If the predicate is not matched, don't do anything with the item
        }

        return newCollectionToReturn;
    }
}
