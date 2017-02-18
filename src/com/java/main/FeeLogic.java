package com.java.main;

/**
 * Created by User on 9/2/2017.
 */
public class FeeLogic {
    public int feeLogic(String memberType, int df, int nf, int wf){
        int fee = 0;
        switch (memberType){
            case "Deluxe":
                fee = df;
                break;
            case "Non-Deluxe":
                fee = nf;
                break;
            case "Week-Day":
                fee = wf;
                break;
        }
        return fee;
    }
}
