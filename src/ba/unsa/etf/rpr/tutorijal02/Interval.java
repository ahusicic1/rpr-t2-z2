package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private  double t1, t2;
    private boolean pripada1, pripada2;

    public Interval (double t1, double t2, boolean pripada1, boolean pripada2) throws IllegalArgumentException{
      if(t1>t2) throw new IllegalArgumentException("Prva koordinata ne moze biti veca od druge");
      this.t1 = t1; this.t2 = t2;
      this.pripada1 = pripada1; this.pripada2 = pripada2;
    }

    public Interval (){
        t1 = 0; t2 = 0; pripada1 = false; pripada2 = false;
    }

    public boolean isNull(){
        if(t1 == 0 && t2 == 0) return true;
        return false;
    }

    public  boolean isIn(double t){
        if(t < t1 || t > t2) return false;
        else if((t==t1 && !pripada1) || (t==t2 && !pripada2)) return false;
        return  true;
    }

    public Interval intersect(Interval i1, Interval i2){
        double veci1, manji2;
        boolean pripada1, pripada2;
        if(i1.t1 >= i2.t1){ veci1 = i1.t1; pripada1 = i1.pripada1; }
        else{ veci1 = i2.t1; pripada1 = i2.pripada1; }



    }





}
