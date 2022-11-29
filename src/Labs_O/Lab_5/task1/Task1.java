package Labs_O.Lab_5.task1;

import java.io.*;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        String filePath = "read.txt";

        try (Scanner file = new Scanner(new BufferedReader(new FileReader(filePath)))) {

            String longestLine = file.nextLine();

            while (file.hasNext()) {
                String newLine = file.nextLine();
                if( newLine.split(" ").length > longestLine.split(" ").length){
                    longestLine = newLine;
                }
            }

            System.out.println("Longest line in this file is: " + longestLine);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
