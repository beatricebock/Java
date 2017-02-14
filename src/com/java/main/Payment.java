package com.java.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

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

        //Text field for input
        TextField txtMemberID = new TextField();

        //Combo boxes for input
        String payTypes[] = {"Monthly", "Registration"};
        JComboBox cbPayType = new JComboBox(payTypes);
        String memberTypes[] = {"Deluxe", "Non-Deluxe", "Week-Day"};
        JComboBox cbMemberType = new JComboBox(memberTypes);

        //Buttons
        Button btnMenu = new Button("<< Main Menu");
        Button btnConfirm = new Button("Confirm");
        Button btnClear = new Button("Clear");

        //Add labels to input panel
        inputPanel.add(new Label("Member ID:"));
        inputPanel.add(txtMemberID);
        inputPanel.add(new Label("Membership Type:"));
        inputPanel.add(cbMemberType);
        inputPanel.add(new Label("Payment Type"));
        inputPanel.add(cbPayType);

        //Add buttons to button panel
        buttonPanel.add(btnMenu);
        buttonPanel.add(btnConfirm);
        buttonPanel.add(btnClear);


        add(inputPanel,"Center");
        add(buttonPanel, "South");

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
                Date date = new Date();

                Random rand = new Random();
                int randomNum = rand.nextInt((99999-10000)+1) + 10000;

                //validation for Member ID text field.
                String memberID = txtMemberID.getText();
                try{
                    Integer.parseInt(memberID);
                    JOptionPane.showConfirmDialog(null,"Confirm payment of RM" + fee + " from MemberID: " + memberID + "?");
                    try {
                        PrintWriter outputFile = new PrintWriter(new FileWriter("payment", true));
                        outputFile.append(randomNum + ":" + date.toString() + ":" + txtMemberID.getText() + ":" + fee + "\n");
                        JOptionPane.showMessageDialog(null,"Payment of RM" + fee + " Paid by MemberID " + memberID);

                        outputFile.close();

                    }catch (Exception fileExcp) {
                        JOptionPane.showMessageDialog(null,"Error: " + fileExcp.getMessage());
                    }

                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a memberID that consists of only integers.");
                }
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //reset and clear form
                dispose();
                Payment payment = new Payment();
            }
        });

        //Window Listener for "Close Window"
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int input = JOptionPane.showConfirmDialog(null, "Confirm exit?", "Confirm Logout", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
                if (input == JOptionPane.OK_OPTION)
                {
                    dispose();
                }
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

