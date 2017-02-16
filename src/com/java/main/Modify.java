package com.java.main;

import javafx.scene.control.Labeled;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Scanner;

/**
 * Created by User on 11/2/2017.
 */
public class Modify extends Frame {

    String newMemberType; //For use in saving modifications from changed combobox selected Item

    public Modify() throws IOException {

        //Frame Setup
        setSize(500, 300);
        setLocation(400, 200);
        setLayout(new BorderLayout());
        setTitle("Modify Users");

        //Panels
        Panel inputPanel = new Panel(new GridLayout(0,2, 0, 50));
        Panel buttonPanel = new Panel(new FlowLayout());

        //Elements
        Label lblMemberID = new Label();
        TextField txtSearch = new TextField("Type member ID to search");
        TextField txtName = new TextField();
        String memberTypes [] = {"Deluxe", "Non-Deluxe", "Week-Day"};
        JComboBox cbMemberType = new JComboBox(memberTypes);

        Button btnSearch = new Button("Search");
        Button btnMenu = new Button("<< Main Menu");
        Button btnSave = new Button("Save Changes");

        final File temp = File.createTempFile("temp",".txt");

        inputPanel.add(txtSearch);
        inputPanel.add(btnSearch);
        inputPanel.add(new Label("Member ID: "));
        inputPanel.add(lblMemberID);
        inputPanel.add(new Label("Member Name: "));
        inputPanel.add(txtName);
        inputPanel.add(new Label("Membership Type: "));
        inputPanel.add(cbMemberType);

        buttonPanel.add(btnMenu);
        buttonPanel.add(btnSave);

        add(inputPanel, "Center");
        add(buttonPanel, "South");

        cbMemberType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cbMemberType = (JComboBox) e.getSource();
                String selectedMember = (String) cbMemberType.getSelectedItem();
                newMemberType = selectedMember;
            }
        });

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Integer.parseInt(txtSearch.getText());
                    try { //Catches if member exists

                        File file = new File("members.txt");
                        Scanner inputFile = new Scanner(file);
                        boolean found = false;

                        while (inputFile.hasNext()) {
                            String memberOri = inputFile.nextLine();
                            String memberIndex[] = memberOri.split(":");
                            String memberID = memberIndex[0];
                            String memberName = memberIndex[1];
                            String memberType = memberIndex[2];

                            String inputID = txtSearch.getText();
                            if (memberID.equals(inputID)) {
                                lblMemberID.setText(memberID);
                                txtName.setText(memberName);
                                cbMemberType.setSelectedItem(memberType);
                                inputFile.close();
                                found = true;
                                break;
                            } else {
                                found = false;
                            }
                        }
                        if (found != true){
                            JOptionPane.showMessageDialog(null,"Member does not exist.");

                                lblMemberID.setText(" ");
                                txtName.setText(" ");
                                cbMemberType.setSelectedItem(" ");
                                inputFile.close();
                        }
                    } catch (Exception fileExcp) {
                        JOptionPane.showMessageDialog(null, "Error: " + fileExcp.getMessage());
                    }
                }catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a memberID that consists of only integers.");
                }
            }
        });


        File finalTemp = temp;
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oriFileName = "members.txt";
                String tempFileName = "temp.txt";

                BufferedReader br = null;
                BufferedWriter bw = null;

                try {
                    br  = new BufferedReader(new FileReader(oriFileName));
                    bw = new BufferedWriter(new FileWriter(tempFileName));

                    String line;
                    while ((line = br.readLine()) != null ){
                        String memberIndex[] = line.split(":");
                        String memberID = memberIndex[0];
                        String memberName = memberIndex[1];
                        String memberType = memberIndex[2];
                        String inputID = txtSearch.getText();

                        if (memberID.equals(inputID)){
                            line = line.replace(memberName, txtName.getText());
                            line = line.replace(memberType, cbMemberType.getSelectedItem().toString());
                        }
                        bw.write(line + "\n");
                    }
                } catch (Exception e2) {
                    return;
                }finally {
                    try {
                        if (br != null) {
                            br.close();
                        }
                    } catch(IOException e2){

                    }
                    try {
                        if (bw != null) {
                            bw.close();
                        }
                    }catch (IOException e2){

                    }
                }

                File oriFile = new File(oriFileName);
                if (!oriFile.delete()){
                 JOptionPane.showMessageDialog(null, "Delete unsuccessful");
                }

                File overwrite = new File(tempFileName);

                if (!overwrite.renameTo(oriFile)){
                    JOptionPane.showMessageDialog(null,"Overwrite Unsuccessful");
                }else {
                    JOptionPane.showMessageDialog(null,"Overwrite successful");
                }

                overwrite.renameTo(oriFile);

                JOptionPane.showMessageDialog(null,"Overwrite successful");
                /*try {
                    File ori = new File("members.txt");
                    Scanner oriFile = new Scanner(ori);
>>>>>>> parent of 24f7b18... added validation for Modify

                    while (oriFile.hasNext()) {
                        String memberOri = oriFile.nextLine();
                        String memberIndex[] = memberOri.split(":");
                        String memberID = memberIndex[0];
                        String memberName = memberIndex[1];
                        String memberType = memberIndex[2];

                        String inputID = txtSearch.getText();
                        if (memberID.equals(inputID)) {
                            String copyMemberID = lblMemberID.getText();
                            String newName = txtName.getText();

                            try {
                                PrintWriter outputFile = new PrintWriter(new FileWriter("temp.txt", true));
                                outputFile.append(copyMemberID + ":" + newName + ":" + newMemberType + "\n");
                                JOptionPane.showMessageDialog(null,"Edited information for member ID:" + copyMemberID + "\nName: " + newName + "\nMembership Type: " + newMemberType);

                            }catch (Exception writeExcp) {
                                JOptionPane.showMessageDialog(null,"Error: " + writeExcp.getMessage());
                            }

                        }else {
                            try {
                                PrintWriter outputFile = new PrintWriter(new FileWriter("temp.txt", true));
                                outputFile.append(memberID + ":" + memberName + ":" + memberType + "\n");
                            }catch (Exception writeExcp) {
                                JOptionPane.showMessageDialog(null,"Error: " + writeExcp.getMessage());
                            }
                        }

                    }
                    oriFile.close();

                    System.gc();
                    if (ori.delete()){
                        JOptionPane.showMessageDialog(null, "Original file deleted");
                    }else{
                        JOptionPane.showMessageDialog(null,"File not deleted, operation failed");
                    }

                    File overwrite = new File("members.txt");
                    boolean success = temp.renameTo(overwrite);
                    if(!success){
                        JOptionPane.showMessageDialog(null,"Error during data overwrite.");
                    }


                } catch (IOException e1) {
                    e1.printStackTrace();
              }  */
        }

        });

        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu();
                dispose();
            }
        });

        //Window Listener for "Close Window"
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int input = JOptionPane.showConfirmDialog(null, "Confirm exit?", "Confirm Logout", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
                if (input == JOptionPane.OK_OPTION)
                {
                    dispose();
                }
            }
        });

        setVisible(true);

    }

}
