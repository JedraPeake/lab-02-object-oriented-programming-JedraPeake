package ca.uwo.eng.se2205b.lab2.model;

import java.util.ArrayList;

/**
 * Created by PeakeAndSons on 2017-02-03.
 */
public interface Student {

    public void setFirstName(String s);
    public String getFirstName();

    public void setLastName(String s);
    public String getLastName();

    public void setName(String s, String t);
    public String getName();

    public ArrayList<Course> viewAllCourses();
    public Course dropCourse(Course s);
    public void takeCourse(Course s);

    public void setDepartment(Department s);
    public Department getDepartment();

    public void setId(Long z);
    public Long getId();

    public void setDepartmentlink(Department s);
    public void takeCourselink (Course s);
    public Course dropCourselink (Course s);

    public String toString();
    public boolean equals(Object o);
}


