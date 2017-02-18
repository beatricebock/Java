package com.java.main;

import javax.swing.*;

/**
 * Created by User on 18/2/2017.
 * Evaluates if a field is
 */
public class noNull {

    public boolean noNull(String i, String field){

        //if evaluated values are null, then noNull returns false
        if (i == null || i == " "){
            JOptionPane.showMessageDialog(null, field + " value cannot be null. Enter a value and try again.");
            return false;
        }
        return true;
    }
}
