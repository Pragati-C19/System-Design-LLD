public class VendingMachine {
    
    public static void main(String[] args) {
        
        Product coke = new Product(1, "Coke", 101,  40);
        Product pepsi = new Product(2, "Pepsi", 102, 30);
        Product chips = new Product(3, "Chips", 103, 20);
        Product water = new Product(4, "Water", 104, 10);

        // Print objects
        System.out.println(coke);
        System.out.println(pepsi);
        System.out.println(chips);
        System.out.println(water);

        // Or check getters
        System.out.println("Pepsi price = Rs." + pepsi.getPrice());
        System.out.println("Water slot code = " + water.getCode());
    }
}
