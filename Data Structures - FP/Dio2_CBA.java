///////////////////////////////////////////////////
//
// Name: Caleb Appiagyei
//
// Date: 10/11/20
//
// Program: Dio2
//
// Description: This program finds the solutions
// to a cubic Diophantine equation faster than it 
// did in dio
//
///////////////////////////////////////////////////

  // Insert your Scanner class
import java.util.Scanner;

public class Dio2_CBA 
{
   public static void main (String[] args)
   {
    
         // Create your variables
      int counter = 0, ans, not = 1, x2 = 0, y2 = 0, z2 = 0;
   
      Scanner input = new Scanner(System.in);
      
      // Prompt the user for a range and span
      System.out.print("Enter range for k: ");
      int k = input.nextInt();
      System.out.print("Enter span for x, y, z: ");
      int span = input.nextInt();
   
      long et = System.nanoTime();
   
        // Check the equation
      for (int i = 0; i <= k; i++) {
         if ( not > 0 && i >= 0 ){
            System.out.println ("k: " + i + ", x: " + x2 + ", y: " + y2 + ", z: " + z2);
            counter++;
         }
         else if (i > 0) { 
            System.out.println("k: " + i + " Not found!");
         }
         not = 0;
         for ( int x = 0 - span; x <= span; x++){
            for ( int y = 0 - span; y < span; y++){
               for ( int z = 0 - span; z < span; z++){
                  ans = ((x*x*x) + (y*y*y) + (z*z*z))-1;
                  if ( ans == i ){
                     not = not + 1;
                     x2 = x;
                     y2 = y;
                     z2 = z;  
                  } 
               }
            } 
         }
      }
      et = System.nanoTime() - et;
      System.out.println("\nn: " + counter);
      System.out.printf("Elapsed time for algorithm: %.3e nsecs",(double)et);
   }
}