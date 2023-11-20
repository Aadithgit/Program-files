// Java program to illustrate Copying the file
// and deleting the original file
import java.io.*;
import java.util.Scanner;
 class dict{ 

	public static void main(String[] args)
	{
			Scanner sc= new Scanner(System.in);
		try
		{
			System.out.print("Enter the Source file path - ");
			String filePath = sc.nextLine();
			File file = new File(filePath);
		
			System.out.print("Enter the destination path - ");
			String destPath = sc.nextLine();

			if (!file.exists()) {
            			throw new FileNotFoundException("Source file does not exist.");
       			}
			
			if(file.renameTo
			(new File(destPath)))
			{
					file.delete();
					System.out.println("File moved successfully");
			}
			else{
				throw new FileNotFoundException("Directory not found");
			}
		}
		catch(Exception e)
		{
			System.err.println("!!!Error!!!");
		}
		

		
	}
}
