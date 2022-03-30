package Group7;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Ali Dore on 17/11/2020
 * To Handle integer/Double input errors
 */
public class ErrorHandler {
   public static int getIntegerInput() {
      Scanner myScanner = new Scanner(System.in);
      int thisInt;
      do {
         try {
            thisInt = myScanner.nextInt();

         } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number");
            myScanner.next(); // reset scanner otherwise enters infinite loop.
            continue; // will go again until doesn't cause error
         }

         return thisInt; // will leave do loop if try successful
      } while (true);
   }//end of method

   public static double getDoubleInput() {
      Scanner myScanner = new Scanner(System.in);
      double thisDouble;
      do {
         try {
            thisDouble = myScanner.nextDouble();
         } catch (InputMismatchException e) {
            System.out.println("Please enter a valid decimal number");
            myScanner.next(); // reset scanner otherwise enters infinite loop.
            continue; // will go again until doesn't cause error
         }
         return thisDouble; // will leave do loop if try successful
      } while (true);
   }//end of method

} // class
