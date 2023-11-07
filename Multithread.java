class MyThread extends Thread {
    
    public void run() {
        System.out.println("This is thread 1");
    }
}

class AnotherThread extends Thread {
    
    public void run() {
        System.out.println("This is thread 2");
    }
}

public class Multithread {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        AnotherThread thread2 = new AnotherThread();

        thread1.start();
        thread2.start();
    }
}
