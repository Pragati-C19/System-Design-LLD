package states;

import src.VendingMachine;

public class IdleState {

    VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        
        this.vendingMachine = vendingMachine;
    }

    public void insertCash(int amount) {
        
        System.out.println("Coin inserted: " + amount);
    }

    public void selectProduct(int productId) {
        System.out.println("Insert money first before selecting a product.");
    }

    public void cancel() {
        System.out.println("No money inserted. Nothing to cancel.");
    }

}
