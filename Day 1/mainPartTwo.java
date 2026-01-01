import java.util.Scanner;
import java.io.File;
import java.io.IOException;

class mainPartTwo {

    public static int countZeroCrossings(int start, char direction, int distance) {
        int position = start;
        int zeroCount = 0;
        
        for (int step = 0; step < distance; step++) {
            if (direction == 'R') {
                position = (position + 1) % 100;
            } else {
                position = (position - 1 + 100) % 100;
            }
            
            if (position == 0) {
                zeroCount++;
            }
        }
        
        return zeroCount;
    }

    public static void Solver() {
        File file = new File("input.txt");
        
        int totalZeros = 0;
        int position = 50;

        try (Scanner myReader = new Scanner(file)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                char direction = data.charAt(0);
                int distance = Integer.parseInt(data.substring(1));

                int zeroCrossings = countZeroCrossings(position, direction, distance);
                totalZeros += zeroCrossings;

                if (direction == 'R') {
                    position = (position + distance) % 100;
                } else {
                    position = (position - distance + 100) % 100;
                }

                System.out.println("Position: " + position + "\tDistance: " + distance + 
                                 "\tDirection: " + direction + "\tZero crossings: " + zeroCrossings);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        System.out.println("Total zero crossings: " + totalZeros);
    }



    public static void main(String[] args) {
        Solver();
    }
}
