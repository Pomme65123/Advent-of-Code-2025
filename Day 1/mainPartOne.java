import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;


class mainPartOne {

    public static void Solver() {
        File file = new File("input.txt");

        int zeros = 0;
        int position = 50;

        try (Scanner myReader = new Scanner(file)) {
            while (myReader.hasNextLine()) {
                
                String data = myReader.nextLine();
                char direction = data.charAt(0);
                int distance = Integer.parseInt(data.substring(1));

                if (direction == 'R') {
                    position += distance;
                } else {
                    position -= distance;
                }

                position = ((position % 100) + 100) % 100;
                if (position == 0) zeros++;

                System.out.println("Position: " + position + "\tDistance: " + distance + "\tDirection: " + direction);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(zeros);
    }



    public static void main(String[] args) {
        Solver();
    }
}
