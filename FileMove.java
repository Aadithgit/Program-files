import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileMove {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the Source file path - ");
            String sourcePath = sc.nextLine();
            File file = new File(sourcePath);

            System.out.print("Enter the destination path - ");
            String destinationPath = sc.nextLine();

            if (!file.exists()) {
                throw new FileNotFoundException("Source file not found");
            }
            File destination = new File(destinationPath);
            if (!destination.exists()) {
                throw new Exception("Destination path not found");
            }
            if (file.renameTo(new File(destinationPath+"sample.txt"))) {
                file.delete();  
                System.out.println("File moved successfully");
            } else {
                System.out.println("Failed to move the file");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Source not available");
        }
        catch(Exception e){
            System.err.println("Directory not found");
        
        }
    }
}
