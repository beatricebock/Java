package com.java.main;

import javax.swing.*;
import javax.xml.soap.Text;
import java.awt.*;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

/**
 * GUI for New Member registration
 */
public class RegGUI extends JFrame {

    int months = 1; //Default month number
    int totalfees = 0; //Default fees

    //Elements requiring global access
    TextField nameTxt = new TextField(20);
    TextField monthTxt = new TextField(20);
    Label infoLbl = new Label();


    public RegGUI () {


        //Frame setup
        setSize(500,300);
        setLocation(400, 200);
        setLayout(new BorderLayout());
        setTitle("Register New Member");

        //Panel with input fields
        Panel inputPanel = new Panel();
        inputPanel.setLayout(new GridLayout(0,2, 10,10));

        //Initialize Combo Box with membertypes
        String [] memberTypes = {"Deluxe", "Non-Deluxe", "Week-Day"};
        JComboBox memberType = new JComboBox(memberTypes);

        //Validation for Months textfield
        try
        {
            months = Integer.parseInt(monthTxt.getText());
        }
        catch (IllegalArgumentException e){
            add(new Label("Enter integers only"));
        }

        //buttons
        Button confirmBtn = new Button("Confirm");
        Button menuBtn = new Button("<< Main Menu");
        Button clearBtn = new Button("Clear");

        //Add elements to frame
        inputPanel.add(new Label("Name:"));
        inputPanel.add(nameTxt);
        inputPanel.add(new Label("Months: "));
        inputPanel.add(monthTxt);
        inputPanel.add(new Label("Membership Types:"));
        inputPanel.add(memberType);
        inputPanel.add(infoLbl);
        inputPanel.add(confirmBtn);
        inputPanel.add(menuBtn);
        inputPanel.add(clearBtn);

        add(inputPanel);

        //Window Listener for "Close Window"
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        //Action Listener for the combobox
        memberType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox memberType = (JComboBox) e.getSource();
                String memberTypes = (String) memberType.getSelectedItem();
                pkgLogic packages = new pkgLogic();
                switch (memberTypes) {
                    case "Non-Deluxe":
                        totalfees = packages.pkgLogic(300, 100, months);
                        break;
                    case "Deluxe":
                        totalfees = packages.pkgLogic(500, 120, months);
                        break;
                    case "Week-Day":
                        totalfees = packages.pkgLogic(180,75, months);
                        break;
                    default:
                        break;
                }
            }
        });

        //actionListener for Confirm button
        confirmBtn.addActionListener(new ActionListener()
        {
             @Override
             public void actionPerformed(ActionEvent e) {
                 JOptionPane.showConfirmDialog(null, "Confirm entered information and enter information into database?");
                 infoLbl.setText("Total Fees are RM" + totalfees + " for new member, " + nameTxt.getText());
             }
         });

        //actionListener for Menu button
        menuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu();
                dispose();
            }
        });

        //actionListener for Clear button
        clearBtn.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monthTxt.setText(" ");
                nameTxt.setText(" ");
                dispose();
                RegGUI regGUI = new RegGUI();
            }
        }));

        setVisible(true);
    }
}


