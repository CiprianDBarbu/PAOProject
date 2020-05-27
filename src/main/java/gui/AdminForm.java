package gui;

import model.Doctor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminForm extends JFrame{
    private JButton enterADoctorButton;
    private JButton enterAnIllnessButton;
    private JPanel adminPannel;
    private JButton BACKButton;

    public AdminForm(){
        add(adminPannel);

        setTitle("ADMIN MODE");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500,400);
        enterADoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
                DoctorForm doctorForm = new DoctorForm();
                doctorForm.setLocation(getLocation());
            }
        });
        enterAnIllnessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
                SicknessForm sicknessForm = new SicknessForm();
                sicknessForm.setLocation(getLocation());
            }
        });
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
