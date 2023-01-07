package company;

import java.util.Scanner;

public class Menu {
    static WestminsterSkinConsultationManager westminsterSkinConsultationManager = new WestminsterSkinConsultationManager();


//    public static void menu(){
//        System.out.println("----------Menu----------");
//        System.out.println("");
//        System.out.println(" 1 : Add a new doctor");
//        System.out.println(" 2 : Delete doctor");
//        System.out.println(" 3 : Print the list of the doctors");
//        System.out.println(" 4 : Save in a file");
//        System.out.println(" 5 : Exit");
//        System.out.println("");
//        System.out.println("-------------------------");
//
//    }
//
//    Scanner input = new Scanner(System.in);
//
//    public void menuList(){
//
//        menu();
//        String var1;
//        System.out.print("Select The Menu Number : ");
//        var1 = input.next();
//
//        while (var1 != "5"){
//            if(var1.equals("1")){
//                doctorInput();
//                menuList();
//
//            } else if (var1.equals("2")) {
//                doctorDelete();
//                menuList();
//
//            } else if (var1.equals("3")) {
//                westminsterSkinConsultationManager.doctorsTable();
//                menuList();
//
//            } else if (var1.equals("4")) {
//                westminsterSkinConsultationManager.saveDetails();
//                menuList();
//
//            }else if (var1.equals("5")) {
//                exit();
//
//            }
//            else {
//                System.out.println("*** Wrong Input ***");
//                return;
//            }
//        }
//    }
//
//    private void doctorInput(){
//
//        System.out.println("");
//        System.out.print("Enter Doctor Licence Number : ");
//        String LNo = input.next();
//
//        while (true){
//            String team = "name";
//            for (Doctor doctor: WestminsterSkinConsultationManager.doctors){
//                if (doctor.getLicenceNumber().equals(LNo)){
//                    team = "rep_name";
//                    break;
//                }
//            }
//            if(team == "rep name"){
//                System.out.println("Try name");
//                System.out.println("licens");
//                LNo = input.next();
//            }else {
//                break;
//            }
//        }
//
//        System.out.print("Enter Doctor's name : ");
//        String new_name = input.next();
//        System.out.print("Enter Doctor's surname : ");
//        String surname = input.next();
//        System.out.print("Enter Doctor specialisation : ");
//        String spec = input.next();
//        System.out.print("Enter Doctor date of birth : ");
//        String doctor_dob = input.next();
//        System.out.print("Enter Doctor's mobile number : ");
//        String mobNo = input.next();
//
//        Doctor f1 = new Doctor(LNo, new_name, surname, spec, doctor_dob, mobNo);
//        westminsterSkinConsultationManager.addDoctor(f1);
//
//    }
//
//    private void doctorDelete() {
//
//        String deleteName;
//        System.out.println("");
//        System.out.print("Enter Doctor Licence Number : ");
//        deleteName = input.next();
//        while (true) {
//            String sameName = "none";
//            for (Doctor foemuldrive : WestminsterSkinConsultationManager.doctors) {
//                if (foemuldrive.getLicenceNumber().equals(deleteName)) {
//                    sameName = "repeatedName";
//                    break;
//                }
//            }
//            if (!sameName.equals("repeatedName")) {
//                System.out.println("gbdd");
//                System.out.println("ra");
//                deleteName = input.next();
//            } else {
//                break;
//            }
//        }
//        westminsterSkinConsultationManager.deleteDoctor(deleteName);
//
//    }
//    private void exit(){
//        System.out.println("Programe Exit");
//        System.exit(-1);
//
//    }



}
