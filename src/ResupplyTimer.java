import java.util.List;

class ResupplyTimer extends Timer {
    private Logistics logistics;
    private List<Shop> shops;

    public ResupplyTimer(int interval, Logistics logistics, List<Shop> shops) {
        super(interval);
        this.logistics = logistics;
        this.shops = shops;
    }

    @Override
    public void tick() {
        for (Shop shop : shops) {
            if (shop.products >= 10 && shop.products <= 1000) {
                logistics.update(shop, shop.products);
            }
        }
    }
}
