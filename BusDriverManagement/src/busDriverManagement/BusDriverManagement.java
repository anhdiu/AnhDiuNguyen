package busDriverManagement;

import driver.Driver;
import mainBusDriverManagent.Main;
import route.Route;
import route.RouteDetail;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class BusDriverManagement {

    private Driver driver;

    private List<RouteDetail> routes;

    private double totalDistance;

    public BusDriverManagement(Driver driver, List<RouteDetail> routes) {
        this.driver = driver;
        this.routes = routes;
        setTotalDistance();
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<RouteDetail> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RouteDetail> routes) {
        this.routes = routes;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance() {
        if (routes == null || routes.isEmpty()) {
            this.totalDistance = 0;
            return;
        }
        AtomicReference<Double> totalDistance = new AtomicReference<>((double) 0);
        this.routes.forEach(routeDetail -> {

            totalDistance.updateAndGet(v -> v + routeDetail.getRoute().getDistance() * routeDetail.getNumberOfturn());

        });
        this.totalDistance = totalDistance.get();


    }
}
