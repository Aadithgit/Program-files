import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Binarycopy {
    public static void main(String[] args) {
        
        String sourceFilePath = "C:\\Users\\Lenovo\\Downloads\\Binarysource.bin";
        String destinationFilePath = "C:\\Users\\Lenovo\\Downloads\\Binarydest.bin";

        try (
            
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFilePath));
            
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFilePath))
        ) {
            
            byte[] buffer = new byte[4096];
            int bytesRead;

            
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            System.out.println("File copy successful!");
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
}
