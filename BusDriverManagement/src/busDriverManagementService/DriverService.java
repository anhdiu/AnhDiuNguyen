package busDriverManagementService;

import driver.Driver;
import mainBusDriverManagent.Main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DriverService {
    public static List<Driver> driverList = new ArrayList<>();

    public static void inputNewDriver() {

        System.out.println(" xin nhap so luong lai xe ban muon them vao : ");
        int drivernumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < drivernumber; i++) {
            Driver driver = new Driver();
            driver.inputInfo();

            driverList.add(driver);

        }
        showDriver();
    }

    public static void showDriver() {
        // print with format table
        String leftAlignFormat = "| %-9s | %-17s | %-30s | %-11s | %-5s |%n";
        System.out.format("+-----------+-------------------+--------------------------------+-------------+-------+%n");
        System.out.format("| Driver ID |    Driver Name    |             Address            |    Phone    | Level |%n");
        System.out.format("+-----------+-------------------+--------------------------------+-------------+-------+%n");
        driverList.forEach(driver -> {
            System.out.format(leftAlignFormat, driver.getDriver_id(),
                    driver.getName(), driver.getAddress(), driver.getPhoneNumber(), driver.getDriverLevel());
        });
        System.out.format("+-----------+-------------------+--------------------------------+-------------+-------+%n");
    }

    public static  int generateId (){
        if (driverList.isEmpty())
            return 10000;
        return driverList.stream().map(Driver::getDriver_id).max(Comparator.comparing(Integer::valueOf)).get()+1;
    }


    public static boolean isEmptyDriver() {
        return driverList.isEmpty();

    }

    public static List<Driver> getDrivers (){
        return driverList;
    }


}
