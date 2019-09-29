package main.webapp.Backend.Banking.Transaction;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TransactionDate{
    public static String getCurrentDate(){
        Calendar calendar =  GregorianCalendar.getInstance();
        String datePattern = "YYYY-MM-dd HH:mm:ss";
        SimpleDateFormat format = new SimpleDateFormat(datePattern);
        return format.format(calendar.getTime());
    }
}
