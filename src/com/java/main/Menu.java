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
        Button newMember = new Button("Add New Member");
        Button modify = new Button("Modify Existing Member");
        Button payment = new Button("Payment");
        Button exit = new Button("Exit System");
        buttonPanel.add(newMember);
        buttonPanel.add(modify);
        buttonPanel.add(payment);
        buttonPanel.add(exit);


        //Add panels to frame
        add(titlePanel, BorderLayout.PAGE_START);
        add(buttonPanel, BorderLayout.CENTER);


        //Methods for Action Buttons
        newMember.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegGUI Reg = new RegGUI();
                dispose();
            }
        });

        payment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Payment payment = new Payment();
                dispose();
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
