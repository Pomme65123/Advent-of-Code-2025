import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;



class mainPartOne {

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



    /// Parse through the input file to find 'S' or the starting position
    public static long solver() {
        try {
            var lines = Files.readAllLines(Paths.get("input.txt"));
            char[][] grid = new char[lines.size()][];
            
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
            
            return simulateBeams(grid, startRow, startCol);
            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return 0;
        }
    }
    


    // Helper Functions
    // From the index of 'S,' traverse the column until a split '^' is found
    // If a split happens, add to the counter
    private static long simulateBeams(char[][] grid, int startRow, int startCol) {
        Queue<Beam> activeBeams = new LinkedList<>();
        Set<String> splitterActivations = new HashSet<>();
        long splitCount = 0;

        activeBeams.add(new Beam(startRow, startCol));

        while (!activeBeams.isEmpty()) {
            Beam beam = activeBeams.poll();

            while (beam.row < grid.length) {
                
                // Beam leaves the grid
                if (beam.col < 0 || beam.col >= grid[beam.row].length) break; 
                if (grid[beam.row][beam.col] == '^') {
                    String splitterKey = beam.row + "," + beam.col;
                    
                    if (!splitterActivations.contains(splitterKey)) {
                        splitterActivations.add(splitterKey);
                        splitCount++;
                        
                        if (beam.col - 1 >= 0) activeBeams.add(new Beam(beam.row + 1, beam.col - 1)); 
                        if (beam.col + 1 < grid[beam.row].length) activeBeams.add(new Beam(beam.row + 1, beam.col + 1));
                    }
                    
                    break;
                }
                beam.row++;
            }
        }
        return splitCount;
    }

    
    public static void main(String[] args) {
        System.out.println(solver());
    }
}
