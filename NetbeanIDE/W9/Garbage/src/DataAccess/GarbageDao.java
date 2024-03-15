package DataAccess;

import Common.Library;
import model.Truck;
import Common.Validate;

public class GarbageDao {

    private static GarbageDao instance = null;
    private static Validate valid = new Validate();
    private Library l = new Library();

    public static GarbageDao Instance() {
        if (instance == null) {
            synchronized (GarbageDao.class) {
                if (instance == null) {
                    instance = new GarbageDao();
                }
            }
        }
        return instance;
    }

    public void calculateCost(Truck truck) {
        String s = l.getString("Enter the amount of garbage at each station: ");
        String[] garbages = s.split(" ");
        int totalWeight = 0;
        int totalTime = 0;
        double totalCost = 0;
        for (String garbage : garbages) {
            int weight = Integer.parseInt(garbage);
            totalWeight += weight;
            try {
                if (truck.getTotal() + weight <= 10000) {
                    truck.setTotal(truck.getTotal() + weight);
                    truck.setTime(truck.getTime() + 8);
                } else {
                    truck.setTotal(weight);
                    truck.setTime(truck.getTime() + 38);
                    truck.setCost(truck.getCost() + 57000);
                }
            } catch (NumberFormatException e) {
                System.err.println(garbage + " is not a numeric");
            }
        }
        totalTime = truck.getTime() + 30;
        truck.setCost(truck.getCost() + 57000);
        totalCost = ((double) totalTime / 60) * 120000 + (double) truck.getCost();
        System.out.println("Total weight: " + totalWeight);
        System.out.println("Total time: " + totalTime + " minutes");
        System.out.println("The total cost is " + totalCost + " VND");
    }


}
