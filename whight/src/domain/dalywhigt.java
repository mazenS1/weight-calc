package domain;

public class dalywhigt {
    int day ,id ;
    double whight;
    public dalywhigt(){}
    public dalywhigt(double whight,int day, int id ) {
        this.whight = whight;
        this.day = day;
        this.id = id;
    }
    public dalywhigt(double whight){
        this.whight=whight;
    }
    public int getDay() {
        return day;
    }
    public  void setDay(int day) {
        this.day = day;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public  double getWhight() {
        return whight;
    }
    public void setWhight(double whight) {
        this.whight = whight;
    }
   
}
