
////////////////////////////////////////////////////////////////
//
// Name: Caleb Appiagyei
//
// Date: 5/26/21
//
// Program: Graphics: Artwork
//
// Description: This program will display an arc, line, oval,
// polygon, rectangle, and other things using draw methods
//
////////////////////////////////////////////////////////////////

// Import classes
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Artwork_CBA extends JPanel
{
   final int WIDTH = 800;
   final int HEIGHT = 400;
   
   // Constructor
   public Artwork_CBA() {
      setPreferredSize(new Dimension(WIDTH, HEIGHT));
   }
   
   public void paintComponent(Graphics page) {
      page.setColor(Color.GREEN);
      page.fillRect(0,0,getWidth(),getHeight());
      
      // Arc
      page.setColor(Color.WHITE);
      page.drawArc(0, 10, 200, 200, 270, 90);
            
      // Rectangles
      page.drawRect(0, 297, 100, 198);
      page.drawRect(1500, 297, 100, 198);
      
      // Oval 
      page.drawOval(800, 33, 50, 30);
      page.fillOval(800, 33, 50, 30);
      
      // Polygon
      int[] x = { 210, 230, 240, 250, 310, 340 };
      int[] y = { 340, 210, 150, 140, 130, 210 };
      page.drawPolygon( x, y, 6 );
      page.fillPolygon( x, y, 6 );
      
      // Line
      page.drawLine(420, 360, 710, 150);
      
      // String
      page.setFont(new Font("Arial", Font.PLAIN, 40));
      page.drawString("Caleb A", 450, 400);
   }
   
   public static void main (String[] args){
      JFrame frame = new JFrame("Artwork_CBA");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new Artwork_CBA());
      frame.pack();
      frame.setVisible(true);
   }
}
