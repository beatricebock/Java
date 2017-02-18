package com.java.main;

import javax.swing.*;

/**
 * Created by User on 18/2/2017.
 * Evaluates if a field is
 */
public class noNull {

    public boolean noNull(String i, String field){
        if (i == null){
            JOptionPane.showMessageDialog(null, field + " value cannot be null. Enter a value and try again.");
            return true;
        }
        return false;
    }
}
