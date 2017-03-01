package ca.uwo.eng.se2205b.lab2.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test the {@link Student} implementation.
 */
public class RealStudentTest {
    private Course temp = new RealCourse("App","A",null,4);
    private Department tempD = new RealDepartment("D");
    private Student me = new RealStudent("J","P",78071073L,null);

    /**
     * Test the name property
     * first/last name  non-null  empty strings
     */
    @Test
    public void name() {
        me.setFirstName("Jedra");
        me.setLastName("Peake");
        me.setName("Jedra","Peake");
        assertEquals("Jedra", me.getFirstName());
        assertEquals("Peake", me.getLastName());
        assertEquals("Jedra Peake", me.getName());
    }
    @Test(expected = NullPointerException.class )
    public void nullName() {
        me.setFirstName(null);
        me.setLastName(null);
        me.setName(null,"Peake");
        me.setName("Jedra",null);
        me.setName(null,null);
    }
    @Test(expected = IllegalStateException.class )
    public void emptyName() {
        me.setFirstName("");
        me.setLastName("");
        me.setName("J","");
        me.setName("","J");
        me.setName("","");
    }

    /**
     * Test course changes
     *
     */
    @Test
    public void courses() {
        me.takeCourse(temp);
        ArrayList<Course> help= new ArrayList<Course>();
        help.add(temp);
        assertArrayEquals( help.toArray(), me.viewAllCourses().toArray() );

    }
    @Test
    public void emptyCourses() {
        ArrayList<Course> help= new ArrayList<Course>();
        assertEquals(help , me.viewAllCourses() );
    }
    @Test
    public void removecourse() {
        me.takeCourse(temp);
        ArrayList<Course> help= new ArrayList<Course>();
        me.dropCourse(temp);
        assertEquals(help , me.viewAllCourses() );
    }
    @Test
    public void removecourses() {
        me.takeCourse(temp);
         Course temp1 = new RealCourse("App","A",null,4);
        ArrayList<Course> help= new ArrayList<Course>();
        assertEquals(null , me.dropCourse(temp1) );
        assertEquals(temp , me.dropCourse(temp) );
    }
    @Test
    public void addcourses() {
        me.takeCourse(temp);
        Course temp1 = new RealCourse("App","A",null,4);
        Course temp2 = new RealCourse("App","A",null,4);
        Course temp3 = new RealCourse("App","A",null,4);
        Course temp4 = new RealCourse("App","A",null,4);
        me.takeCourse(temp1);
        me.takeCourse(temp2);
        me.takeCourse(temp3);
        me.takeCourse(temp4);
        ArrayList<Course> help= new ArrayList<Course>();
        help.add(temp);
        help.add(temp1);
        help.add(temp2);
        help.add(temp3);
        help.add(temp4);
        assertEquals(help , me.viewAllCourses() );
    }

    /**
     * Test department interactions
     * can be null
     */
    @Test
    public void department() {
        me.setDepartment(tempD);
        assertEquals(tempD, me.getDepartment());
    }
    @Test
    public void nullDepartment() {
        assertEquals(null, me.getDepartment());
    }
    /**
     * Test id interactions
     * greater then 0
     */
    @Test
    public void id() {
        me.setId(78071073L);
        assertEquals(78071073L, me.getId().longValue());
    }
    @Test(expected = IllegalArgumentException.class)
    public void idNegative() {
        me.setId(-78071073L);
    }
    @Test
    public void relationship() {
        Student s = new RealStudent("J","P",123L,null) ;
        Course c = new RealCourse("App","A",null,4) ;
        Department d = new RealDepartment("D");

        s.setDepartment(d);
        s.takeCourse(c);
        assertTrue(s.viewAllCourses().contains(c));
        assertTrue(s.getDepartment().equals(d));

        assertTrue(d.getEnrolledStudents().contains(s));
        assertTrue(c.getEnrolledStudents().contains(s));

    }
    @Test
    public void ts() {
        Student s = new RealStudent("J","P",123L,null) ;
        Course c = new RealCourse("App","A",null,4) ;

        ArrayList<Course> help= new ArrayList<Course>();
        assertEquals(help.toString() , s.toString() );

//        s.takeCourse(c);
//        help.add(c);
//        assertEquals("[" + c.toString() + "]", s.toString() );
    }

}
