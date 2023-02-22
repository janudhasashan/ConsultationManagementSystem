import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class viewConsultationFrame {

    static ArrayList<Consultation> patientInfo = new ArrayList<>();

    static ArrayList<Integer> patientsId = new ArrayList<>();

    viewConsultationFrame() {
        JFrame frame = new JFrame();
        viewConsultation(frame);
        backButton(frame);
        viewPicButton(frame);
        checkConsultationButton(frame);
    }

    public static void viewConsultation(JFrame frame) {

        ImageIcon image = new ImageIcon("logo.png");
        frame.setIconImage(image.getImage());

        ImageIcon topImage = new ImageIcon("D:\\Studies\\IIT\\IIT SE Beng(Hons)\\Second year\\Java OOP\\CW\\viewconsul.PNG");

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

    public static void checkConsultationButton(JFrame frame){

        JTextField ptfirstName = new JTextField();
        ptfirstName.setBounds(20, 100, 150, 30);
        ptfirstName.setText(" Enter Patient First Name");
        frame.add(ptfirstName);

        JTextField ptiD = new JTextField();
        ptiD.setBounds(190, 100, 120, 30);
        ptiD.setText(" Enter Patient's ID ");
        frame.add(ptiD);

        JButton checkConsultationButton = new JButton("Check Scheduled Consultation");
        checkConsultationButton.setBounds(460, 100, 250, 30);
        checkConsultationButton.setFocusable(false);
        checkConsultationButton.setFont(new Font("Comic Sans", Font.BOLD, 13));
        checkConsultationButton.setForeground(Color.white);
        checkConsultationButton.setBackground(new Color(0,250,154));
        checkConsultationButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==checkConsultationButton){
                    String PTFName = ptfirstName.getText();
                    int PTId = Integer.parseInt(String.valueOf(ptiD.getText()));
                    patientsId.add(PTId);

                    if (checkPatient(bookConsultationFrame.booking,PTId)){
                        for (int i =0; i<bookConsultationFrame.booking.size(); i++){
                            if (bookConsultationFrame.booking.get(i).getPtId()==PTId){
                                patientInfo.add(new Consultation(bookConsultationFrame.booking.get(i).getDocFName(),
                                        bookConsultationFrame.booking.get(i).getDocLName(),
                                        bookConsultationFrame.booking.get(i).getDocSpec(),
                                        bookConsultationFrame.booking.get(i).getDocId(),
                                        bookConsultationFrame.booking.get(i).getPtFName(),
                                        bookConsultationFrame.booking.get(i).getPtLName(),
                                        bookConsultationFrame.booking.get(i).getPtId(),
                                        bookConsultationFrame.booking.get(i).getPtMNum(),
                                        bookConsultationFrame.booking.get(i).getCost(),
                                        bookConsultationFrame.booking.get(i).getNotes(),
                                        bookConsultationFrame.booking.get(i).getConDate(),
                                        bookConsultationFrame.booking.get(i).getImageFile()
                                        ));

                            }
                        }

                        viewTableModel viewTable = new viewTableModel(patientInfo);
                        JTable myTable = new JTable(viewTable);

                        JScrollPane panel = new JScrollPane(myTable);
                        panel.setBounds(20, 150,690, 200);
                        frame.add(panel);
                    }

                }
            }
        });
        viewTableModel viewTable = new viewTableModel(patientInfo);
        JTable myTable = new JTable(viewTable);

        JScrollPane panel = new JScrollPane(myTable);
        panel.setBounds(20, 150,690, 200);
        frame.add(panel);

        frame.add(checkConsultationButton);

    }

    public static boolean checkPatient(ArrayList<Consultation> viewList, int PatientId){
        boolean temp = false;
        for (int i=0 ; i<viewList.size() ; i++){
            if ((viewList.get(i).getPtId()==PatientId)){
                temp = true;
            }
        }
        return temp;
    }

    public static void viewPicButton(JFrame frame){

        JButton viewPicButton = new JButton("View Uploaded Image");
        viewPicButton.setBounds(460, 410, 250, 30);
        viewPicButton.setFocusable(false);
        viewPicButton.setFont(new Font("Comic Sans", Font.BOLD, 13));
        viewPicButton.setForeground(Color.white);
        viewPicButton.setBackground(new Color(0,255,0));
        viewPicButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==viewPicButton){
                    if (patientInfo.size() > 0) {
                        // run through the patientDetails array
                        for (int i = 0; i < patientInfo.size(); i++) {

                                bookConsultationFrame.encryptImage(patientInfo.get(i).getImageFile());
                                Desktop d = Desktop.getDesktop();   // Create Desktop object
                                try {
                                    d.open(patientInfo.get(i).getImageFile());  // View the image from open the file path
                                    // Asking from patient if they need to encrypt again uploaded image
                                    int answer = JOptionPane.showConfirmDialog(null, "Do you want encrypt back your image?", "Request Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
//                                System.out.println(answer);
                                    // Check the answer and if equal 0 encrypt again
                                    if (answer == 0) {
                                        bookConsultationFrame.encryptImage(patientInfo.get(i).getImageFile());    // Call encrypt method to encrypt image
                                        System.out.println("Encrypt");
//                                    patientDetails.remove(i);
                                    }
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                        }
//                    setDefault(name, id);
                    } else {
                        // Showing error message if the patient details wrong
                        JOptionPane.showMessageDialog(null, "Please Enter Patient First Name, ID and Click Schedule button First ", "Invalid Details", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        frame.add(viewPicButton);

    }
}
