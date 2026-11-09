package state;

import atm.ATMMachine;
import entities.Card;
import entities.Operations;

public class IdealState implements ATMState{


    @Override
        public void insertCard(ATMMachine atmMachine, Card card) {
        if (card == null) {
            System.out.println("Please provide a valid card.");
            return;
        }

        if(atmMachine.getBankService().getCard(card.getCardId())==null){
            System.out.println("Card not inserted please enter it.");
        }

        System.out.println("Card Inserted Successfully....");
        atmMachine.setCurrentCard(card);
        atmMachine.setCurrentState(new CardInsertedState());
    }

    @Override
    public void enterPin(ATMMachine atmMachine, String pin) {
         System.out.println("Please insert the card");
    }

    @Override
    public void selectOperation(ATMMachine atmMachine, Operations operations,int amount) {
        System.out.println("Please insert the card");
    }

    @Override
    public void ejectCard(ATMMachine atmMachine) {
        System.out.println("Card not found, card ejected.");
        atmMachine.setCurrentCard(null);
    }
}
