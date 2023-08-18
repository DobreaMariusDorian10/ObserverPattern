import java.util.Random;

class Shop {
    private String name;
    private boolean isPerishable;
    protected int products;
    private int credits; // New attribute to store credits

    public Shop(String name, boolean isPerishable) {
        this.name = name;
        this.isPerishable = isPerishable;
        this.products = new Random().nextInt(991) + 10;
        this.credits = 0; // Initialize credits to 0
    }

    public void sell(Logistics logistics) {
        if (products > 0) {
            products--;
            incrementCredits(logistics); // Increment credits for each product sold
        }
    }

    public void resupply() {
        int newProducts = products + new Random().nextInt(901) + 200;
        products = Math.min(newProducts, 999);
    }

    public void expirePerishable() {
        if (isPerishable && products > 0) {
            products--;
            System.out.println(name + ": Perishable product expired.");
        }
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