import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        var start = LocalTime.now();

        var service = new FlightService();
        //service.getQuote("site1").thenAccept(System.out::println);
        var futures = service.getQuotes()
                .map(future -> future.thenAccept(System.out::println))
                .collect(Collectors.toList());

        CompletableFuture
                .allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    var end = LocalTime.now();
                    var duration = Duration.between(start, end);
                    System.out.println("Retrieved all quotes in " + duration.toMillis() + " msec.");
                });

        //Output:
        /*Getting a quote from site1
          Getting a quote from site2
          Getting a quote from site3
          Quote{site='site3', price=108}
          Quote{site='site1', price=105}
          Quote{site='site2', price=103}
          Retrieved all quotes in 2920 msec.*/


        /*try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //CompletableFuturesClass.show();

        /*var service = new MailService();
        service.sendAsync();
        System.out.println("Hello Ndion");

        ExecutorsClass.show();
        CompletableFuturesClass.show();*/
    }
}
