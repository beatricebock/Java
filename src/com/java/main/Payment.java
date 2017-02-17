package com.java.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * GUI and methods for Payment module
 */
public class Payment extends JFrame {
    String membership;
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

        //Combo box for input
        String payTypes[] = {"Monthly", "Registration"};
        JComboBox cbPayType = new JComboBox(payTypes);


        //Buttons
        Button btnMenu = new Button("<< Main Menu");
        Button btnConfirm = new Button("Confirm");
        Button btnClear = new Button("Clear");

        //Add labels to input panel
        inputPanel.add(new Label("Member ID:"));
        inputPanel.add(txtMemberID);
        inputPanel.add(new Label("Payment Type"));
        inputPanel.add(cbPayType);

        //Add buttons to button panel
        buttonPanel.add(btnMenu);
        buttonPanel.add(btnConfirm);
        buttonPanel.add(btnClear);


        add(inputPanel,"Center");
        add(buttonPanel, "South");


        //Determines feeLogic method's parameters
        //Logic to decide which values to add into the FeeLogic method call
        cbPayType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File file = new File("members.txt");
                    Scanner inputFile = new Scanner(file);
                    boolean found = false;

                    while (inputFile.hasNext()) {
                        String memberOri = inputFile.nextLine();
                        String memberIndex[] = memberOri.split(":");
                        String memberID = memberIndex[0];
                        String memberType = memberIndex[2];

                        String inputID = txtMemberID.getText();
                        if (memberID.equals(inputID)) {
                            membership = memberType;
                            JComboBox cbPayType = (JComboBox) e.getSource();
                            String payTypes = (String) cbPayType.getSelectedItem();
                            FeeLogic feeLogic = new FeeLogic();
                            switch (payTypes) {
                                case "Registration":
                                    fee = feeLogic.FeeLogic(membership, 500, 300, 180);
                                    break;
                                case "Monthly":
                                    fee = feeLogic.FeeLogic(membership, 120, 100, 75);
                                    break;
                            }
                            inputFile.close();
                            found = true;
                            break;
                        }else {
                            found = false;
                        }
                    }
                    if (found != true){
                        JOptionPane.showMessageDialog(null,"Member does not exist.");
                        txtMemberID.setText(" ");
                        cbPayType.setSelectedItem(" ");
                        inputFile.close();
                    }
                } catch (Exception member){
                    JOptionPane.showMessageDialog(null,"File does not exist");
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
                String inputID = txtMemberID.getText();
                try{ //validates that a string of integers is entered
                    Integer.parseInt(inputID);

                    try { //catches if member exists
                        File file = new File("members.txt");
                        Scanner inputFile = new Scanner(file);
                        boolean found = false;

                        while (inputFile.hasNext()) { //loops through
                            String memberOri = inputFile.nextLine();
                            String memberIndex[] = memberOri.split(":");
                            String indexMemberID = memberIndex[0];
                            String indexMemberName = memberIndex[1];
                            String indexMemberType = memberIndex[2];

                            if (indexMemberID.equals(inputID)) {
                                found = true;
                                break;
                            }else {
                                txtMemberID.setText(" ");
                                cbPayType.setSelectedItem(" ");
                                // cbMemberType.setSelectedItem(" ");
                                found = false;
                            }
                        }
                        if (found == true){
                            int input = JOptionPane.showConfirmDialog(null,"Confirm payment of RM" + fee + " from MemberID: " + inputID + "?", "Confirm payment", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
                            if (input == JOptionPane.OK_OPTION) {
                                try {
                                    PrintWriter outputFile = new PrintWriter(new FileWriter("payment", true));
                                    outputFile.append(randomNum + ":" + date.toString() + ":" + inputID + ":" + fee + ":" + Main.user + "\n");
                                    JOptionPane.showMessageDialog(null, "Payment of RM" + fee + " Paid by MemberID " + inputID);

                                    outputFile.close();

                                } catch (Exception fileExcp) {
                                    JOptionPane.showMessageDialog(null, "append failed, Error: " + fileExcp.getMessage());
                                }
                            }

                        }else {
                            JOptionPane.showMessageDialog(null, "Member does not exist.");
                        }
                    } catch (Exception fileExcp) {
                        JOptionPane.showMessageDialog(null, "Error: " + fileExcp.getMessage());
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


