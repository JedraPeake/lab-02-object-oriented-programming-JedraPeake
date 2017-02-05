package ca.uwo.eng.se2205b.lab2.model;

/**
 * Created by PeakeAndSons on 2017-02-03.
 */
//public class Student {
//}
public interface Student {

    public void setFirstName(String s);
    public String getFirstName();

    public void setLastName(String s);
    public String getLastName();

    public String[] viewAllCourses();
    public String dropCourse(String s);
    public void takeCourse(String s);

    public void setDepartment(String s);
    public String getDepartment();

    public void setId(Long z);
    public Long getId();
}


