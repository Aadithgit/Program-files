public class Interupt {
    public static void main(String[] args) {
        LongRunningThread longRunningThread = new LongRunningThread();

        longRunningThread.start();
	         
        longRunningThread.interrupt();
    }
}

class LongRunningThread extends Thread {
   
    public void run() {
        for (int i = 1; i <= 10; i++) {
            if (isInterrupted()) {
                System.out.println("Thread interrupted. Exiting.");
                return;
            }
            System.out.println("Task step " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted. Exiting.");
                return;
            }
        }
    }
}
