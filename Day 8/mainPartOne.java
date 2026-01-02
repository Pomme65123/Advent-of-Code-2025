import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;



public class mainPartOne {

    static class Coordinates {
        int x, y, z;

        Coordinates(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
        
        @Override
        public String toString() {
            return "(" + x + "," + y + "," + z + ")";
        }
    }
    
    public static void solver() {
        try {
            var lines = Files.readAllLines(Paths.get("input.txt"));
            ArrayList<Coordinates> coordinates = new ArrayList<>();
            
            for (var line : lines) {
                String[] parts = line.split(",");
                
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                int z = Integer.parseInt(parts[2]);
                
                Coordinates inputCoordinates = new Coordinates(x, y, z);
                coordinates.add(inputCoordinates);
                
                System.out.println("Coordinates: " + inputCoordinates);
            }
            
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    

    public static void main (String[] args) {
        solver();
    }
}
