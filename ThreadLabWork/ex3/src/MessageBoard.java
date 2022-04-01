import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MessageBoard {
    public static void main(String[] args) {
        System.out.println("MESSAGE BOARD");
        System.out.println("=======================");

        Scanner input = new Scanner(System.in);
        System.out.print("Number of messages: ");
        int numberOfMessages = input.nextInt();

        List<Thread> threads = new ArrayList<Thread>();
        for (int index = 0; index < numberOfMessages; index++) {
            System.out.print("Message " + (index + 1) + ": ");
            String messageName = input.next();

            System.out.print("Timeout: ");
            int timeout = input.nextInt();

            System.out.print("Priority: ");
            String priority = input.next();

            MyThread thread = new MyThread(messageName, timeout, priority);
            threads.add(thread);
        }

        for (int index = 0; index < numberOfMessages; index++) {
            threads.get(index).start();
        }
    }
}

class MyThread extends Thread {
    private final String message;
    private final int timeout;
    private final String priority;

    public MyThread(String message, int timeout, String priority) {
        this.message = message;
        this.timeout = timeout;
        this.priority = priority;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(message);
        }
    }
}