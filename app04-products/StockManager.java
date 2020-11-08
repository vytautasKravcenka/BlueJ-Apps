import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * This class can: 
 * Accepts delivery various quantities of existing products
 * Sells quantities of products from stock
 * Renames a product from the stock list based on ID
 * Removes a product from the stock list based on ID
 * Prints a list of all products and their stock levels
 * Prints a list of products based on part of the product name
 * Print a list of products whose stock levels are low (3 and less)
 * 
 * @author Vytautas Kravcenka
 * 11/08/2020
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     */
    public void addProduct(Product item)
    {
        stock.add(item);
    }

    public void removeProduct(int id)
    {
        stock.remove(getProduct(id));
    }

    public void renameProduct(int id, String name)
    {
        getProduct(id).setName(name);
    }

    /**
     * Show details of the given product. If found,
     * its name and stock quantity will be shown.
     */
    public void showDetails(int id)
    {
        Product product = getProduct(id);

        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }

    /**
     * Get the product with the given id from the manager.
     * An error message is printed if there is no match.
     */
    public Product getProduct(int id)
    {
        Product product = findProduct(id);

        if(product == null) 
        {
            System.out.println("Product with ID: " + id +
                " is not recognised.");
        }
        return product;
    }

    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     */
    public void delivery(int id, int amount)
    {
        Product product = findProduct(id);  

        if(product != null)
        {
            product.deliver(amount);
        }
        else
        {
            System.out.println("\nCannot find product with " + id + " id\n");   
        }
    }

    /**
     * Selling of a particular product.
     * Decrease the quantity of the product by the given amount.
     */
    public void sellProduct(int id, int quantity)
    {
        Product product = findProduct(id);  

        if(product != null)
        {
            product.sell(quantity);
        }
    }

    /**
     * Try to find a product in the stock with the given id.
     */
    public Product findProduct(int id)
    {
        for(Product product : stock)
        {
            if(product.getID() == id) return product;
        }
        return null;
    }

    public int numberOfProducts()
    {
        return stock.size();
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        printHeading();

        for(Product product : stock)
        {
            System.out.println(product);
        }
    }

    /**
     * Searches for  matching names in product list then
     * prints details of all the products matching it.
     */
    public void printProductsWithName(String partOfProductName)
    {
        System.out.println("\nPrinting searched products:");
        System.out.println("\nSearch word: " + partOfProductName + "\n");
        boolean printedAtleastOneName = false;
        for(Product product : stock)
        {
            int temporaryMatchingLetterNumber = 0;
            char[] productName = product.getName().toCharArray();
            int i = 0;
            for(char ch : partOfProductName.toCharArray())
            {
                if(productName[i] == ch)
                    temporaryMatchingLetterNumber ++;
                i++;
            }
            if(temporaryMatchingLetterNumber == partOfProductName.length())
            {
                System.out.println(product);
                printedAtleastOneName = true;
            }
        }
        if (printedAtleastOneName == false)
            System.out.println("No products match the search\n");
    }

    /**
     * Print details of all the products with stock of 3 an less.
     */
    public void printLowStockProducts()
    {
        System.out.println("\nPrinting low stock products:\n");
        boolean printedAtleastOneName = false;
        for(Product product : stock)
        {
            if(product.getQuantity() <= 3)
            {
                System.out.println(product);
                printedAtleastOneName = true;
            }
        }
        if (!printedAtleastOneName)
            System.out.println("\nNo products with low stock level\n");
    }

    /**
     * Print heading for better looks.
     */
    public void printHeading()
    {
        System.out.println("\nPrinting Jeff's Stock List");
        System.out.println("=================\n");
    }
}
