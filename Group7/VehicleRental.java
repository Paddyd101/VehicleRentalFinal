package Group7;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Patrick Donnelly (group7) on 27/10/2020
 * An abstract super class for a vehicle rental program
 */
abstract public class VehicleRental {

   //import Scanner class
   static Scanner keyboard = new Scanner(System.in);
   //import Decimal Format class
   DecimalFormat df = new DecimalFormat("0.00");
   static SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy_HHmmss");
   static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");



   //arraylist to store all vehicle rentals
   public static ArrayList<VehicleRental> Rentals=new ArrayList<>();
   public static ArrayList<Integer> RentalsID=new ArrayList<>();

   //variables required for constructor methods to create an object of the VehicleRental class
   private String make, regNum,rentalType;
   private int startMileage, numDays;
   int rentalID;
   String dateID, dateOfOrder;
   private static double dailyCost;
   private static int uniqueNum = 10001;
   final static int DISCOUNT_ITEMS = 10;
   static int [] percentageDiscount = new int[DISCOUNT_ITEMS];
   int discount;
   protected static int  countVehiclesRented=0;


   //variables required for other methods/calculations within the VehicleRental class
   private int endMileage=0, totalMileage;
   private final double EXTRA_FEE_PER_MILE=0.2;
   private final int DAILY_MILES_ALLOWED=150;
   private double totalRentalCost;
   protected static double totalRevenue;


   //default constructor
   public VehicleRental(){
      rentalID=uniqueNum;
      Date date = new Date();
      dateID=formatter.format(date);
      dateOfOrder = dateFormatter.format(date);
      uniqueNum++;
      countVehiclesRented++;
      discount= randomSelection();
   }//end default constructor method

   //alternative constructor method with 5 constructor variables passed as parameters
   public VehicleRental(String itsType,String itsMake, String itsRegNum, int MilesBefore, int lengthDays,
                        double dailyFee){
      make=itsMake;
      regNum=itsRegNum;
      startMileage=MilesBefore;
      rentalID=uniqueNum;
      Date date = new Date();
      dateID=formatter.format(date);
      dateOfOrder = dateFormatter.format(date);
      numDays=lengthDays;
      dailyCost=dailyFee;
      uniqueNum++;
      countVehiclesRented++;
      discount = randomSelection();
      rentalType=itsType;

   }//end alternative constructor

   //alternative constructor method
   public VehicleRental(String itsRegNum, int MilesBefore, int lengthDays){
      make="unknown";
      regNum=itsRegNum;
      startMileage=MilesBefore;
      rentalID=uniqueNum;
      Date date = new Date();
      dateID=formatter.format(date);
      dateOfOrder = dateFormatter.format(date);
      numDays=lengthDays;
      dailyCost=0;
      uniqueNum++;
      countVehiclesRented++;
      discount= randomSelection();
   }//end alternative constructor

   //alternative constructor method - can be used if creating orders passing parameters relating to MilesBefore and
   // duration
   public VehicleRental(int MilesBefore, int lengthDays){
      make="unknown";
      regNum="***";
      startMileage=MilesBefore;
      rentalID=uniqueNum;
      Date date = new Date();
      dateID=formatter.format(date);
      dateOfOrder = dateFormatter.format(date);
      numDays=lengthDays;
      dailyCost=0;
      uniqueNum++;
      countVehiclesRented++;
      discount= randomSelection();
   }//end alternative constructor

   //alternative constructor method - can be used if creating order passing parameters relating to Reg, MilesBefore
   // and fee
   public VehicleRental(String itsRegNum, int MilesBefore, double dailyFee){
      make="unknown";
      regNum=itsRegNum;
      startMileage=MilesBefore;
      rentalID=uniqueNum;
      Date date = new Date();
      dateID=formatter.format(date);
      dateOfOrder = dateFormatter.format(date);
      numDays=0;
      dailyCost=-dailyFee;
      uniqueNum++;
      countVehiclesRented++;
      discount= randomSelection();
   }//end alternative constructor

   //alternative constructor - can be used if creating orders passing parameters relating to  make, reg, beforeMiles,
   // duration and daily fee
   public VehicleRental(String make, String reg, int beforeMiles, int numDays, double dailyFee) {
      rentalID=uniqueNum;
      uniqueNum++;
      countVehiclesRented++;
   }//end alternative constructor

   //alternative constructor
   public VehicleRental(String itsType){
      rentalType=itsType;
   }//end alternative constructor


