
package Group7;

import java.util.ArrayList;


/*
 * Created by A.Dungca on 29/10/2020
 * Allows user to search orders created during current session*/

public class Search {

   public static void searchByType(ArrayList<VehicleRental> Rentals) {

      String rentalType = "";

      System.out.println("What type of rental type would you like to see? (Enter a number): 1. Car, 2. MPV, 3. HGV.");
      int userChoiceType = ErrorHandler.getIntegerInput();

      if (userChoiceType == 1) {
         rentalType = "Car";
      } else {
         if (userChoiceType == 2) {
            rentalType = "MPV";
         } else {
            rentalType = "HGV";
         }
      }

      System.out.println("Full Rental Details (by type)");
      System.out.println("=============================");
      System.out.println("\nThese are all the rental orders on our system for your search type");

      for (int i = 0; i < Rentals.size(); i++) {
         System.out.println();
         if (rentalType.equals(Rentals.get(i).getRentalType())) {
            System.out.println(Rentals.get(i));
         }
      }
      MainMenu.mainMenu();
   }

   //method for search for all rentals
   public static void searchAllRentals(ArrayList<VehicleRental> Rentals) {

      System.out.println("Full Rental Details");
      System.out.println("===================");
      System.out.println("\nThese are all the rental orders in our system: ");

      for (int i = 0; i < Rentals.size(); i++) {
         System.out.println();
         System.out.println(Rentals.get(i));
         System.out.println();
      }
      MainMenu.mainMenu();
   }
}//class