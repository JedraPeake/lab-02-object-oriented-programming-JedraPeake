package ca.uwo.eng.se2205b.lab2.model;

import java.util.ArrayList;

/**
 * Created by PeakeAndSons on 2017-02-03.
 */
public class RealStudent implements Student{
    private String firstName;
    private String lastName;
    ArrayList<Course> courses;
    Department department;
    private Long id;

    public void setFirstName(String s) {
        this.firstName = s;
    }

    public String getFirstName() {
        if(this.firstName != null){
            return this.firstName;
        }
        return null;
    }

    public void setLastName(String s) {
        this.lastName = s;
    }

    public String getLastName() {
        if(this.lastName != null){
            return this.lastName;
        }
        return null;
    }

    public ArrayList<Course> viewAllCourses() {
        if(this.courses.size() >0){
            return courses;
        }
        return null;
    }

    public Course dropCourse(Course s) {
        int index = -1;
        for(int i =0; i< this.courses.size();i++){
            Course temp = courses.get(i);
            if(temp == s){
                index=i;
            }
        }
        if(index == -1){
            return null;
        }
        Course temp = courses.get(index);
        for(int i = index + 1; i < this.courses.size(); i++) {
            this.courses.set((i-1), this.courses.get(i));
        }
        return temp;
    }

    public void takeCourse(Course s) {
        int temp = this.courses.size() +1;
        this.courses.set(temp, s);
    }

    public void setDepartment(Department s) {
        if(s != null){
            this.department = s;
        }
    }

    public Department getDepartment() {
        return this.department;
    }


    public void setId(Long z) {
        if(z>0){
            this.id = z;
        }
    }

    public Long getId() {
        return this.id;
    }

    public static void main(String arg[])
    {
        Student obj = new RealStudent();
        obj. setFirstName("jedra");
        System.out.println(obj.getFirstName());
        System.out.println(obj.getLastName());
    }

}