   //get and set methods are not all utilised in the code at present, but there are included for future developements
   // of the program

   //method to getRentalID
   protected int getRentalID() {
      return rentalID;
   }//end getRentalID

   //method to getDateID
   protected String getDateID() {
      return dateID;
   }//end getDateID

   //method to getDateOfOrderID
   protected String getDateOfOrderID() {
      return dateOfOrder;
   }//end getDateID

   //method to getTotalMileage
   protected int getTotalMileage() {
      if(endMileage>startMileage){
         return endMileage-startMileage;
      }//end if
      else{
         return 0;
      }///end else
   }//end getRentalID

   //method for setMake()
   protected void setMake(String vehicleMake) {
      make = vehicleMake;
   }//end setMake

   //method to getMake
   protected String getMake() {
      return make;
   }//end getMake

   //method for setRegNum()
   protected void setRegNum(String regNo) {
      regNum=regNo;
   }//end setRegNum

   //method for getRegNum()
   protected String getRegNum() {
      return regNum;
   }//end getRegNum

   //method to setStartMileage()
   protected void setStartMileage(int beforeMiles) {
      startMileage = beforeMiles;
   }//end setStartMileage()

   //method to getStartMileage()
   protected int getStartMileage() {
      return startMileage;
   }// end method to getStartMileage()

   //method to setNumDays()
   protected void setNumDays(int lengthDays) {
      numDays = lengthDays;
   }// end setNumdays()

   // method to getNumDays()
   protected int getNumDays() {
      return numDays;
   }//end getNumDays

   //method to setDailyCost()
   protected void setDailyCost(double dailyFee) {
      dailyCost = dailyFee;
   }// setDailyCost

   //method to getDailyCost()
   protected double getDailyCost() {
      return dailyCost;
   }//end getDailyCost()

   //method to setEndMileage()
   public void setEndMileage(int mileageAfter) {
      endMileage= mileageAfter;
   }//end  setEndMileage()

   //method to getEndMileage()
   protected int getEndMileage() {
      return endMileage;
   }//end getEndMileage()

   //getRentalType
   protected String getRentalType() {
      return rentalType;
   }//end getRentalType

   //method to calculate averageDailyMiles()
   protected double calculateAverageDailyMiles(){
      return (double) (endMileage-startMileage)/numDays;
   }//end calculateAverageDailyMiles()

   //method to calculate additional fee based on mileage
   protected double calculateAdditionalFee(){
      double answer = (calculateAverageDailyMiles() - DAILY_MILES_ALLOWED)*numDays*EXTRA_FEE_PER_MILE;
      if(answer<0){
         return 0;
      }//end if
      else {
         return (calculateAverageDailyMiles() - DAILY_MILES_ALLOWED)*numDays*EXTRA_FEE_PER_MILE;
      }//end else
   }//end calculateAdditionalFee

   //method to calulcate totol Rental price
   protected double calculateTotalRentalCost(){
      if(endMileage>startMileage){
         totalRentalCost= (dailyCost*numDays)+calculateAdditionalFee();
         totalRentalCost=totalRentalCost-((totalRentalCost/100)*discount);
         return totalRentalCost;
      }//end if
      else{
         return 0;
      }//end else
   }//end calculatetotalRentalCost()

   //method to populate array with int values representing discount
   protected static void autoUpdateDiscountList(){
      Random r = new Random();
      int MAX = 40;
      // generate random list
      for (int index=0; index<DISCOUNT_ITEMS; index++){
         percentageDiscount[index]= r.nextInt(MAX);
      }//end for

      // display array of discounts
      System.out.print("This is the array of percentage discounts: ");
      String result = Arrays.stream(percentageDiscount).mapToObj(String::valueOf).collect(Collectors.joining(", "));
      System.out.println(result);

      String wait = keyboard.nextLine();
      MainMenu.mainMenu();
   }// end autoUpdateDiscountList()


   //method to perform random selection from discount array
   protected int randomSelection(){
      int pick;
      pick=percentageDiscount[(int)(Math.random()*DISCOUNT_ITEMS)];
      return pick;
   }// end randomSelection

   //abstract method getVehicleType()
   abstract protected String getVehicleType();
   //end getVehicleType

