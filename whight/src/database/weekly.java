package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.weeklywhigt;
public class weekly {
    // connecting to data base:
    public static Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:whight.db");
    }
    //inserting data in week avg table
    public static void insertAvg(double whightAvg,int week) {
        try (
            Connection c = connection();
            PreparedStatement p = c.prepareStatement("insert into weekAvg (week,whightAvg) values(?,?) ")
        ) {
            p.setInt(1, week);
            p.setDouble(2, whightAvg);
            p.execute();
            
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
    }
    //getting the last week entered in the database
    public static int getWeeks(){
        ArrayList<weeklywhigt> list = new ArrayList<>();
        int weeks[];
        try (
            Connection c = connection();
            PreparedStatement p = c.prepareStatement("SELECT week FROM weekAvg ")
        ){
            
            ResultSet r = p.executeQuery();
            while (r.next()) {
                list.add(new weeklywhigt(r.getInt("week")));
             }
             weeks = new int[list.size()];
             for (int i = 0; i < list.size(); i++) {
                weeks[i] = list.get(i).getWeek();
             }
             int last = weeks.length;
             
            return last;
        }
             catch (Exception e) {
                System.out.println(e.getMessage());
                return 0;
        }
    }
    //getting all the data in weekavg as an arraylist
    public static ArrayList<weeklywhigt> getWeeklyData(){
        ArrayList<weeklywhigt> list = new ArrayList<>();
        String[] data ;
        try (
            Connection c = connection();
            PreparedStatement p =c.prepareStatement("select * from weekAvg");
        ){
            ResultSet s = p.executeQuery();
            while(s.next()){
                list.add(new weeklywhigt(s.getInt("week"),s.getDouble("whightAvg")));
            }
            data = new String[list.size()];
            for (int i = 0; i < data.length; i++) {
                data[i]= ""+list.get(i).getWeek();
                data[i]=""+list.get(i).getWhightAvg();
            }
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
      
        return list;
    }
}
