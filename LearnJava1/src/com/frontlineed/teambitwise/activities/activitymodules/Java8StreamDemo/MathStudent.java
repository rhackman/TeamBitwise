package com.frontlineed.teambitwise.activities.activitymodules.Java8StreamDemo;

import java.util.StringJoiner;

/**
 * Created by rconroy on 6/14/2017.
 */
public class MathStudent {
    private String firstName;
    private int age;

    public MathStudent(){}

    public MathStudent(String firstName, int age)
    {
        this.firstName = firstName;
        this.age = age;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public int getStudentAge()
    {
        return this.age;
    }

    @Override
    public String toString()
    {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        sj.add(this.firstName).add(Integer.toString(this.age));
        return sj.toString();
    }
}
