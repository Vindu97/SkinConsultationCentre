package company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static company.WestminsterSkinConsultationManager.doctors;

public class GUIConsultation extends JFrame implements ActionListener {
    JLabel label = new JLabel();
    JButton submitButton1;
    JButton BackBtn;
    JComboBox comboBox;

    public GUIConsultation(){



        ConsultationTable table = new ConsultationTable(doctors);
        table.setVisible(true);

//        this.add(submitButton);
//        this.add(BackBtn);
//        this.add(label);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource()==comboBox){
////            submitButton.setVisible(true);
//            AddPatient add = new AddPatient();
//
//        }

    }
}
