import states.IdleState;
import states.State;

public class VendingMachine {

    State idleState;
    State hasMoneyState;
    State dispensingState;
    State outOfStockState;
    State currentState;

    Inventory inventory;
    CashManagement CashManagement;

    public VendingMachine() {
        inventory = new Inventory();
        CashManagement = new CashManagement();

        idleState = new IdleState(this);
        hasMoneyState = new HasMoneyState(this); // will implement soon
        dispensingState = new DispensingState(this); // will implement soon
        outOfStockState = new OutOfStockState(this); // will implement soon

        currentState = idleState; // default
    }

    // Insert Cash in vending Machine
    public void insertCash(int amount) {

        currentState.insertCash(amount);
    }

    // Select Product which user want to buy
    public void selectProduct(int productId) {

        currentState.selectProduct(productId);
    }

    // Cancel any Purchase or any Product
    public void cancel() {

        currentState.cancel();
    }

    // Set State Interface
    public void setState(State state) {
        currentState = state;
    }

    // Check idleState
    public State getIdleState() {
        return idleState;
    }

    // check Has Money state
    public State getHasMoneyState() {
        return hasMoneyState;
    }

    // Check dispensing State
    public State getDispensingState() {
        return dispensingState;
    }

    // Check outofStockState 
    public State getOutOfStockState() {
        return outOfStockState;
    }

    // Check CashManagement details
    public CashManagement getCashManagement() {
        return CashManagement;
    }

    // Check inventory for that product
    public Inventory getInventory() {
        return inventory;
    }
}
