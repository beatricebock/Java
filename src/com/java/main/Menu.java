package com.java.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by beatr on 22/1/2017.
 */
public class Menu extends JFrame {

    public Menu ()
    {
        setSize(500,500);
        setLocation(100,300);
        setLayout(new FlowLayout());
        setTitle("Menu");

        Button menuBtn = new Button("Option 1");

        add(new Label("Menu"));
        add(menuBtn);

        addWindowListener(new WindowAdapter()
        {
        @Override
        public void windowClosing(WindowEvent e)
        {
            dispose();
        }
        });

        menuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add(new Label("Option 1"));
            }
        });

        setVisible(true);
    }

    public void actionPerformed (ActionEvent e)
    {

    }

}
