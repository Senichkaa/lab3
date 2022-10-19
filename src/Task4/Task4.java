package Task4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task4 {
    public static void main(final String[] args) {
        final Thread thread = new Threading();
        thread.start();
        final ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new MultiThreading());
        executorService.execute(new MultiThreading());
        executorService.shutdown();
    }
}
