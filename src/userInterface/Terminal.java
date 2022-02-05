package userInterface;

import models.Address;
import models.Package;
import models.ParcelLocker;
import services.PackageManager;
import services.ParcelLockerManager;

import java.util.Scanner;
import java.util.UUID;

import static services.ParcelLockerManager.displayAllPackagesByParcel;

public class Terminal {

    static Scanner sc = new Scanner(System.in);  //dla Int
    static Scanner sc1 = new Scanner(System.in);  //dla String
    static ParcelLockerManager parcelManager = new ParcelLockerManager();
    static PackageManager packageManager = new PackageManager();

    public static void main(String[] args) {
        init();

    }

    static void init() {
        boolean exit = false;

        do {
            printTerminal();
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    removeParcel();
                    break;
                case 3:
                    displayAllParcels();
                    break;
                case 4:
                    displayParcelsByCityName();
                    break;
                case 5:
                    updateParcel();
                    break;
                case 6:
                    addPackage();
                    break;
                case 7:
                    removePackage();
                    break;
                case 8:
                    displayPackages();
                    break;
                case 9:
                    //updatePackage();
                    break;
                case 0:
                    System.out.println("Exiting program. Thank You!");
                    exit = true;
                default:
                    //printTerminal();
            }
        } while (exit == false);
    }


    static void printTerminal() {
        System.out.println(
                " Parcels Manager \n" +
                        " Chose one of fallowing options:\n" +
                        "[1]. Add Parcel Locker\n" +
                        "[2]. Remove parcel Locker\n" +
                        "[3]. Display All Parcels Lockers\n" +
                        "[4]. Display Parcel Locker By City Name\n" +
                        "[5]. Update Parcel Locker\n" +
                        "[6]. Add Package\n" +
                        "[7]. Remove Package\n" +
                        "[8]. Display Package By Parcel Locker\n" +
                        "[9]. Update Package\n" +
                        "[0]. Exit program");
    }

    private static void addParcel() {
        System.out.println("U chose adding parcel method");
        System.out.println("Enter Parcel Locker Name: ");
        String name = sc1.nextLine();
//        System.out.println("Enter Parcel Locker ID");
//        String id = sc.nextLine();
        System.out.println("Enter Parcel Locker City");
        String city = sc1.nextLine();
        System.out.println("Enter Parcel street");
        String street = sc1.nextLine();
        System.out.println("Enter Parcel Postal Code");
        String postalCode = sc1.nextLine();
        Address address = new Address(city, street, postalCode);
        ParcelLocker toAdd = new ParcelLocker(name, address);
        ParcelLockerManager.addParcelLocker(toAdd);
        System.out.println("                                              ");
        System.out.println("Parcel Locker " + name + " successfully added");
        System.out.println("                                              ");

    }

    private static void removeParcel() {
        System.out.println("U choose removing Parcel Locker method");
        System.out.println("Enter ParcelLocker Id to remove");
        UUID id = UUID.fromString(sc1.nextLine());
        ParcelLockerManager.removeParcelLocker(id);
        System.out.println("                                              ");
        System.out.println("Yoy removed ParcelLocker " + id);
        System.out.println("                                              ");


    }

    private static void displayAllParcels() {
        System.out.println("U chose to display ALL Parcel Lockers in use: ");
        System.out.println("                                              ");
        ParcelLockerManager.displayAllParcelsLockers();
        System.out.println("                                              ");
    }

    private static void displayParcelsByCityName() {
        System.out.println("U chose to display Parcel Lockers by the City");
        System.out.println("Write teh City name: ");
        String city = sc1.nextLine();
        System.out.println("List of Parcel Lockers in given City: ");
        System.out.println("                                              ");
        ParcelLockerManager.displayParcelByCity(city);
        System.out.println("                                              ");
    }

    private static void updateParcel() {
        System.out.println("U chose to update Parcel Locker");
        System.out.println("Which Parcel Locker would You like to update");
        System.out.println("Parcel Locker Id: ");
        UUID id = UUID.fromString(sc.nextLine());
        System.out.println("Whats the new name");
        String name = sc1.nextLine();
        System.out.println("Enter Parcel Locker City");
        String city = sc1.nextLine();
        System.out.println("Enter Parcel street");
        String street = sc1.nextLine();
        System.out.println("Enter Parcel Postal Code");
        String postalCode = sc1.nextLine();
        Address address = new Address(city, street, postalCode);
        ParcelLockerManager.updateParcelLocker(id, name, address);
    }

    private static void removePackage() {
        System.out.println("U chose to remove Package from Parcele: ");
        System.out.println("Enter a ID number ");
        UUID id = UUID.fromString(sc.nextLine());
        ParcelLockerManager.removePackageFromParcelLocker(id);
    }

    private static void addPackage() {
        System.out.println("U chose to Add NEW Package to Parcel");
        System.out.println("Enter the PACKAGE name ");
        String name = sc.nextLine();
        System.out.println("Whats size is package(S, M, L, XL) ");
        Package.Size size = Package.Size.valueOf(sc.nextLine());
        System.out.println("What is weight of package, in kgs: ");
        double weight = sc.nextDouble();
        System.out.println("Who is recipient of the package, Name");
        String recipientName = sc1.nextLine();
        System.out.println("Who is sender of the package: Name: ");
        String senderName = sc1.nextLine();
        System.out.println("The Sender Parcel Locker name is: ");
        String senderParcelLocker = String.valueOf(sc1.nextLine());
        System.out.println("The recipient Parcel Locker name is: ");
        String recipientParcelLocker = String.valueOf(sc1.nextLine());
        ParcelLockerManager.addPackageToParcelLocker(name, size, weight, recipientName, senderName, senderParcelLocker, recipientParcelLocker);
    }

    private static void displayPackages() {
        System.out.println("You chose to display Parcel By Parcels Locker");
        UUID id = UUID.fromString(sc.nextLine());
        //String id = sc.nextLine();
        displayAllPackagesByParcel(id);
    }

    private static void updatePackagesInParcelLocker() {

    }
}


