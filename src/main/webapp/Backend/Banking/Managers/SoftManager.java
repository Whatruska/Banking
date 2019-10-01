package main.webapp.Backend.Banking.Managers;

import main.webapp.Backend.Banking.Client.Client;
import main.webapp.Backend.Banking.CryptWithMD5;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

public class SoftManager {
    public static Client login(String phone, String password){
        Client result;
        String passInDB = CryptWithMD5.cryptWithMD5(password);

        result = ClientManager.getClientFormDBbyPhone(phone);

        if (result == null || !result.getPassword().equals(passInDB)){
            return null;
        }
        return result;
    }

    public static String dateToString(Date date){
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public static Date stringToDate(String date){
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            System.out.println("Date parsing error : " + date);
        }
        return null;
    }
}
