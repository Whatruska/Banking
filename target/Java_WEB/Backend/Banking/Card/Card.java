package main.webapp.Backend.Banking.Card;

public class Card {
    private String cardNum;
    private Integer value;

    public Card() {
        cardNum = CardNumGen.genNum();
        value = 5000;
    }

    public Card(String cardNum, Integer value) {
        this.cardNum = cardNum;
        this.value = value;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String toString() {
        String result = "";
        result += "Card number : " + cardNum + "\n";
        result += "Card value : " + value;
        return result;
    }
}
