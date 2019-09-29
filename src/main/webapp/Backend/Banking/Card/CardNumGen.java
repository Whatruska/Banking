package main.webapp.Backend.Banking.Card;

import main.webapp.Backend.Banking.SoftManager;
import java.util.ArrayList;

public class CardNumGen {
    private static final int FIRM_MARK = 7777;
    private static final ArrayList<String> cardNums = CardManager.getAllCardNum();

    private static int generateBlock(){

        return (int) (Math.random() * 8999) + 1000;
    }

    private static String generateNum(){
        return FIRM_MARK + " " + generateBlock() + " " + generateBlock() + " " + generateBlock();
    }

    public static String genNum(){
        String result = generateNum();
        while (!SoftManager.isUnique(result, cardNums)){
            result = generateNum();
        }
        return result;
    }
}