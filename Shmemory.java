class Message {
    private String content;
    private int order;
    private boolean messageSent = false;

    public synchronized void send(String message, int order) {
        while (messageSent || this.order != order) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.content = message;
        messageSent = true;
        notify();
    }

    public synchronized String receive(int order) {
        while (!messageSent || this.order != order) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String receivedMessage = content;
        messageSent = false;
        this.order++;  // Increment order for the next message
        notify();
        return receivedMessage;
    }
}

class SenderThread extends Thread {
    private Message message;

    public SenderThread(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String[] messages = {"Hello", "How are you?", "Goodbye"};
        for (int i = 0; i < messages.length; i++) {
            message.send(messages[i], i);
            System.out.println("Sent: " + messages[i]);
        }
    }
}

class ReceiverThread extends Thread {
    private Message message;

    public ReceiverThread(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            String receivedMessage = message.receive(i);
            System.out.println("Received: " + receivedMessage);
        }
    }
}

public class Shmemory {
    public static void main(String[] args) {
        Message message = new Message();
        SenderThread senderThread = new SenderThread(message);
        ReceiverThread receiverThread = new ReceiverThread(message);

        senderThread.start();
        receiverThread.start();
    }
}
