package Group7;

import java.text.DecimalFormat;

/**
 * Created by P.Donnelly on 29/10/2020
 * HGV subclass for a vehicle rental program -to create HGV rental objects.
 */
public class HGVRental extends VehicleRental {

   //import Decimal Format class
   DecimalFormat df = new DecimalFormat("0.00");

   //variables unique to HGVRental class
   protected static int countHGVRented=0;
   private static double height, loadCapacity;

   //default constructor
   public HGVRental(){
      countHGVRented++;
   }//end default constructor

   //alternative constructor
   public HGVRental(String type){
      super(type);
      countHGVRented++;
   }//end alternative constructor

   //alternative constructor
   public HGVRental(String HGVType,String HGVMake,String HGVReg,int HGVMilesBefore,int lengthDays,double dailyFee,double
         HGVheight,double HGVloadCapacity ){
      super(HGVType,HGVMake,HGVReg,HGVMilesBefore,lengthDays,dailyFee);
      height=HGVheight;
      loadCapacity=HGVloadCapacity;
      countHGVRented++;
   }//end alternative constructor

   //alternative constructor
   public HGVRental(String HGVType, String HGVMake, String HGVReg,int HGVMilesBefore,int lengthDays, double dailyFee){
      super(HGVType, HGVMake, HGVReg,HGVMilesBefore,lengthDays, dailyFee);
      height=0;
      loadCapacity=0;
      countHGVRented++;
   }//end alternative constructor

   //method to get load capacity
   protected static double getLoadCapacity() {
      return loadCapacity ;
   }//end getLoadCapacity()

   //method to setLoadCapacity
   protected static void setLoadCapacity(double maxLoad) {
      loadCapacity =maxLoad;
   }//end setLoadCapacity

   //method to get height of HGV
   protected static double getHeight() {
      return height;
   }//end getHeight()

   //method to set height of HGV
   protected static void setHeight(double HGVHeight) {
      height = HGVHeight;
   }//end setHeight

   //adding to superclass toString
   public String toString(){
      String message="";
      message= super.toString()+"\n";
      if(height==0){
         message= message +"The maximum height of the HGV is: Not declared\n";
      }//end if
      else{
         message=message+ "The maximum height of the HGV is: "+df.format(height)+" metres "+"\n";
      }//end else
      if (loadCapacity==0){
         message = message+ "Load capacity of the HGV is: Not declared\n ";
      }//end if
      else{
         message=message+ "The maximum working load capacity of the HGV is: "+df.format(loadCapacity)+"kg"+"\n";
      }//end else
      return message;
   }//end toString

   //get number of HGV rentals
   protected static int getNumberHGVRentals(){
      return countHGVRented;
   }//end getNumberHGVRentals

   //completing abstract method getVehicleType()
   protected String getVehicleType(){
      return ("HGV");
   }//end abstract method - getVehicleType

   public static void createHGVOrder(int num){

      String type,make,reg;
      int milesBefore,days;
      double height, loadCapacity, fee;

      System.out.println("\nCREATING HGV RENTAL\n====================");

      for (int count =1; count<=num;count++){
         System.out.println("Creating HGV rental "+count+" of "+ num);
         type="HGV";
         System.out.print("Make: ");
         make=VehicleRental.keyboard.next();
         System.out.print("Reg: ");
         reg=VehicleRental.keyboard.next();
         System.out.print("Miles before:");
         milesBefore = ErrorHandler.getIntegerInput();
         System.out.print("Days rented for: ");
         days= ErrorHandler.getIntegerInput();
         System.out.print("Daily fee (£): ");
         fee= ErrorHandler.getDoubleInput();;
         System.out.print("Height of this HGV?: ");
         height= ErrorHandler.getDoubleInput();
         System.out.print("Load Capacity of this HGV?: ");
         loadCapacity= ErrorHandler.getDoubleInput();

         //creating object with user input
         HGVRental thisHGV=new HGVRental(type,make,reg,milesBefore,days,fee,height,loadCapacity);
         //adding created object to arraylist
         VehicleRental.Rentals.add(thisHGV);
         //adding rental ID to Parralell arraylist
         VehicleRental.RentalsID.add(thisHGV.getRentalID());
         // Write file using dateID
         FileManager.write(thisHGV);
         System.out.println("HGV RENTAL CREATED\n====================");
         System.out.println(thisHGV);
      }//end for
      Pause.pause(3);
      MainMenu.mainMenu();
   }//end createHGVOrder
}//class