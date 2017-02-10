package ca.uwo.eng.se2205b.lab2.model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by PeakeAndSons on 2017-02-09.
 */

public class ModelFactoryTest {
    @Before
    public void before() throws CourseMaxCapacityStoreException {

    }
    @Test
    public void list(){
        List<Department> temp= ProvidedModelFactory.createModel();
        Department New = new RealDepartment();
        assertEquals(true, temp.add(New) );
        //assertEquals(false, temp.add(New));
    }
}
