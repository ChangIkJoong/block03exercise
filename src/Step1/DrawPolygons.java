package Step1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawPolygons extends JComponent{
    private final ArrayList<Polygon> polygons;

    public DrawPolygons(){
        polygons = new ArrayList<>();
        polygons.add(new Polygon("square", new Point(100,100)));
        polygons.add(new Polygon("triangle", new Point(150,150)));
        polygons.add(new Polygon("rectangle", new Point(100,200)));
    }//constructor

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < polygons.size(); i++) {
            Polygon currentPolygon = polygons.get(i);
            Point currentCenter = currentPolygon.centerPoint;
            if (currentPolygon.name.equals("square"))
                g.drawRect(currentCenter.x -10, currentCenter.y -10, 20, 20);
            else if (currentPolygon.name.equals("triangle")) {
                g.drawLine(currentCenter.x, currentCenter.y-10, currentCenter.x-10,
                        currentCenter.y+10);
                g.drawLine(currentCenter.x-10, currentCenter.y+10,
                        currentCenter.x+10, currentCenter.y+10);
                g.drawLine(currentCenter.x+10, currentCenter.y+10, currentCenter.x,
                        currentCenter.y-10);
            } else if (currentPolygon.name.equals("rectangle"))
                g.drawRect(currentCenter.x -20, currentCenter.y -10, 40, 20);
        }
    }//paint

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        DrawPolygons polygons = new DrawPolygons();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(30,30,300,300);
        frame.getContentPane().add(polygons);
        frame.setVisible(true);
    }//main
}//DrawPolygons