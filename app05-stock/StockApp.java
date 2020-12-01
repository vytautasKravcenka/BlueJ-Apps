
/**
 * This app provides a user interface to the
 * stock manager so that users can add, sell, make a delivery,
 * print, remove, search, restock stock products
 *
 * @author Vytautas Kravcenka
 * 24/11/2020
 */
public class StockApp
{
    public static final char CLEAR_CODE = '\u000C';

    public static final char ESC_CODE = 0x1B;
    
    public static final String ENTER_ID = "Enter a product ID";
    
    public static final String TYPE_CHOISE = "Type your choise";
    
    public static final String ENTER_NAME = "Enter the product name";

    // Use to get user input
    private InputReader input;

    private StockManager manager;

    private int lowStockAmount = 2;

    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        input = new InputReader();
        manager = new StockManager();
    }

    /**
     * Controls when the program stops and when asks for different methods.
     */
    public void run()
    {
        System.out.println(CLEAR_CODE);

        boolean finished = false;
        while(!finished)
        {
            printHeading();
            printMenuChoices();

            String choice = input.getString(TYPE_CHOISE);
            choice = choice.toUpperCase();

            if(choice.equals("QUIT"))
            {
                finished = true;
            }
            else
            {
                executeMenuChoice(choice);
            }
        }
    }
    
    /**
     * Finds which methods should be called
     */
    private void executeMenuChoice(String choice)
    {
        if(choice.equals("ADD"))
        {
            addProduct();
        }
        else if(choice.equals("REMOVE"))
        {
            removeProduct();
        }
        else if(choice.equals("DELIVERY"))
        {
            productDelivery();
        }
        else if(choice.equals("SELL"))
        {
            sellProduct();
        }
        else if(choice.equals("SEARCH"))
        {
            searchForProduct();
        }
        else if(choice.equals("RESTOCK"))
        {
            restockProducts();
        }
        else if(choice.equals("PRINTLOW"))
        {
            printLowStockProduct();
        }
        else if(choice.equals("PRINTALL"))
        {
            printAllProducts();
        }        
    }

    /**
     * Ask for user inputs to add an item to StockManager
     */
    private void addProduct()
    {
        System.out.println("\nAdding a new product");

        String name = input.getString(ENTER_NAME);

        int id = input.getInt(ENTER_ID);

        if(manager.isDuplicate(id) || manager.blankName(name))
        {
            System.out.println("Duplicate id or blank name, item not added!");
        }
        else
        {
            Product product = new Product(id, name);

            manager.addProduct(product);

            System.out.println("\nNew Product added " + product + "\n");

        }

    }

    /**
     * Ask for user inputs to remove an item from StockManager
     */
    private void removeProduct()
    {
        System.out.println("\nRemoving a product");

        int id = input.getInt(ENTER_ID);

        if(manager.isDuplicate(id))
        {
            Product product = manager.findProduct(id);
            System.out.println("\n" + product.getName() + " removed\n");
            manager.removeProduct(id);
        }
        else
        {
            System.out.println("No product with that ID!");
        }
    }

    /**
     * Ask for user inputs to deliver items to StockManager stock
     */
    private void productDelivery()
    {
        System.out.println("\nWaiting for product delivery");

        int id = input.getInt(ENTER_ID);

        int amount = input.getInt("Enter delivery amount");

        manager.delivery(id, amount);
    }

    /**
     * Ask for user inputs to sell an item from StockManagers stock
     */
    private void sellProduct()
    {
        System.out.println("\nSelling a product");

        int id = input.getInt(ENTER_ID);

        int amount = input.getInt("How many items to sell?");

        manager.sellProduct(id, amount);
    }

    /**
     * Searches stock for products with name
     */
    private void searchForProduct()
    {
        System.out.println("\nSearch for a product");

        String name = input.getString("Enter part of a product name");

        manager.printProductsWithName(name);
    }
    
    /**
     * Adds an amount to all low stock items
     */
    private void restockProducts()
    {
        System.out.println("\nRe-stocking low stock products");

        int amount = input.getInt("Enter amount to re-stock");
    }

    private void printLowStockProduct()
    {
        System.out.println("\nPrinting low stock products");

        lowStockAmount = input.getInt("Enter amount for low stock");

        manager.printLowStockProducts(lowStockAmount);
    }

    private void printAllProducts()
    {
        manager.printProductDetails();
    }

    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println();
        System.out.println("    Add:        Add a new product");
        System.out.println("    Remove:     Remove an old product");
        System.out.println("    Delivery:   Delivery of a product");
        System.out.println("    Sell:       Sell a product");
        System.out.println("    Search:     Search for a product");
        System.out.println("    ReStock:    Restock low stock products");
        System.out.println("    PrintAll:   Print all products");
        System.out.println("    PrintLow:   Print all products of low stock");
        System.out.println("    Quit:       Quit the program");
        System.out.println();        
    }

    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("******************************");
        System.out.println(" Stock Management Application ");
        System.out.println("    App05: by Vytautas");
        System.out.println("******************************");
    }
}