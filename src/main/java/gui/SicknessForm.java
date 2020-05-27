package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SicknessForm extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton SUBMITButton;
    private JPanel sicknessPannel;
    private JButton BACKButton;

    public SicknessForm() {
        add(sicknessPannel);

        setTitle("Make an appointment");
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
