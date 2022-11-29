package Labs_O.Lab_5.task3;

import java.io.*;

public class Task3 {

    public static void main(String[] args) throws IOException {
        char keyChar = 35;

        try (Reader reader = new EncodedReader(new BufferedReader(new FileReader("read.txt")), keyChar);
             Writer writer = new DecodedWriter(new BufferedWriter(new FileWriter("print.txt")), keyChar)) {

            int readedChar;

            while ((readedChar = reader.read()) != -1) {
                writer.write(readedChar);
            }
        }
        catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}

