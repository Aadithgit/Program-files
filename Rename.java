import java.io.*;
import java.util.*;
 class filren
{
	public void renameFile(String source,String dest)
	{
		String src = source;
		String destination = dest;
		File file = new File(src);
		if(file.exists())
		{
			file.renameTo(new File(destination));
			System.out.println("File Renamed Successfully");
		}
		else
		{
			System.out.println("Unable to rename the file");
		}
	}
}
				
		
public class Rename
{
		public static void main(String args[])
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Source file path");
			String sourcepath = sc.nextLine();
			System.out.println("Enter the Destination file path");
			String destinationpath = sc.nextLine();
			filren r = new filren();
			r.renameFile(sourcepath,destinationpath);
		}
}
			