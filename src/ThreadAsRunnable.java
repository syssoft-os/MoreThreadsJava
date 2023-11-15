import java.lang.Runnable;

// java.lang.Runnable:
// public interface Runnable {
//     void run();
// }

class ThreadAsRunnable {
    private static int counter;

    public static void count ( int limit ) {
        for (int i=0; i<limit; i++) {
            counter++;
            System.out.printf("Current counter value is %d\n",counter);
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException ie) {
                break;
            }
        }
    }

    public static Runnable count_to_100 = new Runnable() {
        public void run () {
            count(100);
        }
    };

    static class CounterRunnable implements Runnable {
        @Override
        public void run () {
            count(100);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println("ThreadAsRunnable");
        Thread t1 = new Thread(count_to_100);
        Thread t2 = new Thread(()-> count(100)); // Expression lambda
        Thread t3 = new Thread(()-> { count(100);});
        Thread t4 = new Thread(new CounterRunnable());
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }
}