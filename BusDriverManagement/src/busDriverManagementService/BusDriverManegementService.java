package busDriverManagementService;

import busDriverManagement.BusDriverManagement;
import driver.Driver;
import route.Route;
import route.RouteDetail;

import java.util.*;
import java.util.stream.Collectors;


public class BusDriverManegementService {

    private static  final List<BusDriverManagement> busDriverManegementLists  = new ArrayList<>();

    public static void busDriverManegement (){
        if (DriverService.isEmptyDriver() || RouteService.isEmptyRoute()){
            System.out.println("can thuc hien them lai xe vaf tuyen duong vao truoc khi phan cong lai xe");
            return;
        }
        System.out.println("nhap so luong lai xe muon phan cong : ");
        int readerNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < readerNumber; i++) {
            Driver driver = inputDriverInfo(i);
            List<RouteDetail> routeDetails = inputRouteDetail(driver.getDriver_id());
            BusDriverManagement  busDriverManagement = new BusDriverManagement(driver,routeDetails);
            busDriverManegementLists.add(busDriverManagement);
        }

        showBusDriverManegent(busDriverManegementLists);
    }

    public static int getTotalRoute (int driverId){
        List<RouteDetail> routeDetails = busDriverManegementLists.stream().filter(busDriverManagement -> busDriverManagement.getDriver().getDriver_id() == driverId).map(BusDriverManagement::getRoutes).findAny().orElse(Collections.emptyList());
        return  routeDetails.stream().map(RouteDetail::getNumberOfturn).mapToInt(Integer::intValue).sum();
    }

    private static List<RouteDetail> inputRouteDetail (int driverId){
        RouteService.showRoute();
        List<RouteDetail> routeDetails = new ArrayList<>();
        System.out.println("----- nhap ma tuyen duong va so luong lai xe tren moi tuyen duong do -----");
        System.out.println("so luong tuyen lai xe: ");
        int routes = new Scanner(System.in).nextInt();
        int totalDrive = getTotalRoute(driverId);
        for (int i = 0; i <= routes ; i++) {
            System.out.println("nhap ma tuyen xe thu: " + i);
            int routeId = new Scanner(System.in).nextInt();
            Route route;
            do {
                route = RouteService.findById(routeId);
                if (route == null) {
                    System.out.println("tuyen duong khong ton tai, vui long nhap lai");
                }
            }while (route == null);
            System.out.println("nhap so luong lai xe cho chuyen xe thu: " + i);
            int numberOfRoute;
            do {
                numberOfRoute = new Scanner(System.in).nextInt();
                if (numberOfRoute + totalDrive > 15){
                    System.out.println("ban khong the lai xe qua 15 luot tren 1 ngay");
                    System.out.println("tong so luot ban da lai xe la : " + totalDrive + "vui long nhap lai");

                }else {
                    break;
                }
            }while ((numberOfRoute + totalDrive) < 15);
            routeDetails.add(new RouteDetail(route, numberOfRoute));
        }
        return routeDetails;
    }


    private static Driver inputDriverInfo (int i){
        DriverService.showDriver();
        System.out.println("nhap ma lai xe thu " + (i + 1) + "muon phan cong: ");
        Driver driver;
        do {
            int driverId = new Scanner(System.in).nextInt();
            driver = DriverService.getDrivers().stream().filter(d -> d.getDriver_id() == driverId).findAny().orElse(null);
            if (driver != null){
                break;
            }
            System.out.println("khong tim thay lai xe vua nhap, vui long nhap lai: ");
        }while (true);
        return driver;
    }

    public static  void sort(){
        System.out.println("nhap lua chon cua ban: ");
        System.out.println("1. theo ho ten lai xe. ");
        System.out.println("2. theo so luong tuyen dam nhan trong ngay (giam dan).");
        int choice;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice == 1 || choice == 2){
                break;
            }
            System.out.println("lua chon khong hop le, vui long chon lai: ");
        } while (true);
        if (busDriverManegementLists.isEmpty()){
            System.out.println("chua co du lieu vui long nhap thong tin ");
            return;
        }
        switch (choice){
            case 1:
                busDriverManegementLists.sort(Comparator.comparing(o -> o.getDriver().getName()));
                showBusDriverManegent(busDriverManegementLists);
                break;
            case 2:
                busDriverManegementLists.sort(Comparator.comparing(BusDriverManagement::getTotalDistance).reversed());
                Map<Driver, Double> maps = busDriverManegementLists.stream().collect(Collectors.groupingBy(BusDriverManagement::getDriver, Collectors.summingDouble(value -> value.getRoutes().stream().mapToDouble(value1 -> value.getTotalDistance()).sum())));
                List<BusDriverManegenmentSortByDistance> sorted = new ArrayList<>();
                for (Map.Entry<Driver,Double> entry : maps.entrySet()){
                    sorted.add(new BusDriverManegenmentSortByDistance(entry.getKey().getName(), entry.getValue()));
                }
                sorted.sort(Comparator.comparing(BusDriverManegenmentSortByDistance::getTotalDistance).reversed());
                // print info
                String leftAlignFormat = "| %-15s | %-14f |%n";

                System.out.format("+-----------------+----------------+%n");
                System.out.format("|   Driver Name   | Total Distance |%n");
                System.out.format("+-----------------+----------------+%n");
                sorted.forEach(s -> System.out.format(leftAlignFormat, s.getDriverName(), s.getTotalDistance()));
                break;
        }
    }

    public static void statistic (){
        String leftAlignFormat = "| %-15s | %-14f |%n";

        System.out.format("+-----------------+----------------+%n");
        System.out.format("|   Driver Name   | Total Distance |%n");
        System.out.format("+-----------------+----------------+%n");

        if (!busDriverManegementLists.isEmpty()){
            busDriverManegementLists.forEach(busDriverManagement -> {
                List<RouteDetail> details = busDriverManagement.getRoutes();
                if (!details.isEmpty()){
                    System.out.format(leftAlignFormat, busDriverManagement.getDriver().getName(), busDriverManagement.getTotalDistance());

                } else {
                    System.out.format(leftAlignFormat, busDriverManagement.getDriver().getName(), 0);
                }
            });
            System.out.format("+-----------------+----------------+%n");
        }
    }


    public static void showBusDriverManegent(List<BusDriverManagement> data){
        String leftAlignFormat = "| %-15s | %-14d | %-14d | %-14f |%n";

        System.out.format("+-----------------+----------------+----------------+----------------+%n");
        System.out.format("|   Driver Name   |    Route Id    | Number of Stop | Total Distance |%n");
        System.out.format("+-----------------+----------------+----------------+----------------+%n");
        data.forEach(busDriverManagement -> {
            Driver driver = busDriverManagement.getDriver();
            List<RouteDetail>details = busDriverManagement.getRoutes();
            if (!details.isEmpty()){
                details.forEach(routeDetail -> {
                    Route route = routeDetail.getRoute();
                    System.out.format(leftAlignFormat, driver.getName(), route.getRoute_ID(), route.getNumberOfBusStop(), route.getDistance()* routeDetail.getNumberOfturn());

                });

            }
        });
        System.out.format("+-----------------+----------------+----------------+----------------+%n");
    }
}
