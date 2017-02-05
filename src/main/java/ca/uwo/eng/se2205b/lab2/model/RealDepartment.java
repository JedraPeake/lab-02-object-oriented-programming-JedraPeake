package ca.uwo.eng.se2205b.lab2.model;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Created by PeakeAndSons on 2017-02-03.
 */
public class RealDepartment implements Department {
    String name;
    List<Student> students;
    List<Course> courses;


    public String getName() {
        return this.name;
    }

    public void setName(@Nonnull String name) {
        this.name = name;
    }

    public void enrollStudent(@Nonnull Student student) {
        students.add(student);
    }

    public Student removeStudent(@Nonnull Student student) {
        int temp = -1;
        for (int i = 0; i < students.size() ; i++){
            if(students.contains(student)){
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
    }

    public Course removeCourse(@Nonnull Course course) {
        int temp = -1;
        for (int i = 0; i < courses.size() ; i++){
            if(courses.contains(course)){
                temp = i;
            }
        }
        if(temp == -1) {
            return null;
        }
        Course removed = courses.get(temp);
        courses.remove(temp);
        return removed;
    }

    public List<Course> getCourses() {
        return this.courses;
    }
}
