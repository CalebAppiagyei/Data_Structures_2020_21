
////////////////////////////////////////////////////////////////////
//
// Name: Caleb Appiagyei
//
// Date: 5/25/21
//
// Program: Cipher2 Brutus
//
// Description: This program will use a cipher bestext from the user
// and use a dictionary attack to generate plainbestext.
//
////////////////////////////////////////////////////////////////////

// Import your classes
import java.util.Scanner;
import java.io.*;

public class Brutus_CBA 
{
   public static void main(String[] args)
   {
   
   // Name your scanner class
      Scanner input = new Scanner (System.in);
   
   // Create variables and arrays
      String usertxt;
      int counter1 = 0, shiftnum = 1, counter2 = 0;
      String temp = "", bestext = "";
      char asciival = (char)32;
      String[] text = new String[25];
      String[] text2 = new String[25];
      String[] dictionary = readwordFile("wordlist.txt");
      double percent1 = 0, percent2 = 0;
      boolean check;
   
      System.out.println("*** Program Brutus ***\n");
   
   // Prompt the user for the ciphertext
      System.out.print("Enter ciphertext: ");
      usertxt = input.nextLine();
      System.out.println();
      
      // Create each String shift
      char[] lwrcase = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz".toCharArray();
      char[] uprcase = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
      
      for( int i = 1; i < 26; i++){
         for( int g = 0; g < usertxt.length(); g++){
            for( int y = 0; y < 26; y++){
               if(usertxt.charAt(g) == lwrcase[y]){
                  temp = temp + lwrcase[y+i];
                  counter1 = 1;
               }
               if(usertxt.charAt(g) == uprcase[y]){
                  temp = temp + uprcase[y+i];
                  counter1 = 1;
               }
            } 
            if (counter1 == 0){
               for( int h = 0; h < 128; h++ ){
                  if( (char)(h) == usertxt.charAt(g) ){
                     temp = temp + (char)(h);
                  }
               }  
            } 
            counter1 = 0;          
         }
         
         // Assign each shift to a value in the array
         text[i - 1] = temp;
         temp = "";
      
      }
      // Split the string into an array of text ("\\W+" will get it to ignore all extra characters.)
      // Make an array to count the number of words in the text
      String[] wordamount = text[0].split("\\W+");
      
      // Make a 2D array to assign each word to a spot
      String[][] words = new String[25][wordamount.length];
      for( int i = 0; i < 25; i++ ){
         words[i] = text[i].split("\\W+");
      }

      // Calculate which deciphered text most aligns with the dictionary
       for(int x = 0; x < 25; x++){
         for(int y = 0; y < wordamount.length; y++){
             for(int j = 0; j < dictionary.length; j++){
                if(words[x][y].equalsIgnoreCase(dictionary[j])){
                   counter2++;
                }
             }
             }
             percent2 = (double)counter2 / (double)wordamount.length;
             if(percent2 > percent1){
                shiftnum = x + 1;
                bestext = text[x];
                percent1 = percent2;
             }
             counter2 = 0;
          }
      
      // Print results
      System.out.print("Shift = " + shiftnum + " (");
      System.out.printf("%.0f", (percent1*100));
      System.out.print("%): " + bestext);
   }
   // #################################################################################################################
   // readWordFile - Reads space-delimited text from input bestext file, stores them in an array, and returns the array.
   // #################################################################################################################
   public static String[] readwordFile(String inFileName) {
   
   // open input file 
      File file = new File(inFileName);
      Scanner input = null;
      try {
         input = new Scanner(file);
      }
      catch (FileNotFoundException ex) {
         System.out.println();
         System.out.println("File read error, cannot open: " + inFileName);
         System.exit(1); //quit the program
      }
      
      // determine input file size
      int n = 0;
      while (input.hasNext()) {
         input.next();
         n++;
      }
      input.close();
      
      // read text from input file and store them in an array 
      try {
         input = new Scanner(file);
      }
      catch (FileNotFoundException ex) {
         System.out.println("File read error, cannot open: " + inFileName);
         System.exit(1); // quit the program
      }
      String[] wordArray = new String[n];
      for (int i = 0; input.hasNext(); i++)
         wordArray[i] = input.next();
         
      input.close();
      
      // return word array to calling method 
      return wordArray;
      
   } // end readWordFile   
}
