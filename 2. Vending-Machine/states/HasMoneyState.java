package states;

import machine.Product;
import machine.VendingMachine;

public class HasMoneyState implements State {
    
    VendingMachine vendingMachine;

    public HasMoneyState(VendingMachine vendingMachine) {
        
        this.vendingMachine = vendingMachine;
    }

    public void insertCash(int amount) {
        
        vendingMachine.getCashManagement().insertCash(amount);
        
        System.out.println("Balance updated. Current balance: " 
                           + vendingMachine.getCashManagement().getCurrentBalance());

    }

    public void selectProduct(int productId) {
        
        Product product = vendingMachine.getInventory().getProduct(productId);

        if (product == null) {
            System.out.println("Invalid product selection.");
            return;
        }

        int balance = vendingMachine.getCashManagement().getCurrentBalance();
        if (product.getPrice() > balance) {
            System.out.println("Insufficient funds. Please add " 
                               + (product.getPrice() - balance) + " more.");
            return;
        }

        if (vendingMachine.getInventory().getQuantity(productId) <= 0) {
            System.out.println("Product out of stock. Refunding...");
            vendingMachine.getCashManagement().refund();
            vendingMachine.setState(vendingMachine.getIdleState());
            return;
        }

        vendingMachine.setState(vendingMachine.getDispensingState());
        vendingMachine.getCurrentState().dispense();

    }

    public void cancel() {
        System.out.println("No money inserted. Nothing to cancel.");
    }

    public void dispense() {

        System.out.println("Cannot dispense. No money inserted.");
    }

}
