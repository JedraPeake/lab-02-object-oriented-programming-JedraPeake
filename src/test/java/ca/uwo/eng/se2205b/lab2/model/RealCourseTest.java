package ca.uwo.eng.se2205b.lab2.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test the {@link Course} implementation
 */
public class RealCourseTest {
    /**
     * Test the name property
     */
    private Course temp = new RealCourse();
    Department tempD = new RealDepartment();

    @Before
    public void before() throws CourseMaxCapacityStoreException {
        this.temp.setName("J");
        this.temp.setDepartment(tempD);
        this.temp.setMaxStudents(4);

    }
    @Test
    public void name() {
        assertEquals("J",temp.getName());
    }
    /**
     * Test department interactions
     */
    @Test
    public void department() {
        assertEquals(tempD,temp.getDepartment());
    }
    /**
     * Test that the maximum occupancy behaves properly
     */
    @Test
    public void maximumOccupancy() {
        assertEquals(4,temp.getMaxStudents());
    }

    /**
     * Test that adding/removing students behaves
     */
    @Test
    public void students() throws CourseMaxCapacityStoreException {
//        assertEquals(null,temp.getEnrolledStudents());

        Student me = new RealStudent();
        //me.setFirstName("Jed");
        temp.enrollStudent(me);

        assertEquals("Jed",temp.getEnrolledStudents().toString());

    }
}