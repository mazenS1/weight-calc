package tables;


import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableCellRenderer;

public class allWhigthTable extends JPanel{
    JTable table;
    JPanel  p;
    JScrollPane sc;
    String data[][];
    JButton print;
    String header[] = {"day","whigt","id"};
    ArrayList<domain.dalywhigt> list = new ArrayList<>();
    public allWhigthTable(){
        
        
    }
    public void showAllDataTable(){
       
        //showing the table with all the weights
        //initilize tabel:
        list = database.dalyData.getDalyData();
        data = new String[list.size()][3];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = ""+list.get(i).getDay();
            data[i][1] = ""+list.get(i).getWhight();
            data[i][2] = ""+list.get(i).getId();
        }

        setBounds(300, 300, 300,300);
        table = new JTable(data,header);
        table.setBounds(500,500,500,200);
        sc = new JScrollPane( );
        sc.setPreferredSize(new Dimension(50, 50));
        add(sc);
        add(table);
        // config table
        
        ((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment((int)JLabel.CENTER_ALIGNMENT);
        DefaultTableCellRenderer v = new DefaultTableCellRenderer();
        v.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(v);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(v);
        }
        
    }
}
