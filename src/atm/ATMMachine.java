package atm;

import dispenser.Dispense100;
import dispenser.Dispense20;
import dispenser.Dispense50;
import dispenser.DispenserHandler;
import entities.*;
import state.ATMState;
import state.IdealState;

public class ATMMachine {

    private static final ATMMachine machine = new ATMMachine();

    ATMState currentState;
    Card currentCard;
    BankService bankService = BankService.getInstace();
    CashDispensor dispensor;

  private  ATMMachine()
    {
        this.currentState = new IdealState();
        DispenserHandler handler100 = new Dispense100(10);
        DispenserHandler handler50 = new Dispense50(20);
        DispenserHandler handler20 = new Dispense20(30);
        handler100.setNext(handler50);
        handler50.setNext(handler20);
        dispensor = new CashDispensor(handler100);
    }

  public static ATMMachine getInstance(){
      return machine;
    }
    public  void getBalanceOfCurrentCard(){
      if(currentCard==null){
          System.out.println("Please first insert the card"); return;
      }
        bankService.getBalance(currentCard);
    }
    public void insertCard(ATMMachine atmMachine, Card card){
       currentState.insertCard(this,card);
    }
    public void enterPin(String pin){
      currentState.enterPin(this,pin);
    }
    public void selectOperation(ATMMachine atmMachine, Operations operations, int amount){
      currentState.selectOperation(atmMachine,operations,amount);
    }
    public void ejectCard(ATMMachine machine){
       currentState.ejectCard(machine);
    }

    public void withdraw(int amount){
          if(!dispensor.canDispense(amount)){
              System.out.println("Insufficient cash available in the ATM.");
          }
          bankService.withdrawMoney(currentCard,amount);
        try {
            dispensor.dispense(amount);
        } catch (Exception e) {
            bankService.depositMoney(currentCard, amount); // Deposit back if dispensing fails
        }
       bankService.getBalance(currentCard);
    }
    public void deposit(int amount){
        bankService.depositMoney(currentCard,amount);
        bankService.getBalance(currentCard);
    }



    public void setCurrentState(ATMState currentState) {
        this.currentState = currentState;
    }

    public BankService getBankService() {
        return bankService;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }


}
