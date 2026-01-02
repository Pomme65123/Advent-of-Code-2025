import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;



class mainPartTwo {
    
    static class Beam {
        int row, col;

        Beam(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Beam beam = (Beam) obj;
            return row == beam.row && col == beam.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row,col);
        }
    }
    


    public static long solver() {
        try {
            var lines = Files.readAllLines(Paths.get("input.txt"));
            char [][] grid = new char[lines.size()][];

            int startRow = -1, startCol = -1;
            for (int row = 0; row < lines.size(); row++) {
                grid[row] = lines.get(row).toCharArray();
                for (int col = 0; col < grid[row].length; col++) {
                    if (grid[row][col] == 'S') {
                        startRow = row;
                        startCol = col;
                    }
                }
            }
            return 0;
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return 0;
        }
    }



    private static long simulateBeams(char[][] grid, int startRow, int startCol)  {
        // Starting at 'S'
        // Beams will fall vertically until it reaches a '^'
        // When it reaches a '^' it will split into two beams going left and right
        // When the beam splits, a char representing the number will be placed in the cell
        // If two splits overlap, the number will be the sum of the splits
        // Sum all the numbers in the final row
        return 0;
    }



    public static void main(String[] args) {
        System.out.println(solver());
    }

}