package ca.uwo.eng.se2205b.lab2.model;

/**
 * Created by PeakeAndSons on 2017-02-03.
 */
public class CourseMaxCapacityStoreException extends RuntimeException {
    RealStudent toBe = null;
    RealCourse toB = null;

    public CourseMaxCapacityStoreException(String c, Student s){
        super(  c  + " can not store " + s.toString() + ", maximum capacity reached.");
    }

    public String getStudent(){
        return toBe.getFirstName();
    }

    public String getCourse (){
        return toB.courseName;
    }

}
