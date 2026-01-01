import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class mainPartOne {

    /// Parse through the input file to find 'S' or the starting position
    public static int[] findS(String filePath) {
        try {
            var lines = Files.readAllLines(Paths.get(filePath));
            char[][] grid = new char[lines.size()][];

            for (int i = 0; i < lines.size(); i++) {
                grid[i] = lines.get(i).toCharArray();
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 'S') {
                        int startRow = i;
                        int startCol = j;
                        return new int[]{startRow, startCol};
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return new int[]{-1, -1};
    }



    public static int solver() {

        int[] start = findS("input.txt");

        // From the index of 'S,' traverse the column until a split '^' is found
        
        // If a split happens then add to the counter
        
        return 0;
    }

    public static void main(String[] args) {
        int[] test = findS("input.txt");
        System.out.println(test[0] + ", " + test[1]);
    }
}