
//////////////////////////////////////////////////
//
// Name: Caleb Appiagyei
//
// Date: 11/15/20
//
// Program: Fibonacci(Fib)
//
// Description: This program caluclates Fn
// iteratively and recursively
//
//////////////////////////////////////////////////

// Import your Scanner class
import java.util.Scanner;

public class Fib_CBA
{
   public static void main(String[] args)
   {
   
   // Name your Scanner Class
      Scanner input = new Scanner (System.in);
      
      System.out.println("*** Program Fib ***\n");
   
   // Create your variables
      int n;
      long temp1 = 0, temp2 = 1, fib = 0;
   
   // Prompt the user for their n value
      System.out.print("Enter n: ");
      n = input.nextInt();
   
   // Calculate the time needed to find fn
      long et = System.nanoTime();
      
   // Baseline Trial
      for(int i = 0; i <= n; i++){
         fib = temp1;
         long fn = temp1 + temp2; 
         temp1 = temp2;
         temp2 = fn;   
      }
          // Print the Baseline results
      et = System.nanoTime() - et;
      System.out.print("\nBaseline: \nfib: " + fib + ", ET: "); 
      System.out.printf("%.2e nsecs",(double)et);
      
      // Iterative Trial
      et = System.nanoTime();     
      long fnI = iterFib(n);  
      
      // Print the Iterative results
      et = System.nanoTime() - et;
      System.out.print("\n\nIterative method: \nfib: " + fnI + ", ET: "); 
      System.out.printf("%.2e nsecs",(double)et);
      
      // Recursive Trial
      et = System.nanoTime();
      
      long fnR = recurFib(n);
      
      // Print the results for the Recursive trial
      et = System.nanoTime() - et;
      System.out.print("\n\nRecursive method: \nfib: " + fnR + ", ET: "); 
      System.out.printf("%.2e nsecs",(double)et);
      
      // Wrapper Trial
      et = System.nanoTime();
      
      long fnO = optFib(n);
      
      // Print wrapper method results
      et = System.nanoTime() - et;
      System.out.print("\n\nShort-circuited method: \nfib: " + fnO + ", ET: "); 
      System.out.printf("%.2e nsecs",(double)et);
   
   }
   // Iterative method
   static long iterFib(int n){
      long t1 = 0, t2 = 1, fibi = 0;
      for(int z = 0; z <= n; z++){
         fibi = t1;
         long iterfn = t1 + t2;
         t1 = t2;
         t2 = iterfn;
      }
      return fibi;
   }
   // Recursive method
   static long recurFib(int n){
      if (n <= 1) 
         return n;
      return recurFib(n-1) + recurFib(n-2);
   }
   // Wrapper method
   static long optFib(int n){
      if( n == 2 )
         return 1;
      return recurFib(n);
   }
}
