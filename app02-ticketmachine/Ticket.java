import java.util.Date;
/**
 * Write a description of class Ticket here.
 *
 * @author Vytautas Kravcenka
 * 10/14/2020
 */
public class Ticket
{
    
    private String destination;
    // full price in pound
    public float cost;
    private Date dateOfPurchase;

    /**
     * Constructor for objects of class Ticket
     */
    public Ticket(String travelDestination, float price)
    {
        destination = travelDestination;
        cost = price;
        dateOfPurchase = new Date();
    }
    
    public float getPrice()
    {
        return cost;
    }
    
    public String getDestination()
    {
     return destination;
    }
    
    
    public void print()
    {
        System.out.println("Destination: " + destination + ", Price: " +
        cost + "£");
    }
}
