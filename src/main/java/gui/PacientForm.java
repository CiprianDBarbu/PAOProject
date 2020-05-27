package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PacientForm extends JFrame{
    private JPanel pacientPannel;
    private JTextField enterNameHereTextField;
    private JTextField enterAgeHereTextField;
    private JTextField pleaseUseCommaTextField;
    private JButton SUBMITButton;
    private JButton BACKButton;

    public PacientForm() {

        add(pacientPannel);

        setTitle("Make an appointment");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500,400);
        BACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
                MainMenuForm mainMenuForm = new MainMenuForm();
                mainMenuForm.setLocation(getLocation());
            }
        });
    }
}
