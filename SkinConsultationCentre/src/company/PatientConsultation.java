package company;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class PatientConsultation extends JFrame implements ActionListener {
    static ArrayList<Patient> patients = new ArrayList<>();
    File patientFile = new File("patient.txt");

    private ArrayList<Doctor> doctors;

    JTextField textField1 = new JFormattedTextField();
    JTextField textField2 = new JFormattedTextField();
    JTextField textField3 = new JFormattedTextField();
    JTextField textField4 = new JFormattedTextField();
    JTextField textField5 = new JFormattedTextField();
//    JTextField textField6 = new JFormattedTextField();
    JTextField textField7 = new JFormattedTextField();
    JTextField textField8 = new JFormattedTextField();
    JTextField textField9 = new JFormattedTextField();
    JTextField textField10 = new JFormattedTextField();
    JTextField textField11 = new JFormattedTextField();
    JTextField textField12 = new JFormattedTextField();

    JFrame Frame2 = new JFrame();
    JPanel pan1 = new JPanel();
    JPanel pan2 = new JPanel();
    JPanel pan3 = new JPanel();
    JPanel pan4 = new JPanel();

    JLabel label12 = new JLabel();

    JComboBox comboBox;
    JButton button = new JButton("Submit");
    JButton button2 = new JButton("Upload Image");
    public PatientConsultation() {

        pan1.setLayout(new GridLayout(7, 2, 5, 5));
        pan2.setLayout(new GridLayout(1, 6, 5, 5));
        pan3.setLayout(new GridLayout(1, 6, 5, 5));
        pan4.setLayout(new GridLayout(1, 2, 5, 5));

        JLabel l1 = new JLabel("Name :");
        pan1.add(l1);
        textField1.setPreferredSize(new Dimension(250, 40));
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
        JLabel l6 = new JLabel("Enter Doctor Name :");
        pan1.add(l6);
        ArrayList<Doctor> Object = new ArrayList<Doctor>(WestminsterSkinConsultationManager.doctors);
        JComboBox<String> comboBox = new JComboBox<>();
        for (Doctor doctor : Object) {
            comboBox.addItem(doctor.getName());
        }
        pan1.add(comboBox);


        JLabel l7 = new JLabel("Year :");
        pan2.add(l7);
        textField7.setPreferredSize(new Dimension(50, 30));
        pan2.add(textField7);
        JLabel l8 = new JLabel("Month :");
        pan2.add(l8);
        textField8.setPreferredSize(new Dimension(50, 30));
        pan2.add(textField8);
        JLabel l9 = new JLabel("Day :");
        pan2.add(l9);
        textField9.setPreferredSize(new Dimension(50, 30));
        pan2.add(textField9);

        JLabel l10 = new JLabel("Start Time :");
        pan3.add(l10);
        textField10.setPreferredSize(new Dimension(10, 30));
        pan3.add(textField10);
        JLabel l11 = new JLabel("End Time :");
        pan3.add(l11);
        textField11.setPreferredSize(new Dimension(10, 30));
        pan3.add(textField11);

        JLabel l12 = new JLabel("Add some notes :");
        pan4.add(l12);
        textField12.setPreferredSize(new Dimension(250, 100));
        pan4.add(textField12);


        Font font = new Font("Roboto", Font.BOLD,25);
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
        this.setSize(630, 850);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setVisible(true);


        this.add(label);
        this.add(pan1);
        this.add(pan2);
        this.add(pan3);
        this.add(pan4);
        this.add(button2);
        this.add(label12);
        this.add(button);


        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filer = new FileNameExtensionFilter(" *.Image", "jpg", "gif" + "png");
                file.addChoosableFileFilter(filer);
                int result = file.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = file.getSelectedFile();
                    String path = selectedFile.getAbsolutePath();
                    label12.setIcon(ResizeImage(path));
                } else if (result == JFileChooser.CANCEL_OPTION) {
                    System.out.println("No file found");

                }
            }
        });

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(400, 200, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button){
            patientRecoverStats();
            // Get form values
            String name = textField1.getText();
            String surname = textField2.getText();
            String Dob = textField3.getText();
            String mNumber = textField4.getText();
            int ID = Integer.parseInt(textField5.getText());
            int year = Integer.parseInt(textField7.getText());
            int Month = Integer.parseInt(textField8.getText());
            int Day = Integer.parseInt(textField9.getText());
            int sTime = Integer.parseInt(textField10.getText());
            int eTime = Integer.parseInt(textField11.getText());
            int min = 0;
            String note = textField12.getText();


            //create LocalDateTime objects to store startTime and endTime
            LocalDateTime datetime1 = LocalDateTime.of(year, Month, Day, sTime, min);
            LocalDateTime datetime2 = LocalDateTime.of(year, Month, Day, eTime, min);


            char[] chars = note.toCharArray();
            for (char c : chars){
                c +=5;
                System.out.print(c);
            }

            for (int i = 0; i < patients.size(); i++) {
                if (patients.get(i).getPersonId() == ID) {
                    System.out.println("consultation fee: pound " + ((eTime - sTime) * 25));
                    break;
                } else {
                    System.out.println("consultation fee: pound " + ((eTime - sTime) * 15));
                    break;
                }
            }
//            Object selectedItem = comboBox.getSelectedItem();
//            String selectedItemString = (String) selectedItem;
//            System.out.println("Enter Doctor Name :" + selectedItemString);

//            for (int i = 0; i < WestminsterSkinConsultationManager.doctors.size(); i++) {
//                if (Objects.equals(WestminsterSkinConsultationManager.doctors.get(i).getName(), selectedItemString)) {
//                    boolean x = datetime2.isBefore(WestminsterSkinConsultationManager.doctors.get(i).getEndTime());
//                    boolean y = datetime1.isAfter(WestminsterSkinConsultationManager.doctors.get(i).getStartTime());
//                    if (x == true && y == true) {
//                        System.out.println("You have succesfully consulted Dr." + selectedItemString);
//                        break;
//                    } else {
//                        System.out.println("Dr." + selectedItemString + " is not available for this date and time.");
//                        for (int a = 0; a < WestminsterSkinConsultationManager.doctors.size(); a++) {
//                            boolean b = datetime2.isBefore(WestminsterSkinConsultationManager.doctors.get(a).getEndTime());
//                            boolean c = datetime1.isAfter(WestminsterSkinConsultationManager.doctors.get(a).getStartTime());
//                            if (b == true && c == true) {
//                                System.out.println("You will allocate for the Dr." + WestminsterSkinConsultationManager.doctors.get(a).getName());
//                                break;
//                            } else {
//                                System.out.println("Sorry! There is no any doctor for this date and time.");
//                                break;
//                            }
//                        }
//                    }
//                }
//            }


            Frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Frame2.setSize(300, 400);
            Frame2.setLayout(new FlowLayout(FlowLayout.CENTER));
            Frame2.setVisible(true);
            Frame2.setFont(new Font("SERIF", Font.PLAIN, 50));

            JTextArea Details = new JTextArea("-------------------- Details -------------------- :\n"+"\n"+
                    "Name :" + name+"\n"+"\n"+
                    "Surname :"+ surname+"\n"+"\n"+
                    "Date of Birth :"+Dob+"\n"+"\n"+
                    "Mobile Number :"+ mNumber+"\n"+"\n"+
                    "ID :"+ ID+"\n"+"\n"+
                    "Enter consultation hours :"+ (eTime-sTime)+"\n"+"\n"+
                    "Date and Time :"+ datetime1+"\n"+"\n"+
                    "Add some notes :"+ chars +"\n"+"\n"+
                    "--------------------------------------------------- ");
            Frame2.add(Details);
            Patient p1 = new Patient(name,surname,Dob,mNumber,ID,datetime1,datetime2);
            patients.add(p1);

//            for (Patient patient : patients) {
//                System.out.println(patient.getName() + " , " + patient.getPersonId());
//            }

            patientSaveDetails();


        }
    }

    public void patientSaveDetails() {


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(patientFile))) {
            for (Patient patient : patients) {
                writer.write(patient.getName() + "\t" + patient.getSurname() + "\t" + patient.getMobileNumber() +"\t" + patient.getDateOfBirth() +"\t" + patient.getPersonId() + "\n");
                //     writer.write(String.valueOf(patientFile));
            }
        } catch (IOException e) {
            System.out.println("Error saving doctors to file");
        }

    }

    public void patientRecoverStats() {
        try (BufferedReader reader = new BufferedReader(new FileReader(patientFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                String name = parts[0];
                String surname = parts[1];
                String dateOfBirth = parts[2];
                String mobileNumber = parts[3];
                int personId = Integer.parseInt(parts[4]);
                LocalDateTime sTime = LocalDateTime.parse(parts[5]);
                LocalDateTime eTime = LocalDateTime.parse(parts[5]);
                Patient Pat = new Patient(name, surname, dateOfBirth, mobileNumber, personId,sTime,eTime);
                patients.add(Pat);
//                    doctorsList.add(new Doctor(name,surname,dateOfBirth,mobileNumber,medicalLicenceNumber,specialization));
            }
        } catch (IOException |ArrayIndexOutOfBoundsException e) {
            // File not found or error reading file, ignore and start with empty list of doctors
        }
    }



}
//    private ArrayList<Doctor> doctors;
//
//    static ArrayList<Patient> patients = new ArrayList<>();
//    File patientFile = new File("patient.txt");
//    JFrame Frame2 = new JFrame();
//
//    JComboBox<String> docComboBox = new JComboBox<>();
//    JTextField textField1 = new JFormattedTextField();
//    JTextField textField2 = new JFormattedTextField();
//    JTextField textField3 = new JFormattedTextField();
//    JTextField textField4 = new JFormattedTextField();
//    JTextField textField5 = new JFormattedTextField();
//    JTextField textField6 = new JFormattedTextField();
//    JTextField textField7 = new JFormattedTextField();
//    JTextField textField8 = new JFormattedTextField();
//    JTextField textField9 = new JFormattedTextField();
//    JTextField textField11 = new JFormattedTextField();
//    JTextField noteField = new JFormattedTextField();
//    JPanel pan1 = new JPanel();
//    JPanel pan2 = new JPanel();
//    JPanel pan3 = new JPanel();
//    JButton button = new JButton("Submit");
//
//    public PatientConsultation() {
//
//        pan1.setLayout(new GridLayout(14, 1, 5, 5));
//        pan2.setLayout(new GridLayout(1, 1, 5, 5));
//        pan3.setLayout(new GridLayout(1, 1, 5, 5));
//
//        JLabel l1 = new JLabel("Name :");
//        pan1.add(l1);
//        textField1.setPreferredSize(new Dimension(450, 40));
//        pan1.add(textField1);
//        JLabel l2 = new JLabel("Surname :");
//        pan1.add(l2);
//        textField2.setPreferredSize(new Dimension(250, 40));
//        pan1.add(textField2);
//        JLabel l3 = new JLabel("Date of Birth :");
//        pan1.add(l3);
//        textField3.setPreferredSize(new Dimension(250, 40));
//        pan1.add(textField3);
//        JLabel l4 = new JLabel("Mobile Number :");
//        pan1.add(l4);
//        textField4.setPreferredSize(new Dimension(250, 40));
//        pan1.add(textField4);
//        JLabel l5 = new JLabel("ID :");
//        pan1.add(l5);
//        textField5.setPreferredSize(new Dimension(250, 40));
//        pan1.add(textField5);
//        //pan1.setLayout(new GridLayout(1, 10, 3, 20));
//        JLabel l6 = new JLabel("Year :");
//        pan1.add(l6);
//        textField6.setPreferredSize(new Dimension(50, 30));
//        pan1.add(textField6);
//        JLabel l7 = new JLabel("Month :");
//        pan1.add(l7);
//        textField7.setPreferredSize(new Dimension(50, 30));
//        pan1.add(textField7);
//        JLabel l8 = new JLabel("Day :");
//        pan1.add(l8);
//        textField8.setPreferredSize(new Dimension(50, 30));
//        pan1.add(textField8);
//
//
//        //pan2.setLayout(new GridLayout(1, 1, 3, 30));
//        JLabel l9 = new JLabel("Start Time :");
//        pan1.add(l9);
//        textField9.setPreferredSize(new Dimension(10, 30));
//        pan1.add(textField9);
//        JLabel l11 = new JLabel("End Time :");
//        pan1.add(l11);
//        textField11.setPreferredSize(new Dimension(10, 30));
//        pan1.add(textField11);
//        JLabel Doctor = new JLabel("Enter Doctor Name :");
//        ArrayList<Doctor> Object = new ArrayList<Doctor>(WestminsterSkinConsultationManager.doctors);
//
//        for (Doctor doctor : Object) {
//            docComboBox.addItem(doctor.getName());
//        }
//
//
////        JTextArea ta = new JTextArea(10, 50);
////        ta.append("adafsasvsc");
//
//       // pan3.setLayout(new GridLayout(1, 2, 5, 1));
//        JLabel notes = new JLabel("Add some notes :");
//        pan2.add(notes);
//        noteField.setPreferredSize(new Dimension(350, 100));
//        pan2.add(noteField);
//
//
//
//        Font font = new Font("Roboto", Font.BOLD, 40);
//        JTextField textField = new JFormattedTextField(10);
//        textField.setFont(font);
//
//        JLabel label = new JLabel();
//        label.setText("Westminster Skin Consultation");
//        label.setForeground(new Color(0x522552));
//        label.setFont(new Font("SERIF", Font.BOLD, 28));
//        label.setVisible(true);
//        label.setVerticalAlignment(JLabel.TOP);
//        label.setHorizontalAlignment(JLabel.CENTER);
//
//
//        button.addActionListener(this);
//        button.setFont(new Font("SERIF", Font.PLAIN, 20));
//        button.setBackground(new Color(0xAD86CB86, true));
//        button.setVerticalAlignment(JLabel.TOP);
//        button.setHorizontalAlignment(JLabel.CENTER);
//
//
//        this.setTitle("SkinConsultation ");
//        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        this.setSize(550, 650);
//        this.setLayout(new FlowLayout(FlowLayout.CENTER));
//        this.setVisible(true);
//
//        this.add(label);
//        this.add(pan1);
//        this.add(pan2);
//        this.add(pan3);
//        this.add(button);
//
//        pan3.add(Doctor);
//        pan3.add(docComboBox);
//
//
//    }
//
//
//
//
//
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }

