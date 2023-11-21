import java.io.*;
import java.util.*;
class Fileappend
{
	public void appendtofile(File filename,String content)
	{
		try	
		{
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			System.out.println("File contents before appending");
			while((line = reader.readLine())!=null)
			{
				System.out.println(line);
			}					
				if(filename.exists()){
					FileWriter fw = new FileWriter(filename,true);
					BufferedWriter bw = new BufferedWriter(fw);
					fw.append("\n"+content);
					bw.close();
				}
				else{
					System.out.println("No such file to append");

				}
				
			BufferedReader read = new BufferedReader(new FileReader(filename));
			System.out.println("File contents after appending");
			String newLine;
			while((newLine = read.readLine())!=null)
			{
				System.out.println(newLine);
			}	
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	
	}
}
class Append
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string to be added");
		String str = sc.nextLine();
		System.out.println("Enter the file name");
		String filename = sc.nextLine();
		File file = new File(filename);
		try
		{
				if(!file.exists())
				{
					file.createNewFile();
				}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
				Fileappend obj = new Fileappend();
				obj.appendtofile(file,str);
	}
}