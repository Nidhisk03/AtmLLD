import atm.ATMMachine;
import entities.Account;
import entities.BankService;
import entities.Card;
import entities.Operations;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    ATMMachine machine = ATMMachine.getInstance();

    machine.getBankService().createCard("1234","5446-7000","Nidhi");
    machine.getBankService().createAccount("1234-5677",5000);

    machine.getBankService().linkCardToAccount("5446-7000","1234-5677");

    Card card = machine.getBankService().getCard("5446-7000");
    Account account = machine.getBankService().getAccountByCardNumber("5446-7000");

    System.out.println(card.getName());
    System.out.println(account.getBalance());

    machine.getBalanceOfCurrentCard();

    machine.insertCard(machine,card);
    System.out.println(machine.getCurrentCard().getName());
    machine.enterPin("1234");
    //machine.selectOperation(machine, Operations.CHECK_BALANCE,500);
    //machine.selectOperation(machine, Operations.DEPOSIT_CASH,500);
    machine.ejectCard(machine);




}
