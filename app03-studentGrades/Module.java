
/**
 * The Module class represents one of courses modules. It stores
 * the title, code number and mark of teh module, it also tells if the module is completed.
 * It can set/get mark, print module details or just modules marks.
 *
 * author Vytautas Kravcenka
 * 10/27/2020
 */
public class Module
{
    // The module name
    private String title;
    // The module code number
    private String codeNo;
    // The module mark
    private int mark;
    // The boolean that shows whether or not the module is complete
    private boolean completed;
    /**
     * Create a new module with a given title and code number.
     */
    public Module(String title, String codeNumber)
    {
        mark = 0;
        this.title = title;
        codeNo = codeNumber;
        completed = false;
    }
    /**
     * Awards a percentage mark to a module
     */
    public void setMark(int mark)
    {
        if(mark >=0 && mark<= 100)
        {this.mark = mark;
        if (mark >= 40) completed = true;
    }
    }
    /**
     * Simple get mark 
     */
    public int getMark()
    {
        return mark;
    }
    /**
     * Returns whether or not the module is complete
     */
    public boolean isCompleted()
    {
        return completed;
    }
    /**
     * Prints module details
     */
    public void print()
    {
        System.out.println("Module title: " + title + ", module code: " +  codeNo +
            ", percentage mark: " + mark + "%");
    }
    /**
     * Prints module mark
     */
    public void printModuleMark()
    {
        System.out.println(title + " mark: " + mark + "%");
    }

}
