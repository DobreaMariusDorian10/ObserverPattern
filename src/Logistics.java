class Logistics implements Observer {
    private static final int RESUPPLY_THRESHOLD = 999;
    private int credits;

    public Logistics() {
        this.credits = 0;
    }

    public int getCredits() {
        return credits;
    }

    public void addCredits(int amount) {
        credits += amount;
    }

    public void update(Shop shop, int products) {
        if (products > RESUPPLY_THRESHOLD) {
            System.out.println("Resupply triggered for " + shop);
            shop.resupply();
        }
        addCredits(1); // Increment credits for each update
    }
    public void update(Market market, int products) {
        if (products > RESUPPLY_THRESHOLD) {
            System.out.println("Resupply triggered for " + market);
            market.resupply();
        }
        addCredits(1); // Increment credits for each update
    }
}
