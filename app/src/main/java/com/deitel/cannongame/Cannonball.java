// Cannonball.java
// Represents the Cannonball that the Cannon fires
package com.deitel.cannongame;

import android.graphics.Canvas;
import android.graphics.Rect;

public class Cannonball extends GameElement {
   private float velocityX;
   private float velocityY;
   private boolean onScreen;

   // constructor
   public Cannonball(CannonView view, int color, int soundId, int x,
      int y, int radius, float velocityX, float velocityY) {
      super(view, color, soundId, x, y,
         2 * radius, 2 * radius);
      this.velocityX = velocityX;
       this.velocityY = velocityY;
      onScreen = true;
   }

   // get Cannonball's radius
   private int getRadius() {
      return (shape.right - shape.left) / 2;
   }

   // test whether Cannonball collides with the given GameElement
   public boolean collidesWith(GameElement element) {
      return (Rect.intersects(shape, element.shape));
   }

   // returns true if this Cannonball is on the screen
   public boolean isOnScreen() {
      return onScreen;
   }

   // reverses the Cannonball's velocity
   public void reverseVelocity() {
       velocityY *= -1;
       velocityX *= -1;

   }

   // updates the Cannonball's position

    // update GameElement position and check for wall collisions
   public void update(double interval) {
       // update vertical position
       shape.offset(0, (int) (velocityY * interval));

       // if this GameElement collides with the wall, reverse direction
       if (shape.top < 0 && velocityY < 0 ||
               shape.bottom > view.getScreenHeight() && velocityY > 0)
           velocityY *= -1; // reverse this GameElement's velocity

      // update horizontal position
      shape.offset((int) (velocityX * interval), 0);

      if (shape.bottom > view.getScreenHeight())
         onScreen = false; // set it to be removed

      // if this GameElement collides with the wall, reverse direction
      if (shape.top < 0 ||
              shape.right > view.getScreenWidth()||
              shape.left < 0)
      // reverse this GameElement's velocity
      {
          velocityX *= -1;
      }
   }

   // draws the Cannonball on the given canvas
   @Override
   public void draw(Canvas canvas) {
      canvas.drawCircle(shape.left + getRadius(),
         shape.top + getRadius(), getRadius(), paint);
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
