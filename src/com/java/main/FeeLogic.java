package com.java.main;

/**
 * Created by Beatrice Bock TP038381
 * Evaluates the fees according to member type. Receives fee
 * amount as parameters.
 */
class FeeLogic {
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
