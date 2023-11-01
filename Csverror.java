import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Csverror {
    public static void main(String[] args) {
        String csvFile = "non_existent_file.csv"; 

        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            String line;

            while ((line = br.readLine()) != null) {
                
                System.out.println(line);
            }

            br.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the CSV file.");
        }
    }
}
