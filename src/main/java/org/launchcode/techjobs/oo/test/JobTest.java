package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    Job testJob;
    Job testJob2;
    Job testJob3;
    Job testJob4;
    Job testJob5;
    Job testJob6;
    Job testJob7;
    Job testJob8;
    Job testJob9;
    Job testJob10;
//    Job test11;


//    @Before
//    public void initiatingJobs(){
//        testJob = new Job();
//        testJob2 = new Job();
//        testJob3 = new Job("Product tester",
//                new Employer("ACME"),
//                new Location("Desert"),
//                new PositionType("Quality control"),
//                new CoreCompetency("Persistence"));
//
//        testJob4 = new Job ("Momento", new Employer("Harris"), new Location("Hawaii"), new PositionType("Analyst"), new CoreCompetency("Ruby"));
//        testJob5 = new Job ("Alias", new Employer("Harris"), new Location("Hawaii"), new PositionType("Analyst"), new CoreCompetency("Kotlin"));
//        testJob6 = new Job ("", new Employer("WeLink"), new Location("Utah"), new PositionType("Analyst"), new CoreCompetency("Python"));
//        testJob7 = new Job ("Eddy", new Employer(""), new Location("Utah"), new PositionType("Analyst"), new CoreCompetency("JavaScript"));
//        testJob8 = new Job ("Foxtrot", new Employer("Google"), new Location(""), new PositionType("Analyst"), new CoreCompetency("Rust"));
//        testJob9 = new Job ("Tony", new Employer("Facebook"), new Location("Ivory Coast"), new PositionType(""), new CoreCompetency("GoLang"));
//        testJob10 = new Job ("Mike", new Employer("Amazon"), new Location("California"), new PositionType("Data Architect"), new CoreCompetency(""));
//        test11 = new Job();
//    }

    @Test
    public void testSettingJobId() {
        testJob = new Job();
        testJob2 = new Job();
        assertEquals(testJob.getId() + 1, testJob2.getId());
        assertTrue(testJob2.getId() > testJob.getId());
        assertFalse(testJob.getId() > testJob2.getId());
    }

//    @Test
//    public void jobIdsAreDifferent1() {
//        assertEquals(1,testJob2.getId(),1);
//    }


    @Test
    public void testJobConstructorSetsAllFields() {
        testJob3 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertTrue(testJob3.getName() instanceof String);
        assertTrue(testJob3.getEmployer() instanceof Employer);
        assertTrue(testJob3.getLocation() instanceof Location);
        assertTrue(testJob3.getPositionType() instanceof PositionType);
        assertTrue(testJob3.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", testJob3.getName());
        assertEquals("ACME", testJob3.getEmployer().getValue());
        assertEquals("Desert", testJob3.getLocation().getValue());
        assertEquals("Quality control",testJob3.getPositionType().getValue());
        assertEquals("Persistence", testJob3.getCoreCompetency().getValue());

    }

    @Test
    public void testJobsForEquality() {
        testJob4 = new Job ("Momento", new Employer("Harris"), new Location("Hawaii"), new PositionType("Analyst"), new CoreCompetency("Ruby"));
        testJob5 = new Job ("Alias", new Employer("Harris"), new Location("Hawaii"), new PositionType("Analyst"), new CoreCompetency("Kotlin"));
        boolean check = testJob4.equals(testJob5);
        assertFalse(check);
//        System.out.println("ID of testJob4 is: " + testJob4.getId());
//        System.out.println("ID of testJob5 is: " + testJob5.getId());
//        assertNotSame(testJob4,testJob5);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        testJob3 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals('\n', testJob3.toString().charAt(0));
        assertEquals('\n', testJob3.toString().charAt(testJob3.toString().length() - 1));
        //retrieving last character of string is always index  - 1
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        testJob3 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertEquals("\nID: " + testJob3.getId() +
                "\nName: " + testJob3.getName() +
                "\nEmployer: " + testJob3.getEmployer() +
                "\nLocation: " + testJob3.getLocation() +
                "\nPosition Type: " + testJob3.getPositionType() +
                "\nCore Competency: " + testJob3.getCoreCompetency() + "\n", testJob3.toString());

    }

    @Test
    public void testToStringHandlesEmptyField() {
        String data;
        testJob6 = new Job ("", new Employer("WeLink"), new Location("Utah"), new PositionType("Analyst"), new CoreCompetency("Python"));
//        testJob7 = new Job ("Eddy", new Employer(""), new Location("Utah"), new PositionType("Analyst"), new CoreCompetency("JavaScript"));
//        testJob8 = new Job ("Foxtrot", new Employer("Google"), new Location(""), new PositionType("Analyst"), new CoreCompetency("Rust"));
//        testJob9 = new Job ("Tony", new Employer("Facebook"), new Location("Ivory Coast"), new PositionType(""), new CoreCompetency("GoLang"));
//        testJob10 = new Job ("Mike", new Employer("Amazon"), new Location("California"), new PositionType("Data Architect"), new CoreCompetency(""));
        assertTrue(testJob6.toString().contains("Data not available"));
//        assertTrue(testJob7.toString().contains("Data not available"));
//        assertTrue(testJob8.toString().contains("Data not available"));
//        assertTrue(testJob9.toString().contains("Data not available"));
//        assertTrue(testJob10.toString().contains("Data not available"));
//        System.out.println(testJob8.toString());
//        System.out.println(testJob7.toString());
//        System.out.println(testJob9.toString());
//        System.out.println(testJob10.toString());

        data = "\nID: " + testJob6.getId() +
                "\nName: " + "Data not available" +
                "\nEmployer: " + testJob6.getEmployer() +
                "\nLocation: " + testJob6.getLocation() +
                "\nPosition Type: " + testJob6.getPositionType() +
                "\nCore Competency: " + testJob6.getCoreCompetency() + "\n";
        assertEquals(data, testJob6.toString());

    }


}