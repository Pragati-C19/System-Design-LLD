package states;

import machine.Product;
import machine.VendingMachine;

public class IdleState implements State{

    VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        
        this.vendingMachine = vendingMachine;
    }

    public void insertCash(int amount) {
        
        // System.out.println("Coin inserted: " + amount);
        
        vendingMachine.getCashManagement().insertCash(amount);
        
        System.out.println("Inserted: " + amount + ". Balance = " 
                           + vendingMachine.getCashManagement().getCurrentBalance());
        
        vendingMachine.setState(vendingMachine.getHasMoneyState());

    }

    public void selectProduct(int productId) {
        System.out.println("Insert money first before selecting a product.");
    }

    public void cancel() {
        System.out.println("No money inserted. Nothing to cancel.");
    }

    public void dispense(Product product) {

        System.out.println("Cannot dispense. No money inserted.");
    }

}
