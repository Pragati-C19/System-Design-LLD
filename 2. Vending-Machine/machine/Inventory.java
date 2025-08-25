package machine;
import java.util.*;

public class Inventory {
    
    Map<Integer, Integer> productQuantities; // productId -> quantity
    Map<Integer, Product> productCatalog;    // productId -> product details

    public Inventory() {
        
        productQuantities = new HashMap<>();
        productCatalog = new HashMap<>();
    }

    // Add new Product in Inventory
    public void addProduct(Product product, int quantity) {
        
        // Get Product Id from Product class
        int productId = product.getId();

        // Get Product Quantity so far
        int prevProductQuantity = productQuantities.getOrDefault(productId, 0);

        productCatalog.put(productId, product);
        
        productQuantities.put(productId, prevProductQuantity + quantity);

        return;
    }

    // Check if product is available or not 
    public boolean isAvailable(int productId) {
        
        // Get Product Quantity so far
        int prevProductQuantity = productQuantities.getOrDefault(productId, 0);

        if (prevProductQuantity > 0) {
            
            return true;
        }

        return false;
    }


    // Get that product details 
    public Product getProduct(int productId) {
        
        return productCatalog.get(productId);
    }


    // After buying product we need to reduce quantity from our data 
    public void reduceQuantity(int productId) {
        
        if (isAvailable(productId)) {
            productQuantities.put(productId, productQuantities.get(productId) - 1);
        }

        return;
    }


    // Get product Quantity
    public int getQuantity(int productId) {
        
        return productQuantities.getOrDefault(productId, 0);
    }

    // IF admin want to see full inventory details print it 
    public void printInventory() {
        
        System.out.println("Inventory Details : ");
        
        for (Integer productId : productCatalog.keySet()) {
            
            Product product = productCatalog.get(productId);
            int qty = getQuantity(productId);
            
            System.out.println("\t" + product.getName() + " (Rs." + product.getPrice() + ") -> " + qty + " left");
        }

        return;
    }

}
