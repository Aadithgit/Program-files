class MyRunnable implements Runnable {
   @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread: " + Thread.currentThread().getId() + " - Count: " + i);
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class Inter {
    public static void main(String[] args) {
        
        MyRunnable r= new MyRunnable();
		Thread t1=new Thread(r);

        
        t1.start();
        
    }
}
