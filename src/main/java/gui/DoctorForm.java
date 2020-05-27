package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorForm extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JPanel doctorPannel;
    private JButton SUBMITButton;
    private JButton BACKButton;

    public DoctorForm() {

        add(doctorPannel);

        setTitle("Add a doctor:");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500,400);
        BACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
                AdminForm adminForm = new AdminForm();
                adminForm.setLocation(getLocation());
            }
        });
    }
}
