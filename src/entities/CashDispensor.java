package entities;

import dispenser.DispenserHandler;

public class CashDispensor
{

    DispenserHandler chain;

    public CashDispensor(DispenserHandler chain) {
        this.chain = chain;
    }

  public   void dispense(int amount){
        this.chain.dispense(amount);
    }

  public   boolean canDispense(int amount){
        if (amount % 10 != 0) {
            return false;
        }
        return chain.canDispense(amount);
    }

}
