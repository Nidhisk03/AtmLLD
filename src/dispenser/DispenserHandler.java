package dispenser;

public interface DispenserHandler {

    void setNext(DispenserHandler handler);
    void dispense(int amount);
    boolean canDispense(int amount);

}
