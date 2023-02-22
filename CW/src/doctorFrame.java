import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class doctorFrame {

    doctorFrame(){
        JFrame frame = new JFrame();
        viewDoctor(frame);
        backButton(frame);
        orderButton(frame);
        bookButton(frame);
    }

    //Adding View Doctor Frame-------------------------------------------------------------

    public static void viewDoctor(JFrame frame) {

        ImageIcon image = new ImageIcon("logo.png");
        frame.setIconImage(image.getImage());

        ImageIcon topImage = new ImageIcon("D:\\Studies\\IIT\\IIT SE Beng(Hons)\\Second year\\Java OOP\\CW\\doclist.PNG");

        JLabel topLabel = new JLabel();
        topLabel.setIcon(topImage);

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.white);
        topPanel.setBounds(0,0,750,80);
        topPanel.add(topLabel);
        frame.add(topPanel);

        doctorTableModel tableModel = new doctorTableModel(WestminsterSkinConsultationManager.doctors);
        JTable myTable = new JTable(tableModel);

        JScrollPane panel = new JScrollPane(myTable);
        panel.setBounds(10, 90,717, 300);
//        panel.setFont(new Font("Comic Sans", Font.BOLD, 13));
        frame.add(panel);
        frame.setLayout(null);

        frame.setTitle("Westminster Skin Consultation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(750,500);
        frame.setBackground(Color.white);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);


    }


    //Adding Back Button-------------------------------------------------------------

    public static void backButton(JFrame frame){
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


    //Adding Sorting A-Z Button------------------------------------------------------

    public static void orderButton(JFrame frame){

        JButton sortButton = new JButton("A - Z");
        sortButton.setBounds(150, 410, 100, 30);
        sortButton.setFocusable(false);
        sortButton.setFont(new Font("Comic Sans", Font.BOLD, 13));
        sortButton.setForeground(Color.white);
        sortButton.setBackground(new Color(0, 255, 0));

        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == sortButton) {

                    Collections.sort(WestminsterSkinConsultationManager.doctors, Doctor.surNameComparator);
                    ArrayList<Doctor> t1 = new ArrayList<Doctor>(WestminsterSkinConsultationManager.doctors);
                    viewDoctor(frame);
                }
            }
        });
        frame.add(sortButton);
    }


    //Adding Book Consultation Button-----------------------------------------------

    public static void bookButton(JFrame frame){

        JButton bookButton = new JButton("Book Consultation");
        bookButton.setBounds(560, 410, 150, 30);
        bookButton.setFocusable(false);
        bookButton.setFont(new Font("Comic Sans", Font.BOLD, 13));
        bookButton.setForeground(Color.white);
        bookButton.setBackground(new Color(0,250,154));
        bookButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==bookButton){
                    frame.dispose();
                    bookConsultationFrame c1 = new bookConsultationFrame();
                }
            }
        });
        frame.add(bookButton);

    }

}
