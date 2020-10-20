import java.util.Scanner;

/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * 
 * Modified by Student Name
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private float balance = 0;
    // The total amount of money collected by this machine.
    private int total;

    private Ticket ticketToAylesbury;
    private Ticket ticketToAmersham;
    private Ticket ticketToHighWycombe;
    
    //The ticket customer is currently trying to buy
    private Ticket ticketToBuy;
    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine()
    {
        ticketToAylesbury = new Ticket ("Aylesbury", 2.2f);
        ticketToAmersham = new Ticket ("Amersham", 3f);
        ticketToHighWycombe = new Ticket ("High Wycombe", 3.3f);
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    private float getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertCoins(float amount)
    {
        if(amount == 0.1f || amount == 0.2f || amount == 1 || amount == 2) 
        {
            balance += amount;
            System.out.println("Coin entered: " + amount 
            + " Current balance: " + balance);
        }
        else 
        {
            System.out.println(
            "I'm sorry the ticket machine only accepts 0.1, 0.2, 1 and 2 coins");
        }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicketList()
    {
        
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println();
            ticketToAylesbury.print();
            System.out.println();
            ticketToAmersham.print();
            System.out.println();
            ticketToHighWycombe.print();
            System.out.println(); 
    }
    
    public void chooseTicketToBuy ()
    {
       System.out.println("Type: "); 
       System.out.println("1 for Aylesbury"); 
       System.out.println("2 for Amersham"); 
       System.out.println("3 for High Wycombe");
       Scanner scan = new Scanner(System.in);
       int choiseNumber = scan.nextInt();
       scan.close();
       whichTicketIsSelected (choiseNumber);
    }
    
    private void buyTicket()
    {
        if (ticketToBuy.cost < balance || ticketToBuy.cost == balance)
        {
            System.out.println("Ticket purchased");
            balance -= ticketToBuy.cost;
            System.out.println("Balance left: " + balance);
            if (balance > 0)
            System.out.println("refund excess money by clicking refundBalance");
        }
        else
        {
            System.out.println("too little balance to buy the ticket");
            System.out.println("add more coins or click refundBalance");
        }
    }
    
    private void whichTicketIsSelected (int choiseNumber)
    {
        if(choiseNumber == 1)
        {
           ticketToBuy = ticketToAylesbury;
           System.out.println("Ticket selected: ");
           ticketToAylesbury.print();
           buyTicket();
        }
        else if(choiseNumber == 2)
        {
           ticketToBuy = ticketToAmersham;
           System.out.println("Ticket selected: ");
           ticketToAmersham.print();
           buyTicket();
        }
        else if(choiseNumber == 3)
        {
           ticketToBuy = ticketToHighWycombe;
           System.out.println("Ticket selected: ");
           ticketToHighWycombe.print();
           buyTicket();
        }
        else
           System.out.println("Sorry there is no ticket available under number " + choiseNumber);
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public void refundBalance()
    {
        System.out.println("refunded: " + balance);
        balance = 0;
    }
}
