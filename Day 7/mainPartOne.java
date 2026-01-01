import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class mainPartOne {

    private static List<String> lines;
    private static char[][] grid;



    // Need to track the beams
    static class Beam {
        int row, col;

        Beam(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }



    /// Parse through the input file to find 'S' or the starting position
    public static int[] findS(String filePath) {
        try {
            lines = Files.readAllLines(Paths.get(filePath));
            grid = new char[lines.size()][];

            for (int row = 0; row < lines.size(); row++) {
                grid[row] = lines.get(row).toCharArray();
                for (int col = 0; col < grid[row].length; col++) {
                    if (grid[row][col] == 'S') {
                        int startRow = row;
                        int startCol = col;
                        return new int[]{startRow, startCol};
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return new int[]{-1, -1};
    }


    // Helper Function
    // From the index of 'S,' traverse the column until a split '^' is found
    // If a split happens then add to the counter
    private static int simulateBeams(int startRow, int startCol) {
        
        Queue<Beam> activeBeams = new LinkedList<>();
        Set<String> splitterActivated = new HashSet<>();
        int splitCount = 0;
        
        return 0;
    }



    public static int solver() {

        int[] start = findS("input.txt");

        
        return 0;
    }



    public static void main(String[] args) {
        int[] test = findS("input.txt");
        System.out.println(test[0] + ", " + test[1]);
    }
}