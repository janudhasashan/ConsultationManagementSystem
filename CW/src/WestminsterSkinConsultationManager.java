import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class WestminsterSkinConsultationManager {

    static ArrayList<Doctor> doctors = new ArrayList<Doctor>(10);

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean eLoop = true;
        while (eLoop) {
            System.out.println("""

                    -WESTMINSTER SKIN CONSULTATION MANAGER-

                    Select a option from above List

                    Press 'A' for - Add a New Doctor
                    Press 'D' for - Delete a Doctor
                    Press 'P' for - Print the list of Doctors
                    Press 'S' for - Save all the information to a file
                    Press 'G' for - Open GUI
                    Press 'Q' for - Quit Program


                    Please Enter Your option:\s""");

            switch (Character.toUpperCase(input.next().charAt(0))) {
                case 'A' -> addDoctor();
                case 'D' -> deleteDoctor();
                case 'P' -> printDoctors();
                case 'S' -> storeDoctorDetails();
                case 'G' -> openGui();
                case 'Q' -> eLoop = false;
                default -> System.out.println("Invalid Option selected");
            }
        }
    }

    //ADD METHOD----------------------------------------------------------------------------------


    public static void addDoctor() {


        Scanner input = new Scanner(System.in);
        Date dob = new Date();

        System.out.println("Enter Doctor's First Name : ");
        String Name = input.next();

        System.out.println("Enter Doctor's Last Name : ");
        String Surname = input.next();



        System.out.println("Enter Doctor's Birth Year : ");
        int year = input.nextInt();

        System.out.println("Enter Doctor's Birth Month : ");
        int month = input.nextInt();

        System.out.println("Enter Doctor's Birth Date : ");
        int date = input.nextInt();

        dob.setYear(year);
        dob.setMonth(month);
        dob.setDate(date);



        System.out.println("Enter Doctor's Mobile Number : ");
        int MobileNum = 0;
        try{
            MobileNum = input.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Please enter valid Mobile number: ");
            addDoctor();
        }

        System.out.println("Enter Doctor's Gender : ");
        String Gender = input.next();

        System.out.println("Enter Doctor's Medical Licence Number : ");
        int MedicalLicenseNum = 0;

        try{
            MedicalLicenseNum = input.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Please enter valid medical license number: ");
            addDoctor();
        }

        System.out.println("Enter Doctor's Specialisation : ");
        String Specialisation = input.next();

        if (Specialisation.equalsIgnoreCase("Cosmetic")){
            Doctor.cosmetic.add(new Doctor(Name, Surname, dob, MobileNum, Gender,MedicalLicenseNum,Specialisation));
            doctors.add(new Doctor(Name, Surname, dob, MobileNum, Gender, MedicalLicenseNum, Specialisation+" Dermatology"));
            System.out.println("\n Doctor Added Successfully ");
        }
        else if (Specialisation.equalsIgnoreCase("Medical")){
            Doctor.medical.add(new Doctor(Name, Surname, dob, MobileNum, Gender,MedicalLicenseNum,Specialisation));
            doctors.add(new Doctor(Name, Surname, dob, MobileNum, Gender, MedicalLicenseNum, Specialisation+" Dermatology"));
            System.out.println("\n Doctor Added Successfully ");
        }
        else if (Specialisation.equalsIgnoreCase("Paediatric")){
            Doctor.paediatric.add(new Doctor(Name, Surname, dob, MobileNum, Gender,MedicalLicenseNum,Specialisation));
            doctors.add(new Doctor(Name, Surname, dob, MobileNum, Gender, MedicalLicenseNum, Specialisation+" Dermatology"));
            System.out.println("\n Doctor Added Successfully ");
        }
        else{
            System.out.println("Invalid Specialization");
            addDoctor();
        }



    }


    //VIEW METHOD------------------------------------------------------------------------------------------------

    public static void printDoctors() {

        if (doctors.size()>0) {

            Collections.sort(doctors,Doctor.surNameComparator);


            System.out.println("\nAvailable Doctor's and Information");
            for (int i = 0; i < doctors.size(); i++) {
                System.out.println("\nFirst Name : " + doctors.get(i).getName() + "\nSurname : " + doctors.get(i).getSurname() + "\nDate of Birth : " + doctors.get(i).getDob() + "\nMobile Number : " + doctors.get(i).getMobileNum() + "\nGender : " + doctors.get(i).getGender() + "\nMedical Licence Number : " + doctors.get(i).getMedicalLicenseNum() + "\nSpecialisation : " + doctors.get(i).getSpecialisation());
                System.out.println("");
            }


            //string arrayList.sort
            System.out.println("\nAvailable Number of Doctors : " + doctors.size());

        }
        else{
            System.out.println("No doctor in the Center");
        }
    }


    //DELETE METHOD----------------------------------------------------------------------------------------------

    public static void deleteDoctor(){

        Scanner input = new Scanner(System.in);                         //Getting Medical License number Input from the User
        System.out.println("Enter the Medical License Number of the doctor want to Delete : ");
        int licenseNum = input.nextInt();

        for (int i =0; i < doctors.size();i++){

            if (doctors.get(i).getMedicalLicenseNum()==licenseNum){

                System.out.println("\nDoctor Deleted Successfully");    //Deleting and Printing Doctor Details
                System.out.println("\nDeleted Doctor Details");
                System.out.println("\nFirst Name : " + doctors.get(i).getName() + "\nSurname : " + doctors.get(i).getSurname() + "\nDate of Birth : " + doctors.get(i).getDob() + "\nMobile Number : " + doctors.get(i).getMobileNum() + "\nGender : " + doctors.get(i).getGender() + "\nMedical Licence Number : " + doctors.get(i).getMedicalLicenseNum() + "\nSpecialisation : " + doctors.get(i).getSpecialisation());

                doctors.remove(i);                                      //Deleting doctor from the List

            }
        }

                                                                        //Printing Total number of Doctors in the Center
        System.out.println("\nTotal Numbers of Doctors in the Center : "+doctors.size());


    }


    //STORE DATA METHOD-----------------------------------------------------------------------------------------

    public static void storeDoctorDetails() {

        try (FileWriter inputFile = new FileWriter("D:\\Studies\\IIT\\IIT SE Beng(Hons)\\Second year\\Java OOP\\CW\\DoctorList.txt", true);
             BufferedWriter b = new BufferedWriter(inputFile);
             PrintWriter p = new PrintWriter(b)) {
//            Formatter fmt = new Formatter();
            p.printf("%14s %13s %20s %18s %15s %9s\n", "Last name", "First name", "Medical License No", "Specialisation", "Mobile No", "DOB");

            for (int i = 0; i < doctors.size(); i++) {
                p.printf("%11s %13s %15s %19s %19s %17s\n", doctors.get(i).getSurname()+
                        "|", doctors.get(i).getName() +
                        "|", doctors.get(i).getMedicalLicenseNum() +
                        "|", doctors.get(i).getSpecialisation() +
                        "|", doctors.get(i).getMobileNum() +
                        "|", doctors.get(i).getDob().getYear() +
                        "/" + doctors.get(i).getDob().getMonth() +
                        "/" + doctors.get(i).getDob().getDate());
            }
            System.out.println("\nSaved Successfully");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //GUI METHOD-----------------------------------------------------------------------------------------------

    public static void openGui(){
        new MainGUI();
    }
}
