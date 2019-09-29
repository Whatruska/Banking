package main.webapp.Backend.Banking.Client;

import main.webapp.Backend.Banking.SoftManager;
import main.webapp.Backend.Executor;
import main.webapp.Backend.Banking.Card.CardManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class ClientManager {
    private static final String INSERT_SQL = "INSERT INTO CLIENTS(NAME, SURNAME, CARD_NUM, IS_ADMIN, PHONE, PASSWORD, GENDER, BIRTHDATE, AGE) VALUES";
    private static final String SELECT_SQL = "SELECT * FROM CLIENTS";
    private static final String UPDATE_SQL = "UPDATE CLIENTS";
    private static final String DELETE_SQL = "DELETE FROM CLIENTS WHERE CARD_NUM=\"";

    public static void insertClient(Client client){
        try {
            Executor.execute(
                    INSERT_SQL + "(\"" + client.getName() + "\", \"" + client.getSurname() + "\", \"" + client.getCardNum() + "\", " + client.isAdmin() + ", \"" + client.getPhone() + "\", \"" + client.getPassword() + "\", \"" + client.getGender() + "\", \"" + SoftManager.dateToString(client.getBirthdate()) + "\", " + client.getAge() + ")"
            );
            CardManager.insertCard(client.getCard());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getAllPhones(){
        ArrayList<String> phones = new ArrayList<>();
        try {
            ResultSet resultSet = Executor.executeSelect(
                    "SELECT PHONE FROM CLIENTS"
            );
            while (resultSet.next()){
                phones.add(
                        resultSet.getString("PHONE")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phones;
    }

    public static Client getClientFormDBbyID(Integer id){
        Client result = null;
        try {
            ResultSet resultSet = Executor.executeSelect(
                    SELECT_SQL + " WHERE ID=" + id
            );
            while (resultSet.next()){
                result = createClientFromSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Client getClientFormDBbyCardNum(String cardNum){
        Client result = null;
        try {
            ResultSet resultSet = Executor.executeSelect(
                    SELECT_SQL + " WHERE CARD_NUM=\"" + cardNum + "\""
            );
            while (resultSet.next()){
                result = createClientFromSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Client getClientFormDBbyPhone(String phone){
        Client result = null;
        try {
            ResultSet resultSet = Executor.executeSelect(
                    SELECT_SQL + " WHERE PHONE=\"" + phone + "\""
            );
            while (resultSet.next()){
                result = createClientFromSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void updateName(Client client){
        try {
            Executor.execute(
                    UPDATE_SQL + " SET NAME=\"" + client.getName() + "\" WHERE PHONE=\"" + client.getPhone() + "\""
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateSurname(Client client){
        try {
            Executor.execute(
                    UPDATE_SQL + " SET SURNAME=\"" + client.getSurname() + "\" WHERE PHONE=\"" + client.getPhone() + "\""
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateCard(Client client){
        try {
            Executor.execute(
                    UPDATE_SQL + " SET CARD_NUM=\"" + client.getCard().getCardNum() + "\" WHERE PHONE=\"" + client.getPhone() + "\""
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateAdmin(Client client){
        try {
            Executor.execute(
                    UPDATE_SQL + " SET IS_ADMIN=" + client.isAdmin() + " WHERE PHONE=\"" + client.getPhone() + "\""
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePhone(Client client){
        try {
            Executor.execute(
                    UPDATE_SQL + " SET PHONE=\"" + client.getPhone() + "\" WHERE CARD_NUM=\"" + client.getCard().getCardNum() + "\""
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateGender(Client client){
        try {
            Executor.execute(
                    UPDATE_SQL + " SET GENDER=\"" + client.getGender() + "\" WHERE PHONE=\"" + client.getPhone() + "\""
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePassword(Client client){
        try {
            Executor.execute(
                    UPDATE_SQL + " SET PASSWORD=\"" + client.getPassword() + "\" WHERE PHONE=\"" + client.getPhone() + "\""
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateBirthdate(Client client){
        try {
            Executor.execute(
                    UPDATE_SQL + " SET BIRTHDATE=\"" + SoftManager.dateToString(client.getBirthdate()) + "\", " + "\" WHERE PHONE=\"" + client.getPhone() + "\""
            );
            updateAge(client);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateAge(Client client){
        try {
            Executor.execute(
                    UPDATE_SQL + " SET AGE=" + client.getAge() + ", " + "\" WHERE PHONE=\"" + client.getPhone() + "\""
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteClient(Client client){
        try {
            String cardNum = client.getCardNum();
            Executor.execute(
                    DELETE_SQL + cardNum + "\""
            );
            CardManager.deleteCard(cardNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Client> getAllClients(){
        ArrayList<Client> clients = new ArrayList<>();
        try {
            ResultSet resultSet = Executor.executeSelect(
              SELECT_SQL
            );
            while (resultSet.next()){
                ClientWithID client = new ClientWithID(
                        resultSet.getInt("ID"),
                        createClientFromSet(resultSet)
                );
                client.setId(resultSet.getInt("ID"));
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public static Client createClientFromSet(ResultSet resultSet) throws SQLException {
        Client result;
        String card_Num = resultSet.getString("CARD_NUM");
        String name = resultSet.getString("NAME");
        String surname = resultSet.getString("SURNAME");
        Boolean isAdmin = resultSet.getBoolean("IS_ADMIN");
        String phone = resultSet.getString("PHONE");
        String password = resultSet.getString("PASSWORD");
        String gender = resultSet.getString("GENDER");
        Date birthdate = resultSet.getDate("BIRTHDATE");
        result = ClientBuilder
                .name(name)
                .surname(surname)
                .card(
                        CardManager.getCardFormDB(card_Num)
                )
                .isAdmin(isAdmin)
                .phone(phone)
                .password(password)
                .gender(gender)
                .birthdate(birthdate)
                .build();
        return result;
    }
}
