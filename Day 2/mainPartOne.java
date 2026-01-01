import java.util.Scanner;
import java.io.File;
import java.io.IOException;

class mainPartOne {

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
        // Apparently "==" compares if they are the same object in memory not if they are same literal
        return (firstHalf.equals(secondHalf));
    }



    public static long solver() {

        long result = 0;

        // Parse through input.txt
        File file = new File("input.txt");

        try (Scanner scanner = new Scanner(file)){
            String line = scanner.nextLine();
            String [] ranges = line.split(",");

            // Split by delimiters
            
            for (int i = 0; i < ranges.length; i++) {
                String range = ranges[i];
                String [] processed_ranges = range.split("-");
                Long start = Long.parseLong(processed_ranges[0]);
                Long end = Long.parseLong(processed_ranges[1]);

                // Iterate over the ranges and check if it's a valid ID using helper function

                for (long num = start; num <= end; num++) {
                    // If invalid, add it to result
                    if (isInvalidId(num)) {
                        result += num;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        return result;
    }



    public static void main(String[] args) {
        System.out.println(solver());
    }
}
