
import java.util.Scanner;

public class Evenodd
{
     public static void main(String []args)
     {
         Scanner sc=new Scanner(System.in);
         int n;     
         System.out.println("Enter the size of the array");
         n=sc.nextInt();   
         
         int arr[]=new int[n];   
        System.out.println("Enter the array");  
        for(int i=0;i<n;i++)     
        {
            arr[i]=sc.nextInt();
        }
        
        int even=0,odd=0;    
        for(int i=0;i<n;i++)   
        {
            if(arr[i]%2==0)
             even++;    
             else 
             odd++;
		}
		int e[]=new int[even];
		int o[]=new int[odd];
        int j=0,k=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]%2==0)
            {
              e[j]=arr[i];   
              j++;
            }
            else
            {
                o[k]=arr[i];  
                k++;
            }
        }
        
        System.out.println("The array with even elements...");
        for(int i=0;i<even;i++)
        {
            System.out.print(e[i]+" ");  
        }
        System.out.println("");
        System.out.println("The array with odd elements...");
        for(int i=0;i<odd;i++)
        {
            System.out.print(o[i]+" ");    
        }
        
    }
}