import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;



class Main {


    public static long solver () {
        List<long[]> inputRanges = new ArrayList<>();
        
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

            inputRanges.sort(Comparator.comparingLong(range -> range[0]));
            List<long[]> mergedRanges = new ArrayList<>();
            
            for (long[] currentRange : inputRanges) {
                if (mergedRanges.isEmpty()) {
                    mergedRanges.add(currentRange);
                } else {
                    long[] lastMerged = mergedRanges.get(mergedRanges.size() - 1);

                    if (currentRange[0] <= lastMerged[1] + 1) {
                        lastMerged[1] = Math.max(lastMerged[1], currentRange[1]);
                    } else {
                        mergedRanges.add(currentRange);
                    }
                }
            }
            
            long totalFreshCount = 0;
            for (long[] range : mergedRanges) {
                long start = range[0];
                long end = range[1];
                totalFreshCount += (end - start + 1);
            }
            
            return totalFreshCount;
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    
    public static void main(String[] args) {
        System.out.println(solver());
    }
}