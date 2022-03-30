package Group7;

/**
 * Created by Patrick Donnelly on 22/11/2020
 * Program used for testing the program - instantiating objects of the different classes, using get and set methods to
 * input and change and the toString methods to display details  relating to rental orders
 */
public class TestVehicleRental {
   public static void main(String[] args) {

      HGVRental HGV1 = new HGVRental("HGV");
      HGV1.setStartMileage(1000);
      HGV1.setEndMileage(2000);
      HGV1.setNumDays(7);
      HGV1.setDailyCost(35);

      System.out.println(HGV1);


   }//main
}//class 

