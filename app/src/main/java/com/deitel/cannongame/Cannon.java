// Cannon.java
// Represents Cannon and fires the Cannonball
package com.deitel.cannongame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class Cannon {
   private Cannonball cannonball; // the Cannon's Cannonball
   private Paint paint = new Paint(); // Paint used to draw the cannon
   private CannonView view; // view containing the Cannon
   private int paddleLength;
   private int paddleHeight;
    private Rect shape;

   // constructor
   public Cannon(CannonView view, int color, int x, int y, int paddleLength, int paddleHeight) {
      this.view = view;
      paint.setColor(color); // Cannon's color is Black
       shape = new Rect(x, y, x + paddleLength, y + paddleHeight);
   }


   // creates and fires Cannonball in the direction Cannon points
   public void fireCannonball(double angle) {
      // calculate the Cannonball velocity's x component
      int velocityX = (int) (CannonView.CANNONBALL_SPEED_PERCENT *
         view.getScreenWidth() * Math.sin(angle));

      // calculate the Cannonball velocity's y component
      int velocityY = (int) (CannonView.CANNONBALL_SPEED_PERCENT *
         view.getScreenWidth() * -Math.cos(angle));

      // calculate the Cannonball's radius
      int radius = (int) (view.getScreenHeight() *
         CannonView.CANNONBALL_RADIUS_PERCENT);

      // construct Cannonball and position it in the Cannon
      cannonball = new Cannonball(view, Color.BLACK,
         CannonView.CANNON_SOUND_ID, view.getScreenWidth() / 2 - radius,
         view.getScreenHeight() - 150, radius, velocityX,
         velocityY);

      cannonball.playSound(); // play fire Cannonball sound
   }

   // draws the Cannon on the Canvas
   public void draw(Canvas canvas) {
//      canvas.drawLine((view.getScreenWidth() / 2) - (paddleLength / 2), view.getScreenHeight() - (paddleHeight/ 2),
//              (view.getScreenWidth() / 2) + (paddleLength / 2), view.getScreenHeight() + (paddleHeight/ 2), paint);
           canvas.drawRect(shape, paint);

   }

   // returns the Cannonball that this Cannon fired
   public Cannonball getCannonball() {
      return cannonball;
   }

   // removes the Cannonball from the game
   public void removeCannonball() {
      cannonball = null;
   }
}

/*********************************************************************************
 * (C) Copyright 1992-2016 by Deitel & Associates, Inc. and * Pearson Education, *
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this   *
 * book have used their * best efforts in preparing the book. These efforts      *
 * include the * development, research, and testing of the theories and programs *
 * * to determine their effectiveness. The authors and publisher make * no       *
 * warranty of any kind, expressed or implied, with regard to these * programs   *
 * or to the documentation contained in these books. The authors * and publisher *
 * shall not be liable in any event for incidental or * consequential damages in *
 * connection with, or arising out of, the * furnishing, performance, or use of  *
 * these programs.                                                               *
 *********************************************************************************/
