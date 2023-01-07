package company;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class TestGUI extends JFrame implements ActionListener {

    JButton doctors = new JButton();
    JButton Add_patient = new JButton();
    JButton consultation = new JButton();
    JButton Add_notes = new JButton();
    JButton button5 = new JButton();


    public TestGUI() {

        doctors.setBounds(180,125,200,50);
        doctors.setBackground(new Color(0x87878A));
        doctors.addActionListener(this);
        doctors.setText("Doctors");
        doctors.setHorizontalTextPosition(JButton.CENTER);
        doctors.setVerticalTextPosition(JButton.CENTER);
        doctors.setFont(new Font("SERIF",Font.BOLD,20));
//        doctors.setBorder(BorderFactory.createEtchedBorder());

        Add_patient.setBounds(180,225,200,50);
        Add_patient.setBackground(new Color(0x87878A));
        Add_patient.addActionListener(this);
        Add_patient.setText("Add_patient");
        Add_patient.setHorizontalTextPosition(JButton.CENTER);
        Add_patient.setVerticalTextPosition(JButton.CENTER);
        Add_patient.setFont(new Font("SERIF",Font.BOLD,20));


        Add_notes.setBounds(180,325,200,50);
        Add_notes.setBackground(new Color(0x87878A));
        Add_notes.addActionListener(this);
        Add_notes.setText("Add some notes");
        Add_notes.setHorizontalTextPosition(JButton.CENTER);
        Add_notes.setVerticalTextPosition(JButton.CENTER);
        Add_notes.setFont(new Font("SERIF",Font.BOLD,20));

        JLabel label = new JLabel();
        label.setText("Westminster Skin Consultation Manager");
        label.setForeground(new Color(0x522552));
        label.setFont(new Font("SERIF", Font.BOLD, 28));
        label.setVisible(true);
        label.setBounds(0, 50, 90, 40);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);

       // JFrame frame = new JFrame();
        this.setTitle("SkinConsultation ");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        frame.setLayout(null);
        this.setResizable(true);
        this.setSize(600, 540);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(0xE3B8B8));



        this.add(doctors);
        this.add(Add_patient);
        this.add(Add_notes);
        this.add(label);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Add_patient){
//            this.dispose();
            new AddPatient();

        }
        if (e.getSource()==doctors){
//            this.dispose();
            new All_Doctors();

        }
//        if (e.getSource()==consultation){
////            this.dispose();
//            new GUIConsultation();
//
//        }
//        if (e.getSource()==Add_notes){
////            this.dispose();
//            try {
//                new AddNotes();
//            } catch (NoSuchAlgorithmException ex) {
//                throw new RuntimeException(ex);
//            } catch (NoSuchPaddingException ex) {
//                throw new RuntimeException(ex);
//            } catch (InvalidKeyException ex) {
//                throw new RuntimeException(ex);
//            } catch (IllegalBlockSizeException ex) {
//                throw new RuntimeException(ex);
//            } catch (BadPaddingException ex) {
//                throw new RuntimeException(ex);
//            } catch (UnsupportedEncodingException ex) {
//                throw new RuntimeException(ex);
//            }




    }

}