import java.io.*;
import java.util.*;
public class Wordcnt {
    public static void main(String args[])
    {
        int count=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the File name");
        String filename = sc.nextLine();
        try {
                   
                BufferedReader reader = new BufferedReader(new FileReader(filename));
                String line;
                while((line=reader.readLine())!=null)
                {
                    String[] words = line.split(" ");

                    
                    count += words.length;
    
                }
                System.out.println(count);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
    
}
