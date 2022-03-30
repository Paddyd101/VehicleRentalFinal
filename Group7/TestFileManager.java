package Group7;

/**
 * Created by Ali Dore on 21/11/2020
 * Test FileManager Class and methods
 */
public class TestFileManager
{
   public static void main(String[] args)
   {
      // test getAllReceipts with empty file
      FileManager.getAllReceipts();

      // test createFolder
      FileManager.createFolder();

      // test write method
      MPVRental busRentalOrder = new MPVRental("MPV", "Lada", "MNV 153Y", 1000,
            5, 75, 12);
      System.out.println(busRentalOrder.getRentalType());
      FileManager.write(busRentalOrder);

      // test getAllReceipts
      FileManager.getAllReceipts();

      // test read method
      FileManager.read();

   } // main
} // class