package com.java.main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Class for Menu frame
 */
public class Menu extends JFrame {

    public Menu ()
    {
        setSize(500,300);
        setLocation(400,200);
        setLayout(new BorderLayout());
        setTitle("Menu");

        //Panel for title
        Panel titlePanel = new Panel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(new Label("Menu"), JLabel.CENTER);


        //Panel for menu options
        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new GridLayout(4,1, 30, 10));
        Button btnNewMember = new Button("Add New Member");
        Button btnModify = new Button("Modify Existing Member");
        Button btnPayment = new Button("Payment");
        Button btnExit = new Button("Exit System");
        buttonPanel.add(btnNewMember);
        buttonPanel.add(btnModify);
        buttonPanel.add(btnPayment);
        buttonPanel.add(btnExit);


        //Add panels to frame
        add(titlePanel, BorderLayout.PAGE_START);
        add(buttonPanel, BorderLayout.CENTER);


        //Methods for Action Buttons
        btnNewMember.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register Reg = new Register();
                dispose();
            }
        });

        btnPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Payment payment = new Payment();
                dispose();
            }
        });

        btnModify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Modify mod = new Modify();
                dispose();
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int input = JOptionPane.showConfirmDialog(null, "Confirm exit?", "Confirm Logout", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
                if (input == JOptionPane.OK_OPTION)
                {
                    dispose();
                }

            }
        });



        //Window Listener for "Close Window"
        addWindowListener(new WindowAdapter()
        {
        @Override
        public void windowClosing(WindowEvent e)
        {
            dispose();
        }
        });


        setVisible(true);
    }


}
