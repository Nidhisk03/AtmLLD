package state;


import atm.ATMMachine;
import entities.Card;
import entities.Operations;

public interface ATMState {

     void insertCard(ATMMachine atmMachine, Card card);
     void enterPin(ATMMachine atmMachine,String pin);
     void selectOperation(ATMMachine atmMachine, Operations operations, int amount);
     void ejectCard(ATMMachine atmMachine);
}
