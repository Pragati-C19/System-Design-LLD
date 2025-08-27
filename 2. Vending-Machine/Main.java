import java.util.Scanner;

import machine.CashManagement;
import machine.Inventory;
import machine.Product;
import machine.VendingMachine;

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

        System.out.println("------------------------------------------------------------"); 


        // Add product in inventory
        inventory.addProduct(coke, 5);
        inventory.addProduct(pepsi, 3);
        inventory.addProduct(chips, 7);

        System.out.println("Products added in Inventory");

        inventory.printInventory();

        // Try reducing product stock from inventory
        inventory.reduceQuantity(2);
        System.out.println("    - Pepsi left: " + inventory.getQuantity(2));


        System.out.println("------------------------------------------------------------"); 


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

        System.out.println("------------------------------------------------------------"); 
    

        VendingMachine vendingMachine = new VendingMachine();
        
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Vending Machine!");

        while (running) {
            System.out.println("\nCurrent State: " + vendingMachine.getCurrentStateName());
            System.out.println("Choose an action:");
            System.out.println("1. Insert Cash");
            System.out.println("2. Select Product");
            System.out.println("3. Cancel Transaction");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to insert: ");
                    int amount = scanner.nextInt();
                    vendingMachine.insertCash(amount);
                    break;
                case 2:
                    System.out.print("Enter product ID to select: ");
                    int productId = scanner.nextInt();
                    vendingMachine.selectProduct(productId);
                    break;
                case 3:
                    vendingMachine.cancel();
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using the vending machine!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");

            }

            }

        scanner.close();

    }
}
