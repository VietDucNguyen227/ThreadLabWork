public class MyThread extends Thread {

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        System.out.println("name of t1: " + t1.getName());
        t1.start();

        t1.setName("MyJavaThread");
        System.out.println("Name of thread after change: " + t1.getName());

    }
    @Override
    public void run() {
        System.out.println("Processing...");
        int index = 1;
        for (int i = 0; i < 20; i++) {
            if(i % 2 == 0){
                System.out.println("MyJavaThread: " +i++);
            }
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}