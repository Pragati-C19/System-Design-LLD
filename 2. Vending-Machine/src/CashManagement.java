package src;
import java.util.*;

public class CashManagement {

    Map<Integer, Integer> cashInventory; // Cash -> count
    int currentBalance; // balance inserted by customer

    public CashManagement() {
        
        cashInventory = new HashMap<>();
        currentBalance = 0;
        
        // Initialize with some coins/notes (we need money in vending machine if it needs to give change to customer)
        cashInventory.put(1, 10);
        cashInventory.put(2, 10);
        cashInventory.put(5, 10);
        cashInventory.put(10, 10);
    }

    // Insert money (by user)
    public void insertCash(int amount) {
        
        if (!cashInventory.containsKey(amount)) {
            
            System.out.println("\tMachine does not accept this denomination: " + amount);
            return;
        }

        cashInventory.put(amount, cashInventory.get(amount) + 1);

        currentBalance += amount;
        System.out.println("\tInserted Rs." + amount + " | Current balance: Rs." + currentBalance);

        return;
    }

    // Get current balance (For customer to see how much money he has to give for i=his purchase)
    public int getCurrentBalance() {
        
        return currentBalance;
    }

    // Deduct amount for product purchase
    public boolean deduct(int price) {
        
        if (currentBalance < price) {
            return false; // insufficient
        }
        
        currentBalance -= price;
        return true;
    }

    // Return remaining balance as change
    public int refund() {
        
        int refund = currentBalance;
        
        currentBalance = 0;
        
        System.out.println("\tRefunded Rs." + refund);
        return refund;
    }

}
