
/**
 * The Course class represents course of a real student. It stores
 * the title, number, modules list and final students grade, as well as the final
 * average 4 modules mark. It can calculate final grade, add up to 4 modules and
 * print final grades or course (+modules) info.
 *
 * @author Vytautas Kravcenka
 * 10/27/2020
 */
public class Course
{
    // the course name
    public String title;
    // the course number
    private String courseNumber;
    // the course 4 modules
    private Module firstModule;
    private Module secondModule;
    private Module thirdModule;
    private Module fourthModule;
    // the final grade for this course
    private Grades finalGrade;
    // the average of all 4 modules marks
    private int finalMark;
    /**
     * Create a new course with a given name and number.
     */
    public Course(String courseName, String courseNumber)
    {
        title = courseName;
        this.courseNumber = courseNumber;
        finalGrade = Grades.NULL;
    }
    /**
     * Count final mark of 4 modules, checks if all modules are
     * completed, if so gets the final grade for the course
     */
    public void calculateFinalGrade()
    {
        finalMark = (firstModule.getMark() + secondModule.getMark() +
            thirdModule.getMark() + fourthModule.getMark()) / 4;
            if(firstModule.isCompleted() && secondModule.isCompleted() &&
                thirdModule.isCompleted() && fourthModule.isCompleted())
            {
            if(finalMark < 40) finalGrade = Grades.F;
            else if(finalMark >= 40 && finalMark < 50) finalGrade = Grades.D;
            else if(finalMark >= 50 && finalMark < 60) finalGrade = Grades.C;
            else if(finalMark >= 60 && finalMark < 70) finalGrade = Grades.B;
            else finalGrade = Grades.A;
        }
        else System.out.println("not all modules completed");
    }
    /**
     * Adds modules and assigns marks to modules for test purposes
     */
    public void addModules()
    {
        firstModule = new Module("Programming Concepts",
            "CO452");
        firstModule.setMark(70);
        secondModule = new Module("Game Design",
            "CO460");
            secondModule.setMark(75);
        thirdModule = new Module("Computer Architectures",
            "CO450");
            thirdModule.setMark(80);
        fourthModule = new Module("3d Modelling",
            "CO461");
            fourthModule.setMark(60);
    }
    /**
     * Prints the final grade and the marks for the modules for a student
     */
    public void printFinalGrades()
    {
        System.out.println("Final grade: " + finalGrade);
        firstModule.printModuleMark();
        secondModule.printModuleMark();
        thirdModule.printModuleMark();
        fourthModule.printModuleMark();
    }
    /**
     * Prints the details of the course and its modules
     */
    public void print()
    {
        System.out.println("Course name: " + title + ", course number: " + courseNumber);
        System.out.println("Modules:");
        firstModule.print();
        secondModule.print();
        thirdModule.print();
        fourthModule.print();
    }

}
