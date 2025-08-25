public class Main {
    
    public static void main(String[] args) {
        
        Inventory inventory = new Inventory();
        CashManagement cashManager = new CashManagement();
        
        Product coke = new Product(1, "Coke", 101,  40);
        Product pepsi = new Product(2, "Pepsi", 102, 30);
        Product chips = new Product(3, "Chips", 103, 20);
        Product water = new Product(4, "Water", 104, 10);

        // Print objects
        System.out.println("Product Details : ");
        System.out.println("\t" + coke);
        System.out.println("\t" + pepsi);
        System.out.println("\t" + chips);
        System.out.println("\t" + water);

        // Or check getters
        System.out.println("    - Pepsi price = Rs." + pepsi.getPrice());
        System.out.println("    - Water slot code = " + water.getCode());

    // ------------------------------------------------------------

        // Add product in inventory
        inventory.addProduct(coke, 5);
        inventory.addProduct(pepsi, 3);
        inventory.addProduct(chips, 7);

        System.out.println("Products added in Inventory");

        inventory.printInventory();

        // Try reducing product stock from inventory
        inventory.reduceQuantity(2);
        System.out.println("    - Pepsi left: " + inventory.getQuantity(2));


    // ------------------------------------------------------------

        System.out.println("Cash Management : ");
        // Insert money
        cashManager.insertCash(5);   // Accepted
        cashManager.insertCash(10);  // Accepted
        cashManager.insertCash(3);   // Not accepted (invalid denom)

        // Check balance
        System.out.println("    - Current Balance: Rs." + cashManager.getCurrentBalance());

        // Try deducting
        boolean success = cashManager.deduct(12);
        System.out.println("    - Deduct 12: " + success + ", Remaining Balance: Rs." + cashManager.getCurrentBalance());

        // Refund remaining balance
        cashManager.refund();
        System.out.println("    - Balance after refund: Rs." + cashManager.getCurrentBalance());

    // ------------------------------------------------------------
    
        VendingMachine vm = new VendingMachine();
        vm.sayHello();

    }
}
