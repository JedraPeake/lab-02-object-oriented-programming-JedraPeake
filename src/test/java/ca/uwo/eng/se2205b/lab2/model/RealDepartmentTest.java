package ca.uwo.eng.se2205b.lab2.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test the {@link Department} implementation.
 */
public class RealDepartmentTest {
    private Course temp = new RealCourse();
    private Department tempD = new RealDepartment();
    private Student me = new RealStudent();
    /**
     * Test the name property
     */
    @Test
    public void name() {
        tempD.setName("SSC");
        assertEquals("SSC", tempD.getName());
    }
    @Test(expected = IllegalArgumentException.class )
    public void emptyName() {
        tempD.setName("");
    }
    @Test(expected = NullPointerException.class )
    public void nullName() {
        tempD.setName(null);
    }
    /**
     * Test course changes
     */
    @Test
    public void courses() {
        tempD.addCourse(temp);
        ArrayList<Course> help= new ArrayList<Course>();
        help.add(temp);
        assertEquals(help, tempD.getCourses());
    }
    @Test
    public void nullCourses() {
        ArrayList<Student> help= new ArrayList<Student>();
        assertEquals(help, tempD.getCourses());
    }
    @Test
    public void removeCourse() {
        tempD.addCourse(temp);
        assertEquals(temp, tempD.removeCourse(temp));
    }
    @Test
    public void removeCoursesNotStored() {
        tempD.addCourse(temp);
        Course temp1 = new RealCourse();
        Course temp2 = new RealCourse();
        Course temp3 = new RealCourse();
        Course temp4 = new RealCourse();
        assertEquals(temp, tempD.removeCourse(temp));
        assertEquals(null, tempD.removeCourse(temp1));
        assertEquals(null, tempD.removeCourse(temp2));
        assertEquals(null, tempD.removeCourse(temp3));
        assertEquals(null, tempD.removeCourse(temp4));
    }
    @Test
    public void removeCourses() {
        tempD.addCourse(temp);
        Course temp1 = new RealCourse();
        Course temp2 = new RealCourse();
        Course temp3 = new RealCourse();
        Course temp4 = new RealCourse();
        tempD.addCourse(temp1);
        tempD.addCourse(temp2);
        tempD.addCourse(temp3);
        tempD.addCourse(temp4);
        assertEquals(temp, tempD.removeCourse(temp));
        assertEquals(temp1, tempD.removeCourse(temp1));
        assertEquals(temp2, tempD.removeCourse(temp2));
        assertEquals(temp3, tempD.removeCourse(temp3));
        assertEquals(temp4, tempD.removeCourse(temp4));
    }

    /**
     * Test student changes
     */
    @Test
    public void students() {
        tempD.enrollStudent(me);
        ArrayList<Student > t= new ArrayList<Student>();
        t.add(me);
        assertEquals(t, tempD.getEnrolledStudents());
    }
    @Test (expected = NullPointerException.class )
    public void nullStudents() {
        tempD.enrollStudent(null);
    }
    @Test
    public void removeStudent() {
        tempD.enrollStudent(me);
        tempD.removeStudent(me);
        ArrayList<Student > t= new ArrayList<Student>();
        assertEquals(t, tempD.getEnrolledStudents());
    }
    @Test
    public void removeStudentsNotStored() {
        tempD.enrollStudent(me);
        Student me1 = new RealStudent();
        Student me2 = new RealStudent();
        Student me3 = new RealStudent();
        Student me4 = new RealStudent();
        assertEquals(me, tempD.removeStudent(me));
        assertEquals(null, tempD.removeStudent(me1));
        assertEquals(null, tempD.removeStudent(me2));
        assertEquals(null, tempD.removeStudent(me3));
        assertEquals(null, tempD.removeStudent(me4));
    }
    @Test
    public void removeStudents() {
        tempD.enrollStudent(me);
        Student me1 = new RealStudent();
        Student me2 = new RealStudent();
        Student me3 = new RealStudent();
        Student me4 = new RealStudent();
        tempD.enrollStudent(me1);
        tempD.enrollStudent(me2);
        tempD.enrollStudent(me3);
        tempD.enrollStudent(me4);
        assertEquals(me, tempD.removeStudent(me));
        assertEquals(me1, tempD.removeStudent(me1));
        assertEquals(me2, tempD.removeStudent(me2));
        assertEquals(me3, tempD.removeStudent(me3));
        assertEquals(me4, tempD.removeStudent(me4));
    }
    @Test
    public void relationship() {
        Student s = new RealStudent() ;
        Course c = new RealCourse() ;
        Department d = new RealDepartment();

        d.addCourse(c);
        d.enrollStudent(s);
        assertTrue(d.getEnrolledStudents().contains(s));
        assertTrue(d.getCourses().contains(c));

        //dont work....
        assertTrue(s.getDepartment().equals(d));
        assertTrue(c.getDepartment().equals(d));
    }
}