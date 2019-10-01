package main.webapp.Backend.Banking.Client;


import main.webapp.Backend.Banking.Card.Card;
import main.webapp.Backend.Banking.Managers.SoftManager;

import java.util.Calendar;
import java.util.Date;

public class Client {
    public static final String MALE_GENDER = "MALE";
    public static final String FEMALE_GENDER = "FEMALE";

    private String name;
    private String surname;
    private Card card;
    private Boolean isAdmin;
    private String password;
    private String phone;
    private String gender;
    private Date birthdate;
    private Integer age;

    public Client() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;

        Calendar birthCalendear = Calendar.getInstance();
        Date today = birthCalendear.getTime();
        birthCalendear.setTime(birthdate);
        int count = 0;
        while (!birthCalendear.getTime().after(today)){
            birthCalendear.add(Calendar.YEAR, 1);
            count++;
        }

        age = count - 1;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getCardNum(){
        return card.getCardNum();
    }

    public int getValue(){
        return card.getValue();
    }

    public Boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Client clone(){
        Client result = new Client();
        result.setCard(card);
        result.setName(name);
        result.setSurname(surname);
        result.setAdmin(isAdmin);
        result.setGender(gender);
        result.setPhone(phone);
        result.setPassword(password);
        result.setBirthdate(birthdate);
        return result;
    }

    public String toString() {
        String result = "";
        result += "Name : " + name + "\n";
        result += "Surname : " + surname + "\n";
        result += "Birthdate : " + SoftManager.dateToString(birthdate) + "\n";
        result += "Age : " + age + "\n";
        result += "Is admin ? : " + (isAdmin ? "Yes" :"No") + "\n";
        result += "Phone : " + phone + "\n";
        result += "Gender : " + gender + "\n";
        result += "-------CARD INFO-------\n";
        result += card.toString();
        return result;
    }
}
