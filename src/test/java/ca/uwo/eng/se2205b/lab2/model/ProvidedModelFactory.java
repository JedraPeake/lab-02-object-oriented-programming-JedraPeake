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

        Course AM1413 = new RealCourse("Calculus","AM1413",null,6);

        Course ES1022 = new RealCourse("Statics","ES1022",null,6);

        Course ES1036 = new RealCourse("Programming Fundamentals I","ES1036",null,5);

        Course SE2205 = new RealCourse("Data Structures and Algorithms","SE2205",null,10);

        Student JS = new RealStudent("John", "Smith",1111L,null);
        JS.takeCourse(AM1413);
        JS.takeCourse(ES1036);

        Student SM = new RealStudent("Sarah","McLachlan",2222L,null);
        SM.takeCourse(AM1413);
        SM.takeCourse(ES1036);
        SM.takeCourse(SE2205);

        Student GW = new RealStudent("Gene", "Wilder",3333L,null);
        GW.takeCourse(AM1413);
        GW.takeCourse(SE2205);

        Student RW = new RealStudent("Ron","Weasley",4444L,null);
        RW.takeCourse(ES1022);
        RW.takeCourse(SE2205);

        Student MP = new RealStudent("Minh","Pham",5555L,null);
        MP.takeCourse(AM1413);
        MP.takeCourse(ES1022);

        Student GT = new RealStudent("George","Takei",6666L,null);
        GT.takeCourse(AM1413);
        GT.takeCourse(SE2205);

        Student RN = new RealStudent("Ralph", "Nader",7777L,null);
        RN.takeCourse(AM1413);
        RN.takeCourse(ES1022);
        RN.takeCourse(ES1036);
        RN.takeCourse(SE2205);

        Student JT = new RealStudent("Jane","Tarzan",8888L, null);

        Department ECE = new RealDepartment("Electrical And Computer Engineering");
        ECE.addCourse(SE2205);
        ECE.addCourse(ES1036);
        ECE.enrollStudent(SM);
        ECE.enrollStudent(GW);
        ECE.enrollStudent(RW);
        ECE.enrollStudent(MP);
        ECE.enrollStudent(JT);

        Department CEE = new RealDepartment("Civil and Environmental Engineering");
        CEE.addCourse(ES1022);
        CEE.enrollStudent(JS);

        Department AM = new RealDepartment("Applied Math");
        AM.addCourse(AM1413);
        AM.enrollStudent(GT);
        AM.enrollStudent(RN);

        ArrayList<Department > t= new ArrayList<Department>();
        t.add(CEE);
        t.add(ECE);
        t.add(AM);
        return t;
    }
}
