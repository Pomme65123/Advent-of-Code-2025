import java.util.Scanner;
import java.io.File;
import java.io.IOException;

class Main {
    
    public static void parseInput() {
        File file = new File("input.txt");
        
        try (Scanner scanner = new Scanner(file)) {
            String line = scanner.nextLine();
            String[] ranges = line.split(",");
            
            for (int i = 0; i < ranges.length; i++) {
                String range = ranges[i];
                String[] parts = range.split("-");
                
                if (parts.length == 2) {
                    long start = Long.parseLong(parts[0]);
                    long end = Long.parseLong(parts[1]);
                    long rangeSize = end - start + 1;
                    
                    System.out.println("Range " + (i+1) + ": " + start + " to " + end + " (size: " + rangeSize + ")");
                } else {
                    System.out.println("Invalid range format: " + range);
                }
            }
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }




    // Helper Function if a number is invalid
    public static boolean isInvalidId(long num) {

        // Convert number to string
        String str = String.valueOf(num);
        int strLength = str.length();

        // If odd length: false, if even length: split string in half
        if (strLength % 2 == 1) return false;
        
        String firstHalf = str.substring(0, strLength / 2);
        String secondHalf = str.substring(strLength / 2);

        /*
        System.out.println(firstHalf + " SPLIT " + secondHalf);
        */

        // Checks if strings are equal
        // Apparently "==" compares if they are the same object in memory
        return (firstHalf.equals(secondHalf));
    }


    public static long solver() {

        long result = 0;

        // Parse through input.txt
        
        // Split by delimiters
        
        // Iterate over the ranges and check if it's a valid ID using helper function
        
        // If invalid, add it to result
        
        return 0;
    }

    
    public static void main(String[] args) {
        parseInput();
        System.out.println(isInvalidId(123123));
    }
}