   //toString Method
   public String toString() {
      String message;
      message = String.format("Date of order: %s\n", dateOfOrder);
      message+= "Rental ID: " + rentalID + "\n"+
            "Vehicle Make: " + make + "\n" +
            "Registration Number: " + regNum + "\n" +
            "Rental Duration (Days): " + numDays + "\n";
      if(dailyCost==0){
         message=message+"\n Daily Cost: (not provided)\n";
      }//end if
      else{
         message=message+"\n Daily Cost: £" + df.format(dailyCost) + "\n";
      }//end else
      if(dailyCost*numDays<0){
         message = message+ "Total Cost (before any additional fees): unable to calculate. More information needed\n";
      }//end if
      else{
         message = message+ "Total Cost (before any additional fees): £"+df.format(dailyCost*numDays)+"\n"+
               "Daily Mileage Allowance: " + DAILY_MILES_ALLOWED + " miles\n" +
               "Start Mileage: " + startMileage + " miles\n";
      }//end else
      if(endMileage==0) {
         message=message+"\nEnd Mileage: to be recorded on vehicle return\n";
      }//end if
      else {
         message=message+"End Mileage: "+endMileage+" miles\n";
      }//end else
      if (calculateAverageDailyMiles()<0) {
         message = message+ "Average Daily Miles: to be calculated on vehicle return\n";
      }//end if
      else{
         message = message+"Average Daily Miles: "+df.format(calculateAverageDailyMiles())+" miles\n";
      }//end else
      if(endMileage>startMileage){
         if((calculateAverageDailyMiles()*numDays)-(DAILY_MILES_ALLOWED*numDays)>0){
            message=message+"Additional Miles (over that contracted): " +
                  df.format((calculateAverageDailyMiles()*numDays)-(DAILY_MILES_ALLOWED*numDays))+"\n";
         }//end if
         else{
            message=message+"Additional Miles (over that contracted): 0\n";
         }//end else

      }//end if
      else {
         message = message + "Additional Miles (over that contracted): to be calculated on vehicle return\n";
      }//end else
      if((endMileage>startMileage)){
         if(((calculateAverageDailyMiles() > DAILY_MILES_ALLOWED))){
            message=message+"Extra Fee: £" + df.format(EXTRA_FEE_PER_MILE) +" per mile: £"
                  + df.format(((calculateAverageDailyMiles()*numDays)-(DAILY_MILES_ALLOWED*numDays))
                  *EXTRA_FEE_PER_MILE)+"\n";
         }//end if
         else{
            message=message+ "Extra Fee: £0.20 per mile: £0.00 \n";
         }//end else
      }//end if
      else{
         message=message+"Extra Fee: £" + df.format(EXTRA_FEE_PER_MILE) +" per mile:to be calculated on vehicle return\n";
      }//end else
      message=message+"Discount Percentage applied (selected at random): " + discount +"%\n";
      if(calculateTotalRentalCost()<=0){
         message=message+"\nTotal Cost (after "+discount+" % discount applied): to be calculated on vehicle return\n";
      }//end if
      else{
         message=message+"\nTotal Cost (after "+discount+" % discount applied): £" + df.format(calculateTotalRentalCost());
      }//end else
      return message;
   }//end toString method

   protected static void returnVehicle(int rentalNum){
      int endMiles;
      int requiredNumber=rentalNum, position =0;
      boolean found =false;

      while ((!found)&& (position< VehicleRental.Rentals.size())){
         if ((requiredNumber != VehicleRental.RentalsID.get(position))){
            position++;
         }//end else
         else {
            found=true;
         }//end else

      }//end while

      if (found){
         System.out.println("Please enter end mileage of Rental id: "+ requiredNumber);
         System.out.println("The end mileage must be greater than " + Rentals.get(position).getStartMileage()+" " +
               "(start mileage).");
         endMiles= keyboard.nextInt();
         while(!(endMiles> Rentals.get(position).getStartMileage())){
            System.out.println("Try again.");
            System.out.println("The end mileage must be greater than " + Rentals.get(position).getStartMileage());
            System.out.println("Please enter end mileage of Rental id: "+ requiredNumber);
            endMiles= keyboard.nextInt();
         }//end while
         Rentals.get(position).setEndMileage(endMiles);
         //total rental cost added to total revenue
         totalRevenue=totalRevenue+Rentals.get(position).calculateTotalRentalCost();
      }//end if
      else{
         System.out.println("Rental " + requiredNumber + " not found");
      }//end else

      MainMenu.mainMenu();
   }//end returnVehicle

}//class