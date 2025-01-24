class Truck {
    int id;
    int batteryCapacity;
    int currentCharge;
    int requiredCharge;

    public Truck(int id, int batteryCapacity, int currentCharge) {
        this.id = id;
        this.batteryCapacity = batteryCapacity;
        this.currentCharge = currentCharge;
        this.requiredCharge = batteryCapacity - currentCharge;
    }
}
