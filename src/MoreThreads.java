import java.util.LinkedList;
import java.util.List;

public class MoreThreads {
    private static final long DELAY = 0;
    private static final long LIMIT = 10;
    public static void count () {
        long counter = 0;
        for (int i=0; i<LIMIT; i++) {
            counter++;
            String myName = Thread.currentThread().getName();
            System.out.printf("Thread (%s): Current counter value is %d\n",myName,counter);
            if (DELAY > 0) {
                try {
                    Thread.sleep(DELAY);
                } catch (InterruptedException ie) {
                    System.out.format("There was an interrupted exception in count() calling sleep()");
                    break;
                }
            }
        }
    }

    static class CountThread extends Thread {
        @Override
        public void run () {
            count();
        }
    }

    public static Runnable count_runnable = new Runnable() {
        public void run () {
            count();
        }
    };

    static class CountRunnable implements Runnable {
        @Override
        public void run () {
            count();
        }
    }
    public static void main(String[] args) {
        System.out.println("Starting threads ...");
        List<Thread> threads = new LinkedList<>();

        // Various ways to create additional threads
        threads.add(new Thread(MoreThreads::count)); // Method reference
        threads.add(new Thread(() -> count()));
        threads.add(new Thread(() -> { count();}));
        threads.add(new Thread(new CountThread()));
        threads.add(new Thread(count_runnable));
        threads.add(new Thread(new CountRunnable()));
        threads.add(new Thread(new Runnable() {
            public void run() {
                count();
            }
        }));

        // Now start all the threads
        for (Thread t : threads) {
            t.start();
        }

        // ... and wait for them to finish
        for (Thread t : threads) {
            try {
                t.join();
            }
            catch (InterruptedException ie) {
                System.out.format("There was an interrupted exception in main() calling join()");
                break;
            }
        }
    }
}