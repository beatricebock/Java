package com.java.main;

import javax.swing.*;
import javax.xml.soap.Text;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

/**
 * GUI for New Member registration
 */
public class RegGUI extends JFrame implements ActionListener {

    TextField nameTxt = new TextField(20);
    TextField monthTxt = new TextField(20);
    public int months = Integer.parseInt(monthTxt.getText());

    public RegGUI () {

        //Frame setup
        setSize(500, 300);
        setLocation(400, 200);
        setLayout(new BorderLayout());
        setTitle("Register New Member");

        //Panel with input fields
        Panel inputPanel = new Panel();
        inputPanel.setLayout(new GridLayout(0,2, 10,10));

        String [] memberTypes = {"Deluxe", "Non-Deluxe", "Week-Day"};
        JComboBox memberType = new JComboBox(memberTypes);
        memberType.addActionListener(this);

        inputPanel.add(new Label("Name:"));
        inputPanel.add(nameTxt);
        inputPanel.add(new Label("Months: "));
        inputPanel.add(monthTxt);
        inputPanel.add(new Label("Membership Types:"));
        inputPanel.add(memberType);

        add(inputPanel);

        //Window Listener for "Close Window"
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    //action listener for package type combo box
    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox memberType = (JComboBox)e.getSource();
        String memberTypes = (String)memberType.getSelectedItem();
        switch (memberTypes)
        {
            case "Non-Deluxe":
                pkgLogic nonDeluxe = new pkgLogic();
                add(new Label("Total fees is: " + nonDeluxe.pkgLogic(300,100,months)));

        }
    }

}
