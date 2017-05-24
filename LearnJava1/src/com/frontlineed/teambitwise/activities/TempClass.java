package com.frontlineed.teambitwise.activities;

import java.util.*;

/**
 * Created by Robert on 4/12/2017.
 */
public class TempClass
{
    public void runCollectionTest()
    {
        List<Integer> iList = new ArrayList<Integer>();
        iList.add(10);
        iList.add(2);
        iList.add(45);

        for(Integer i : iList)
        {
            System.out.println(i);
        }

        Map<Integer,String> iMap = new HashMap<Integer,String>();
        iMap.put(1,"a");
        iMap.put(2,"b");
        iMap.put(3,"c");
        iMap.put(4,"d");
        iMap.put(5,"e");

        System.out.println(iMap.get(3).toString());

        Set<Integer> iSet = new HashSet<Integer>();
        iSet.add(1);
        iSet.add(2);
        iSet.add(3);
        iSet.add(1);

        System.out.println(iSet.size());

        Queue<String> myQueue = new LinkedList<String>();
        myQueue.offer("a"); // Doesn't throw exception if queue is full; add will
        myQueue.offer("b");
        myQueue.offer("c");

        while(myQueue.peek() != null)
        {
            System.out.println(myQueue.poll());
        }
    }
}
