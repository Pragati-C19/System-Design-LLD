package states;

import machine.Product;
import machine.VendingMachine;

public class OutOfStockState implements State{

    VendingMachine vendingMachine;

    public OutOfStockState(VendingMachine vendingMachine) {
        
        this.vendingMachine = vendingMachine;
    }

    public void insertCash(int amount) {
        
        System.out.println("Product out of stock. Returning your money.");

        vendingMachine.getCashManagement().refund();

        // return to idleState
        vendingMachine.setState(vendingMachine.getIdleState());
    }

    public void selectProduct(int productId) {

       System.out.println("Product is out of stock. Please choose another product.");
    }

    public void cancel() {
        
        System.out.println("Cancelling transaction. Returning your money.");
        vendingMachine.getCashManagement().refund();

        // return to idleState
        vendingMachine.setState(vendingMachine.getIdleState());
    }

    public void dispense(Product product) {

        System.out.println("Cannot dispense. Product is out of stock.");
    }

}
