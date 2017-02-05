package com.java.main;

import com.sun.jmx.snmp.InetAddressAcl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 This is the class for the login page
 */
public class Login extends JFrame {

    TextField userTxt = new TextField("Enter Username");
    Button submitBtn = new Button("Login");

    public Login () {

        setSize(500, 500);
        setLocation(100, 300);
        setTitle("Login");


        setLayout(new FlowLayout());
        add(new Label("Username:"));
        add(userTxt);
        add(submitBtn);


        submitBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                Menu menu = new Menu();
                menu.setVisible(true);
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });


        setVisible(true);

    }


}
