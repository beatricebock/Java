package com.java.main;

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
    String paymentType, membership;
    int fee;

    public Payment (){

        //Frame setup
        setSize(500,300);
        setLocation(400, 200);
        setLayout(new BorderLayout());
        setTitle("Register New Member");

        //Panels for input
        Panel inputPanel = new Panel();
        inputPanel.setLayout(new GridLayout(0,2));
        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new FlowLayout());

        //Text fields for input
        TextField txtMemberID = new TextField();
        TextField txtAmount = new TextField();

        //Combo boxes for input
        String payTypes[] = {"Monthly", "Registration"};
        JComboBox cbPayType = new JComboBox(payTypes);
        String memberTypes[] = {"Deluxe", "Non-Deluxe", "Week-Day"};
        JComboBox cbMemberType = new JComboBox(memberTypes);

        //Functions for combo boxes
        //Logic to determine string value for method parameter
        cbMemberType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cbMemberType = (JComboBox) e.getSource();
                String memberTypes = (String) cbMemberType.getSelectedItem();
                switch(memberTypes){
                    case "Deluxe":
                        membership = "Deluxe";
                        break;
                    case "Non-Deluxe":
                        membership = "Non-Deluxe";
                        break;
                    case "Week-Day":
                        membership = "Week-Day";
                        break;
                }
            }
        });

        //Determines feeLogic method's parameters
        //Logic to decide which values to add into the FeeLogic method call
        cbPayType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cbPayType = (JComboBox) e.getSource();
                String payTypes = (String) cbPayType.getSelectedItem();

                FeeLogic feeLogic = new FeeLogic();
                switch(payTypes){
                    case "Registration":
                        fee = feeLogic.FeeLogic(membership, 500, 300, 180);
                        break;
                    case "Monthly":
                        fee = feeLogic.FeeLogic(membership,120,100,75);
                        break;
                }

            }
        });


        //Buttons
        Button btnMenu = new Button("<< Main Menu");
        Button btnConfirm = new Button("Confirm");
        Button btnClear = new Button("Clear");

        //Functions for Buttons
        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Menu menu = new Menu();
            }
        });

        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        //Add labels to input panel
        inputPanel.add(new Label("Member ID:"));
        inputPanel.add(txtMemberID);
        inputPanel.add(new Label("Membership Type:"));
        inputPanel.add(cbMemberType);
        inputPanel.add(new Label("Payment Type"));
        inputPanel.add(cbPayType);
        inputPanel.add(new Label("Amount Paid:"));
        inputPanel.add(txtAmount);

        //Add buttons to button panel
        buttonPanel.add(btnMenu);
        buttonPanel.add(btnConfirm);
        buttonPanel.add(btnClear);


        add(inputPanel,"Center");
        add(buttonPanel, "South");

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
}

//Validation for Months textfield
//try
//{
//months = Integer.parseInt(txtMonth.getText());
//}
//catch (IllegalArgumentException ec){
//JOptionPane.showMessageDialog(null,"Enter integers only");
//}

