package ca.uwo.eng.se2205b.lab2.model;

/**
 * Created by PeakeAndSons on 2017-02-03.
 */
public class RealStudent implements Student{
    private String firstName;
    private String lastName;
    private String[] courses;
    private String department;
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

    public String[] viewAllCourses() {
        if(this.courses.length>0){
            return courses;
        }
        return null;
    }

    public String dropCourse(String s) {
        int index = -1;
        for(int i =0; i< this.courses.length;i++){
            if(this.courses[i] == s){
                index=i;
            }
        }
        if(index == -1){
            return null;
        }
        String temp = courses[index];
        for(int i = index + 1; i < this.courses.length; i++) {
            this.courses[i - 1] = this.courses[i];
        }
        return temp;
    }

    public void takeCourse(String s) {
        int size = this.courses.length;
        this.courses[size++] = s;
    }

    public void setDepartment(String s) {
        if(s != null){
            this.department = s;
        }
    }

    public String getDepartment() {
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

