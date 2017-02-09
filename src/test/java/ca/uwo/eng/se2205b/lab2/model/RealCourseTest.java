package ca.uwo.eng.se2205b.lab2.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
/**
 * Test the {@link Course} implementation
 */
public class RealCourseTest {
    /**
     * Test the name property
     */
    private Course temp = new RealCourse();
    private Department tempD = new RealDepartment();
    private Student me = new RealStudent();

    @Before
    public void before() throws CourseMaxCapacityStoreException {
        this.temp.setMaxStudents(4);
    }
    @Test
    public void name() {
        temp.setName("J");
        assertEquals("J",temp.getName());
    }
    @Test(expected = IllegalArgumentException.class )
    public void emptyName() {
        this.temp.setName("");
    }
    @Test(expected = NullPointerException.class )
    public void nullName() {
        this.temp.setName(null);
    }
    /**
     * Test department interactions
     */
    @Test
    public void department() {
        this.temp.setDepartment(tempD);
        assertEquals(tempD,temp.getDepartment());
    }
    @Test
    public void departmentName() {
        tempD.setName("SSC");
        this.temp.setDepartment(tempD);
        assertEquals("SSC",temp.getDepartment().getName());
    }
    @Test
    public void nullDepartment() {
        assertEquals(null,temp.getDepartment());
    }
    /**
     * Test that the maximum occupancy behaves properly
     */
    @Test
    public void maximumOccupancy() {
        assertEquals(4,temp.getMaximumOccupancy());
    }

    /**
     * Test that adding/removing students behaves
     */
    @Test
    public void students() throws CourseMaxCapacityStoreException {
        temp.setMaxStudents(1);
        temp.enrollStudent(me);
        me.setFirstName("J");
        ArrayList<Student> help= new ArrayList<Student>();
        help.add(me);
        assertEquals( help ,temp.getEnrolledStudents());
    }
    @Test
    public void emptyStudentsList() throws CourseMaxCapacityStoreException {
        ArrayList<Student> help= new ArrayList<Student>();
        assertEquals(help,temp.getEnrolledStudents());
    }
    @Test(expected = CourseMaxCapacityStoreException.class )
    public void fullStudentsList() throws CourseMaxCapacityStoreException{
       temp.setMaxStudents(0);
       temp.enrollStudent(me);
    }
    @Test(expected = NullPointerException.class )
    public void nullStudents() throws CourseMaxCapacityStoreException{
        temp.setMaxStudents(1);
        temp.enrollStudent(null);
    }
    @Test(expected = NullPointerException.class )
    public void nullRemoveStudents() throws CourseMaxCapacityStoreException{
        temp.setMaxStudents(1);
        temp.enrollStudent(me);
        temp.removeStudent(null);
    }
    @Test
    public void removeStudent() throws CourseMaxCapacityStoreException{
        temp.setMaxStudents(1);
        temp.enrollStudent(me);
        assertEquals(me,temp.removeStudent(me));
    }
    @Test
    public void removeStudentNotStored() throws CourseMaxCapacityStoreException{
        temp.setMaxStudents(1);
        temp.enrollStudent(me);
        Student maz = new RealStudent();
        assertEquals(null,temp.removeStudent(maz));
    }
    @Test
    public void removeStudents() throws CourseMaxCapacityStoreException{
        temp.setMaxStudents(5);
        temp.enrollStudent(me);
        Student temp1 = new RealStudent();
        Student temp2 = new RealStudent();
        Student temp3 = new RealStudent();
        Student temp4 = new RealStudent();
        temp.enrollStudent(temp1);
        temp.enrollStudent(temp2);
        temp.enrollStudent(temp3);
        temp.enrollStudent(temp4);
        assertEquals(me,temp.removeStudent(me));
        assertEquals(temp4,temp.removeStudent(temp4));
        assertEquals(temp3,temp.removeStudent(temp3));
        assertEquals(temp2,temp.removeStudent(temp2));
        assertEquals(temp1,temp.removeStudent(temp1));
    }
    @Test
    public void removeStudentsNotStored() throws CourseMaxCapacityStoreException{
        temp.setMaxStudents(5);
        temp.enrollStudent(me);
        Student temp1 = new RealStudent();
        Student temp2 = new RealStudent();
        Student temp3 = new RealStudent();
        Student temp4 = new RealStudent();
        Student temp5 = new RealStudent();
        Student temp6 = new RealStudent();
        Student temp7 = new RealStudent();
        Student temp8 = new RealStudent();
        temp.enrollStudent(temp1);
        temp.enrollStudent(temp2);
        temp.enrollStudent(temp3);
        temp.enrollStudent(temp4);
        assertEquals(me,temp.removeStudent(me));
        assertEquals(null,temp.removeStudent(temp5));
        assertEquals(null,temp.removeStudent(temp6));
        assertEquals(null,temp.removeStudent(temp7));
        assertEquals(null,temp.removeStudent(temp8));
    }
}