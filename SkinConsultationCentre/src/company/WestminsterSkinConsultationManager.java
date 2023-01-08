package company;
import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

//Console class
public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    //create doctor array list
    static ArrayList<Doctor> doctors = new ArrayList<>();
    //Create test file
    public File docFile = new File("file.text");
    //Initiate maximum doctors
    static int maxNumDoctors = 10;

    //Create input variable
    Scanner input = new Scanner(System.in);

    //Console Menu
    public static void menu() {
        System.out.println("----------Menu----------");
        System.out.println("");
        System.out.println(" 1 : Add a new doctor");
        System.out.println(" 2 : Delete doctor");
        System.out.println(" 3 : Print the list of the doctors");
        System.out.println(" 4 : Save in a file");
        System.out.println(" 5 : Graphical User Interface");
        System.out.println(" 6 : Exit");
        System.out.println("");
        System.out.println("-------------------------");

    }

    //Initiate Menu list
    @Override
    public void menuList() {

        menu();
        String var1;
        System.out.print("Select The Menu Number : ");
        var1 = input.next();

        while (var1 != "7") {
            if (var1.equals("1")) {
                doctorInput();
                menuList();

            } else if (var1.equals("2")) {
                doctorDelete();
                menuList();

            } else if (var1.equals("3")) {
                doctorsTable();
                menuList();

            } else if (var1.equals("4")) {
                saveDetails();
                menuList();

            } else if (var1.equals("5")) {
//                TestGUI.getFrames();
                new TestGUI();
                break;

            } else if (var1.equals("6")) {
                exit();

            }else {
                System.out.println("*** Wrong Input ***");
                return;
            }
        }
    }

    //Get doctor details
    @Override
    public void doctorInput() {

        System.out.println("");
        System.out.print("Enter Doctor Licence Number : ");
        String LNo = input.next();
        System.out.print("Enter Doctor's name : ");
        String new_name = input.next();
        System.out.print("Enter Doctor's surname : ");
        String surname = input.next();
        System.out.print("Enter Doctor specialisation : ");
        String spec = input.next();
        System.out.print("Enter Doctor date of birth : ");
        String doctor_dob = input.next();
        System.out.print("Enter Doctor's mobile number : ");
        String mobNo = input.next();
        System.out.print("Enter Doctor's Year : ");
        int year = input.nextInt();
        System.out.print("Enter Doctor's Month : ");
        int month = input.nextInt();
        System.out.print("Enter Doctor's Day: ");
        int day = input.nextInt();
        System.out.print("Enter Doctor's Start Time : ");
        int sTime = input.nextInt();
        System.out.print("Enter Doctor's End Time : ");
        int eTime = input.nextInt();
        int min=0;


        //Create localDate start time and end time
        LocalDateTime time1 = LocalDateTime.of(year,month,day,sTime,min);
        LocalDateTime time2 = LocalDateTime.of(year,month,day,eTime,min);

        Doctor f1 = new Doctor(LNo, new_name, surname, spec, doctor_dob, mobNo, time1,time2);
        addDoctor(f1);
    }



    //Check maximum doctors
    @Override
    public void addDoctor(Doctor doctor) {
        if (maxNumDoctors == doctors.size()) {
            System.out.println("Error: Reach max doctors");
        } else {
            doctors.add(doctor);
            maxNumDoctors = -1;
        }
    }


    //Delete doctor from the list
    @Override
    public void doctorDelete() {

        if (doctors.size() == 0) {
            System.out.println("There ara no more doctors");
            return;
        }
        String deleteName;
        System.out.println("");
        System.out.print("Enter Doctor Licence Number : ");
        deleteName = input.next();

        String finalDeleteName = deleteName;
        //doctors.removeIf(doctor -> doctor.getLicenceNumber().equals(finalDeleteName));

        Iterator<Doctor> item = doctors.iterator();
        while (item.hasNext()) {
            Doctor doctor = item.next();
            if (doctor.getLicenceNumber().equals(finalDeleteName)) {
                item.remove();
                System.out.println(doctor.getSpecialisation()+ " specialist Dr." +doctor.getName()+ " "+ doctor.getSurname()+ "("+doctor.getLicenceNumber()+") has been deleted.");
                System.out.println("Available number of doctors = "+ doctors.size());
                break;
            }else{
                System.out.println("wrong licence number");
                doctorDelete();
            }
        }
    }


    //Get doctor details as a table
    @Override
    public void doctorsTable() {

        Collections.sort(doctors, new Comparator<Doctor>() {
            @Override
            public int compare(Doctor d1, Doctor d2) {
                return d1.getSurname().compareTo(d2.getSurname());
            }
        });


        String Table = "| %-14s | %-14s | %-14s | %-14s | %-14s | %-14s | %n";

        System.out.format("+-----------------------------------------------------------------------------------------------------+%n");
        System.out.format("| List Of The Doctors                                                                                 |%n");
        System.out.format("+----------------+----------------+----------------+----------------+----------------+----------------+%n");
        System.out.format("|  LicenceNumber |   First Name   |    Surname     | Specialisation |  DateOfBirth   |  MobileNumber  |%n");
        System.out.format("+----------------+----------------+----------------+----------------+----------------+----------------+%n");

        for (Doctor doctor : doctors) {
            System.out.format(Table, doctor.getLicenceNumber(), doctor.getName(), doctor.getSurname(),
                    doctor.getSpecialisation(), doctor.getDateOfBirth(), doctor.getMobileNumber());

        }
        System.out.format("+----------------+----------------+----------------+----------------+----------------+----------------+%n");

    }


    //Save doctor details
    @Override
    public void saveDetails() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(docFile))) {
            for (Doctor doctor : doctors) {
                writer.write(doctor.getLicenceNumber() + "\t" + doctor.getName() + "\t" + doctor.getSpecialisation()
                        +"\t" + doctor.getDateOfBirth() +"\t" + doctor.getMobileNumber() +"\t" + doctor.getSurname()
                        +"\t" + doctor.getStartTime() +"\t" + doctor.getEndTime() + "\n");
//                   writer.write(doctorsFile);
            }
        } catch (IOException e) {
            System.out.println("Error saving doctors to file");
        }
}

    //Recover previous data
    @Override
    public void recoverStats() {
        try (BufferedReader reader = new BufferedReader(new FileReader(docFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                String name = parts[0];
                String surname = parts[1];
                String dateOfBirth = parts[2];
                String mobileNumber = parts[3];
                String medicalLicenceNumber = parts[4];
                String specialization = parts[5];
                LocalDateTime startTime= LocalDateTime.parse(parts[6]);
                LocalDateTime endTime= LocalDateTime.parse(parts[7]);
                Doctor doctor = new Doctor(name, surname, dateOfBirth, mobileNumber, medicalLicenceNumber, specialization,startTime,endTime);
                doctors.add(doctor);
//                    doctorsList.add(new Doctor(name,surname,dateOfBirth,mobileNumber,medicalLicenceNumber,specialization));
            }
        } catch (IOException|ArrayIndexOutOfBoundsException e) {
            // File not found or error reading file, ignore and start with empty list of doctors
        }
    }

    //exit from the code
    @Override
    public void exit() {
        System.out.println("Program Exit");
        System.exit(-1);

    }
}

