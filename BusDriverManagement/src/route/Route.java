package route;

import busDriverManagementService.RouteService;
import interFace.InputTable;

import java.util.Scanner;

public class Route implements InputTable {



    private  int route_ID;

    private  int distance;

    private int numberOfBusStop;
    public  Route ( ) {};

    public Route(int route_ID, int distance, int numberOfBusStop) {
        this.route_ID = route_ID;
        this.distance = distance;
        this.numberOfBusStop = numberOfBusStop;
    }



    public int getRoute_ID() {
        return route_ID;
    }

    public void setRoute_ID(int route_ID) {
        this.route_ID = route_ID;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getNumberOfBusStop() {
        return numberOfBusStop;
    }

    public void setNumberOfBusStop(int numberOfBusStop) {
        this.numberOfBusStop = numberOfBusStop;
    }

    @Override
    public void inputInfo() {
        this.setRoute_ID(RouteService.generateId());
        System.out.println(" xin moi nhap khoang cach di chuyen ");
        this.distance = new Scanner(System.in).nextInt();
        System.out.println(" xin moi nhap so diem dung ");
        this.numberOfBusStop = new Scanner(System.in).nextInt();

    }

    @Override
    public String toString() {
        return "Route{" +
                "route_ID=" + route_ID +
                ", distance=" + distance +
                ", numberOfBusStop=" + numberOfBusStop +
                '}';
    }

}
