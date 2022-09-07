package route;

public class RouteDetail {

    private Route route;

    private int numberOfturn;

    public RouteDetail(Route route, int numberOfturn) {
        this.route = route;
        this.numberOfturn = numberOfturn;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public int getNumberOfturn() {
        return numberOfturn;
    }

    public void setNumberOfturn(int numberOfturn) {
        this.numberOfturn = numberOfturn;
    }

    @Override
    public String toString() {
        return "RouteDetail{" +
                "route=" + route +
                ", numberOfturn=" + numberOfturn +
                '}';
    }
}
