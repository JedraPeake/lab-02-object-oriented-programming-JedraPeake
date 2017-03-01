package ca.uwo.eng.se2205b.lab2.model;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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
    int cap =10;
    ArrayList<Student> students= new ArrayList<Student>();

    RealCourse(String name, String courseCode, @Nullable Department department, int maxOccupancy){
        setName(name);
        setCourseCode(courseCode);
        if(department != null){
            setDepartment(department);
        }
        setMaxStudents(maxOccupancy);
    }

    public String getCourseCode(){
     return this.courseCode;
    }

    public void setCourseCode(String code){
        if(code.equals("")){
            throw new IllegalArgumentException();
        }
        if(code ==null){
            this.courseCode = null;
        }
        this.courseCode = code;
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
        newDepartment.addCourselink(this);
    }

    public void setDepartmentlink(Department newDepartment){
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

    public void enrollStudent(@Nonnull Student student){

            if (student == null) {
                throw new NullPointerException();
            }
            if (this.cap > this.students.size()) {
                this.students.add(student);
                student.takeCourselink(this);
            } else {
                throw new CourseMaxCapacityStoreException(getName(), student);
            }

    }

    public void enrollStudentlink (@Nonnull Student student){

        if (student == null) {
            throw new NullPointerException();
        }
        if (this.cap > this.students.size()) {
            this.students.add(student);
        } else {
            throw new CourseMaxCapacityStoreException(getName(), student);
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
        student.dropCourselink(this);
        Student removed = students.get(temp);
        students.remove(temp);
        return removed;
    }

    public Student removeStudentlink(@Nonnull Student student){
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

    @Override
    public String toString(){
        return "[" + toStringHelper() + "]";
    }
    private int counter= -1;
    private String toStringHelper() {
        counter ++;

        if (students.size() == 0)
            return "";

        if (students.size() == counter-1)
            return "" + students.get(counter-1) ;

        return students.get(counter) + ", ";// + toStringHelper( courses. ref.link);
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

