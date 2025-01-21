package BaseTest;
import java.io.*;
import java.util.*;


public class JavaPractice {



        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in); // Use Scanner to read input from STDIN
            int lineNumber = 1;

            // Read input line by line until EOF
            while (sc.hasNextLine()) {
                String line = sc.nextLine(); // Read each line of input
                System.out.println(lineNumber + " " + line); // Print line number and content
                lineNumber++; // Increment line number
            }

            sc.close(); // Close the scanner
        }
    }


