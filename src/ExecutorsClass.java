import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsClass {

    public static void show() {
        var executor = Executors.newFixedThreadPool(2);

        try {
            executor.submit(() -> System.out.println(Thread.currentThread().getName()));
        }
        finally {
            executor.shutdown();
        }
    }
}
