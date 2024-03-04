class Line{
    private double A, B, C;

    @Override
    public String toString(){
        String s2 = "", s3 = "";
        String s = String.format("%.2f", A);
        if(B<0){
            String s1 = String.format("%.2f", Math.abs(B));
            s2 = ""+" - "+s1;
        } else {
            String s1 = String.format("%.2f", B);
            s2 = ""+" + "+s1;
        }
        if(C<0){
            String s1 = String.format("%.2f", Math.abs(C));
            s3 = ""+" - "+s1;
        } else {
            String s1 = String.format("%.2f", C);
            s3 = ""+" + "+s1;
        }
        return s+"x"+s2+"y"+s3+" = 0";

    }
    Line(double A, double B, double C){
        this.A = A;
        this.B = B;
        this.C = C;
    }
    Line(){

    }
    Line(double x1, double y1, double x2, double y2){
        this.A = y1 - y2;
        this.B = x2 - x1;
        this.C = x1*y2 - x2*y1;
    }



    public boolean isParallel(Line l){
        boolean flag;
        String s1= String.format("%.4f",(-1)*A/B);
        String s2 = String.format("%.4f",(-1)*l.A/l.B);
        if(s1.equals(s2)){
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }
    public Pointt intersection(Line l){
        if (this.isParallel(l) == true) {
            return null;
        }
        Pointt p =  new Pointt();
        p.x= (this.B*l.C-l.B*this.C)/(this.A*l.B - this.B*l.A);
        p.y= (this.C*l.A-l.C*this.A)/(this.A*l.B - this.B*l.A);
        return p;
    }
    public Pointt nearPoint(Pointt p){
        Line l = new Line((-1)*B,A,p.GetX()*B - p.GetY()*A);
        return intersection(l);
    }

    public void normalize(){
        if (C!=0){

            A/=C;
            B/=C;
            C = 1;
        } else if (A != 0){

            C/= A;
            B/= A;
            A = 1;
        } else B=1;
        if (C==-0) C=0;
    }
    public Line perpendicularLine(Pointt p){
        Line l = new Line((-1)*B,A,p.GetX()*B - p.GetY()*A);
        return l;
    }
    public Line parallelLine(Pointt p){
        Line l = new Line(A,B,-1*(A*p.GetX()+B*p.GetY()));
        return l;
    }
}
class Pointt{
    public double x, y, distance;
    Pointt(){
        this.x = 0;
        this.y = 0;
    }
    Pointt (double x, double y){
        this.x=x;
        this.y=y;
    }
    public double GetX(){
        return x;
    }
    public double GetY(){
        return y;
    }

    public String toString() {
        String s = String.format("%.2f", x);
        String s1 = String.format("%.2f", y);
        return "("+s+", "+s1+")";
    }
}
