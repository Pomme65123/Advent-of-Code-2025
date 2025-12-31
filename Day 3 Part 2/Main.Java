import java.util.Scanner;
import java.io.File;
import java.io.IOException;



class Main {

    public static long findMaxVoltage(String bank) {
        int n = bank.length();
        int k = 12;
        
        if (n < k) {
            return 0;
        }
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            char current = bank.charAt(i);
            
            while (result.length() > 0 && 
                   result.charAt(result.length() - 1) < current &&
                   result.length() - 1 + (n - i) >= k) {
                result.deleteCharAt(result.length() - 1);
            }
            
            if (result.length() < k) {
                result.append(current);
            }
        }
        
        return Long.parseLong(result.toString());
    }



    public static long solver() {
        // Parse line by line through input.txt

        long totalVoltage = 0;
        File file = new File("input.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String bank = scanner.nextLine();
                long maxVoltage = findMaxVoltage(bank);

                // Add max_voltage to result
                totalVoltage += maxVoltage;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return totalVoltage;
    }


    
    public static void main(String[] args) {
        System.out.println(solver());
    }
}