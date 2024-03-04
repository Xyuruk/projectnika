import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;



public class Pointpu extends JPanel implements MouseListener, MouseMotionListener  {
    ArrayList<Point> mas_points = new ArrayList<>();
    public Pointpu() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    public void mousePressed(MouseEvent e) {
        mas_points.add(new Point(e.getPoint()));
        repaint();
        System.out.println(e.getPoint());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //mas_points.add(new Point(e.getPoint()));
        //repaint();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void paint (Graphics g) {
        try {
            for (int i = 0; i < mas_points.size(); i++) {
                g.setColor(Color.RED);
                Point pt = mas_points.get(i);
                g.fillOval((int) (pt.x - 2.5), (int) (pt.y - 2.5), 5, 5);
                g.drawOval((int) (pt.x - 2.5), (int) (pt.y - 2.5), 5, 5);
            }
            if (mas_points.size() % 10 == 0) {
                int munx  = findMinX().x;
                int muny  = findMinY().y;
                int maxnx  = findMaxX().x;
                int maxy  = findMaxY().y;



                System.out.println(munx);
                System.out.println( muny);
                System.out.println(maxnx);
                System.out.println(maxy );

                g.drawLine(findMinX().x,findMinX().y,findMinY().x, findMinY().y );
                // perpendicularLine(findMinY());
                //g.drawLine(findMinX().x,findMinX().y, findMaxY().x,findMaxY().y);
                // g.drawLine(findMaxX().x, findMaxX().y,findMaxY().x,findMaxY().y);
                // g.drawLine(findMaxY().x,findMaxY().y,findMinX().x,findMinX().y );
                mas_points.clear();


            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
 /*   public Line perpendicularLine(Pointt p){
        double x1;
        double y1;
        double x2;
        double y2;
     // double A = y1 - y2;
      //  double B = x2 - x1;
     //   double C = x1*y2 - x2*y1;
      //  Line l = new Line((-1)*B,A,p.GetX()*B - p.GetY()*A);
        return l;
   }*/

    Point findMaxX(){
        Point max =mas_points.get(0);
        for(int i = 0; i < mas_points.size(); i ++){
            if(mas_points.get(i).getX() > max.getX()){
                max = mas_points.get(i);
            }
        }
        return max;
    }

    Point findMaxY(){
        Point max = mas_points.get(0);
        for(int i = 0; i < mas_points.size(); i ++){
            if(mas_points.get(i).getY() > max.getY()){
                max = mas_points.get(i);
            }
        }
        return max;
    }
    Point findMinX(){
        Point min = mas_points.get(0);
        for(int i = 0; i < mas_points.size(); i ++){
            if(mas_points.get(i).getX() < min.getX()){
                min = mas_points.get(i);
            }
        }
        return min;
    }
    Point findMinY(){
        Point min = mas_points.get(0);
        for(int i = 0; i < mas_points.size(); i ++){
            if(mas_points.get(i).getY() < min.getY()){
                min = mas_points.get(i);
            }
        }
        return min;
    }

}







