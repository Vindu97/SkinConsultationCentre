package company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import static company.WestminsterSkinConsultationManager.doctors;

public class All_Doctors extends JFrame implements ActionListener {

    Table table = new Table(doctors);
    JButton BackBtn;

    public All_Doctors() {

        Table table = new Table(doctors);
        table.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==BackBtn){
            this.dispose();
            TestGUI GUI = new TestGUI();

        }

    }
}

//