package ca.uwo.eng.se2205b.lab2.model;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PeakeAndSons on 2017-02-03.
 */
public class RealDepartment implements Department {
    String name;
    ArrayList<Course > courses= new ArrayList<Course>();
    ArrayList<Student> students = new ArrayList<>();

    public String getName() {
        if(this.name == null){
            return null;
        }
        return this.name;
    }

    public void setName(@Nonnull String name) {
        if(name.equals("")){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public void enrollStudent(@Nonnull Student student) {
        if(student  == null){
            throw new NullPointerException();
        }
        students.add(student);
        student.setDepartmentlink(this);
    }

    public void enrollStudentlink(@Nonnull Student student) {
        if(student  == null){
            throw new NullPointerException();
        }
        students.add(student);
    }

    public Student removeStudent(@Nonnull Student student) {
        int temp = -1;
        for (int i = 0; i < students.size() ; i++){
            if(student == students.get(i)){
                temp = i;
            }
        }
        if(temp == -1) {
            return null;
        }
        student.setDepartmentlink(null);
        Student removed = students.get(temp);
        students.remove(temp);
        return removed;
    }

    public Student removeStudentlink(@Nonnull Student student) {
        int temp = -1;
        for (int i = 0; i < students.size() ; i++){
            if(student == students.get(i)){
                temp = i;
            }
        }
        if(temp == -1) {
            return null;
        }
        Student removed = students.get(temp);
        students.remove(temp);
        return removed;
    }

    public List<Student> getEnrolledStudents() {
        return this.students;
    }

    public void addCourse(@Nonnull Course course) {
        this.courses.add(course);
        course.setDepartmentlink(this);
    }

    public void addCourselink(@Nonnull Course course) {
        this.courses.add(course);
    }

    public Course removeCourse(@Nonnull Course course) {
        int temp = -1;
        for (int i = 0; i < courses.size() ; i++){
            if(course == courses.get(i)){
                temp = i;
            }
        }
        if(temp != -1) {
            course.setDepartmentlink(null);
            Course removed = courses.get(temp);
            courses.remove(temp);
            return removed;
        }
        return null;
    }

    public Course removeCourselink(@Nonnull Course course) {
        int temp = -1;
        for (int i = 0; i < courses.size() ; i++){
            if(course == courses.get(i)){
                temp = i;
            }
        }
        if(temp != -1) {
            Course removed = courses.get(temp);
            courses.remove(temp);
            return removed;
        }
        return null;
    }

    public List<Course> getCourses() {
        return this.courses;
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

        if( students.size() == tmp.size()) {
            for(int i = 0; i < students.size(); i++ ) {
                if ( students.get(i) == null && students.get(i) != tmp.get(i)) {
                    return false;
                } else if ( students.get(i) != null && !( students.get(i)).equals(tmp.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
