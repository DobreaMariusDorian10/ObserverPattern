import java.util.List;

class ProductTimer extends Timer {
    private List<Shop> shops;
    private List<Market> markets;
    private Logistics logistics; // Add Logistics instance

    public ProductTimer(int interval, List<Shop> shops, List<Market> markets, Logistics logistics) {
        super(interval);
        this.shops = shops;
        this.markets = markets;
        this.logistics = logistics; // Initialize the Logistics instance
    }

    @Override
    public void tick() {
        for (Shop shop : shops) {
            shop.sell(logistics); // Pass the Logistics instance
            System.out.println(shop + ": Products left = " + shop.products + ", Total credits = " + logistics.getCredits());
        }
        for (Market market : markets) {
            market.sell(logistics); // Pass the Logistics instance
            System.out.println(market + ": Products left = " + market.products + ", Total credits = " + logistics.getCredits());
        }
    }
}
