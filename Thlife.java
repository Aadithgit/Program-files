public class Thlife {
    public static void main(String[] args) {
        
        Thread myThread = new Thread(new MyTask());

        
        System.out.println("Before starting, is thread alive? " + myThread.isAlive());

        
        myThread.start();

        
        System.out.println("After starting, is thread alive? " + myThread.isAlive());

        try {
            
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        
        System.out.println("After completion, is thread alive? " + myThread.isAlive());
    }
}

class MyTask implements Runnable {
    
    public void run() {
        
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " - Count: " + i);
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
