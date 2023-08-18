import java.util.Random;

class Market {
    private String name;
    protected int products;
    private int credits; // New attribute to store credits

    public Market(String name) {
        this.name = name;
        this.products = 25;  // Set the initial product count to 25
        this.credits = 0;   // Initialize credits to 0
    }

    public void sell(Logistics logistics) {
        if (products > 0) {
            products--;
            incrementCredits(logistics); // Increment credits for each product sold
        }

        if (products < 10) {
            resupply();
        }
    }

    public void resupply() {
        int resupplyAmount = new Random().nextInt(901) + 200;  // Random resupply amount between 200 and 1100
        int newProducts = products + resupplyAmount;
        products = Math.min(newProducts, 999);
        System.out.println(name + ": Resupplied with " + resupplyAmount + " products.");
    }

    public void incrementCredits(Logistics logistics) {
        credits++;
        logistics.addCredits(1); // Transfer 1 credit to Logistics
    }

    public int getCredits() {
        return credits;
    }

    public void resetCredits() {
        credits = 0;
    }

    @Override
    public String toString() {
        return name;
    }
}