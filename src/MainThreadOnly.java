public class MainThreadOnly {
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

    public static void main(String[] args) {
        System.out.println("MainThreadOnly");
        counter = 0;
        count(100);
    }
}