import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



class Main {



    public static int countAdjacents(char[][] grid, int row, int col) {
        
        // returns the amount of adjacent rolls
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
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
                if (grid[newRow][newCol] == '@') {
                    count++;
                }
            }
        }
        
        return count;
    }



    public static List<int[]> findAccessibleRolls(char[][] grid) {
        List<int[]> accessible = new ArrayList<>();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '@') {
                    int adjacentCount = countAdjacents(grid, row, col);
                    if (adjacentCount < 4) {
                        accessible.add(new int[]{row, col});
                    }
                }
            }
        }
        return accessible;
    }


    
    // Need mutable data array

    // Find accessible rolls (Helper)

    // Have to remove until no more accessible rolls
    public static int solver () {

        int totalRemovedRolls = 0;
        List<String> inputLines = new ArrayList<>();
        File file = new File("input.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                inputLines.add(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return 0;
        }

        int rows = inputLines.size();
        int cols = inputLines.get(0).length();
        char[][] grid = new char[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            grid[i] = inputLines.get(i).toCharArray();
        }

        while (true) {
            List<int[]> accessibleRolls = findAccessibleRolls(grid);
            if (accessibleRolls.isEmpty()) break;

            for (int[] position : accessibleRolls) {
                grid[position[0]][position[1]] = '.';
                totalRemovedRolls++;
            }
        }

        return totalRemovedRolls;
    }



    public static void main (String[] args) {
        System.out.println(solver());
    }
}