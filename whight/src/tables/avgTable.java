package tables;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableCellRenderer;

public class avgTable extends JPanel {
    JTable table;
    JScrollPane sc;
    String data[][];
    JButton print;
    String header[] = {"day","whigt"};
    ArrayList<domain.weeklywhigt> list = new ArrayList<>();

    public avgTable(){}
    // showing a table filled with the week avrgers
    public void showAvg(){
        list= database.weekly.getWeeklyData();
        data = new String [list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = ""+list.get(i).getWeek();
            data[i][1] = ""+list.get(i).getWhightAvg();
        }
        
        setBounds(300, 300, 300,300);
        table = new JTable(data,header);
        table.setBounds(500,500,500,200);
        sc = new JScrollPane( );
        sc.setSize(50,50);
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