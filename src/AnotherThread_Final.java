public class AnotherThread_Final {
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

    public static void count_to_100 () {
        count(100);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("AnotherThread_Final");
        Thread t = new Thread(AnotherThread_Final::count_to_100);
        t.start();
        t.join();
    }
}