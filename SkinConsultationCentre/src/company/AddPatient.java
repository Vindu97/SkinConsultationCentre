package company;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;


public class AddPatient extends JFrame implements ActionListener {


    private ArrayList<Doctor> doctors;

    static ArrayList<Patient> patients = new ArrayList<>();
    File patientFile = new File("patient.txt");
    JFrame Frame2 = new JFrame();

    JTextField textField1 = new JFormattedTextField();
    JTextField textField2 = new JFormattedTextField();
    JTextField textField3 = new JFormattedTextField();
    JTextField textField4 = new JFormattedTextField();
    JTextField textField5 = new JFormattedTextField();

    JPanel pan1 = new JPanel();
    JPanel pan2 = new JPanel();
    JButton button = new JButton("Submit");

    public AddPatient() {

        pan1.setLayout(new GridLayout(11, 1, 5, 5));
        pan2.setLayout(new GridLayout(1, 1, 5, 5));

        JLabel l1 = new JLabel("Name :");
        pan1.add(l1);
        textField1.setPreferredSize(new Dimension(450, 40));
        pan1.add(textField1);
        JLabel l2 = new JLabel("Surname :");
        pan1.add(l2);
        textField2.setPreferredSize(new Dimension(250, 40));
        pan1.add(textField2);
        JLabel l3 = new JLabel("Date of Birth :");
        pan1.add(l3);
        textField3.setPreferredSize(new Dimension(250, 40));
        pan1.add(textField3);
        JLabel l4 = new JLabel("Mobile Number :");
        pan1.add(l4);
        textField4.setPreferredSize(new Dimension(250, 40));
        pan1.add(textField4);
        JLabel l5 = new JLabel("ID :");
        pan1.add(l5);
        textField5.setPreferredSize(new Dimension(250, 40));
        pan1.add(textField5);


        Font font = new Font("Roboto", Font.BOLD, 40);
        JTextField textField = new JFormattedTextField(10);
        textField.setFont(font);

        JLabel label = new JLabel();
        label.setText("Westminster Skin Consultation");
        label.setForeground(new Color(0x522552));
        label.setFont(new Font("SERIF", Font.BOLD, 28));
        label.setVisible(true);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);


        button.addActionListener(this);
        button.setFont(new Font("SERIF", Font.PLAIN, 20));
        button.setBackground(new Color(0xAD86CB86, true));
        button.setVerticalAlignment(JLabel.TOP);
        button.setHorizontalAlignment(JLabel.CENTER);


        this.setTitle("SkinConsultation ");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(550, 650);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setVisible(true);


        this.add(label);
        this.add(pan1);
        this.add(pan2);
        pan2.add(button);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            new ConsultationGUI();

//                System.out.println(doctorBox.getSelectedItem());
//                System.out.println(yearsField.getSelectedItem());
////            new AddPatient();
                patientRecoverStats();


                Frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                Frame2.setSize(300, 400);
                Frame2.setLayout(new FlowLayout(FlowLayout.CENTER));
                Frame2.setVisible(true);
                Frame2.setFont(new Font("SERIF", Font.PLAIN, 50));

                JTextArea Details = new JTextArea("-------------------- Details -------------------- :\n" + "\n" +
                        "Name :" + textField1.getText() + "\n" + "\n" +
                        "Surname :" + textField2.getText() + "\n" + "\n" +
                        "Date of Birth :" + textField3.getText() + "\n" + "\n" +
                        "Mobile Number :" + textField4.getText() + "\n" + "\n" +
                        "ID :" + textField5.getText() + "\n" + "\n" +
                        "--------------------------------------------------- ");
                Frame2.add(Details);
                Patient pat = new Patient(textField1.getText(), textField2.getText(), textField3.getText(), textField4.getText(), textField5.getText());
                patients.add(pat);
//            patientSaveDetails(pat);

                patientSaveDetails();

//            for (Patient patient : patients) {
//                System.out.println(patient.getName() + ", " + patient.getPersonId()+","+ patient.getDateOfBirth());
//            }

//        char[] chars = textField9.getText().toCharArray();
//        for (char c : chars){
//            c +=5;
//            System.out.print(c);


            }
        }


        private void patientSaveDetails () {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(patientFile))) {
                for (Patient patient : patients) {
                    writer.write(patient.getName() + "\t" + patient.getSurname() + "\t" + patient.getMobileNumber() + "\t" + patient.getDateOfBirth() + "\t" + patient.getPersonId() + "\n");
                    //     writer.write(String.valueOf(patientFile));
                }
            } catch (IOException e) {
                System.out.println("Error saving doctors to file");
            }
        }

        private void patientRecoverStats () {
            try (BufferedReader reader = new BufferedReader(new FileReader(patientFile))) {
                String line;
                while ((line = reader.readLine()) == null) {
                    String[] parts = line.split("\t");
                    String name = parts[0];
                    String surname = parts[1];
                    String dateOfBirth = parts[2];
                    String mobileNumber = parts[3];
                    String personId = parts[4];
//                String specialization = parts[5];
                    Patient patient = new Patient(name, surname, dateOfBirth, mobileNumber, personId);
                    patients.add(patient);
//                    doctorsList.add(new Doctor(name,surname,dateOfBirth,mobileNumber,medicalLicenceNumber,specialization));
                }
            } catch (IOException exception) {
                // File not found or error reading file, ignore and start with empty list of doctors
            }
        }

    }