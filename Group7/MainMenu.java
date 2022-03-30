package Group7;

import java.text.DecimalFormat;

/**
 * Created by Ali Dore on 17/11/2020
 * Displays a menu to the user and prompts user selection to perform various functions
 */
public class MainMenu {

   protected static void mainMenu() {
      int choice;
      int id;
      int numCars, numBus, numHGV;
      DecimalFormat currencyFormat = new DecimalFormat("£###,##0.00");

      Search search = new Search();

      System.out.println("Vehicle Rentals");
      System.out.println("===============");
      System.out.println();
      System.out.println("What would you like to do?");
      System.out.println();
      System.out.println("Your Options (please enter a number):");
      System.out.println("1. Make a single Vehicle rental order \n2. Make a multi-Vehicle (fleet) Vehicle Rental order  \n3. Search " +
            "existing orders \n4. Log details of a returned vehicle \n" +
            "5. Update Discount List \n6. Display number of rental orders \n7. Print Summary list of all rentals " +
            "\n8. Display Total Revenue \n9. Access rental receipts on our Database \n0. Quit?");

      choice = Group7.ErrorHandler.getIntegerInput();

      switch (choice) {
         case 1:
            System.out.println();
            System.out.println("Create a Rental order");
            System.out.println("===============");
            System.out.println("What type of vehicle rental order would you like to make?:");
            System.out.println("1. Car\n2. MPV\n3. HGV");

            choice = Group7.ErrorHandler.getIntegerInput();

            //nested switch statement - Create order
            switch (choice) {
               case 1:
                  CarRental.makeCarOrder(1);
                  break;
               case 2:
                  MPVRental.makeBusOrder(1);
                  break;
               case 3:
                  HGVRental.createHGVOrder(1);
                  break;
            }//end nested switch statement / Create order
            break;

         case 2:
            System.out.println();
            System.out.println("Create a multi-vehicle (fleet) rental order");
            System.out.println("===========================================");

            System.out.println("What type of vehicle rental order would you like to make?:");
            System.out.println("1. Car\n2. MPV\n3. HGV");

            choice = ErrorHandler.getIntegerInput();

            switch (choice) {

               case 1:
                  //prompt user to enter number of Cars to rent
                  System.out.println("Please enter number of cars you wish to rent");
                  numCars = ErrorHandler.getIntegerInput();
                  Group7.CarRental.makeCarOrder(numCars);
                  break;

               case 2:
                  //prompt user to enter number of buses needed
                  System.out.println("Please enter number of buses you wish to rent");
                  numBus = ErrorHandler.getIntegerInput();
                  Group7.MPVRental.makeBusOrder(numBus);
                  break;

               case 3:
                  //prompt user to enter number of Cars needed
                  System.out.println("Please enter number of HGV you wish to rent");
                  numHGV = ErrorHandler.getIntegerInput();
                  Group7.HGVRental.createHGVOrder(numHGV);
                  break;

            }//end nested switch
            break;

         case 3:

            //nested switch statement - Search
            System.out.println();
            System.out.println("Search Vehicles");
            System.out.println("===============");
            System.out.println("Your Options (please enter a number):");
            System.out.println("1. Search By Rental Type  \n2. Search all rentals");

            choice = ErrorHandler.getIntegerInput();

            switch (choice) {
               case 1:
                  search.searchByType(VehicleRental.Rentals);
                  break;

               case 2:
                  search.searchAllRentals(VehicleRental.Rentals);
                  break;
            }//end nested switch statement - Search
            break;
         case 4:
            System.out.println();
            System.out.println("Return a Vehicle");
            System.out.println("================");

            // informs the user as to which rental orders have been made
            for (VehicleRental thisOrder : VehicleRental.Rentals) {
               System.out.println(thisOrder.getRentalType() + " " + thisOrder.getRentalID() + " " + thisOrder.dateOfOrder);
            }

            System.out.println("Please enter the Vehicle rental ID you wish to return:");
            id = ErrorHandler.getIntegerInput();

            VehicleRental.returnVehicle(id);
            break;
         case 5:
            VehicleRental.autoUpdateDiscountList();
            break;
         case 6:
            System.out.println("Number of Vehicle Rentals");
            System.out.println("=========================");
            System.out.println(("Your Options (please enter a number):"));
            System.out.println("1. Number of Car rentals  \n2. Number of MPV rentals \n3. Number of HGV rentals " +
                  "\n4. Total number of rentals");

            choice = ErrorHandler.getIntegerInput();

            //nested switch - Vehicle counts
            switch (choice) {


               case 1:
                  System.out.println();
                  System.out.println("Total number of car rentals: " +CarRental.getNumberCarRentals());
                  mainMenu();
                  break;
               case 2:
                  System.out.println();
                  System.out.println("Total number of MPV rentals: " + MPVRental.getNumberBusRentals());
                  mainMenu();
                  break;
               case 3:
                  System.out.println();
                  System.out.println("Total number of HGV rentals: " + HGVRental.countHGVRented);
                  mainMenu();
                  break;
               case 4:
                  System.out.println();
                  System.out.println("Total number of Vehicle rentals: " + VehicleRental.countVehiclesRented);
                  mainMenu();
                  break;
            }//end nested Switch - Vehicle counts
            break;

         case 7:
            System.out.println();
            System.out.println("Summary of Rentals");
            System.out.println("==================");
            System.out.println("Summary of all Vehicle rental Orders: ");
            SummaryTable.displaySummary();
            Pause.pause(3);

            mainMenu();
            break;
         case 8:
            System.out.println();
            System.out.println("Total Revenue");
            System.out.println("=============");
            System.out.println("Total revenue generated from all rentals: " + currencyFormat.format(VehicleRental.totalRevenue));
            mainMenu();
            break;
         case 9:
            FileManager.getAllReceipts();
            Pause.pause(3);
            mainMenu();
            break;
         case 0:
            System.out.println("Quitting program.\nThank you.\nGoodbye");
            break;
         default:

            mainMenu();

      }//end switch
   }//end main menu()
} // class
