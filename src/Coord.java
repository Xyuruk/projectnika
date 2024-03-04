import javax.swing.*;
import java.awt.*;

public class Coord extends JPanel {
    int w = 1000, h = 1000;
    Coord(){
    }

    @Override
    public void paint (Graphics g) {
        int x = -w/100;
        int y = h/100;
        g.setColor(Color.BLACK);
        g.drawLine((w / 2), 0, (w / 2), h);
        for (int i = 0; i < 1000; i += 50) {
            g.drawRect((int) ((h / 2) - 7.5), i , 15, 2);
            g.fillRect((int) ((h / 2) - 7.5), i ,  15 ,2);
            String oy = Integer.toString(y);
            g.drawString(oy, ((w / 2) + 1), i+1);
            y -= 1;
        }
        g.drawLine(0, (h / 2) + 1, w, (h / 2) + 1);
        for (int j = -1;j < 1000; j += 50) {
            g.drawRect(j, (int) ((h / 2) - 7.5), 2, 15);
            g.fillRect(j, (int) ((h / 2) - 7.5), 2, 15);
            String ox = Integer.toString(x);
            g.drawString(ox, j + 2, w / 2);
            x += 1;
        }
    }
}


