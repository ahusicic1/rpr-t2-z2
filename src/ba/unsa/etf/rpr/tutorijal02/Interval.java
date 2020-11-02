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

    public double getPrva() {
        return t1;
    }
    public double getDruga() {
        return t2;
    }
    public boolean isIn1(){
        return pripada1;
    }
    public boolean isIn2(){
        return pripada2;
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

    public static Interval intersect(Interval i1, Interval i2){
        double veci1, manji2;
        boolean pripada1, pripada2;
        if(i1.getPrva() >= i2.getPrva()){ veci1 = i1.getPrva(); pripada1 = i1.isIn1(); }
        else{ veci1 = i2.getPrva(); pripada1 = i2.isIn1(); }

        if(i1.getDruga() <= i2.getDruga()){ manji2 = i1.getDruga(); pripada2 = i1.isIn2(); }
        else{ manji2 = i2.getDruga(); pripada2 = i2.isIn2(); }

        Interval i = new Interval(veci1, manji2, pripada1, pripada2);
        return i;
    }

    public Interval intersect(Interval i1){
        double veci1, manji2;
        boolean pripada1, pripada2;
        if(i1.getPrva() >= this.getPrva()){ veci1 = i1.getPrva(); pripada1 = i1.isIn1(); }
        else{ veci1 = this.getPrva(); pripada1 = this.isIn1(); }

        if(i1.getDruga() <= this.getDruga()){ manji2 = i1.getDruga(); pripada2 = i1.isIn2(); }
        else{ manji2 = this.getDruga(); pripada2 = this.isIn2(); }

        Interval i = new Interval(veci1, manji2, pripada1, pripada2);
        return i;
    }

    @Override
    public boolean equals(Object obj) {
        Interval i = (Interval) obj;
        return ( i.getPrva() == this.getPrva() && i.getDruga() == this.getDruga()
         && i.isIn1() == this.isIn1()  &&  i.isIn2() == this.isIn2());
    }

}
