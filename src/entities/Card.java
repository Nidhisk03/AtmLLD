package entities;

public class Card {
    String name;
    String cardId;
    String pin;

    public Card(String pin, String cardId, String name) {
        this.pin = pin;
        this.cardId = cardId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCardId() {
        return cardId;
    }

    public String getPin() {
        return pin;
    }
}
