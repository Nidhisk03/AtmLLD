package state;

import atm.ATMMachine;
import entities.Card;
import entities.Operations;

public class CardInsertedState implements ATMState{
    @Override
    public void insertCard(ATMMachine atmMachine, Card card) {
          System.out.println("Card already Inserted");
    }

    @Override
    public void enterPin(ATMMachine atmMachine, String pin) {
         if(pin.equals(atmMachine.getCurrentCard().getPin())){
             System.out.println("Pin Accepted.");
             atmMachine.setCurrentState(new AuthenticatedState());
        }
        else{
            System.out.println("Wrong pin inserted.");
            ejectCard(atmMachine);
         }
    }

    @Override
    public void selectOperation(ATMMachine atmMachine, Operations operations,int amount) {
             System.out.println("Please enter the pin.");
    }

    @Override
    public void ejectCard(ATMMachine atmMachine) {
        System.out.println("Incorrect pin entered, card ejected.");
        atmMachine.setCurrentCard(null);
        atmMachine.setCurrentState(new IdealState());
    }
}
