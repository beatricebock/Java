package com.java.main;

import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * GUI and methods for Payment module
 */
public class Payment extends JFrame {
    public Payment (){

        //Frame setup
        setSize(500,300);
        setLocation(400, 200);
        setLayout(new BorderLayout());
        setTitle("Register New Member");

        //Validation for Months textfield
        //try
        //{
        //    months = Integer.parseInt(monthTxt.getText());
        //}
        //catch (IllegalArgumentException e){
        //    JOptionPane.showMessageDialog(null,"Enter integers only");
        //}

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
}
