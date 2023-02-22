import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI{

    MainGUI(){

        //Adding Main Frame-------------------------------------------------------------

        JFrame frame = new JFrame();
        frame.setTitle("Westminster Skin Consultation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(750,500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);


        //Adding image for Frame Icon---------------------------------------------------

        ImageIcon image = new ImageIcon("logo.png");
        frame.setIconImage(image.getImage());


        //Adding View Doctor List Button------------------------------------------------

        JButton viewButton = new JButton("View Doctor List");
        viewButton.setBounds(525,260,150,30);
        viewButton.setFocusable(false);
        viewButton.setFont(new Font("Comic Sans",Font.BOLD,13));
        viewButton.setForeground(Color.white);
        viewButton.setBackground(new Color(173,255,47));
        viewButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==viewButton){
                    frame.dispose();
                    doctorFrame d1 = new doctorFrame();
                }
            }
        });
        frame.add(viewButton);


        //Adding Book Consultation Button------------------------------------------------

        JButton bookButton = new JButton("Book Consultation");
        bookButton.setBounds(525,305,150,30);
        bookButton.setFocusable(false);
        bookButton.setFont(new Font("Comic Sans",Font.BOLD,13));
        bookButton.setForeground(Color.white);
        bookButton.setBackground(new Color(0,255,0));
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


        //Adding View Consultation Button------------------------------------------------

        JButton viewConButton = new JButton("View Consultation");
        viewConButton.setBounds(525,350,150,30);
        viewConButton.setFocusable(false);
        viewConButton.setFont(new Font("Comic Sans",Font.BOLD,13));
        viewConButton.setForeground(Color.white);
        viewConButton.setBackground(new Color(0,250,154));
        viewConButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==viewConButton){
                    frame.dispose();
                    viewConsultationFrame v1 = new viewConsultationFrame();
                }
            }
        });
        frame.add(viewConButton);

        //Adding Exit Button-------------------------------------------------------------

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(525,395,150,30);
        exitButton.setFocusable(false);
        exitButton.setFont(new Font("Comic Sans",Font.BOLD,13));
        exitButton.setBackground(new Color(102,205,170));
        exitButton.setForeground(Color.white);
        exitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==exitButton){
                    frame.dispose();
                }
            }
        });
        frame.add(exitButton);


        //Adding Logo Image to Main Frame-------------------------------------------------

        ImageIcon topImage = new ImageIcon(("D:\\Studies\\IIT\\IIT SE Beng(Hons)\\Second year\\Java OOP\\CW\\Top.PNG"));
        JLabel Top = new JLabel();
        Top.setIcon(topImage);
        Top.setBounds(425,0,275,275);
        frame.add(Top);

        //Adding Background Image to Main Frame------------------------------------------

        ImageIcon headImage = new ImageIcon(("D:\\Studies\\IIT\\IIT SE Beng(Hons)\\Second year\\Java OOP\\CW\\Head1.png"));
        JLabel Head = new JLabel();
        Head.setIcon(headImage);
        Head.setBounds(0,0,750,500);
        frame.add(Head);
        frame.setVisible(true);

    }


}
