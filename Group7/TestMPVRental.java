package Group7;

/**
 * Created by Ali Dore on 21/11/2020
 * Test MPVRental class and methods
 */
public class TestMPVRental
{
   public static void main(String[] args)
   {
      MPVRental testBus = new MPVRental("MPV", "Lada", "MNV 153Y", 1000,
            5, 75, 12);
      // Test output equals input
      System.out.println(testBus);
      // Pass

      // Test getDate methods
      System.out.println(testBus.getDateOfOrderID());
      System.out.println(testBus.getDateID());
      // Pass

      // Test other get and set methods
      testBus.setSeats(20);
      System.out.println(testBus.getSeats());

      testBus.setEndMileage(2000);
      System.out.println(testBus.getEndMileage());

      testBus.setDailyCost(100);
      System.out.println(testBus.getDailyCost());

      testBus.setMake("Ubuntu");
      System.out.println(testBus.getMake());

      testBus.setNumDays(2);
      System.out.println(testBus.getNumDays());

      testBus.setRegNum("MY N3WC4R");
      System.out.println(testBus.getRegNum());

      testBus.setStartMileage(50);
      System.out.println(testBus.getStartMileage());

      System.out.println(testBus);
      //pass

      System.out.println("Start of pause test");
      // Test pause class
      Pause.pause(1);
      System.out.println("1 second");
      Pause.pause(0);
      System.out.println("0 seconds");
      Pause.pause(5);
      System.out.println("5 seconds");

   } // main
} // class