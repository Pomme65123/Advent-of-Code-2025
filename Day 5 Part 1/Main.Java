import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;



class Main {


    public static int solver () {
        List<long[]> inputRanges = new ArrayList<>();
        int freshCount = 0;
        
        // Parse input until we reach empty line: we can call them inputRanges and inputIDs
        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // If there is a blank line we separate
                if (line.trim() .isEmpty()) {
                    break;
                }

                String[] parts = line.split("-");
                long start = Long.parseLong(parts[0]);
                long end = Long.parseLong(parts[1]);
                inputRanges.add(new long[]{start, end});
            }

            // Starting the IDs
            List<Long> inputIDs = new ArrayList<>();
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    inputIDs.add(Long.parseLong(line));
                }
            }

            // Check ID against the ranges
            for (Long ingredientID : inputIDs) {
                boolean isFresh = false;

                for (long[] range : inputRanges) {
                    long start = range[0];
                    long end = range[1];
                    if (ingredientID >= start && ingredientID <= end) {
                        isFresh = true;
                        break;
                    }
                }

                if (isFresh) freshCount++;
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return 0;
        }
        return freshCount;
    }


    
    public static void main (String[] args) {
        System.out.println(solver());
    }
}