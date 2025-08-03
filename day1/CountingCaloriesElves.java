package day1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountingCaloriesElves {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Insert file name as argument.");
            return;
        }

        String fileName = args[0];
        int maxCalories = 0;
        int currentTotal = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    if (currentTotal > maxCalories) {
                        maxCalories = currentTotal;
                    }
                    currentTotal = 0;
                } else {
                    int calories = Integer.parseInt(line);
                    currentTotal += calories;
                }
            }

            if (currentTotal > maxCalories) {
                maxCalories = currentTotal;
            }

            reader.close();

            System.out.println("The elf who carries the most calories has them: " + maxCalories + " calories.");
        } catch (IOException e) {
            System.out.println("Error reading file " + e.getMessage());
        }
    }
}