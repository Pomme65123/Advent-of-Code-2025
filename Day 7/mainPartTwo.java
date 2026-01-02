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
            
            return simulateBeams(grid, startRow, startCol);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return 0;
        }
    }



    private static long simulateBeams(char[][] grid, int startRow, int startCol)  {
        // Instead of working with char[][] grid, we can use a hashmap
        Map<Beam, Long> beamCounts = new HashMap<>();

        // Starting at 'S'
        beamCounts.put(new Beam(startRow, startCol), 1L);

        // Beams will fall vertically until it reaches a '^'
        for (int row = startRow; row < grid.length - 1; row++) {
            Map<Beam, Long> nextRowCounts = new HashMap<>();

            for (Map.Entry<Beam, Long> entry : beamCounts.entrySet()) {
                Beam beam = entry.getKey();
                Long count = entry.getValue();

                if (beam.row != row) continue;
                
                char currentCell = grid[beam.row][beam.col];
                
                if (currentCell == '^') {
                    // When it reaches a '^' it will split into two beams going left and right
                    if (beam.col - 1 >= 0 && beam.col - 1 < grid[row + 1].length) {
                        Beam leftBeam = new Beam(row + 1, beam.col - 1);
                        nextRowCounts.merge(leftBeam, count, Long::sum);
                    }

                    if (beam.col + 1 >= 0 && beam.col + 1 < grid[row + 1].length) {
                        Beam rightBeam = new Beam(row + 1, beam.col + 1);
                        nextRowCounts.merge(rightBeam, count, Long::sum);
                    }
                } else {

                    // If no '^', beam goes downwards
                    if (beam.col >= 0 && beam.col < grid[row + 1].length) {
                        Beam straightBeam = new Beam(row + 1, beam.col);
                        nextRowCounts.merge(straightBeam, count, Long::sum);
                    }
                }
            }

            for (Map.Entry<Beam, Long> entry : nextRowCounts.entrySet()) {
                beamCounts.put(entry.getKey(), entry.getValue());
            }
        }

        // Sum all the numbers in the final row
        long totalBeams = 0;
        int finalRow = grid.length - 1;
        for (Map.Entry<Beam, Long> entry : beamCounts.entrySet()) {
            if (entry.getKey().row == finalRow) {
                totalBeams += entry.getValue();
            }
        }

        // for (Map.Entry<Beam, Long> entry : beamCounts.entrySet()) {
        //     System.out.println("Beam at (" + entry.getKey().row + ", " + entry.getKey().col + "): " + entry.getValue());
        // }
        
        return totalBeams;
    }



    public static void main(String[] args) {
        System.out.println(solver());
    }

}