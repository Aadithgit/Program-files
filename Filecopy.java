import java.io.*;
class Filecopy
{
	public static void main(String args[]) throws IOException
	{
		FileInputStream fin = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\File1.txt");
		FileOutputStream fout = new FileOutputStream("C:\\Users\\Lenovo\\Desktop\\File2.txt");
		int i;
		while((i=fin.read())!=-1)
		{
			fout.write((char)i);
		}
		System.out.println("Written Successfully");
	}
}