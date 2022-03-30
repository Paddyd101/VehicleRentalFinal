package Group7;


/**
 * Created by Ali Dore on 29/10/2020
 * Bus subclass for a vehicle rental program - creates MPVrental Objects
 */
public class MPVRental extends VehicleRental {

   //variables unique to BusRental class
   protected static int countBusesRented = 0;
   private int seats;

   //default constructor
   public MPVRental() {
      super();
      seats = 2;
      countBusesRented++;
   }

   //alternative constructor1
   public MPVRental(String MPVtype, String busMake, String busReg, int busMilesBefore, int lengthDays, double dailyFee,
                    int busSeats) {
      super(MPVtype, busMake, busReg, busMilesBefore, lengthDays, dailyFee);
      seats = busSeats;
      countBusesRented++;
   }

   //alternative constructor2
   public MPVRental(String MPVtype, String busReg, int busMilesBefore, int lengthDays, int busSeats) {
      super(busReg, busMilesBefore, lengthDays);
      seats = busSeats;
      countBusesRented++;
   }

   protected int getSeats() {
      return seats;
   }

   protected void setSeats(int carSeats) {
      seats = carSeats;
   }

   //adding to superclass toString
   public String toString() {
      return super.toString() + "\n" +
            "No. of seats in bus: " + seats + "\n";
   }

   //get number of bus rentals
   protected static int getNumberBusRentals() {
      return countBusesRented;
   }

   //completing abstract method getVehicleType()
   protected String getVehicleType() {
      return ("This is a bus rental");
   }

   public static void makeBusOrder(int num) {
      String type, make, reg;
      int milesBefore, days, seats;
      double fee;
      System.out.println("\nCREATING BUS RENTAL\n====================");
      for (int count = 1; count <= num; count++) {
         System.out.println("Creating Bus rental " + count + " of " + num);
         type = "MPV";
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
         System.out.print("How many seats in this bus? ");
         seats = ErrorHandler.getIntegerInput();
         //creating object with user input
         MPVRental thisBus = new MPVRental(type, make, reg, milesBefore, days, fee, seats);
         //adding created object to arraylist
         Rentals.add(thisBus);
         // Write file using dateID
         FileManager.write(thisBus);
         RentalsID.add(thisBus.getRentalID());

         System.out.println("BUS RENTAL CREATED\n====================");
         System.out.println(thisBus);
         Pause.pause(3);
      }//end for
      MainMenu.mainMenu();
   }

   //Method to be utilised in Testing - creating Bus orders automatically
   public static void testBusOrder(int num) {
      System.out.println("\nCREATING BUS RENTAL\n====================");
      MPVRental thisBus = new MPVRental("MPV", "Lada", "MNV 153Y", 1000,
            5, 75, 12);
      //adding created object to arraylist
      Rentals.add(thisBus);
      // Write file using dateID
      FileManager.write(thisBus);
      RentalsID.add(thisBus.getRentalID());

      System.out.println("BUS RENTAL CREATED\n====================");
      System.out.println(thisBus);

      //MainMenu.mainMenu();
   }
}//class