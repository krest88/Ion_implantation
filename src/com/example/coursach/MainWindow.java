package com.example.coursach;

import javax.swing.*;
import java.awt.event.*;

public class MainWindow extends JDialog {
    private JPanel contentPane;
    private JButton BuildPlotButton;
    private JRadioButton bRadioButton;
    private JRadioButton pRadioButton;
    private JRadioButton asRadioButton;
    private JRadioButton sbRadioButton;
    private JTextArea SelectIonTextArea;
    private JTextField EnergyTextField;
    private JTextField DoseTextField;

    public MainWindow() {
        setContentPane(contentPane);
        setModal(true);

        //skdskldfs'f
        IonImplantation ii = new IonImplantation("B", 10, 50000);
        //ii.ConcentrationProfile();

        bRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ii = null;

            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
    }

    private void onClick(){

    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        MainWindow dialog = new MainWindow();
        dialog.pack();
        dialog.setVisible(true);


        System.exit(0);
    }
}
