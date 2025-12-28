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
    
    public static void main(String[] args) {
        parseInput();
    }
}