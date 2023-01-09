package company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import static company.WestminsterSkinConsultationManager.doctors;

public class All_Doctors extends JFrame  {

    Table table = new Table(doctors);


    public All_Doctors() {

        Table table = new Table(doctors);
        table.setVisible(true);

    }


}

//