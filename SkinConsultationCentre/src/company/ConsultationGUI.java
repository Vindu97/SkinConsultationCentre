package company;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ConsultationGUI extends JFrame implements ActionListener {

    private ArrayList<Doctor> doctors;
    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Consultation> consultations = new ArrayList<>();
    File consultationFile = new File("consultation.txt");

    JComboBox<String> docComboBox = new JComboBox<>();
    JFrame Frame2 = new JFrame();

    JTextField textField6 = new JFormattedTextField();
    JTextField textField7 = new JFormattedTextField();
    JTextField textField8 = new JFormattedTextField();
    JTextField textField9 = new JFormattedTextField();
    JTextField textField11 = new JFormattedTextField();
    JPanel pan1 = new JPanel();
    JPanel pan2 = new JPanel();
    JPanel pan3 = new JPanel();
    JPanel pan4 = new JPanel();
    JPanel pan5 = new JPanel();
    JTextField noteField = new JFormattedTextField();
    JLabel label12 = new JLabel();
    JButton Upload = new JButton("Upload Image");
    JButton Submit2 = new JButton("Submit");
    JButton Encrypted = new JButton("Encrypted");
    JButton Check = new JButton("Check");
    String pId;
    String name;
    String Surname;
    String Dob;
    String mNumber;

    public ConsultationGUI(String pId,String name,String Surname,String Dob,String mNumber) {
        this.pId=pId;
        this.name=pId;
        this.Surname=pId;
        this.Dob=pId;
        this.mNumber=pId;

        pan1.setLayout(new GridLayout(1, 10, 3, 20));
        JLabel l6 = new JLabel("Year :");
        pan1.add(l6);
        textField6.setPreferredSize(new Dimension(50, 30));
        pan1.add(textField6);
        JLabel l7 = new JLabel("Month :");
        pan1.add(l7);
        textField7.setPreferredSize(new Dimension(50, 30));
        pan1.add(textField7);
        JLabel l8 = new JLabel("Day :");
        pan1.add(l8);
        textField8.setPreferredSize(new Dimension(50, 30));
        pan1.add(textField8);


        pan2.setLayout(new GridLayout(1, 1, 3, 30));
        JLabel l9 = new JLabel("Start Time :");
        pan2.add(l9);
        textField9.setPreferredSize(new Dimension(10, 30));
        pan2.add(textField9);
        JLabel l11 = new JLabel("End Time :");
        pan2.add(l11);
        textField11.setPreferredSize(new Dimension(10, 30));
        pan2.add(textField11);
        JLabel Doctor = new JLabel("Enter Doctor Name :");
        ArrayList<Doctor> Object = new ArrayList<Doctor>(WestminsterSkinConsultationManager.doctors);

        for (Doctor doctor : Object) {
            docComboBox.addItem(doctor.getName());
        }


        JTextArea ta = new JTextArea(10, 50);
        ta.append("adafsasvsc");

        pan3.setLayout(new GridLayout(1, 2, 5, 1));
        JLabel notes = new JLabel("Add some notes :");
        noteField.setPreferredSize(new Dimension(350, 100));


        Font font = new Font("Roboto", Font.BOLD, 40);
        JTextField textField = new JFormattedTextField(10);
        textField.setFont(font);

        JLabel label = new JLabel();
        label.setText("   Westminster Skin Consultation   ");
        label.setForeground(new Color(0x522552));
        label.setFont(new Font("SERIF", Font.BOLD, 28));
        label.setVisible(true);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);


        this.setTitle("SkinConsultation ");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(750, 700);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setVisible(true);


        this.add(label);
        this.add(pan1);
        this.add(pan2);
        this.add(pan5);
        this.add(pan4);
        this.add(pan3);
        pan2.add(Doctor);
        pan2.add(docComboBox);
        pan5.add(Check);
        pan4.add(ta);
        pan3.add(notes);
        pan3.add(noteField);
        this.add(Upload);
        this.add(label12);
        this.add(Encrypted);
        this.add(Submit2);
        System.out.println(pId+" "+Surname);


        Upload.addActionListener(new ActionListener() {
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
        if (e.getSource() == Check) {

            Frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Frame2.setSize(300, 400);
            Frame2.setLayout(new FlowLayout(FlowLayout.CENTER));
            Frame2.setVisible(true);
            Frame2.setFont(new Font("SERIF", Font.PLAIN, 50));

            JTextArea Details = new JTextArea("-------------------- Details -------------------- :\n" + "\n" +
                    "Name :" + name+ "\n" + "\n" +
                    "Surname :" + Surname+ "\n" + "\n" +
                    "Date of Birth :" + Dob + "\n" + "\n" +
                    "Mobile Number :" + mNumber + "\n" + "\n" +
                    "ID :" + pId + "\n" + "\n" +
                    "--------------------------------------------------- ");
            Frame2.add(Details);

            patientRecoverStats();


            String note = noteField.getText();
            int year = Integer.parseInt(textField6.getText());
            int Month = Integer.parseInt(textField7.getText());
            int Day = Integer.parseInt(textField8.getText());
            int sTime = Integer.parseInt(textField9.getText());
            int eTime = Integer.parseInt(textField11.getText());
            int min=0;
            double cost = (eTime-sTime)*15;
            new AddPatient();
//            patients.get(0).getPersonId().equals(textField5.getText());


            LocalDateTime time1 = LocalDateTime.of(year,Month,Day,sTime,min);
            LocalDateTime time2 = LocalDateTime.of(year,Month,Day,eTime,min);

            Consultation consultation = new Consultation(cost,note,time1,time2);

            patientSaveDetails();
            Object sel = docComboBox.getSelectedItem();
            String selString = (String) sel;
            System.out.println("Docter"+ selString);

        }
        if (e.getSource() == Submit2){
            Frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Frame2.setSize(300, 400);
            Frame2.setLayout(new FlowLayout(FlowLayout.CENTER));
            Frame2.setVisible(true);
            Frame2.setFont(new Font("SERIF", Font.PLAIN, 50));

            JTextArea Details = new JTextArea("-------------------- Details -------------------- :\n" + "\n" +
                    "Name :" + name+ "\n" + "\n" +
                    "Surname :" + Surname+ "\n" + "\n" +
                    "Date of Birth :" + Dob + "\n" + "\n" +
                    "Mobile Number :" + mNumber + "\n" + "\n" +
                    "ID :" + pId + "\n" + "\n" +
                    "--------------------------------------------------- ");
            Frame2.add(Details);

        }
//
    }


    private void patientSaveDetails () {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(consultationFile))) {
            for (Consultation consultation : consultations) {
                writer.write(consultation.getCost() + "\t" + consultation.getStartTime() + "\t" + consultation.getEndTime() + "\t" + consultation.getNotes() + "\t" +   "\n");
                //     writer.write(String.valueOf(patientFile));
            }
        } catch (IOException e) {
            System.out.println("Error saving doctors to file");
        }
    }

    private void patientRecoverStats () {
        try (BufferedReader reader = new BufferedReader(new FileReader(consultationFile))) {
            String line;
            while ((line = reader.readLine()) == null) {
                String[] parts = line.split("\t");
                String note = parts[0];
                double cost = Double.parseDouble(parts[1]);
                LocalDateTime startTime= LocalDateTime.parse(parts[2]);
                LocalDateTime endTime= LocalDateTime.parse(parts[3]);
                Consultation consultation = new Consultation(cost, note,startTime,endTime);
                consultations.add(consultation);
//                    doctorsList.add(new Doctor(name,surname,dateOfBirth,mobileNumber,medicalLicenceNumber,specialization));
            }
        } catch (IOException exception) {
            // File not found or error reading file, ignore and start with empty list of doctors
        }
    }
