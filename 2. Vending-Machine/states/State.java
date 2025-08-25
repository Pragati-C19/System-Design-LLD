package states;

public interface State {

    void insertCash(int amount);

    void selectProduct(int productId);

    void cancel();
    
    void dispense();
}

