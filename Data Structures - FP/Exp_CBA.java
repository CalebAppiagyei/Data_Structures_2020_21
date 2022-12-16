
/////////////////////////////////////////////////////
//
// Name: Caleb Appiagyei
//
// Date: 3/16/21
//
// Program: Exp
//
// Description: This program "reverse-engineers
// the EXP.BAS program and translates it from 
// BASIC to Java.
//
/////////////////////////////////////////////////////

// Import your classes
import java.util.Scanner;


public class Exp_CBA
{
   public static void main(String[] args)
   {
   
   // Name your Scanner class
      Scanner input = new Scanner (System.in);
   
   // Create your variables
      double base, expo;
      int ndigits = 1000, carry, temp, sig = ndigits - 1;
      
   // Create your array
      int[] sum = new int[ndigits];  
      sum[0] = 1;
      System.out.println("<><><> Program Exp <><><>");
      System.out.println();
   
   // Prompt the user for the base
      System.out.print("Enter base? ");
      base = input.nextDouble();
   
   // Bounds check the base
      while( base < 0){
         System.out.println("Invalid base!");
         System.out.print("Enter base? ");
         base = input.nextDouble();
      }
   
   // Prompt the user for the exponent
      System.out.print("Enter exponent? ");
      expo = input.nextDouble();
         
   // Bounds check the exponent
      while( expo < 0 ){
         System.out.println("Invalid exponent!");
         System.out.print("Enter exponent?");
         expo = input.nextDouble();
      }
      System.out.println();
      
      if(base == 0 && expo == 0){
         System.out.print("Zero to the power zero is undefined!");
      }
      
      else if(expo > 0 && base == 0){
         System.out.print((int)base + " to the power " + (int)expo + " is: " + (int)base);
      }
      
      else if(base > 0 && expo == 0){
         System.out.print((int)base + " to the power " + (int)expo + " is: 1");
      }
      
      else{
      // Create your loops
         for(int i = 1; i < sum.length; i++){
            sum[i] = 0;
         }  
      
         for (int g = 1; g <= expo; g++){
            carry = 0;
            for (int y = 0; y < sum.length; y++){
               temp = (sum[y] * (int)base) + carry;
               sum[y] = (temp % 10);
               carry = (temp / 10);
            }   
         }
      
         while(sum[sig] == 0){
            sig = sig - 1;
         }
      
         System.out.print((int)base + " to the " + (int)expo + " power is: ");
         for(int h = sig; h >= 0; h--){
            System.out.print(sum[h]);
            if(h > 0 && ((h % 3) == 0)){
               System.out.print(",");
            }
         } 
      }
   }
}