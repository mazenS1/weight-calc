package tabs;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import database.dalyData;
import tables.allWhigthTable;
import tables.avgTable;
import java.awt.event.*;
public class showAllData extends JFrame implements ActionListener {
    JTabbedPane tab;
    allWhigthTable d1;
    avgTable d2;
    JButton c;
    
    public showAllData(){}

    public void showAllDataScreen(){
        //the seconde screen to show the data when the user asks
        c = new JButton("calc");
        c.addActionListener(this);
        c.setBounds(300,300,50,80);
        d1 = new allWhigthTable();
        avgTable d2 = new avgTable();
        d1.showAllDataTable();
        d2.showAvg();
        setTitle("info");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setSize(600,400);
        setBounds(500,500,500,500);
        setVisible(true);
        tab = new JTabbedPane();
        tab.addTab("info", d1);
        tab.add("avg",d2);
        add(tab);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       dalyData.calculateAvg();
    }
}
