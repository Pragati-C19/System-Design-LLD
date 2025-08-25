package states;

import machine.VendingMachine;
import machine.Product;

public class DispensingState implements State{

    VendingMachine vendingMachine;

    public DispensingState(VendingMachine vendingMachine) {
        
        this.vendingMachine = vendingMachine;
    }

    public void insertCash(int amount) {
        System.out.println("Please wait, dispensing in progress...");
    }

    public void selectProduct(int productId) {
        System.out.println("Dispensing in progress... can't select now.");
    }

    public void cancel() {
        System.out.println("Cannot cancel now, already dispensing.");
    }

    public void dispense(Product product) {

        System.out.println("Dispensing " + product.getName() + "...");

        // Deduct 1 quantity
        vendingMachine.getInventory().reduceQuantity(product.getId());

        // Deduct balance & return change
        int price = product.getPrice();
        int inserted = vendingMachine.getCashManagement().getCurrentBalance();

        if (inserted > price) {
            int change = inserted - price;
            System.out.println("Returning change: ₹" + change);
            vendingMachine.getCashManagement().refundChange(change);
        }

        vendingMachine.getCashManagement().resetBalance();

        // Back to idle State
        vendingMachine.setState(vendingMachine.getIdleState());
    }

}
