package src;
public class Product {
    
    int productId;
    String productName;
    int productCode;
    int productPrice;

    public Product (int id, String name, int code, int price) {

        productId = id;
        productName = name;
        productCode = code;
        productPrice = price;

    }

    // Get Product id
    public int getId() {

        return productId;
    }

    // Get Product Name
    public String getName() {

        return productName;
    }

    // Get Product Code
    public int getCode() {

        return productCode;
    }

    // Get Product Price
    public int getPrice() {

        return productPrice;
    } 


    // To check if we are getting correct product details wrote print statement
    @Override
    public String toString() {

        return "Product { id= " + productId + ", name= '" + productName + "', code= " + productCode + ", price= " + productPrice + " }";
    }
}
