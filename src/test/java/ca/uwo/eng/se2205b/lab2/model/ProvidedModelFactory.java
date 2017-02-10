package ca.uwo.eng.se2205b.lab2.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Test fixture used to create a test model for test cases.
 */
public class ProvidedModelFactory {
    /**
     * Creates the model shown in
     * <a href="https://uwoece-se2205b-2017.github.io/labs/02-oop-serialization#question-0">Q1 Deliverable</a>.
     *
     * @return List of Department values
     */
    public static <T> List<Department> createModel (List<? extends T> list) {
        Course AM1413 = new RealCourse();
        AM1413.setMaxStudents(10);
        AM1413.setName("AM1413");

        Course ES1022 = new RealCourse();
        ES1022.setMaxStudents(10);
        ES1022.setName("ES1022");

        Course ES1036 = new RealCourse();
        ES1036.setMaxStudents(10);
        ES1036.setName("ES1036");

        Course SE2205 = new RealCourse();
        SE2205.setMaxStudents(10);
        SE2205.setName("SE2205");

        Student JS = new RealStudent();
        JS.setName("John", "Smith");
        JS.setId(1111L);
        JS.takeCourse(AM1413);
        JS.takeCourse(ES1036);

        Student SM = new RealStudent();
        SM.setId(2222L);
        SM.setName("Sarah","McLachlan");
        SM.takeCourse(AM1413);
        SM.takeCourse(ES1036);
        SM.takeCourse(SE2205);

        Student GW = new RealStudent();
        GW.setId(3333L);
        GW.setName("Gene", "Wilder");
        GW.takeCourse(AM1413);
        GW.takeCourse(SE2205);

        Student RW = new RealStudent();
        RW.setId(4444L);
        RW.setName("Ron","Weasley");
        RW.takeCourse(ES1022);
        RW.takeCourse(SE2205);

        Student MP = new RealStudent();
        MP.setId(5555L);
        MP.setName("Minh","Pham");
        MP.takeCourse(AM1413);
        MP.takeCourse(ES1022);

        Student GT = new RealStudent();
        GT.setId(6666L);
        GT.setName("George","Takei");
        GT.takeCourse(AM1413);
        GT.takeCourse(SE2205);

        Student RN = new RealStudent();
        RN.setId(7777L);
        RN.setName("Ralph", "Nader");
        RN.takeCourse(AM1413);
        RN.takeCourse(ES1022);
        RN.takeCourse(ES1036);
        RN.takeCourse(SE2205);

        Student JT = new RealStudent();
        JT.setId(8888L);
        JT.setName("Jane","Tarzan");

        Department ECE = new RealDepartment();
        ECE.addCourse(SE2205);
        ECE.addCourse(ES1036);
        ECE.setName("ECE");
        ECE.enrollStudent(SM);
        ECE.enrollStudent(GW);
        ECE.enrollStudent(RW);
        ECE.enrollStudent(MP);
        ECE.enrollStudent(JT);

        Department CEE = new RealDepartment();
        CEE.addCourse(ES1022);
        CEE.setName("CEE");
        CEE.enrollStudent(JS);

        Department AM = new RealDepartment();
        AM.addCourse(AM1413);
        AM.setName("AM");
        AM.enrollStudent(GT);
        AM.enrollStudent(RN);

        ArrayList<Department > t= new ArrayList<Department>();
        t.add(CEE);
        t.add(ECE);
        t.add(AM);
        return t;
    }
}
