import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/** Demonstrates submitting tasks to a fixed-size thread pool. */
public class ExecutorExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        try {
            for (int taskId = 1; taskId <= 4; taskId++) {
                final int id = taskId;
                executor.submit(() ->
                        System.out.println("Task " + id + " on "
                                + Thread.currentThread().getName()));
            }
        } finally {
            executor.shutdown();
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        }
    }
}
