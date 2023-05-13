package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import domain.*;
public class dalyData {
    // connnecting to data base:
    public static Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:whight.db");
    }
    // inserting the wight in whight table
    public static void insertWhigt(double whight) {
        try (
            Connection c = connection();
            PreparedStatement p = c.prepareStatement("insert into whight (whight,day) values(?,?) ")
        ) {
            int day = knowingDay();
            if(day!=7){
                day++;
            }
            else if (day==7) {
                day=1;
            }
            System.out.println("connected");
            p.setDouble(1, whight);
            p.setInt(2, day);
            p.execute();
            System.out.println(day);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //gettign all the data in wight table
    public static ArrayList<dalywhigt> getDalyData(){
        ArrayList<dalywhigt> list = new ArrayList<>();
        try (
            Connection c = connection();
            PreparedStatement p =c.prepareStatement("select * from whight");
        ){
            ResultSet s = p.executeQuery();
            while(s.next()){
                list.add(new dalywhigt(s.getDouble("whight"),s.getInt("day"),s.getInt("id")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    public static void calculateAvg() {
        ArrayList<dalywhigt> list = new ArrayList<>();
        try (Connection c = connection();
             PreparedStatement p = c.prepareStatement("SELECT whight FROM whight ORDER BY ROWID DESC LIMIT 7")) {
             
            int j = getDalyData().size();
                if(j%7 != 0){
                    throw new Exception("not now");
                }
                ResultSet r = p.executeQuery();
                while (r.next()) {
                    list.add(new dalywhigt(r.getDouble("whight")));
                }
            double[] caling = new double[7];
            for (int i = 0; i < caling.length; i++) {
                caling[i] = list.get(i).getWhight();
            }
            int last = weekly.getWeeklyData().size()-1;
            double sum = Arrays.stream(caling).sum();
            double avg = sum / 7;
            double avgRonded = Math.round(avg * 100) / 100.0;
            if (avgRonded==weekly.getWeeklyData().get(last).getWhightAvg()) {
            throw new Exception("double");
            
        }
            int week = weekly.getWeeks() + 1;
            weekly.insertAvg(avgRonded, week);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("here for");
        }
        System.out.println("nothere");
    }
    // to know which day it is 
    public static int  knowingDay(){
        ArrayList<Integer> list = new ArrayList<>();
        try (
            Connection c = connection();
            PreparedStatement p = c.prepareStatement("SELECT day FROM whight ORDER BY ROWID DESC LIMIT 1")
        ){
            ResultSet r = p.executeQuery();
            while (r.next()) {
                list.add((r.getInt("day")));
            }
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
        System.out.println("here");
        return list.get(0);
    }
}

 


