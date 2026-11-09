package entities;

import java.util.HashMap;

public class BankService {

    final static BankService service = new BankService();

    HashMap<String,Card> cardHashMap = new HashMap<>();
    HashMap<String,Account> accountHashMap = new HashMap<>();
    HashMap<String,String> cardToAccount = new HashMap<>();

    private BankService(){

    }

    public static BankService getInstace(){
        return service;
    }

    public void createCard(String pin,String cardId, String name){
        Card card = new Card(pin,cardId,name);
        cardHashMap.put(cardId,card);
    }

    public void createAccount(String accountNumber, int balance){
        Account account = new Account(accountNumber,balance);
        accountHashMap.put(accountNumber,account);
    }

    public  void linkCardToAccount(String cardNumber, String accountNumber){
        Account account = accountHashMap.get(accountNumber);
        account.getCards().put(cardNumber,cardHashMap.get(cardNumber));
        cardToAccount.put(cardNumber,accountNumber);
    }

    public  boolean authentiate(Card card , String pin)
    {  return card.getPin().equals(pin);
    }

    public Card getCard(String cardNumber){
        return cardHashMap.get(cardNumber);
    }

    public Account getAccountByCardNumber(String cardNumber){
        String string = cardToAccount.get(cardNumber);
        return (accountHashMap.get(string));
    }


    public void getBalance(Card card){

      System.out.println("Current Balance of card is "+  accountHashMap.get(cardToAccount.get(card.getCardId())).getBalance());
    }

    public  void withdrawMoney(Card card , int amount)
    {
         accountHashMap.get(cardToAccount.get(card.getCardId())).debit(amount);
    }
    public void depositMoney(Card card , int amount)
    {
        accountHashMap.get(cardToAccount.get(card.getCardId())).credit(amount);
    }


}
