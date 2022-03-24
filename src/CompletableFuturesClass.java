import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFuturesClass {

    /*public static CompletableFuture<String> getUserEmailAsync() {
        return CompletableFuture.supplyAsync(() -> "email");
    }

    public static CompletableFuture<String> getPlaylistAsync(String email) {
        return CompletableFuture.supplyAsync(() -> "playlist");
    }*/

    /*public static int toFahrenheit(int celsius) {
        return (int) (celsius * 1.8) + 32;
    }*/

    public static void show() {
        var first = CompletableFuture.supplyAsync(() -> 1);
        var second = CompletableFuture.supplyAsync(() -> 2);
        var third = CompletableFuture.supplyAsync(() -> 3);

        var all = CompletableFuture.allOf(first, second, third);
        all.thenRun(() -> {
            try {
                var firstResult = first.get();
                System.out.println(firstResult);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("All tasks completed successfully");
        });


        /*var first = CompletableFuture
                .supplyAsync(() -> "20USD")
                .thenApply(str-> {
                    var price = str.replace("USD", "");
                    return Integer.parseInt(price);
                });
        var second = CompletableFuture.supplyAsync(() -> 0.9);

        first
           .thenCombine(second, (price, exchangeRate) -> price * exchangeRate)
           .thenAccept(result -> System.out.println(result));*/

        /*getUserEmailAsync()
          .thenCompose(CompletableFuturesClass::getPlaylistAsync)
          .thenAccept(playlist -> System.out.println(playlist));*/


        /*var future = CompletableFuture.supplyAsync(() -> 20);
        future
                .thenApply(CompletableFuturesClass::toFahrenheit)
                .thenAccept(f -> System.out.println(f));*/

        /*var future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting the current weather");
            throw new IllegalStateException();
        });

        try {
            var temperature = future.exceptionally(ex -> 1).get();
            System.out.println(temperature);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/

        /*var future = CompletableFuture.supplyAsync(() -> 1);
        future.thenRun(() -> System.out.println("Done"));
        future.thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Done");
        });
        future.thenAccept(result -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(result);
        });*/

        /*Runnable task1 = () -> System.out.println("a");
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
        }*/
    }
}
