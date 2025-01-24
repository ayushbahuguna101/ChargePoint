public class Main {
    public static void main(String[] args) {
        List<Truck> trucks = Arrays.asList(
                new Truck(1, 100, 50),
                new Truck(2, 150, 100),
                new Truck(3, 200, 120),
                new Truck(4, 120, 60)
        );
        int availableHours = 4;
        List<Charger> chargers = Arrays.asList(
                new Charger(1, 50, availableHours),
                new Charger(2, 30, availableHours)
        );
        long startTime = System.currentTimeMillis();
        Map<Integer, List<Integer>> schedule = ChargingScheduler.scheduleCharging(trucks, chargers);
        long endTime = System.currentTimeMillis();

        long elapsedTime = endTime - startTime;
        System.out.println("Time taken: " + elapsedTime + " milliseconds");

        for (Map.Entry<Integer, List<Integer>> entry : schedule.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
