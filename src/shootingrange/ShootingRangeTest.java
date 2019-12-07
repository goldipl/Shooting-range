package shootingrange;

import java.awt.*;
import javax.swing.*;

/**
 * Author: Marcin Godlewski
 * Source: C.Horstmann | Java. X Edition.
 */

public class ShootingRangeTest
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new ShootingRangeFrame();
               frame.setTitle("ShootingRange");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}