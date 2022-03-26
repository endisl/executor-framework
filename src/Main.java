import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        var service = new FlightService();
        //service.getQuote("site1").thenAccept(System.out::println);
        service.getQuotes()
                .map(future -> future.thenAccept(System.out::println))
                .collect(Collectors.toList());

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
