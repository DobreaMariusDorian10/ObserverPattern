class Timer {
    private int interval;

    public Timer(int interval) {
        this.interval = interval;
    }

    public void start() {
        while (true) {
            try {
                Thread.sleep(interval * 1000);
                tick();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void tick() {
        // To be overridden in subclasses
    }
}