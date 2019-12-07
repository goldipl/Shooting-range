package shootingrange;

import javax.swing.*;

/**
 * Author: Marcin Godlewski
 * Source: C.Horstmann | Java. X Edition.
 * --------------------------------------------
 * A frame containing a panel for ShootingRange
 */

public class ShootingRangeFrame extends JFrame
{
   public ShootingRangeFrame()
   {
      add(new ShootingRange());
      pack();
   }
}