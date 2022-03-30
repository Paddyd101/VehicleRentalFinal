package Group7;
/**
 * Created by Ali Dore on 17/11/2020
 * Pauses to allow user to read output on the terminal
 */
public class Pause
{
   public static void pause(int secs)
   {
      try
      {
         Thread.sleep(secs*1000);
      } catch (InterruptedException e)
      {
         e.printStackTrace();
      }

   } // main
} // class