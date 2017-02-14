package com.java.main;

import javafx.scene.control.Labeled;

import javax.swing.*;
import javax.xml.soap.Text;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by User on 11/2/2017.
 */
public class Modify extends Frame {
    public Modify() {

        //Frame Setup
        setSize(500, 300);
        setLocation(400, 200);
        setLayout(new BorderLayout());
        setTitle("Modify Users");

        //Panels
        Panel inputPanel = new Panel();
        inputPanel.setLayout(new GridLayout(0,2, 0, 50));
        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new FlowLayout());

        //Elements
        Label lblMemberID = new Label();
        TextField txtSearch = new TextField("Type member ID to search");
        TextField txtName = new TextField();
        String memberTypes [] = {"Deluxe", "Non-Deluxe", "Week-Day"};
        JComboBox cbMemberType = new JComboBox(memberTypes);

        Button btnSearch = new Button("Search");
        Button btnMenu = new Button("<< Main Menu");
        Button btnPrev = new Button("< Prev Record");
        Button btnSave = new Button("Save Changes");
        Button btnNext = new Button("Next Record >");

        inputPanel.add(txtSearch);
        inputPanel.add(btnSearch);
        inputPanel.add(new Label("Member ID: "));
        inputPanel.add(lblMemberID);
        inputPanel.add(new Label("Member Name: "));
        inputPanel.add(txtName);
        inputPanel.add(new Label("Membership Type: "));
        inputPanel.add(cbMemberType);


        buttonPanel.add(btnMenu);
        buttonPanel.add(btnPrev);
        buttonPanel.add(btnSave);
        buttonPanel.add(btnNext);

        add(inputPanel, "Center");
        add(buttonPanel, "South");

        //Window Listener for "Close Window"
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu();
                dispose();
            }
        });

        setVisible(true);

    }
}
