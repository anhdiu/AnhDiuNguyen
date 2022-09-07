package busDriverManagementService;

public class BusDriverManegenmentSortByDistance {

    private String driverName;

    private double totalDistance;

    public BusDriverManegenmentSortByDistance(){}

    public BusDriverManegenmentSortByDistance(String driverName, double totalDistance) {
        this.driverName = driverName;
        this.totalDistance = totalDistance;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getTotalDistance() {
        return totalDistance;
    }
}
