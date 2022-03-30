package Group7;

import java.text.DecimalFormat;
import java.util.Scanner;


/**
 * Created by A.Dungca on 28/10/2020
 * Car subclass for a vehicle rental program - creates carRental objects
 */
public class CarRental extends VehicleRental {

   //import Scanner class
   Scanner keyboard = new Scanner(System.in);
   //import Decimal Format class
   DecimalFormat df = new DecimalFormat("0.00");

   //variables unique to CarRental class
   private static int countCarsRented = 0;
   private int seats, doors;

   //default constructor
   public CarRental() {
   }

   //alternative constructor1
   public CarRental(String itsType, String carMake, String carReg, int carMilesBefore, int lengthDays, double dailyFee, int carSeats, int carDoors) {
      super(itsType, carMake, carReg, carMilesBefore, lengthDays, dailyFee);
      seats = carSeats;
      doors = carDoors;
      countCarsRented++;
      //itsType="Car";
   }

   //alternative constructor2
   public CarRental(String carReg, int carMilesBefore, int lengthDays, int carSeats) {
      super(carReg, carMilesBefore, lengthDays);
      seats = carSeats;
      doors = 0;
      String carType = "Car";
      countCarsRented++;
   }

   protected int getSeats() {
      return seats;
   }

   protected void setSeats(int carSeats) {
      seats = carSeats;
   }

   protected int getDoors() {
      return doors;
   }

   protected void setDoors(int carDoors) {
      doors = carDoors;
   }

   //adding to superclass toString
   public String toString() {
      return super.toString() + "\n" +
            "No. of seats in car: " + seats + "\n" +
            "No. of doors in car:" + doors + "\n";
   }

   //get number of car rentals
   protected static int getNumberCarRentals() {
      return countCarsRented;
   }

   //completing abstract method getVehicleType()
   protected String getVehicleType() {
      return ("This is a car rental");
   }

   public static void makeCarOrder(int num) {
      String type, make, reg;
      int milesBefore, days, seats, doors;
      double fee;
      System.out.println("\nCREATING CAR RENTAL\n====================");
      for (int count = 1; count <= num; count++) {
         System.out.println("Creating Car rental " + count + " of " + num);
         type = "Car";
         System.out.print("Make: ");
         make = VehicleRental.keyboard.next();
         System.out.print("Reg: ");
         reg = VehicleRental.keyboard.next();
         System.out.print("Miles before:");
         milesBefore = ErrorHandler.getIntegerInput();
         System.out.print("Days rented for: ");
         days = ErrorHandler.getIntegerInput();
         System.out.print("Daily fee (£): ");
         fee = ErrorHandler.getDoubleInput();
         System.out.print("How many seats in this car? ");
         seats = ErrorHandler.getIntegerInput();
         System.out.print("How many doors in this car? ");
         doors = ErrorHandler.getIntegerInput();

         //creating object with user input
         CarRental car1 = new CarRental(type, make, reg, milesBefore, days, fee, seats, doors);
         //adding created object to arraylist
         Rentals.add(car1);
         // Write file using dateID
         FileManager.write(car1);

         RentalsID.add(car1.getRentalID());
         System.out.println("CAR RENTAL CREATED\n====================");
      }
      MainMenu.mainMenu();
   }

}//class