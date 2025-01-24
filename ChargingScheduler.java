public class ChargingScheduler {
    public static Map<Integer, List<Integer>> scheduleCharging(List<Truck> trucks, List<Charger> chargers) {
        Map<Integer, List<Integer>> schedule = new HashMap<>();

        for (Charger charger : chargers) {
            schedule.put(charger.id, new ArrayList<>());
        }

        // Sorting trucks by the required charge in ascending order
        trucks.sort(Comparator.comparingInt(t -> t.requiredCharge));

        // Sorting chargers by charging rate in descending order
        chargers.sort((c1, c2) -> Integer.compare(c2.chargingRate, c1.chargingRate));

        for (Truck truck : trucks) {
            boolean scheduled = false;

            for (Charger charger : chargers) {
                int requiredTime = (int) Math.ceil((double) truck.requiredCharge / charger.chargingRate);

                if (requiredTime <= charger.availableHours) {
                    schedule.get(charger.id).add(truck.id);
                    charger.availableHours -= requiredTime;
                    scheduled = true;
                    break;
                }
            }

            if (!scheduled) {
                break; // If a truck cannot be scheduled, that means chargers will be fully occupied now, hence quit!
            }
        }

        return schedule;
    }
}
