package ca.uwo.eng.se2205b.lab2.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test the {@link Department} implementation.
 */
public class RealDepartmentTest {
    private Course temp = new RealCourse();
    private Department tempD = new RealDepartment();
    private Student me = new RealStudent();

    @Before
    public void before() throws CourseMaxCapacityStoreException {
        tempD.setName("SSC");
        tempD.addCourse(temp);

    }
    /**
     * Test the name property
     */
    @Test
    public void name() {
        assertEquals("SSC", tempD.getName());
    }
    /**
     * Test course changes
     */
    @Test
    public void courses() {
//        temp.setName("CALC");
        assertEquals("CALC", tempD.getCourses());
    }
    /**
     * Test student changes
     */
    @Test
    public void students() {

    }
}