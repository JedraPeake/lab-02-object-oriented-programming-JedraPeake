package ca.uwo.eng.se2205b.lab2.model;

/**
 * Created by PeakeAndSons on 2017-02-03.
 */
public class CourseMaxCapacityStoreException extends Exception {
    RealStudent toBe = null;
    RealCourse toB = null;
    public CourseMaxCapacityStoreException(){
        super(  RealCourse.class  + " can not store " + RealStudent.class + ", maximum capacity reached.");
    }
    public String getStudent(){
        return toBe.getFirstName();
    }
    public String getCourse (){
        return toB.courseName;
    }

}
