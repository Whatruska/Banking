package main.webapp.Backend.Banking.Card;


import main.webapp.Backend.Executor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CardManager {
    private static final String INSERT_SQL = "INSERT INTO CARDS(CARD_NUM, CARD_VALUE) VALUES";
    private static final String SELECT_SQL = "SELECT * FROM CARDS";
    private static final String UPDATE_SQL = "UPDATE CARDS";
    private static final String DELETE_SQL = "DELETE FROM CARDS WHERE CARD_NUM=\"";

    public static void insertCard(Card card){
        try {
            Executor.execute(
                    INSERT_SQL + "(\"" + card.getCardNum() + "\", " + card.getValue() + ")"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Card getCardFormDB(String cardNum){
        Card result = null;
        try {
            ResultSet resultSet = Executor.executeSelect(
                    SELECT_SQL + " WHERE CARD_NUM=\"" + cardNum + "\""
            );
            while (resultSet.next()){
                String card_Num = resultSet.getString("CARD_NUM");
                Integer value = resultSet.getInt("CARD_VALUE");
                result = new Card(card_Num, value);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void updateCard(Card card){
        try {
            Executor.execute(
                    UPDATE_SQL + " SET CARD_VALUE=" + card.getValue() + " WHERE CARD_NUM=\"" + card.getCardNum() + "\""
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteCard(String cardNum){
        try {
            Executor.execute(
                    DELETE_SQL + cardNum + "\""
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getAllCardNum(){
        ArrayList<String> cardNums = new ArrayList<>();
        try {
            ResultSet resultSet = Executor.executeSelect(
              "SELECT CARD_NUM FROM CARDS"
            );
            while (resultSet.next()){
                cardNums.add(
                  resultSet.getString("CARD_NUM")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cardNums;
    }
}
