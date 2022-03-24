import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;

public class CompletableFuturesClass {
    public static void show() {
        Runnable task1 = () -> System.out.println("a");
        var future1 = CompletableFuture.runAsync(task1);

        Supplier<Integer> task2 = () -> 1;
        var future2 = CompletableFuture.supplyAsync(task2);
        try {
            var result = future2.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
