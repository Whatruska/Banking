package main.webapp.Backend.Banking.Transaction;

import main.webapp.Backend.Banking.Card.Card;
import main.webapp.Backend.Banking.Managers.CardManager;
import main.webapp.Backend.Banking.Managers.TransactionManager;

public class Transaction {
    private Card fromCard;
    private Card toCard;
    private Integer value;
    private String timemark;

    public static final int SUCCESS = 0;
    public static final int ERROR = 1;

    public Transaction(Card fromCard, Card toCard, Integer value) {
        this.fromCard = fromCard;
        this.toCard = toCard;
        this.value = value;
    }

    public void setTimemark(String timestamp) {
        this.timemark = timestamp;
    }

    public String getTimemark() {
        return timemark;
    }

    public Card getFromCard() {
        return fromCard;
    }

    public Card getToCard() {
        return toCard;
    }

    public Integer getValue() {
        return value;
    }

    public int performTransaction(){
        int status = SUCCESS;
        if (fromCard.getValue() < value){
            status = ERROR;
        } else {
            //Making transaction...
            fromCard.setValue(fromCard.getValue() - value);
            toCard.setValue(toCard.getValue() + value);

            CardManager.updateCard(fromCard);
            CardManager.updateCard(toCard);

            timemark = TransactionDate.getCurrentDate();
            TransactionManager.insertTransaction(this);
        }
        return status;
    };

    public String toString(){
        String result = "";
        result += "From card : " + fromCard.getCardNum() + "\n";
        result += "To card : " + toCard.getCardNum() + "\n";
        result += "Value : " + value + "\n";
        return result;
    }
}
