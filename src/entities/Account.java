package entities;

import java.util.HashMap;

public class Account {
    String accountNumber;
    int balance;
    HashMap<String, Card> cards = new HashMap<>();

    public Account(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void debit(int amount){
        System.out.println("Money debited form "+accountNumber+ " Rs."+amount);
        balance = balance-amount;
    }
    void credit(int amount){
        System.out.println("Money credited to "+accountNumber+ " Rs."+amount);
        balance=  amount+balance;
    }

   public void addCard(Card card){
        cards.put(card.getCardId(), card);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public HashMap<String, Card> getCards() {
        return cards;
    }
}
