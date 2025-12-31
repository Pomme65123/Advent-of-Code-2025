import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

class Main {

    public static long solver() {
        long totalSum = 0;

        try {
            // Find a way to put the inputs in a 2-D Array
            // Spaces create misalignment
            String[][] data = Files.readAllLines(Paths.get("input.txt"))
                                  .stream()
                                  .map(line -> Arrays.stream(line.split("\\s+"))
                                                     .filter(s -> !s.trim().isEmpty())
                                                     .toArray(String[]::new))
                                  .toArray(String[][]::new);

            int numColumns = data[0].length;
            
            for (int col = 0; col < numColumns; col++) {
                String operator = data[data.length - 1][col];
                
                long result = Long.parseLong(data[0][col]);
                for (int row = 1; row < data.length - 1; row++) {
                    if (operator.equals("*")) {
                        result *= Long.parseLong(data[row][col]);
                    } else {
                        result += Long.parseLong(data[row][col]);
                    }
                }
                
                totalSum += result;
            }

            return totalSum;
            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return 0;
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number: " + e.getMessage());
            return 0;
        }
    }


    
    public static void main(String[] args) {
        System.out.println(solver());
    }
}
