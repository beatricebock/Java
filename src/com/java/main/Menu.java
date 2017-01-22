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
public class Menu extends JFrame implements ActionListener{

    public void menu ()
    {
        setSize(500,500);
        setLocation(100,300);
        setLayout(new BorderLayout());
        setTitle("Menu");

        Panel panel = new Panel();
        panel.add(new Label("Menu"));

        panel.setVisible(true);

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

    public void actionPerformed (ActionEvent e)
    {

    }

}
