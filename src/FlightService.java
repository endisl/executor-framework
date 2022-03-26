import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class FlightService {
    public CompletableFuture<Quote> getQuote(String site) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting a quote from " + site);

            LongTask.simulate();

            var random = new Random();
            var price = 100 + random.nextInt(10);

            return new Quote(site, price);
        });
    }
}
