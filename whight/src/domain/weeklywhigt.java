package domain;

public class weeklywhigt {
    private int week;
    private double whightAvg;
    public weeklywhigt(int week, double whightAvg) {
        this.week = week;
        this.whightAvg = whightAvg;
    }
    public weeklywhigt(){}
    public weeklywhigt(int week){
            this.week=week;
    }
    public int getWeek() {
        return week;
    }
    public void setWeek(int week) {
        this.week = week;
    }
    public double getWhightAvg() {
        return whightAvg;
    }
    public void setWhightAvg(double whightAvg) {
        this.whightAvg = whightAvg;
    }
}
