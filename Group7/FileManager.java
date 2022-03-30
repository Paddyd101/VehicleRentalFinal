package Group7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Ali Dore on 16/11/2020. Amended by A.Dungca 17/11
 * Reading and writing text file, gets a list of orders created
 * Checks if a folder "order_receipts" exists and create it if not
 */
public class FileManager {
   static String fileName;
   final static String FILE_PATH = "order_receipts";

   private static void create() {
      try {
         File file = new File(fileName);
         file.createNewFile();
      } catch (IOException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
      }
   }

   public static void createFolder() {
      File theDir = new File(FILE_PATH);
      if (!theDir.exists()) {
         theDir.mkdirs();
      }
   }

   public static void getAllReceipts() {
      System.out.println("\nHistorical Orders on our system\n===========================\n");
      File theDir = new File(FILE_PATH);
      if (!theDir.exists()) {
         System.out.println("No Orders");
      } else {
         System.out.println("Enter number of order you'd like to see");
         String[] orders;
         // Creates a new File instance by converting the given order file string
         // into an abstract pathname
         File f = new File(FILE_PATH);

         // Populates the array with names of files and directories
         orders = f.list();

         // For each pathname in the pathnames array
         // Used a for-each loop, or enhanced for loop as extra practice
         // I could also have used a normal for loop
         int i = 0;
         for (String pathname : orders) {
            // Print the names of files and directories
            System.out.println(i + "\t" + pathname);
            i++;
         }

         int index;
         String wantedFilename;
         do {
            try {

               index = Group7.ErrorHandler.getIntegerInput();

               wantedFilename = orders[index];

            } catch (ArrayIndexOutOfBoundsException e) {
               System.out.println(e.getMessage());
               System.out.println("Please enter a whole number between 0 and " + (orders.length-1));
               VehicleRental.keyboard.next(); // reset scanner otherwise enters infinite loop.
               continue;
            }
            break; // need this to leave do loop if try successful
         } while (true);

         fileName = FILE_PATH + "/" + wantedFilename;
         System.out.println(read());
         Pause.pause(3);
      }
   }

   public static void write(VehicleRental vehicleRental) {
      createFolder();

      fileName = String.format("%s/%s_receipt_%s_%s.txt", FILE_PATH, vehicleRental.getRentalType(), vehicleRental.getDateID(), vehicleRental.getRentalID());

      create();

      try {
         java.io.FileWriter myWriter = new java.io.FileWriter(fileName);

         myWriter.write(String.valueOf(vehicleRental));

         myWriter.close();
      } catch (IOException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
      }
   }

   public static String read() {
      String text = "";

      try {
         File file = new File(fileName);
         Scanner myReader = new Scanner(file);

         while (myReader.hasNextLine()) {
            text += myReader.nextLine() + "\n";
         }

         myReader.close();
         return text;
      } catch (FileNotFoundException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
         e.getMessage();
      }
      return text;
   }
}//class