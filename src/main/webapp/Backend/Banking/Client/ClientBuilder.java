package main.webapp.Backend.Banking.Client;

import main.webapp.Backend.Banking.Card.Card;

import java.util.Date;

public class ClientBuilder {
    private static Client client = new Client();

    public static ClientBuilder name(String name){
        client.setName(name);
        return null;
    }

    public static ClientBuilder surname(String surname){
        client.setSurname(surname);
        return null;
    }

    public static ClientBuilder card(Card card){
        client.setCard(card);
        return null;
    }

    public static ClientBuilder isAdmin(Boolean isAdmin){
        client.setAdmin(isAdmin);
        return null;
    }

    public static ClientBuilder phone(String phone){
        client.setPhone(phone);
        return null;
    }

    public static ClientBuilder gender(String gender){
        client.setGender(gender);
        return null;
    }

    public static ClientBuilder password(String password){
        client.setPassword(password);
        return null;
    }
    public static ClientBuilder birthdate(Date birthdate){
        client.setBirthdate(birthdate);
        return null;
    }

    public static Client build(){
        return client.clone();
    }
}
