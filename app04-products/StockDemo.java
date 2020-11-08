import java.util.Random;
/**
 * Runs a fast test using Product and StockManager classes.
 * 
 * @author Vytautas Kravcenka.
 * 11/08/2020
 */
public class StockDemo
{
    // The stock manager.
    private StockManager manager;
    private Random generator = new Random();
    private int amount = 0;    
    /**
     * Create a StockManager and populate it with a 12
     * sample products for test.
     */
    public StockDemo(StockManager manager)
    {
        this.manager = manager;

        manager.addProduct(new Product(101, "Samsung Galaxy S20"));
        manager.addProduct(new Product(102, "Apple iPhone 12"));
        manager.addProduct(new Product(103, "Google Pixel 1A"));
        manager.addProduct(new Product(104, "Samsung Galaxy S10"));
        manager.addProduct(new Product(105, "Apple iPhone 10"));
        manager.addProduct(new Product(106, "Google Pixel 2B"));
        manager.addProduct(new Product(107, "Samsung Galaxy S8"));
        manager.addProduct(new Product(108, "Apple iPhone 8"));
        manager.addProduct(new Product(109, "Google Pixel 3C"));
        manager.addProduct(new Product(110, "Samsung Galaxy S7"));
        manager.addProduct(new Product(111, "Apple iPhone 6"));
        manager.addProduct(new Product(112, "Google Pixel 4D"));
    }

    /**
     * Provide a very simple demonstration of how a StockManager
     * might be used. 
     * Accepts delivery various quantities of existing products
     * Sells quantities of products from stock
     * Renames a product from the stock list based on ID
     * Removes a product from the stock list based on ID
     * Prints a list of all products and their stock levels
     * Prints a list of products based on part of the product name
     * Print a list of products whose stock levels are low (3 and less)
     */
    public void runDemo()
    {

        manager.printProductDetails();

        int noProducts = manager.numberOfProducts();

        System.out.println("No of Products in Stock = " + noProducts);

        demoDeliverProducts();

        demoSellProducts();

        demoRenameProducts();

        demoRemoveProducts();

        demoProductsWithName();

        manager.printLowStockProducts();
    }

    /** 
     * Accepts delivery various quantities of existing products
     */
    private void demoDeliverProducts()
    {
        System.out.println("\nDelivering all the products\n");

        for(int id = 101; id <= 112; id++)
        {
            amount = generator.nextInt(8);
            manager.delivery(id, amount); 
        }

        manager.printProductDetails();        
    }

    /**
     * Sells quantities of products from stock
     */
    private void demoSellProducts()
    {
        System.out.println("\nSelling the products\n");

        for(int id = 101; id <= 112; id++)
        {
            amount = generator.nextInt(4);
            manager.sellProduct(id, amount); 
        }

        manager.printProductDetails();      
    }

    /**
     * Renames a product from the stock list based on ID
     */
    private void demoRenameProducts()
    {
        int randomNumber = generator.nextInt(116-98+1) + 100;
        manager.renameProduct(randomNumber, "changed name");
    }

    /**
     * Removes a product from the stock list based on ID
     */
    private void demoRemoveProducts()
    {
        int randomNumber = generator.nextInt(116-98+1) + 100;
        manager.removeProduct(randomNumber);
    }

    /**
     * Prints a list of products based on part of the product name
     */
    private void demoProductsWithName()
    {
        manager.printProductsWithName("Samsung");
        manager.printProductsWithName("Huawei");
    }   

    /**
     * @return The stock manager.
     */
    public StockManager getManager()
    {
        return manager;
    }
}
