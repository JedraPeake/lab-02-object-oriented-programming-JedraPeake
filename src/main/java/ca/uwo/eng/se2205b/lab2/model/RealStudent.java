package ca.uwo.eng.se2205b.lab2.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PeakeAndSons on 2017-02-03.
 */
public class RealStudent implements Student{
    String firstName;
    String lastName;
    ArrayList<Course> courses= new ArrayList<Course>();
    Department department;
    Long id;

    public void setFirstName(String s) {
        if(s.equals("")){
            throw new IllegalStateException();
        }
        if(s == null){
            throw new NullPointerException();
        }
        this.firstName = s;
    }

    public String getFirstName() {
        if(this.firstName != null){
            return this.firstName;
        }
        return null;
    }

    public void setName(String s, String t) {
        if(s.equals("") || (t.equals(""))){
            throw new IllegalStateException();
        }
        if(s == null || t == null){
            throw new NullPointerException();
        }
        this.setFirstName(s);
        this.setLastName(t);
    }

    public String getName() {
        if(this.firstName != null && this.lastName !=null){
            return firstName + " " + lastName;
        }
        return null;
    }

    public void setLastName(String s) {
        if(s.equals("")){
            throw new IllegalStateException();
        }
        if(s == null){
            throw new NullPointerException();
        }
        this.lastName = s;
    }

    public String getLastName() {
        if(this.lastName != null){
            return this.lastName;
        }
        return null;
    }

    public void setId(Long z) {
        if(z>0){
            this.id = z;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public Long getId() {
        return this.id;
    }

    public ArrayList<Course> viewAllCourses() {
            return courses;
    }

    public Course dropCourse(Course s) {
        int index = -1;
        for(int i =0; i< this.courses.size();i++){
            if(courses.get(i) == s){
                index=i;
            }
        }
        if(index == -1){
            return null;
        }
        s.removeStudentlink(this);
        Course temp = courses.get(index);
        courses.remove(index);
        return temp;
    }

    public Course dropCourselink (Course s) {
        int index = -1;
        for(int i =0; i< this.courses.size();i++){
            if(courses.get(i) == s){
                index=i;
            }
        }
        if(index == -1){
            return null;
        }
        Course temp = courses.get(index);
        courses.remove(index);
        return temp;
    }

    public void takeCourse(Course s) {
        this.courses.add(s);
        s.enrollStudentlink(this);
    }

    public void takeCourselink (Course s) {
        this.courses.add(s);
    }

    public void setDepartment(Department s) {
        if(s != null){
            this.department = s;
            s.enrollStudentlink(this);
        }
    }

    public void setDepartmentlink(Department s) {
        if(s != null){
            this.department = s;
        }
    }

    public Department getDepartment() {
        return this.department;
    }

    @Override
    public String toString(){
        return "[" + toStringHelper() + "]";
    }
    private int counter= -1;
    private String toStringHelper() {
        counter ++;

        if (courses.size() == 0)
            return "";

        if (courses.size() == counter-1)
            return "" + courses.get(counter-1) ;

        return courses.get(counter) + ", ";// + toStringHelper( courses. ref.link);
    }

    @Override
    public boolean equals(Object o){
        if(o == this) {
            return true;
        }

        List<?> tmp = (List<?>)o;

        if( courses.size() == tmp.size()) {
            for(int i = 0; i < courses.size(); i++ ) {
                if ( courses.get(i) == null && courses.get(i) != tmp.get(i)) {
                    return false;
                } else if ( courses.get(i) != null && !( courses.get(i)).equals(tmp.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}

