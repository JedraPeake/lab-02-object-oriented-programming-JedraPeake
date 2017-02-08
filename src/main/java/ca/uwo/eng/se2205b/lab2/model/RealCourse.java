package ca.uwo.eng.se2205b.lab2.model;

import javax.annotation.Nonnull;
import java.util.List;


/**
 * Created by PeakeAndSons on 2017-02-03.
 */
public class RealCourse implements Course{
    //changed all methods to public in interface ie String getCourse -> public String getCourse
    //http://stackoverflow.com/questions/13160672/java-getting-an-error-for-implementing-interface-method-with-weaker-access

    String courseCode;
    String courseName;
    Department department;
    int cap;
    List<Student> students;
    public int maxStudents;

    public String getCourseCode(){
     return this.courseCode;
    }

    public void setName(@Nonnull String name){
        this.courseName = name;
    }

    public String getName(){
        return this.courseName;
    }

    public void setDepartment(Department newDepartment){
        this.department = newDepartment;
    }

    public Department getDepartment(){
        return this.department;
    }

    public int getMaximumOccupancy(){
        return this.cap;
    }

    public void enrollStudent(@Nonnull Student student) throws CourseMaxCapacityStoreException{
        if(this.students == null){
            this.students.add(0, student);
        }
        if (this.maxStudents >= this.students.size()){
            this.students.add(student);
        }
        throw new CourseMaxCapacityStoreException();
    }

    public Student removeStudent(@Nonnull Student student){
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

    public List<Student> getEnrolledStudents(){
        return this.students;
    }

    public void setMaxStudents(int n){
        this.maxStudents = n;
    }

    public int getMaxStudents(){
        return this.maxStudents;
    }
}
