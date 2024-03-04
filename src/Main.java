import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {
    int w = 1000, h = 1000;
    Main(){
        ArrayList<Point> points = new ArrayList<>();
        ArrayList<String> lines = FileReader.readFileContents("points");
        for (String line : lines) {
            String[] coordinates = line.split(" ");
            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);
            Point point = new Point(x, y);
            points.add(point);
        }

        for (Point point : points) {
            System.out.println("x = " + point.getX() + " y = " + point.getY());
        }



//        setVisible(true);
//        setSize(w, h);
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//       /* JMenuBar menuBar = new JMenuBar(); // coздание меню
//        menuBar.add(chooseMenu());
//        this.setJMenuBar(menuBar);*/
//        add(new Coord());
//        add(new Pointpu());
//        //
//
//         /* JButton  jButton1 = new JButton("нарисовать прямоугольник");
//        jButton1.setFont(new Font("Courier New", Font.BOLD, 24));
//        jButton1.setBounds(400,0,90,30);
//        add(jButton1);
//        jButton1.addActionListener(this::printResult1);*/
    }
    public JMenu chooseMenu(){
        JMenu jmenu = new JMenu("Выбрать");
        JMenuItem keyboard = new JMenuItem("Клавиатура");
        jmenu.add(keyboard);
        jmenu.add(new JSeparator());
        JMenuItem mouse = new JMenuItem("Мышка");
        jmenu.add(mouse);
        jmenu.add(new JSeparator());
        mouse.addActionListener(this::printResult1);
        JMenuItem file = new JMenuItem("Файл");
        jmenu.add(file);
        jmenu.setLocation(0,0);
        return jmenu;
    }
    void printResult1(ActionEvent activeEvent){

    }
    public static void main (String[] args){
        new Main().setVisible(true);
    }
}