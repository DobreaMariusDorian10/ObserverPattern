import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Logistics logistics = new Logistics();
        List<Shop> shops = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            shops.add(new Shop("Shop " + i, i % 2 == 0));
        }

        List<Market> markets = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            markets.add(new Market("Market " + i));
        }

        ProductTimer productTimer = new ProductTimer(1, shops, markets, logistics);
        ResupplyTimer resupplyTimer = new ResupplyTimer(5, logistics, shops);

        System.out.println("Starting the simulation...");

        Thread productThread = new Thread(() -> {
            System.out.println("Product timer started.");
            productTimer.start();
        });

        Thread resupplyThread = new Thread(() -> {
            System.out.println("Resupply timer started.");
            resupplyTimer.start();
        });

        // Start the threads
        productThread.start();
        resupplyThread.start();

        // Wait for the threads to complete
        try {
            productThread.join();
            resupplyThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Simulation complete.");
        System.out.println("Total credits: " + logistics.getCredits());
    }
}
