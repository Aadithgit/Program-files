import java.util.*;
import java.io.*;
public class Binstructured{
	public static void main(String args[]) throws Exception{
		DataInputStream dos = new DataInputStream (new FileInputStream("C:\\Users\\Lenovo\\Downloads\\Binarydata.bin"));
		String line;
		while((line = dos.readLine())!=null){
			String []array = line.split(" ");
			for(String str : array){
				System.out.print((char)Integer.parseInt(str,2));
			}
		
		}
		dos.close();
	}
}