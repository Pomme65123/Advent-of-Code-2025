import java.util.Scanner;
import java.io.File;
import java.io.IOException;



class Main {

    public static int findMaxVoltage (String bank) {
        int maxVoltage = 0;

        // Iterate through the String with pointers such as max_battery
        for (int i = 0; i < bank.length(); i++) {
            for (int j = i + 1; j < bank.length(); j++) {
                int firstDigit = bank.charAt(i) - '0';
                int secondDigit = bank.charAt(j) - '0';
                int voltage = firstDigit * 10 + secondDigit;
                
                if (voltage > maxVoltage) {
                    maxVoltage = voltage;
                }
                
                // 99 is BIS value
                if (voltage == 99) {
                    return 99;
                }
            }
        }

        return maxVoltage;
    }


    public static int solver () {
        // Parse line by line through input.txt

        int totalVoltage = 0;
        File file = new File("input.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String bank = scanner.nextLine();
                int maxVoltage = findMaxVoltage(bank);

                // Add max_battery to result
                totalVoltage += maxVoltage;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return totalVoltage;
    }

    public static void main () {
        System.out.println(solver());
    }
}