package company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Create GUI first page
public class TestGUI extends JFrame implements ActionListener {

    //Create buttons
    JButton View_doctors = new JButton();
    JButton consultation = new JButton();
    JButton Exit = new JButton();



    public TestGUI() {
        PatientConsultation.patientRecoverStats();

        //View all doctors button
        View_doctors.setBounds(180,125,200,50);
        View_doctors.setBackground(new Color(0x5F5FA6));
        View_doctors.addActionListener(this);
        View_doctors.setText("Doctors");
        View_doctors.setHorizontalTextPosition(JButton.CENTER);
        View_doctors.setVerticalTextPosition(JButton.CENTER);
        View_doctors.setFont(new Font("SERIF",Font.BOLD,20));


        //Add consultation button
        consultation.setBounds(180,225,200,50);
        consultation.setBackground(new Color(0x5F5FA6));
        consultation.addActionListener(this);
        consultation.setText("consultation");
        consultation.setHorizontalTextPosition(JButton.CENTER);
        consultation.setVerticalTextPosition(JButton.CENTER);
        consultation.setFont(new Font("SERIF",Font.BOLD,20));


        //Exit button
        Exit.setBounds(180,325,200,50);
        Exit.setBackground(new Color(0x9B4C4C));
        Exit.addActionListener(this);
        Exit.setText("Exit");
        Exit.setHorizontalTextPosition(JButton.CENTER);
        Exit.setVerticalTextPosition(JButton.CENTER);
        Exit.setFont(new Font("SERIF",Font.BOLD,20));

        //Create labels
        JLabel label = new JLabel();
        label.setText("Westminster Skin Consultation Manager");
        label.setForeground(new Color(0x522552));
        label.setFont(new Font("SERIF", Font.BOLD, 28));
        label.setVisible(true);
        label.setBounds(0, 50, 90, 40);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);


        this.setTitle("SkinConsultation ");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(true);
        this.setSize(600, 540);
        this.setVisible(true);
//        this.getContentPane().setBackground(new Color(0xE3B8B8));



        this.add(View_doctors);
        this.add(consultation);
        this.add(Exit);
        this.add(label);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==consultation){
            new ConsultationForm();

        }
        if (e.getSource()==View_doctors){
            new All_Doctors();

        }
        if (e.getSource()==Exit){
            this.dispose();

        }
    }
}