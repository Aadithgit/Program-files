public class Priority {
    public static void main(String[] args) {
        Runnable simpleTask1 = new SimpleTask();
        Runnable simpleTask2 = new SimpleTask();
        Runnable simpleTask3 = new SimpleTask();

        Thread thread1 = new Thread(simpleTask1, "Thread 1");
        Thread thread2 = new Thread(simpleTask2, "Thread 2");
        Thread thread3 = new Thread(simpleTask3, "Thread 3");

        
        thread1.setPriority(Thread.MIN_PRIORITY); 
        thread2.setPriority(Thread.NORM_PRIORITY); 
        thread3.setPriority(Thread.MAX_PRIORITY); 

        try {
           
            thread3.start(); 
            thread3.join(); 

            thread2.start(); 
            thread2.join(); 

            thread1.start(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SimpleTask implements Runnable {
   
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " - Count: " + i +
                    " | Priority: " + Thread.currentThread().getPriority());
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
