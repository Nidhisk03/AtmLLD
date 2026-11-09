package state;

import atm.ATMMachine;
import entities.Card;
import entities.Operations;

public class AuthenticatedState implements ATMState{
    @Override
    public void insertCard(ATMMachine atmMachine, Card card) {
         System.out.println("Card already Inserted");
    }

    @Override
    public void enterPin(ATMMachine atmMachine, String pin) {
        System.out.println("Card is already Authenticated");
    }

    @Override
    public void selectOperation(ATMMachine atmMachine, Operations operations,int amount) {
           if(Operations.CHECK_BALANCE.equals(operations)){
                 atmMachine.getBalanceOfCurrentCard();
           }else if(Operations.WITHDRAW_CASH.equals(operations)){
                 atmMachine.withdraw(amount);
           }else if(Operations.DEPOSIT_CASH.equals(operations)){
                 atmMachine.deposit(amount);
           }

        System.out.println("Transaction complete.");
        ejectCard(atmMachine);

    }

    @Override
    public void ejectCard(ATMMachine atmMachine) {
        System.out.println("Ending session. Card has been ejected. Thank you for using our ATM.");
        atmMachine.setCurrentCard(null);
        atmMachine.setCurrentState(new IdealState());
    }
}
