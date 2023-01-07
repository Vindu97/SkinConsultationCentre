package company;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class ConsultationGUI extends JFrame implements ActionListener {

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
    JPanel pan3 = new JPanel();
    JPanel pan4 = new JPanel();

    JComboBox doctorBox;
    JComboBox hourBox;
    JComboBox minutesBox;
    JComboBox yearsField;
    JComboBox monthsField;
    JComboBox daysField;
    JComboBox durationField;
    JTextField noteField = new JFormattedTextField();
    JLabel label12 = new JLabel();
    JButton Upload = new JButton("Upload Image");
    JButton Submit2 = new JButton("Submit");
    JButton Encrypted = new JButton("Encrypted");

    Integer[] months = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    Integer[] duration = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public ConsultationGUI() {

        pan1.setLayout(new GridLayout(2, 6, 3, 20));
        pan2.setLayout(new GridLayout(1, 2, 3, 40));

        JLabel timeLb = new JLabel("Consultation Time : ");
        String[] hours = addHours();
        String[] minutes = addMinutes();
        hourBox = new JComboBox(hours);
        minutesBox = new JComboBox(minutes);


        JLabel availability = new JLabel("select");
        JLabel year = new JLabel("               Year :");
        ArrayList<Integer> years = addYears();
        yearsField = new JComboBox(years.toArray());
        yearsField.addActionListener(this);
        JLabel month = new JLabel("             Month :");
        monthsField = new JComboBox(months);
        monthsField.addActionListener(this);
        JLabel day = new JLabel("             Day :");
        ArrayList<Integer> days = addDays();
        daysField = new JComboBox(days.toArray());
        JLabel durationLabel = new JLabel("Duration (hrs) :");
        durationField = new JComboBox(duration);

        JLabel Doctor = new JLabel("Enter Doctor Name :");
        ArrayList<Doctor> Object = new ArrayList<Doctor>(WestminsterSkinConsultationManager.doctors);
        JComboBox<String> docComboBox = new JComboBox<>();
        for (Doctor doctor : Object) {
            docComboBox.addItem(doctor.getName());
        }


        pan3.setLayout(new GridLayout(1, 2, 5, 5));
        JLabel notes = new JLabel("Add some notes :");
        noteField.setPreferredSize(new Dimension(250, 100));

        JTextArea ta = new JTextArea(10, 50);

        this.setTitle("SkinConsultation ");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(610, 700);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setVisible(true);


        this.add(pan1);
        this.add(pan2);
        this.add(pan4);
        this.add(pan3);

        this.add(timeLb);
        pan1.add(availability);
        pan1.add(year);
        pan1.add(yearsField);
        pan1.add(month);
        pan1.add(monthsField);
        pan1.add(day);
        pan1.add(daysField);
        pan1.add(durationLabel);
        pan1.add(durationField);
        pan2.add(Doctor);
        pan2.add(docComboBox);
        pan2.add(timeLb);
        pan2.add(hourBox);
        pan2.add(minutesBox);
        pan4.add(ta);
        pan3.add(notes);
        pan3.add(noteField);
        this.add(Upload);
        this.add(label12);
        this.add(Encrypted);
        this.add(Submit2);


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

    public ArrayList<Integer> addYears() {
        ArrayList<Integer> yearList = new ArrayList<>();
        for (int year = 2023; year <= 2040; year++) {
            yearList.add(year);
        }

        return yearList;
    }

    public ArrayList<Integer> addDays() {
        ArrayList<Integer> dayList = new ArrayList<>();
        for (int day = 1; day <= 31; day++) {
            dayList.add(day);
        }
        return dayList;
    }

    private String[] addMinutes() {
        String[] minute = new String[60];
        String number;
        for (int i = 0; i < minute.length; i++) {
            if (i < 10) {
                number = ("0" + i);
            } else {
                number = (Integer.toString(i));
            }
            minute[i] = number;
        }
        return minute;
    }

    private String[] addHours() {
        String[] hour = new String[24];
        String number;
        for (int i = 0; i < hour.length; i++) {
            if (i < 10) {
                number = ("0" + i);
            } else {
                number = (Integer.toString(i));
            }
            hour[i] = number;
        }
        return hour;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == yearsField) {
            yearsField.getSelectedItem();

        }
        if (e.getSource() == monthsField) {
            monthsField.getSelectedItem();
        }
        if (e.getSource() == Encrypted) {
            System.out.println(monthsField.getSelectedItem());
            System.out.println(yearsField.getSelectedItem());

        }
    }
}