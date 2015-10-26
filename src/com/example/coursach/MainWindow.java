package com.example.coursach;

import javax.swing.*;
import java.awt.event.*;
import org.jfree.ui.RefineryUtilities;


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
        IonImplantation ii = new IonImplantation("B", 1e15, 50000);
        //ii.ConcentrationProfile();

        BuildPlotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                BuildPlot(ii);

            }
        });

        bRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ii.ChangeData("B", 1e15, 50000);

            }
        });
        pRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ii.ChangeData("P", 1e15, 50000);

            }
        });
        asRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ii.ChangeData("As", 1e15, 50000);

            }
        });
        sbRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ii.ChangeData("Sb", 1e15, 120000);

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

    private void BuildPlot(IonImplantation ii){
        final Chart demo = new Chart("Concentration profile in waffle of Si", ii);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
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
