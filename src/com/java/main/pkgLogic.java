package com.java.main;



/**
 * Created by User on 6/2/2017.
 */
public class pkgLogic
    {
    private int regFee;
    private int monthFee;

    public  int pkgLogic(int rf, int mf, int months)
    {
        regFee = rf;
        monthFee = mf;
        return months * monthFee + regFee;
    }

}
