package com.java.main;

import javax.swing.*;
import javax.swing.*;
import javax.xml.soap.Text;
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

        //Panels for input
        Panel inputPanel = new Panel();
        inputPanel.setLayout(new GridLayout(0,2));

        //Text fields for input
        TextField txtMemberID = new TextField();
        TextField txtAmount = new TextField();

        //Combo boxes for input
        String payTypes [] = {"Monthly", "Registration"};
        JComboBox cbPayType = new JComboBox(payTypes);
        String memberTypes[] = {"Deluxe", "Non-Deluxe", "Week-Day"};
        JComboBox cbMemberType = new JComboBox(memberTypes);

        //Buttons

        //Add labels to panel
        inputPanel.add(new Label("Member ID:"));
        inputPanel.add(txtMemberID);
        inputPanel.add(new Label("Membership Type:"));
        inputPanel.add(cbMemberType);
        inputPanel.add(new Label("Payment Type"));
        inputPanel.add(cbPayType);
        inputPanel.add(new Label("Amount Paid:"));
        inputPanel.add(txtAmount);


        add(inputPanel);


        //monthly fees
        //FeeLogic feeLogic = new FeeLogic(string, 120, 100, 75);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
}
