package ca.uwo.eng.se2205b.lab2.model;

import javax.annotation.Nonnull;
import java.util.ArrayList;
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
    ArrayList<Student> students= new ArrayList<Student>();

    public String getCourseCode(){
     return this.courseCode;
    }

    public void setName(@Nonnull String name){
        if(name.equals("")){
            throw new IllegalArgumentException();
        }
        this.courseName = name;
    }

    public String getName(){
        return this.courseName;
    }

    public void setDepartment(Department newDepartment){
        this.department = newDepartment;
    }

    public Department getDepartment(){
        if(this.department == null){
            return null;
        }
        return this.department;
    }

    public int getMaximumOccupancy(){
        return this.cap;
    }

    public void enrollStudent(@Nonnull Student student) throws CourseMaxCapacityStoreException{
        if(student == null){
            throw new NullPointerException();
        }
        if (this.cap > this.students.size()){
            this.students.add(student);
        }
        else{
            throw new CourseMaxCapacityStoreException();
        }
    }

    public Student removeStudent(@Nonnull Student student){
        if(student == null){
            throw new NullPointerException();
        }
        int temp = -1;
        for (int i = 0; i < students.size() ; i++){
            if (student == students.get(i)){
                temp = i ;
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
        List<Student> temp = new ArrayList<>();
        for(int i =0; i<students.size();i++){
            temp.add(i, students.get(i));
        }
        return temp;
    }

    public void setMaxStudents(int n){
        this.cap = n;
    }

    public static void main(String [] args) throws CourseMaxCapacityStoreException {
        Course temp = new RealCourse();
        Student me = new RealStudent();
        me.setFirstName("hi");
        Student meme = new RealStudent();
        meme.setFirstName("hey");
        temp.setMaxStudents(1);
        temp.enrollStudent(me);
        temp.enrollStudent(meme);
        System.out.println(temp.getEnrolledStudents());
        temp.removeStudent(me);
        System.out.println(temp.getEnrolledStudents());


    }
}
