
//////////////////////////////////////////////////////
//
// Name: Caleb Appiagyei 
//
// Date: 10/19/20
//
// Program: BigO
//
// Description: This Program calculates and
// displays ProgamX's runtimes for various time 
// complexities, and estimates which of those 
// time complexities best characterizes ProgramX
//
//////////////////////////////////////////////////////

  // Import your Scanner class
import java.util.Scanner;

public class BigO_CBA 
{
   public static void main(String[] args)
   {
     
       // Name your Scanner Class
      Scanner input = new Scanner (System.in);
     
       // Create your variables
      double n1, t1, n2, t2, n, constant, linear, log, polynomial2, quasilinear, exponential, polynomial3, tCalc = 0, error = 0, temp = 0, tCalc2;
     
      System.out.println("*** Program BigO ***\n");
      
        // Prompt the user for the values
      System.out.print("Enter n1: ");
      n1 = input.nextDouble();
      System.out.print("Enter t1: ");
      t1 = input.nextDouble();
      System.out.print("Enter n2: ");
      n2 = input.nextDouble();
      System.out.print("Enter t2: ");
      t2 = input.nextDouble();
      
        // Determine the time for each complexity
      linear = t1 * n2 / n1;
      constant = t1; 
      n = n2;
      log = t1 * Math.log(n2) / Math.log(n1);
      polynomial2 = t1 * (n2*n2) / (n1*n1);
      polynomial3 = t1 * (n2*n2*n2) / (n1*n1*n1);
      quasilinear = t1 * (n2*Math.log(n2)) / (n1*Math.log(n1));
      exponential = t1 * (Math.pow(2,n2)) / (Math.pow(2,n1));
      
        // Print the values in Scientific Notation
      System.out.printf("\nn1: %.1E \n",n1);
      System.out.printf("t1: %.1E \n",t1);
      System.out.printf("n2: %.1E \n",n2);
      System.out.printf("t2: %.1E \n",t2);
      
      System.out.println("   n          0(1)     0(log(n))       0(n)    0(nlog(n))       0(n^2)       0(n^3)       0(2^n)");
      System.out.println("------- ---------- ------------- ---------- ------------- ------------ ------------ ------------");
      System.out.printf("%.1E    ",n);
      System.out.printf("%.1E       ",constant);
      System.out.printf("%.1E    ",log);
      System.out.printf("%.1E       ",linear);
      System.out.printf("%.1E      ",quasilinear);
      System.out.printf("%.1E      ",polynomial2);
      System.out.printf("%.1E      ",polynomial3);
      System.out.printf("%.1E    ",exponential);
      
        // Calculate which time complexity has the best fit
      for ( int i = 0; i < 8; i++ ){
         if (i == 0){
            tCalc = linear;  
            if(linear >= t2){
               error = (linear / t2) -1;
            } 
            if( linear < t2){
               error = (t2 / linear) -1;
            }
         }
         if (i == 1){
            tCalc2 = constant; 
            if(constant >= t2){
               temp = (constant / t2) -1;
            } 
            if( constant < t2){
               temp = (t2 / constant) -1;
            }
            if (error > temp){
               tCalc = tCalc2;
               error = temp;
            }  
         }
         if (i == 2){
            tCalc2 = n;   
            if(n >= t2){
               temp = (n / t2) -1;
            } 
            if( n < t2){
               temp = (t2 / n) -1;
            }
            if (error > temp){
               tCalc = tCalc2;
               error = temp;
            }  
         }
         if (i == 3){
            tCalc2 = log; 
            if(log >= t2){
               temp = (log / t2) -1;
            } 
            if( log < t2){
               temp = (t2 / log) -1;
            }
            if (error > temp){
               tCalc = tCalc2;
               error = temp;
            }  
         }
         if (i == 4){
            tCalc2 = polynomial2;   
            if(polynomial2 >= t2){
               temp = (polynomial2 / t2) -1;
            } 
            if( polynomial2 < t2){
               temp = (t2 / polynomial2) -1;
            }
            if (error > temp){
               tCalc = tCalc2;
               error = temp;
            }  
         }
         if (i == 5){
            tCalc2 = polynomial3;  
            if(polynomial3 >= t2){
               temp = (polynomial3 / t2) -1;
            } 
            if( polynomial3 < t2){
               temp = (t2 / polynomial3) -1;
            }
            if (error > temp){
               tCalc = tCalc2;
               error = temp;
            }  
         }
         if (i == 6){
            tCalc2 = quasilinear;  
            if(quasilinear >= t2){
               temp = (quasilinear / t2) -1;
            } 
            if( quasilinear < t2){
               temp = (t2 / quasilinear) -1;
            }
            if (error > temp){
               tCalc = tCalc2;
               error = temp;
            }  
         }
         if (i == 7){
            tCalc2 = exponential;   
            if(exponential >= t2){
               temp = (exponential / t2) -1;
            } 
            if( exponential < t2){
               temp = (t2 / exponential) -1;
            }
            if (error > temp){
               tCalc = tCalc2;
               error = temp;
            }  
         }
      }
        // Print the best fit
      System.out.print("\n\nBest Fit: ");
      if(tCalc == linear) {
         System.out.print("0(n)");
      }
      if(tCalc == constant) {
         System.out.print("0(1)");
      }
      if(tCalc == n) {
         System.out.print("n");
      }
      if(tCalc == log) {
         System.out.print("0(log(n)");
      }
      if(tCalc == polynomial2) {
         System.out.print("0(n^2)");
      }
      if(tCalc == polynomial3) {
         System.out.print("0(n^3)");
      }
      if(tCalc == quasilinear) {
         System.out.print("0(nlog(n))");
      }
      if(tCalc == exponential) {
         System.out.print("0(2^n)");
      }
   }  
}