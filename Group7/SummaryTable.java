package Group7;

import java.text.DecimalFormat;

/**
 * Created by Ali Dore on 17/11/2020 amended by A.Dungca 17/11/20 and further amended by Patrick Donnelly 18/11/20
 * Tested by the whole group on the 18/11/20
 * A program which displays all vehicle rental orders in the current session, and other
 * order information
 */


public class SummaryTable {

   static int totalOrders;
   static int widthOfSummary = 5;
   static DecimalFormat decimalFormat = new DecimalFormat("###,##0.##");
   static DecimalFormat currencyFormat = new DecimalFormat("£###,##0.00");
   static DecimalFormat df2 = new DecimalFormat("0.00");

   public static void displaySummary() {
      totalOrders=VehicleRental.Rentals.size();

      // Create 2D array and add column titles
      String[][] orderSummary = new String[totalOrders+1][widthOfSummary];

      orderSummary[0][0] = "Date";
      orderSummary[0][1] = "\t\t\tOrderID";
      orderSummary[0][2] = "Type";
      orderSummary[0][3] = "\tMiles Travelled";
      orderSummary[0][4] = "Cost(£)";

      //Fill 2D array
      for (int row = 0; row < totalOrders; row++) {
         orderSummary[row+1][0] = String.valueOf(VehicleRental.Rentals.get(row).getDateOfOrderID());
         orderSummary[row+1][1] = String.valueOf(VehicleRental.RentalsID.get(row));
         orderSummary[row+1][2] = String.valueOf(VehicleRental.Rentals.get(row).getRentalType());
         orderSummary[row+1][3] = "\t\t"+decimalFormat.format(VehicleRental.Rentals.get(row).getTotalMileage());
         orderSummary[row+1][4] = "\t\t\t"+ df2.format(VehicleRental.Rentals.get(row).calculateTotalRentalCost());
      }//end for

      System.out.println("=================");
      System.out.println("Rental Summary");
      double totalCost = 0;
      int totalMileage=0;

      System.out.println();
      // Display summary table
      for (int row = 0; row < orderSummary.length; row++) {
         for(int col =0; col<widthOfSummary;col++){
            System.out.print("\t"+orderSummary[row][col]+"\t\t");
         }//end nested for
         System.out.println();
      }//end for

      // calculate totals
      for (int row = 1; row <=totalOrders; row++) {
         // calculate totals
         if(VehicleRental.Rentals.get(row-1).getTotalMileage()==0){
            continue;
         }//end if
         else{
            totalMileage+= VehicleRental.Rentals.get(row-1).getTotalMileage();
            totalCost+=Double.parseDouble(orderSummary[row][4]);
         }//end else
      }//end for

      //display totals
      System.out.println();
      System.out.println("Total number of buses rented: " + MPVRental.getNumberBusRentals());
      System.out.println("Total number of cars rented: "+ CarRental.getNumberCarRentals());
      System.out.println("Total number of HGVs rented: "+ HGVRental.getNumberHGVRentals());
      System.out.println("Total number of Vehicles rented " + VehicleRental.Rentals.size());
      System.out.println("Total mileage for all vehicles rented: " + decimalFormat.format(totalMileage));
      System.out.println("Total revenue from all vehicles rented: " + currencyFormat.format(totalCost));
   }//end display Summary
} // class

