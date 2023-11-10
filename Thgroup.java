class Thread1 extends Thread {
    private ThreadGroup threadGroup; // Store ThreadGroup information

    public Thread1(ThreadGroup tg, String tname) {
        super(tg, tname);
        this.threadGroup = tg; // Save ThreadGroup information
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Trouble Shooting ");
        }
        // Access the ThreadGroup information here
        System.out.println("Details of current Thread\n" +
                "Thread Name: " + this.getName() + "\nThreadGroup :" + threadGroup.getName());
    }
}

class Thread2 extends Thread {
    private ThreadGroup threadGroup; // Store ThreadGroup information

    public Thread2(ThreadGroup tg, String tname) {
        super(tg, tname);
        this.threadGroup = tg; // Save ThreadGroup information
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Performing a task ");
        }
        // Access the ThreadGroup information here
        System.out.println("Details of current Thread\n" +
                "Thread Name: " + this.getName() + "\nThreadGroup :" + threadGroup.getName());
    }
}

public class Thgroup {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("FreshersGroup");
        Thread1 user1 = new Thread1(threadGroup, "Aadith");
        Thread2 user2 = new Thread2(threadGroup, "Karthik");

        // Start the threads
        user1.start();
        user2.start();

        // Wait for threads to finish (optional)
        try {
            user1.join();
            user2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
