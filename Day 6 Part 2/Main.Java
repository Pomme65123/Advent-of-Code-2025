import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

class Main {

    // Helper function that solves the equations
    private static long solveProblem(char[][] grid, int startCol, int endCol) {

        // Find the '*' or '+' operator
        char operator = ' ';
        for (int col = startCol; col < endCol; col++) {
            char c = grid[grid.length - 1][col];
            if (c == '*' || c == '+') {
                operator = c;
                break;
            }
        }
        
        long result = 0;
        boolean firstNumber = true;
        
        // Columns go from right to left
        // Column forms a number by reading top to bottom
        for (int col = endCol - 1; col >= startCol; col--) {
            StringBuilder numberStr = new StringBuilder();
            for (int row = 0; row < grid.length - 1; row++) {
                char c = grid[row][col];
                if (c != ' ') {
                    numberStr.append(c);
                }
            }
            
            if (numberStr.length() > 0) {
                long number = Long.parseLong(numberStr.toString());
                
                if (firstNumber) {
                    result = number;
                    firstNumber = false;
                } else {
                    if (operator == '*') {
                        result *= number;
                    } else {
                        result += number;
                    }
                }
            }
        }
        return result;
    }



    public static long solver() {
        // inputs from input.txt are int that are read vertically

        long totalSum = 0;

        try {
            var lines = Files.readAllLines(Paths.get("input.txt"));
            int maxLength = lines.stream().mapToInt(String::length).max().orElse(0);
            char[][] grid = new char[lines.size()][maxLength];

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                for (int j = 0; j < maxLength; j++) {
                    grid[i][j] = (j < line.length()) ? line.charAt(j) : ' ';
                }
            }
            

            // If a column is filled with spaces, that's the end of the equation
            boolean[] isSpaceColumn = new boolean[maxLength];
            for (int col = 0; col < maxLength; col++) {
                boolean allSpaces = true;
                for (int row = 0; row < grid.length; row++) {
                    if (grid[row][col] != ' ') {
                        allSpaces = false;
                        break;
                    }
                }
                isSpaceColumn[col] = allSpaces;
            }

            int start = 0;
            while (start < maxLength) {
                while (start < maxLength && isSpaceColumn[start]) start++;

                if (start >= maxLength) break;
                int end = start;

                while (end < maxLength && !isSpaceColumn[end]) end++;

                long problemResult = solveProblem(grid, start, end);
                totalSum += problemResult;
                
                start = end;
            }

            return totalSum;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return 0;
        }
    }



    public static void main(String[] args) {
        System.out.println(solver());
    }
}
