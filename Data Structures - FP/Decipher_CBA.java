
////////////////////////////////////////////////////////////////////
//
// Name: Caleb Appiagyei
//
// Date: 5/8/21
//
// Program: Cipher1 Decipher
//
// Description: This program will use a cipher text from the user
// and display all 25 possible shifts of that text.
//
////////////////////////////////////////////////////////////////////

// Import your scanner class
import java.util.Scanner;

public class Decipher_CBA 
{
   public static void main(String[] args)
   {
   
   // Name your scanner class
      Scanner input = new Scanner (System.in);
   
   // Create your variables
      String usertxt;
      int counter = 0;
      String temp = " ";
      char asciival = (char)32;
   
      System.out.println("*** Program Decipher ***\n");
   
   // Prompt the user for the ciphertext
      System.out.print("Enter ciphertext: ");
      usertxt = input.nextLine();
      System.out.println();
   
   // Create your arrays
      char[] lwrcase = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz".toCharArray();
      char[] uprcase = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
      
   // Print each type of translated text
      for( int i = 1; i < 26; i++){
         System.out.print( i + ": ");
         for( int g = 0; g < usertxt.length(); g++){
            for( int y = 0; y < 26; y++){
               if(usertxt.charAt(g) == lwrcase[y]){
                  System.out.print(lwrcase[y+i]);
                  counter = 1;
               }
               if(usertxt.charAt(g) == uprcase[y]){
                  System.out.print(uprcase[y+i]);
                  counter = 1;
               }
            } 
            if (counter == 0){
               for( int h = 0; h < 128; h++ ){
                  if( (char)(h) == usertxt.charAt(g) ){
                     System.out.print((char)(h));
                  }
               }  
            } 
            counter = 0;          
         }
         System.out.println();
      }
   }
}
