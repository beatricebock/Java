package com.java.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * GUI for New Member registration
 */
public class reg extends JFrame {

    public reg () {

        //Frame setup
        setSize(500, 500);
        setLocation(100, 300);
        setLayout(new BorderLayout());
        setTitle("Register New Member");

        //Panel with input fields
        Panel inputPanel = new Panel();
        inputPanel.setLayout(new FlowLayout());

        TextField nameTxt = new TextField(20);
        Choice memberType = new Choice();
        memberType.add("Deluxe");
        memberType.add("Non-Deluxe");
        memberType.add("Week-Day");

        inputPanel.add(new Label("Name:"));
        inputPanel.add(nameTxt);
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

}
