package busDriverManagementService;

import route.Route;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class RouteService {

    public  static List<Route> routeList = new ArrayList<>();

    public static  void  inputNewRoute (){

        System.out.println(" xin moi nhap cac tuyen duong ban muon them : ");

        int routeNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < routeNumber; i++) {
            Route route = new Route();
            route.inputInfo();
            routeList.add(route);
        }

        showRoute();
    }

    public  static  void  showRoute (){
        String leftAlignFormat = "| %-9d | %-17f | %-18d |%n";

        System.out.format("+-----------+-------------------+--------------------+%n");
        System.out.format("| Route ID  |    Distance       |   Number Of Stops  |%n");
        System.out.format("+-----------+-------------------+--------------------+%n");
        routeList.forEach(route -> {
            System.out.format(leftAlignFormat, route.getRoute_ID(),
                    route.getDistance(), route.getNumberOfBusStop());
        });
        System.out.format("+-----------+-------------------+--------------------+%n");
    }
    public static boolean isEmptyRoute (){
      return routeList.isEmpty();
    }

    public static List<Route> getRouteList(){
        return routeList;
    }

    public static Route findById (int routeId){
        return routeList.stream().filter(route -> route.getRoute_ID() == routeId).findAny().orElse(null);
    }

    public static int generateId (){
        if (routeList.isEmpty())
            return 10000;
        return routeList.stream().map(Route::getRoute_ID).max(Comparator.comparing(Integer::valueOf)).get() + 1;
    }
}
