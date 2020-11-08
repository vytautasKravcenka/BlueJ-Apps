import java.util.*;

/**
 * The Student class represents a real student with a course. It stores
 * the name, id and students course. It can enroll student on a course,
 * ask Course class to count final grade and print final details out.
 * author Vytautas Kravcenka
 * 10/27/2020
 */
public class Student
{
    // the student's full name
    private String name;
    // the student ID
    private String id;
    // the students course
    private Course course;
    /**
     * Create a new student with a given name and ID number.
     */
    public Student(String fullName, String studentID)
    {
        name = fullName;
        id = studentID;
    }

    /**
     *  enrolls a student on a course
     */
    public void setCourse()
    {
        this.course = new Course ("Computing", "G400");
    }

    /**
     * calculates a final grade for a course consisting of 4 modules
     */
    public void countGrade()
    {
        course.calculateFinalGrade();
    }

    /**
     * Prints out the final grade and the marks for the modules for a student
     */
    public void print()
    {
        course.printFinalGrades();
    }
}
