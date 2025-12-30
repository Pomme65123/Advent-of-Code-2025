import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



class Main {


    public static int solver () {

         // Store the inputs in an Array
         List<String> grid = new ArrayList<>();

        // Parse input from input.txt
        File file = new File("input.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                grid.add(scanner.nextLine());
            }

            for (int row = 0; row < grid.size(); row++) {
                String currentRow = grid.get(row);
                for (int col = 0; col < currentRow.length(); col++) {

                    if (currentRow.charAt(col) == '@') {
                        // Start helper function here
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        // Iterate through the Array

        // If a paper rolle is found
            // Count adjacent and diagonal rolls
            // If grid contains '@' increment counter or can use a boolean helper

        return 0;
    }



    public static void main () {
        System.out.println(solver());
    }
}