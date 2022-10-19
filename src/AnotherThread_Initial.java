public class AnotherThread_Initial {
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

    public static void main(String[] args) {
        System.out.println("AnotherThread_Initial");
        Thread t = new Thread(AnotherThread_Initial::count_to_100);
        t.start();
    }
}