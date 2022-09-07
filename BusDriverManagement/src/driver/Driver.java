package driver;

import busDriverManagementService.DriverService;
import interFace.InputTable;

import java.util.Scanner;

public class Driver implements InputTable {

    private int driver_id;

    private String name;

    private String address;

    private int phoneNumber;

    private DriverLevel driverLevel;

    public Driver (){};

    public Driver(int driver_id, String name, String address, int phoneNumber, DriverLevel driverLevel) {
        this.driver_id = driver_id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.driverLevel = driverLevel;
    }


    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public DriverLevel getDriverLevel() {
        return driverLevel;
    }

    public void setDriverLevel(DriverLevel driverLevel) {
        this.driverLevel = driverLevel;
    }

    @Override
    public void inputInfo() {
        this.setDriver_id(DriverService.generateId());
        System.out.println(" xin nhap ho va ten lai xe : ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println(" xin moi nhap va dia chi cua lai xe : ");
        this.address = new Scanner(System.in).nextLine();
        System.out.println(" xin moi nhap so dien thoai cua lai xe : ");
        this.phoneNumber = new Scanner(System.in).nextInt();
        System.out.println(" xin hay nhap vao trinh do lai xe : ");
        this.showDriverLever();
    }
    public void showDriverLever(){
        System.out.println("1. bang lai xe loai A");
        System.out.println("2. bang lai xe loai B");
        System.out.println("3. bang lai xe loai C");
        System.out.println("4. bang lai xe loai D");
        System.out.println("5. bang lai xe loai E");
        System.out.println("6. bang lai xe loai F");
        int choiceDriverlevel = 0;
        do {
            choiceDriverlevel = new Scanner(System.in).nextInt();
            if (choiceDriverlevel >= 1 && choiceDriverlevel <= 6){
                break;
            } else {
                System.out.println(" lua chon khong hop le vui long chon lai");
            }
        }while (true);
        switch (choiceDriverlevel){
            case 1:
                this.setDriverLevel(DriverLevel.A);
                break;
            case 2:
                this.setDriverLevel(DriverLevel.B);
                break;
            case 3:
                this.setDriverLevel(DriverLevel.C);
                break;
            case 4:
                this.setDriverLevel(DriverLevel.D);
                break;
            case 5:
                this.setDriverLevel(DriverLevel.E);
                break;
            case 6:
                this.setDriverLevel(DriverLevel.F);
                break;
        }



    }

    @Override
    public String toString() {
        return "Driver{" +
                "driver_id=" + driver_id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", driverLevel=" + driverLevel +
                '}';
    }


}
