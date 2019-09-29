package main.webapp.Backend.Banking.Transaction;

import main.webapp.Backend.Banking.Card.CardManager;
import main.webapp.Backend.Executor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TransactionManager {
    private static final String INSERT_SQL = "INSERT INTO TRANSACTIONS(FROM_CARD_NUM, TO_CARD_NUM, VALUE, TIME_MARK) VALUES";
    private static final String SELECT_SQL = "SELECT * FROM TRANSACTIONS";

    public static void insertTransaction(Transaction transaction){
        try {
            Executor.execute(
                    INSERT_SQL + "(\"" + transaction.getFromCard().getCardNum() + "\", \"" + transaction.getToCard().getCardNum() +"\", \"" + transaction.getValue() +"\", \"" + transaction.getTimemark() + "\")"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Transaction> get_IN_Transactoins(String cardNum){
        ArrayList<Transaction> transactions = new ArrayList<>();
        try {
            ResultSet resultSet = Executor.executeSelect(
                    SELECT_SQL + " WHERE TO_CARD_NUM=\"" + cardNum + "\""
            );
            while (resultSet.next()){
                transactions.add(
                    createTransactionFromSet(resultSet)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    public static ArrayList<Transaction> get_OUT_Transactoins(String cardNum){
        ArrayList<Transaction> transactions = new ArrayList<>();
        try {
            ResultSet resultSet = Executor.executeSelect(
                    SELECT_SQL + " WHERE FROM_CARD_NUM=\"" + cardNum + "\""
            );
            while (resultSet.next()){
                transactions.add(
                        createTransactionFromSet(resultSet)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    private static Transaction createTransactionFromSet(ResultSet resultSet) throws SQLException {
        Transaction result = new Transaction(
                CardManager.getCardFormDB(resultSet.getString("FROM_CARD_NUM")),
                CardManager.getCardFormDB(resultSet.getString("TO_CARD_NUM")),
                resultSet.getInt("VALUE")
        );
        result.setTimemark(
                resultSet.getDate("TIME_MARK").toString()
        );
        return result;
    }
}