//
//for (int i = 0; i < WestminsterSkinConsultationManager.doctorsList.size(); i++) {
//        if (Objects.equals(WestminsterSkinConsultationManager.doctorsList.get(i).getName(), selectedItemString)) {
//            boolean x = datetime2.isBefore(WestminsterSkinConsultationManager.doctorsList.get(i).endLocalDateTime);
//            boolean y = datetime1.isAfter(WestminsterSkinConsultationManager.doctorsList.get(i).startLocalDateTime);
//            if (x == true && y == true) {
//                System.out.println("You have succesfully consulted Dr." + selectedItemString);
//                break;
//            } else {
//                System.out.println("Dr." + selectedItemString + " is not available for this date and time.");
//                for (int a = 0; a < WestminsterSkinConsultationManager.doctorsList.size(); a++) {
//                    boolean b = datetime2.isBefore(WestminsterSkinConsultationManager.doctorsList.get(a).endLocalDateTime);
//                    boolean c = datetime1.isAfter(WestminsterSkinConsultationManager.doctorsList.get(a).startLocalDateTime);
//                    if (b == true && c == true) {
//                        System.out.println("You will allocate for the Dr." + WestminsterSkinConsultationManager.doctorsList.get(a).getName());
//                        break;
//                    } else {
//                        System.out.println("Sorry! There is no any doctor for this date and time.");
//                        break;
//                    }
//                }
//            }
//        }
//    }

//    for (int i = 0; i < consultations.size(); i++) {
//        if (consultations.get(i).getPatientId() == patientId ){
//            System.out.println("consultation fee: pound " + ((consulteHour - consultsHour)*25));
//            break;
//        }
//        else {
//            System.out.println("consultation fee: pound " + ((consulteHour - consultsHour)*15));
//            break;

}