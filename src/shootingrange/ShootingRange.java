package shootingrange;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

/**
 * Author: Marcin Godlewski
 * Source: C.Horstmann | Java. X Edition.
 */

public class ShootingRange extends JComponent
{
   private static final int DEFAULT_WIDTH = 500;
   private static final int DEFAULT_HEIGHT = 500;
   private static final int SIDELENGTHSMALL = 100;
   private static final int SIDELENGTHNORMAL = 250;
   private static final int SIDELENGTHBIG = 400;
   
   private ArrayList<Rectangle2D> shoot;
   private Rectangle2D current;
   private Rectangle2D small;
   private Rectangle2D normal;
   private Rectangle2D large;

   public ShootingRange()
   {
      shoot = new ArrayList<>();
      small = new Rectangle2D.Double(DEFAULT_HEIGHT/2 - SIDELENGTHSMALL/2, DEFAULT_WIDTH/2-SIDELENGTHSMALL/2, SIDELENGTHSMALL, SIDELENGTHSMALL);
      normal = new Rectangle2D.Double(DEFAULT_HEIGHT/2 - SIDELENGTHNORMAL/2, DEFAULT_WIDTH/2-SIDELENGTHNORMAL/2, SIDELENGTHNORMAL, SIDELENGTHNORMAL);
      large = new Rectangle2D.Double(DEFAULT_HEIGHT/2 - SIDELENGTHBIG/2, DEFAULT_WIDTH/2-SIDELENGTHBIG/2, SIDELENGTHBIG, SIDELENGTHBIG);

      current = null;

      shoot.add(small);
      shoot.add(normal);
      shoot.add(large);
      addMouseListener(new ShotHandler());
      addMouseMotionListener(new RifleCrosshairHandler());
   }

   public void paintComponent(Graphics graphics)
   {
      Graphics2D graphics2 = (Graphics2D) graphics;

      for (Rectangle2D r : shoot)
         graphics2.draw(r);
   }

   public Rectangle2D find(Point2D point)
   {
      for (Rectangle2D r : shoot)
      {
         if (r.contains(point)) return r;
      }
      return null;
   }

   public void add(Point2D point)
   {
      double x = point.getX();
      double y = point.getY();

      current = new Rectangle2D.Double(x - 5, y - 5, 8, 8);
      shoot.add(current);
      repaint();
   }

   private class ShotHandler extends MouseAdapter
   {

      public void mouseClicked(MouseEvent event)
      {
         current = find(event.getPoint());
    	  
    	 if (current == small) System.out.println("100pkt");
    	 if (current == small) add(event.getPoint());
    	 if (current == normal) System.out.println("50pkt");
    	 if (current == normal) add(event.getPoint());
    	 if (current == large) System.out.println("20pkt");
    	 if (current == large) add(event.getPoint());
    	 
      }
   }

   private class RifleCrosshairHandler implements MouseMotionListener
   {
      public void mouseMoved(MouseEvent event)
      {
         if (find(event.getPoint()) == null) setCursor(Cursor.getDefaultCursor());
         else setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
      }

      public void mouseDragged(MouseEvent event)
      {
    	  //do nothing
      }
   }
   
   public Dimension getPreferredSize() { return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT); }
}
