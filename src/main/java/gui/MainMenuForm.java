package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuForm extends JFrame{
    private JButton enterAsPACIENTButton;
    private JButton enterAsADMINButton;
    private JPanel mainPannel;

    public MainMenuForm(){

        add(mainPannel);


        setTitle("Make an appointment");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500,400);

        enterAsPACIENTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
                PacientForm pacientForm = new PacientForm();
                pacientForm.setLocation(getLocation());
            }
        });
        enterAsADMINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
                AdminForm adminForm = new AdminForm();
                adminForm.setLocation(getLocation());
            }
        });
    }
}
