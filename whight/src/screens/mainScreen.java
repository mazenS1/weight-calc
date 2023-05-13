package screens;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import database.dalyData;
import domain.dalywhigt;
import java.awt.event.*;
public class mainScreen extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    JButton send ,extre = new JButton();
    JTextField in = new JTextField();
    JLabel text = new JLabel("user id");
    JTabbedPane tab = new JTabbedPane();
    dalyData dd = new dalyData();
    public mainScreen(){
        
    }
    public void showMian(){
        //important stuff idk what to classfie them to
        int day =dalyData.getttttday();
        if(day!=7){
            day++;
        }
        else if (day==7) {
            day=1;
        }
        //the frame
        text = new JLabel("enter whight for day: "+day);
        in = new JTextField();
        send = new JButton("send");
        extre = new JButton("extra");
        text.setBounds(40,95,250,35);
        in.setBounds(190,100,200,25);
        send.setBounds(125,200,100,25);
        extre.setBounds(125,250,100,25);
        send.addActionListener(this);
        extre.addActionListener(this);

        //adding to frame ;
        frame.add(extre);
        frame.add(send);
        frame.add(text);
        frame.add(in);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // sending the data enterd by the user to the data base via insertWhight() method in dalyData.java and calling the calculate method;
        if(e.getSource()==send){
            new dalywhigt();
            database.dalyData.insertWhigt(Double.valueOf(in.getText()));
            dalyData.calculateAvg();
            JOptionPane.showMessageDialog(null, "sent successfully", "successfully", JOptionPane.INFORMATION_MESSAGE);
        
            
            }
        // showing the ShowAllData screen 
      if (e.getSource()==extre) {
        int j = dalyData.getDalyData().size();
        if (j%7!=0) {
            int elment = 7 - (j%7);
            JOptionPane.showMessageDialog(null, "not 7 yet you have to add "+elment, "not 7", JOptionPane.INFORMATION_MESSAGE);
        }
        System.out.println("cil");
         new tabs.showAllData().showAllDataScreen();

      }
    }
    
    
}
