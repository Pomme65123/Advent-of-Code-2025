import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



class Main {



    public static int countAdjacents(List<String> grid, int row, int col) {
        
        // returns the amount of adjacent rolls
        int count = 0;
        int rows = grid.size();
        int cols = grid.get(0).length();
        
        // implement 8-directional adjacency check
        // (row-1,col-1), (row-1,col), (row-1,col+1),
        // (row,col-1),                 (row,col+1),
        // (row+1,col-1), (row+1,col), (row+1,col+1)

        int[] deltaRow = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] deltaCol = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int newRow = row + deltaRow[i];
            int newCol = col + deltaCol[i];

            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                if (grid.get(newRow).charAt(newCol) == '@') {
                    count++;
                }
            }
        }
        
        return count;
    }



    public static int solver () {

        int accessibleRolls = 0;

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
                        int adjacentCount = countAdjacents(grid, row, col);
                        if (adjacentCount < 4) {
                            accessibleRolls++;
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return accessibleRolls;
    }



    public static void main () {
        System.out.println(solver());
    }
}