import java.util.HashSet;
import java.util.Scanner;

/**
 * InputReader reads typed text input from the standard text terminal. 
 * The text typed by a user is returned.
 * 
 * @author     Michael Kölling and David J. Barnes
 * edited by Vytautas Kravcenka
 * @version    0.1.1 (2020.12.01)
 */
public class InputReader
{
    private Scanner reader;

    /**
     * Create a new InputReader that reads text from the text terminal.
     */
    public InputReader()
    {
        reader = new Scanner(System.in);
    }

    /**
     * Read a line of text from standard input (the text terminal),
     * and return it as a String.
     *
     * @return  A String typed by the user.
     */
    public String getString(String prompt)
    {
        System.out.print(prompt + "\n");
        System.out.print("> ");
        String inputLine = reader.nextLine();

        return inputLine;
    }

    /**
     * Read a line of text from standard input (the text terminal),
     * and return it as an int.
     */
    public int getInt(String prompt)
    {
        System.out.print(prompt + "\n");
        System.out.print("> ");         
        int number = reader.nextInt();

        return number;
    }    
}
