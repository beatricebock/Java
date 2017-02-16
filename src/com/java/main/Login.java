package com.java.main;

import com.sun.jmx.snmp.InetAddressAcl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Scanner;


/**
 This is the class for the login page GUI
 */
public class Login extends JFrame {


    public Login () throws IOException {


        setSize(500, 300);
        setLocation(400, 200);
        setTitle("Login");
        setLayout(new BorderLayout());

        TextField txtUser = new TextField(20);
        TextField txtPwd = new TextField(20);
        Button submitBtn = new Button("Login");

        Panel inputPanel = new Panel(new GridLayout(2, 0));
        Panel usernamePanel = new Panel(new FlowLayout());
        Panel passPanel = new Panel(new FlowLayout());
        Panel buttonPanel = new Panel();

        usernamePanel.add(new Label("Username:"), "Left");
        usernamePanel.add(txtUser);
        passPanel.add(new Label("Password: "), "Left");
        passPanel.add(txtPwd);
        inputPanel.add(usernamePanel);
        inputPanel.add(passPanel);
        buttonPanel.add(submitBtn);

        add(inputPanel, "Center");
        add(buttonPanel, "South");


        submitBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    File file = new File("login");
                    Scanner inputFile = new Scanner(file);
                    boolean success = false;

                    while(inputFile.hasNext())
                    {
                        String loginCred = inputFile.nextLine();

                        String[] userindex = loginCred.split(":");
                        String username = userindex[0];
                        String password = userindex[1];
                        String inputUser = txtUser.getText();
                        String inputPass = txtPwd.getText();

                        if (username.equals(inputUser)&& password.equals(inputPass)){
                            JOptionPane.showMessageDialog(null,"Login successful. Welcome, "+ userindex[0]);
                            Menu menu = new Menu();
                            menu.setVisible(true);
                            dispose();
                            inputFile.close();
                            success = true;

                            break;
                        }else{
                            success = false;
                        }
                    }
                    if (success != true){
                        JOptionPane.showMessageDialog(null, "Username or password incorrect. Try again.");
                    }

                }catch (Exception fileExcp) {
                   JOptionPane.showMessageDialog(null,"Error: " + fileExcp.getMessage());
                }
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int input = JOptionPane.showConfirmDialog(null, "Confirm exit?", "Confirm Exit", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
                if (input == JOptionPane.OK_OPTION) {
                    dispose();
                }
            }
        });

        setVisible(true);
    }


}
