class EvenThread extends Thread {
    
    public void run() {
        for (int i = 1; i <= 10; i++) {
            if(i%2==0)
			{
				System.out.println("Even Thread: " + i);
				try {
          Thread.sleep(1000); 
	} catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
	
}
}
class OddThread extends Thread {
	public void run()
	{
		for(int i=1;i<=10;i++)
		{
			if(i%2!=0)
			{
				System.out.println("Odd Thread: " + i);
				try {
          Thread.sleep(1000); 
	} catch (InterruptedException e) {
                e.printStackTrace();
            }
			}
		}
		

	}
}


public class Threadex {
    public static void main(String[] args) {
       OddThread oddThread = new OddThread();
	   EvenThread evenThread = new EvenThread();
        evenThread.start();
		        try {
            evenThread.join(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


		oddThread.start();
        
    }
}
