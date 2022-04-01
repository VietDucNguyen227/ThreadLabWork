public class App {
    public static void main(String[] args) {
        new MyThread("One");
        new MyThread("Two");
        new MyThread("Three");
        try{

            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            System.out.println("Main Thread interrupted");

        }
        System.out.println("Main thread exiting.");
    }
}
