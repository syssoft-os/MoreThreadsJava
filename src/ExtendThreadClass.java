public class ExtendThreadClass {
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

    static class CountThread extends Thread {
        @Override
        public void run () {
            count(100);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println("ExtendThreadClass");
        Thread t = new CountThread();
        t.start();
        t.join();
    }
}