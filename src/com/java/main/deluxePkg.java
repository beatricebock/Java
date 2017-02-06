package com.java.main;

/**
 * Created by User on 6/2/2017.
 */
public class deluxePkg
    {
    private int regFee;
    private int monthFee;
    private int calcFee;

    public deluxePkg()
    {
        regFee = 500;
        monthFee = 120;
    }

    public int getCalcFee(int month)
    {
        return calcFee = month * monthFee + regFee + monthFee;
    }

}
