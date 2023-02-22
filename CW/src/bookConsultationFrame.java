import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class bookConsultationFrame {

    static ArrayList<Consultation> booking = new ArrayList<Consultation>();

    static ArrayList<File> imagePath = new ArrayList<>();
    static int countFilePath;


    bookConsultationFrame() {
        JFrame frame = new JFrame();
        bookConsultation(frame);
        backButton(frame);
        ptInfo(frame);
        countFilePath=0;
    }

    static String path = "";

    //Adding Consultation Frame-----------------------------------------------------------

    public static void bookConsultation(JFrame frame) {


        ImageIcon image = new ImageIcon("logo.png");
        frame.setIconImage(image.getImage());

        ImageIcon topImage = new ImageIcon("D:\\Studies\\IIT\\IIT SE Beng(Hons)\\Second year\\Java OOP\\CW\\bookconsul.PNG");

        JLabel topLabel = new JLabel();
        topLabel.setIcon(topImage);

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.white);
        topPanel.setBounds(0, 0, 750, 80);
        topPanel.add(topLabel);
        frame.add(topPanel);

        frame.setLayout(null);
        frame.setTitle("Westminster Skin Consultation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(750, 500);
        frame.setBackground(Color.white);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }


    //Adding Back Button-----------------------------------------------------------------

    public static void backButton(JFrame frame) {
        JButton backButton = new JButton("Back");
        backButton.setBounds(20, 410, 100, 30);
        backButton.setFocusable(false);
        backButton.setFont(new Font("Comic Sans", Font.BOLD, 13));
        backButton.setForeground(Color.white);
        backButton.setBackground(new Color(173, 255, 47));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backButton) {
                    frame.dispose();
                    MainGUI m1 = new MainGUI();
                }
            }
        });
        frame.add(backButton);
    }


    //Inputs All the details from the patient----------------------------------------------------
    public static void ptInfo(JFrame frame){

        //Patient First Name Text Field----------------------------------------------------------
        JTextField ptFirstName = new JTextField();
        ptFirstName.setBounds(20, 110, 170, 30);
        ptFirstName.setText(" Enter Patient First Name");
        frame.add(ptFirstName);

        //Patient Surname Text Field-------------------------------------------------------------
        JTextField ptLastName = new JTextField();
        ptLastName.setBounds(220, 110, 170, 30);
        ptLastName.setText(" Enter Patient Surname");
        frame.add(ptLastName);

        //Patient ID Text Field-----------------------------------------------------------------
        JTextField ptID = new JTextField();
        ptID.setBounds(420, 110, 150, 30);
        ptID.setText(" Enter Patient ID");
        frame.add(ptID);

        //Patient Gender Select Combo Box-------------------------------------------------------
        JComboBox ptGender = new JComboBox();
        ptGender.setBounds(600,110,100,30);
        ptGender.addItem(" Male ");
        ptGender.addItem(" Female ");
        frame.add(ptGender);

        //Patient Mobile Number Text Field-------------------------------------------------------
        JTextField ptMobileNum = new JTextField();
        ptMobileNum.setBounds(20, 160, 170, 30);
        ptMobileNum.setText(" Enter Patient Mobile Number");
        frame.add(ptMobileNum);

        //Patient DOB Year Label and Combo Box-----------------------------------------------------------------
        JLabel ptbYearLabel = new JLabel("Birth Year :");
        ptbYearLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        ptbYearLabel.setBounds(220, 160, 110, 30);

        String[] birthYear = new String[120];
        for (int i = 0; i < 120; i++) {
            String temp1 = Integer.toString(i + 1903);
            birthYear[i] = temp1;
        }
        JComboBox ptbYear = new JComboBox(birthYear);
        ptbYear.setBounds(290, 160, 65, 30);

        frame.add(ptbYearLabel);
        frame.add(ptbYear);

        //Patient DOB Month Label and Combo Box-----------------------------------------------------------------
        JLabel ptbMonthLabel = new JLabel("Birth Month :");
        ptbMonthLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        ptbMonthLabel.setBounds(380, 160, 110, 30);

        String[] birthMonth = new String[12];
        for (int i = 0; i < 12; i++) {
            String temp2 = Integer.toString(i + 1);
            birthMonth[i] = temp2;
        }
        JComboBox ptbMonth = new JComboBox(birthMonth);
        ptbMonth.setBounds(460, 160, 50, 30);

        frame.add(ptbMonthLabel);
        frame.add(ptbMonth);

        //Patient DOB Date Label and Combo Box-----------------------------------------------------------------
        JLabel ptbDateLabel = new JLabel("Birth Date :");
        ptbDateLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        ptbDateLabel.setBounds(540, 160, 110, 30);

        String[] birthDate = new String[31];
        for (int i = 0; i < 31; i++) {
            String temp3 = Integer.toString(i + 1);
            birthDate[i] = temp3;
        }
        JComboBox ptbDate = new JComboBox(birthDate);
        ptbDate.setBounds(620, 160, 50, 30);

        frame.add(ptbDateLabel);
        frame.add(ptbDate);

        //Doctor Select Combo Box-----------------------------------------------------------------
        JLabel docListLabel = new JLabel("Select Doctor :");
        docListLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        docListLabel.setBounds(20, 210, 110, 30);


        String[] tempDoc = new String[WestminsterSkinConsultationManager.doctors.size()];

        for (int i = 0; i < WestminsterSkinConsultationManager.doctors.size(); i++) {
            String temp = WestminsterSkinConsultationManager.doctors.get(i).getName() + " || " + WestminsterSkinConsultationManager.doctors.get(i).getSurname() + " || " + WestminsterSkinConsultationManager.doctors.get(i).getSpecialisation();
            tempDoc[i] = temp;
        }


        JComboBox docList = new JComboBox(tempDoc);
        docList.setBounds(120, 210, 300, 25);

        frame.add(docListLabel);
        frame.add(docList);


        //Consultation Time Select Combo Box-----------------------------------------------------------------
        JLabel conTimeLabel = new JLabel("Consultation Time :");
        conTimeLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        conTimeLabel.setBounds(440, 210, 110, 30);

        //----Hours Combo Box
        JComboBox conHours = new JComboBox();
        conHours.setBounds(560, 210, 50, 30);

        for (int i = 9; i <= 21; i++) {
            conHours.addItem(i);
        }

        //----Minutes Combo Box
        JComboBox conMinutes = new JComboBox();
        conMinutes.addItem("00");
        conMinutes.setBounds(620, 210, 50, 30);

        frame.add(conTimeLabel);
        frame.add(conHours);
        frame.add(conMinutes);

        //Consultation Year Select Combo Box-----------------------------------------------------------------
        JLabel conYearLabel = new JLabel("Consultation Year :");
        conYearLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        conYearLabel.setBounds(20, 255, 110, 30);

        String[] consultationYear = new String[3];
        for (int i = 0; i < 3; i++) {
            String temp4 = Integer.toString(i + 2022);
            consultationYear[i] = temp4;
        }
        JComboBox conYear = new JComboBox(consultationYear);
        conYear.setBounds(135, 255, 65, 30);

        frame.add(conYearLabel);
        frame.add(conYear);

        //Consultation Month Select Combo Box-----------------------------------------------------------------
        JLabel conMonthLabel = new JLabel("Consultation Month :");
        conMonthLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        conMonthLabel.setBounds(220, 255, 150, 30);

        String[] consultationMonth = new String[12];
        for (int i = 0; i < 12; i++) {
            String temp5 = Integer.toString(i + 1);
            consultationMonth[i] = temp5;
        }
        JComboBox conMonth = new JComboBox(consultationMonth);
        conMonth.setBounds(345, 255, 50, 30);

        frame.add(conMonthLabel);
        frame.add(conMonth);

        //Consultation Date Select Combo Box-----------------------------------------------------------------
        JLabel conDateLabel = new JLabel("Consultation Date :");
        conDateLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        conDateLabel.setBounds(420, 255, 110, 30);

        String[] consultationDate = new String[31];
        for (int i = 0; i < 31; i++) {
            String temp6 = Integer.toString(i + 1);
            consultationDate[i] = temp6;
        }
        JComboBox conDate = new JComboBox(consultationDate);
        conDate.setBounds(540, 255, 50, 30);

        frame.add(conDateLabel);
        frame.add(conDate);

        //Notes Text Field--------------------------------------------------------
        JTextField specialNote = new JTextField();
        specialNote.setBounds(20, 320, 350, 60);
        specialNote.setText(" Special Notes");
        frame.add(specialNote);


        //Adding Book Consultation Button-----------------------------------------

        JButton bookButton = new JButton("Book Consultation");
        bookButton.setBounds(560, 400, 150, 40);
        bookButton.setFocusable(false);
        bookButton.setFont(new Font("Comic Sans", Font.BOLD, 13));
        bookButton.setForeground(Color.white);
        bookButton.setBackground(new Color(0, 250, 154));
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == bookButton) {
                    String PtFName = ptFirstName.getText();
                    String PtLName = ptLastName.getText();

                    int PtId = 0;
                    try {
                        PtId = Integer.parseInt(String.valueOf(ptID.getText()));
                    }
                    catch (Exception er){
                        JOptionPane.showMessageDialog(null," Invalid ID Number , Try Again","Value Error", JOptionPane.ERROR_MESSAGE);
                    }

                    int PtMNum = 0;
                    try{
                        PtMNum = Integer.parseInt(String.valueOf(ptMobileNum.getText()));
                    }
                    catch (Exception er){
                        JOptionPane.showMessageDialog(null," Invalid Mobile Number , Try Again","Value Error", JOptionPane.ERROR_MESSAGE);
                    }


                    int dfIndex = Integer.parseInt(String.valueOf(docList.getSelectedIndex()));
                    String DocFName = WestminsterSkinConsultationManager.doctors.get(dfIndex).getName();
                    String DocLName = WestminsterSkinConsultationManager.doctors.get(dfIndex).getSurname();
                    String DocSpec = WestminsterSkinConsultationManager.doctors.get(dfIndex).getSpecialisation();
                    int DocId = WestminsterSkinConsultationManager.doctors.get(dfIndex).getMedicalLicenseNum();
                    String gender = String.valueOf(ptGender.getSelectedItem());

                    Date ConDate = new Date();
                    ConDate.setYear(Integer.parseInt(conYear.getSelectedItem().toString()));
                    ConDate.setMonth(Integer.parseInt(conMonth.getSelectedItem().toString()));
                    ConDate.setDate(Integer.parseInt(conDate.getSelectedItem().toString()));
                    ConDate.setHours(Integer.parseInt(conHours.getSelectedItem().toString()));
                    ConDate.setMinutes(Integer.parseInt(conMinutes.getSelectedItem().toString()));

                    Date patientBirthDate = new Date();
                    int ptBirthYear = Integer.parseInt(String.valueOf(ptbYear.getSelectedItem()));
                    int ptBirthMonth = Integer.parseInt(String.valueOf(ptbMonth.getSelectedItem()));
                    int ptBirthDate = Integer.parseInt(String.valueOf(ptbDate.getSelectedItem()));
                    patientBirthDate.setYear(ptBirthYear);
                    patientBirthDate.setMonth(ptBirthMonth);
                    patientBirthDate.setDate(ptBirthDate);
                    String Notes = specialNote.getText();

                    //Random Doctor Index----------------------------------------------------
                    int indexCosmetic = (int)(Math.random()*Doctor.cosmetic.size());
                    int indexMedical = (int)(Math.random()*Doctor.medical.size());
                    int indexPaediatric = (int)(Math.random()*Doctor.paediatric.size());

                    double Cost;
                    if (checkPatient(Patient.patientsDetails,PtId)){
                        Cost = 15;
                    }
                    else{
                        Cost = 25;
                    }

                    if (PtId>0 && PtMNum>0){
                        if (checkDoctorAvailability(booking,ConDate,DocId)){
                            Patient.patientsDetails.add(new Patient(PtFName,PtLName,patientBirthDate,PtMNum,gender,PtId));
                            encryptImage(imagePath.get(countFilePath));
                            booking.add(new Consultation(DocFName, DocLName, DocSpec, DocId, PtFName, PtLName, PtId, PtMNum, Cost, Notes, ConDate, imagePath.get(countFilePath)));
                            JOptionPane.showMessageDialog(null,"Booking Added Successfully","Booking Update",JOptionPane.INFORMATION_MESSAGE);
                            defaultValue(ptFirstName, ptLastName,ptID, ptGender, ptMobileNum, specialNote, conYear, conMonth, conDate, ptbYear, ptbMonth, ptbDate,
                                    conHours,conMinutes);
                            countFilePath++;
                        }
                        else{
                            if (DocSpec.equalsIgnoreCase("Cosmetic Dermatology")){
                                if (Doctor.cosmetic.get(indexCosmetic).getMedicalLicenseNum()!=DocId){
                                    DocFName=Doctor.cosmetic.get(indexCosmetic).getName();
                                    DocLName=Doctor.cosmetic.get(indexCosmetic).getSurname();
                                    DocId=Doctor.cosmetic.get(indexCosmetic).getMedicalLicenseNum();

                                    int answer = JOptionPane.showConfirmDialog(null,"The Doctor You Selected" +
                                            " is Not Available at That Time, We Can arrange you Dr. "+ DocLName +" by Same Specialization","Doctor Not " +
                                            "Available! ", JOptionPane.YES_NO_CANCEL_OPTION);
                                    if (answer==0){
                                        Patient.patientsDetails.add(new Patient(PtFName,PtLName,patientBirthDate,PtMNum,gender,PtId));
                                        encryptImage(imagePath.get(countFilePath));
                                        booking.add(new Consultation(DocFName, DocLName, DocSpec, DocId, PtFName, PtLName, PtId, PtMNum, Cost, Notes, ConDate, imagePath.get(countFilePath)));
                                        JOptionPane.showMessageDialog(null,"Booking Added Successfully","Booking Update",JOptionPane.INFORMATION_MESSAGE);
                                        defaultValue(ptFirstName, ptLastName,ptID, ptGender, ptMobileNum, specialNote, conYear, conMonth, conDate, ptbYear, ptbMonth, ptbDate,
                                                conHours,conMinutes);
                                        countFilePath++;
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null,"Please Select Other Time Slot","Doctor Not Available!",JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            }
                            else if(DocSpec.equalsIgnoreCase("Medical Dermatology")){
                                if (Doctor.medical.get(indexMedical).getMedicalLicenseNum()!=DocId){
                                    DocFName=Doctor.medical.get(indexMedical).getName();
                                    DocLName=Doctor.medical.get(indexMedical).getSurname();
                                    DocId=Doctor.medical.get(indexMedical).getMedicalLicenseNum();

                                    int answer = JOptionPane.showConfirmDialog(null,"The Doctor You Selected" +
                                            " is Not Available at That Time, We Can arrange you Dr. "+DocLName+" by Same Specialization","Doctor Not " +
                                            "Available! ", JOptionPane.YES_NO_CANCEL_OPTION);
                                    if (answer==0){
                                        Patient.patientsDetails.add(new Patient(PtFName,PtLName,patientBirthDate,PtMNum,gender,PtId));
                                        encryptImage(imagePath.get(countFilePath));
                                        booking.add(new Consultation(DocFName, DocLName, DocSpec, DocId, PtFName, PtLName, PtId, PtMNum, Cost, Notes, ConDate, imagePath.get(countFilePath)));
                                        JOptionPane.showMessageDialog(null,"Booking Added Successfully","Booking Update",JOptionPane.INFORMATION_MESSAGE);
                                        defaultValue(ptFirstName, ptLastName,ptID, ptGender, ptMobileNum, specialNote, conYear, conMonth, conDate, ptbYear, ptbMonth, ptbDate,
                                                conHours,conMinutes);
                                        countFilePath++;
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null,"Please Select Other Time Slot","Doctor Not Available!",JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            }
                            else if(DocSpec.equalsIgnoreCase("Paediatric Dermatology")){
                                if (Doctor.paediatric.get(indexPaediatric).getMedicalLicenseNum()!=DocId){
                                    DocFName=Doctor.paediatric.get(indexPaediatric).getName();
                                    DocLName=Doctor.paediatric.get(indexPaediatric).getSurname();
                                    DocId=Doctor.paediatric.get(indexPaediatric).getMedicalLicenseNum();

                                    int answer = JOptionPane.showConfirmDialog(null,"The Doctor You Selected" +
                                            " is Not Available at That Time, We Can arrange you Dr. "+DocLName+" by Same Specialization","Doctor Not " +
                                            "Available! ", JOptionPane.YES_NO_CANCEL_OPTION);
                                    if (answer==0){
                                        Patient.patientsDetails.add(new Patient(PtFName,PtLName,patientBirthDate,PtMNum,gender,PtId));
                                        encryptImage(imagePath.get(countFilePath));
                                        booking.add(new Consultation(DocFName, DocLName, DocSpec, DocId, PtFName, PtLName, PtId, PtMNum, Cost, Notes, ConDate, imagePath.get(countFilePath)));
                                        JOptionPane.showMessageDialog(null,"Booking Added Successfully","Booking Update",JOptionPane.INFORMATION_MESSAGE);
                                        defaultValue(ptFirstName, ptLastName,ptID, ptGender, ptMobileNum, specialNote, conYear, conMonth, conDate, ptbYear, ptbMonth, ptbDate,
                                                conHours,conMinutes);
                                        countFilePath++;
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null,"Please Select Other Time Slot","Doctor Not Available!",JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            }
                        }

                    }
                    else{
                        System.out.println("INVALID ID OR MOBILE NUMBER");
                    }

                }

            }
        });
        frame.add(bookButton);

        if (Patient.patientsDetails.size()>0){
            for (int i=0; i<Patient.patientsDetails.size();i++){
                System.out.println(Patient.patientsDetails.get(i).getSurname()+Patient.patientsDetails.get(i).getPatientUID());
            }
        }
        if (booking.size()>0){
            for (int i=0; i<booking.size();i++){
                System.out.println("Dr Name: "+booking.get(i).getDocFName()+" Consultation Time: "+booking.get(i).getConDate().getHours()+" Cost: "+booking.get(i).getCost());
            }
        }

        //Adding Upload Image Button-----------------------------------------------------

        JButton uploadPicButton = new JButton("Upload Image");
        uploadPicButton.setBounds(560, 320, 150, 40);
        uploadPicButton.setFocusable(false);
        uploadPicButton.setFont(new Font("Comic Sans", Font.BOLD, 13));
        uploadPicButton.setForeground(Color.white);
        uploadPicButton.setBackground(new Color(0, 255, 0));
        JFileChooser myFile = new JFileChooser();
        uploadPicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == uploadPicButton) {


                    JFileChooser fileChooser = new JFileChooser();  // Create JFileChooser object
                    int response = fileChooser.showOpenDialog(null);    // read response from show open dialog from file chooser
                    if (response == JFileChooser.APPROVE_OPTION) {   // Check if file selected or not
                        File file = new File(fileChooser.getSelectedFile().getAbsolutePath());  // get a absolute file path to File Object

                        FileInputStream in = null;  // set FileInputStream null
                        FileOutputStream ou = null; // Set FileOutputStream null

                        // use try catch method to avoid errors
                        try {
                            in = new FileInputStream(file); // pass the selected file location
                            ou = new FileOutputStream("D:\\Studies\\IIT\\IIT SE Beng(Hons)\\Second year\\Java OOP\\CW\\Image\\" + file.getName());  // pass the selected file location
                        } catch (Exception exe) {
                            exe.printStackTrace();
                        }

                        BufferedInputStream bin = new BufferedInputStream(in);  // Create BufferedInputStream and pass the input file path
                        BufferedOutputStream bou = new BufferedOutputStream(ou);    // Create BufferedOutputStream and pass the output file path

                        int b = 0;  // assign int b variable = 0
                        // Use check b not equal -1
                        while (b != -1) {
                            try {
                                b = bin.read(); // read the BufferedInputStream
                                bou.write(b);   // write the BufferedOutputStream
                            } catch (IOException er) {
                                er.printStackTrace();
                            }
                        }

                        try {
                            bin.close();    // close BufferedInputStream
                            bou.close();    // close BufferedOutputStream
                        } catch (IOException ee) {
                            ee.printStackTrace();
                        }

                        // Set upload path
                        File uploadPath = new File("D:\\Studies\\IIT\\IIT SE Beng(Hons)\\Second year\\Java OOP\\CW\\Image\\" + file.getName());
                        imagePath.add(countFilePath, uploadPath);   // add fileArrayList to each uploaded paths
//                        System.out.println(file);
                    }
                }
            }
        });
        frame.add(uploadPicButton);
    }

    public static void encryptImage(File newFile ){
        int k = 10;
        try{
            FileInputStream fileInputStream = new FileInputStream(newFile);    // Read the file path as FileInputStream

            byte [] data = new byte[fileInputStream.available()];   // create a Byte array to fileInputStream available
            fileInputStream.read(data); // read data as fileInputStream
            int i = 0;  // set int i as 0
            // using for loop run the every bit through
            for(byte b:data){
//                System.out.println(b);
                data[i] = (byte) (b ^ k);
                i++;
            }

            FileOutputStream fileOutputStream = new FileOutputStream(newFile);     // use FileOutputStream and pass file path
            fileOutputStream.write(data);   // write data fo fileOutputStream
            fileOutputStream.close();   // close fileOutputStream
            fileInputStream.close();    // close fileInputStream

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void defaultValue(JTextField PtFName, JTextField PtLName, JTextField PtId, JComboBox Gender,
                                    JTextField PtMNum, JTextField Notes, JComboBox ConYear, JComboBox ConMonth,
                                    JComboBox ConDate, JComboBox PtBYear, JComboBox PtBMonth, JComboBox PtBDate,
                                    JComboBox ConHours, JComboBox ConMinutes){
        PtFName.setText(" Enter Patient First Name");
        PtLName.setText(" Enter Patient First Name");
        PtId.setText(" Enter Patient ID");
        Gender.setSelectedIndex(0);
        PtMNum.setText(" Enter Patient Mobile Number");
        PtBYear.setSelectedIndex(0);
        PtBMonth.setSelectedIndex(0);
        PtBDate.setSelectedIndex(0);
        ConHours.setSelectedIndex(0);
        ConMinutes.setSelectedIndex(0);
        ConYear.setSelectedIndex(0);
        ConMonth.setSelectedIndex(0);
        ConDate.setSelectedIndex(0);
        Notes.setText(" Special Notes");

    }

    public static boolean checkPatient(ArrayList<Patient> patientList, int PatientId){
        boolean temp = true;
        for (int i=0 ; i<patientList.size() ; i++){
            if ((patientList.get(i).getPatientUID()==PatientId)&& temp){
                temp = false;
            }
        }
        return temp;
    }

    public static boolean checkDoctorAvailability(ArrayList<Consultation> checkList, Date consultationDate, int medicalLisenseNum){
        boolean temp = true;
        for (int i=0 ;i<checkList.size(); i++){
            if (checkList.get(i).getConDate().getHours()==consultationDate.getHours() &&
                    checkList.get(i).getConDate().getDate()==consultationDate.getDate() &&
                    checkList.get(i).getConDate().getMonth()==consultationDate.getMonth() &&
                    checkList.get(i).getConDate().getYear()==consultationDate.getYear() &&
                    checkList.get(i).getDocId()==medicalLisenseNum &&
                    temp){
                temp = false;

            }
        }
        return temp;

    }

}


