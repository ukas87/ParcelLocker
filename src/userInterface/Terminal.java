package userInterface;

import models.Address;
import models.Package;
import models.ParcelLocker;
import services.ParcelLockerManager;
import services.Validation;

import java.util.Scanner;
import java.util.UUID;

import static services.ParcelLockerManager.displayAllPackagesByParcel;

public class Terminal {

    static Scanner sc = new Scanner(System.in);  //dla Int
    static Scanner sc1 = new Scanner(System.in);  //dla String
   // static ParcelLockerManager parcelManager = new ParcelLockerManager();
   // static PackageManager packageManager = new PackageManager();

    public static void main(String[] args) {

        start();

    }

    static public void start() {
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
                    updatePackage();
                    break;
                case 0:
                    System.out.println("Exiting program. Thank You!");
                    exit = true;
                default:
                    //printTerminal();
            }
        } while (!exit);
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
                        "[8]. Display Packages By Parcel Locker\n" +
                        "[9]. Update Package\n" +
                        "[0]. Exit program");
    }

    private static void addParcel() {
        System.out.println("U chose adding parcel method");
        System.out.println("Enter Parcel Locker Name: [a-zA-Z] ");
        String name = (sc1.nextLine());
        validName(name);
        System.out.println("Enter Parcel Locker City [a-zA-Z] ");
        String city = (sc1.nextLine());
        validCity(city);
        System.out.println("Enter Parcel street [a-zA-Z] ");
        String street = (sc1.nextLine());
        validStreet(street);
        System.out.println("Enter Parcel Postal Code [00-000]");
        String postalCode = sc1.nextLine();
        validPostalCode(postalCode);
        Address address = new Address(city, street, postalCode);
        ParcelLocker toAdd = new ParcelLocker(name, address);
        ParcelLockerManager.addParcelLocker(toAdd);
        successfulParcelAdd(name);
    }



    private static void removeParcel() {
        System.out.println("U choose removing Parcel Locker method");
        System.out.println("Enter ParcelLocker Id to remove");
        UUID id = UUID.fromString(sc1.nextLine());
        ParcelLockerManager.removeParcelLocker(id);
        validUUID(id);
        successfulRemovedParcelLockerByID(id);
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
        validCity(city);
        successfulDisplayParcelLockerByCItyName(city);
    }



    private static void updateParcel() {
        System.out.println("U chose to update Parcel Locker");
        System.out.println("Which Parcel Locker would You like to update");
        System.out.println("Parcel Locker Id: ");
        UUID id = UUID.fromString(sc.nextLine());
        validUUID(id);
        System.out.println("Whats the new name");
        String name = sc1.nextLine();
        validName(name);
        System.out.println("Enter Parcel Locker City");
        String city = sc1.nextLine();
        validCity(city);
        System.out.println("Enter Parcel street");
        String street = sc1.nextLine();
        validStreet(street);
        System.out.println("Enter Parcel Postal Code");
        String postalCode = sc1.nextLine();
        validPostalCode(postalCode);
        Address address = new Address(city, street, postalCode);
        ParcelLockerManager.updateParcelLocker(id, name, address);
    }


    private static void addPackage() {
        System.out.println("U chose to Add NEW Package to Parcel");
        System.out.println("Enter the PACKAGE name ");
        String name = sc.nextLine();
        validName(name);
        System.out.println("Whats size is package(S, M, L, XL) ");
        Package.Size size = Package.Size.valueOf(sc.nextLine());
        //// jak walidować size???
        System.out.println("What is weight of package, in kgs: ");
        double weight = sc.nextDouble();
        ///// jak walidować weight??
        System.out.println("Who is recipient of the package, Name");
        String recipientName = sc1.nextLine();
        validRecipientName(recipientName);
        System.out.println("Who is sender of the package: Name: ");
        String senderName = sc1.nextLine();
        validSenderName(senderName);
        System.out.println("The Sender Parcel Locker name is: ");
        String senderParcelLocker = sc1.nextLine();
        validSenderParcelLocker(senderParcelLocker); //!!!!!
        System.out.println("The recipient Parcel Locker name is: ");
        String recipientParcelLocker = sc1.nextLine();
        validRecipientParcelLocker(recipientParcelLocker); //!!!!!!!!!!!
        System.out.println("Add the state: W, T, R  ");
        Package.State state = Package.State.valueOf(sc1.nextLine());
        ///jak walidować stan!!???SSA
        ParcelLockerManager.addPackageToParcelLocker(name, size, weight, recipientName, senderName, senderParcelLocker, recipientParcelLocker, state);
        System.out.println("Package " + name + " added");
    }

    private static void removePackage() {
        System.out.println("U chose to remove Package from Parcele: ");
        System.out.println("Enter a ID number ");
        UUID id = UUID.fromString(sc.nextLine());
        validUUID(id);
        ParcelLockerManager.removePackageFromParcelLocker(id);
    }

    private static void displayPackages() {
        System.out.println("You chose to display Parcel By Parcels Locker");
        UUID id = UUID.fromString(sc.nextLine());
        validUUID(id);
        displayAllPackagesByParcel(id);
    }

    private static void updatePackage() {
        System.out.println("U chose to update Package");
        System.out.println("Which Package would You like to update");
        System.out.println("Package Id: ");
        UUID id = UUID.fromString(sc.nextLine());
        validUUID(id);
        System.out.println("New name will be ");
        String name = sc.nextLine();
        validName(name);
        System.out.println("Whats size is new package(S, M, L, XL) ");
        Package.Size size = Package.Size.valueOf(sc.nextLine());
        ////
        System.out.println("What is weight of new package, in kgs: ");
        double weight = sc.nextDouble();
        ////
        System.out.println("Who is recipient of the package");
        String recipient = sc1.nextLine();
        validRecipientName(recipient);
        System.out.println("Who is sender of the package: ");
        String sender= sc1.nextLine();
        validSenderName(sender);
        System.out.println("The Sender Parcel Locker name is: ");
        String senderParcelLocker = sc1.nextLine();
        validSenderParcelLocker(senderParcelLocker);
        //tu czy istniejej?!??!?!?
        System.out.println("The recipient Parcel Locker name is: ");
        String recipientParcelLocker = sc1.nextLine();
        validRecipientParcelLocker(recipientParcelLocker);
        ///// tu trzeba saprawdzic raczej jej istnienie!??
        System.out.println("Add the state: W, T, R  ");
        Package.State state = Package.State.valueOf(sc1.nextLine());
        ParcelLockerManager.updatePackagesInParcelLocker(id, name, size, weight, recipient, sender, senderParcelLocker, recipientParcelLocker, state);
    }

//VAlidUUID;
    private static void validUUID(UUID id) {
        if(Validation.isValidUUIDNumber(String.valueOf(id))) {
            System.out.println(" Wrong data format. The pacrcel" + String.valueOf(id) + "dosen't exist");
            System.out.println("You need to start method again                                        ");
            System.out.println("                                                                      ");
            Terminal.start();
        }
    }
//validName;
    private static void validName(String name) {
        if(!Validation.isThatAString(name) || Validation.isNotEmptyValidation(name))
        {
            System.out.println("                                 ");
            System.out.println("    This value is incorrect       ");
            System.out.println("You have to do Whole Method again");
            System.out.println("                                 ");
            Terminal.start();
        }
    }
    private static void validCity(String city) {
        if(!Validation.isThatAString(city) || Validation.isNotEmptyValidation(city))
        {
            System.out.println("                                 ");
            System.out.println("         Empty Value             ");
            System.out.println("You have to do Whole Method again");
            System.out.println("                                  ");
            Terminal.start();
        }
    }

    private static void validStreet(String street) {
        if(!Validation.isThatAString(street) || Validation.isNotEmptyValidation(street))
        {
            System.out.println("                                 ");
            System.out.println("         Wrong Format             ");
            System.out.println("You have to do Whole Method again ");
            System.out.println("                                  ");
            Terminal.start();
        }
    }

    private static void validPostalCode(String postalCode) {
        if(!Validation.isValidPostalCodeNumber(postalCode)) {
            System.out.println("                                 ");
            System.out.println("         Wrong Format             ");
            System.out.println("You have to do Whole Method again");
            System.out.println("                                   ");
            Terminal.start();
        }
    }

    private static void successfulParcelAdd(String name) {
        System.out.println("                                              ");
        System.out.println("Parcel Locker " + name + " successfully added");
        System.out.println("                                              ");
    }

    private static void successfulRemovedParcelLockerByID(UUID id) {
        System.out.println("                                              ");
        System.out.println("Yoy removed ParcelLocker " + id);
        System.out.println("                                              ");
    }

    private static void successfulDisplayParcelLockerByCItyName(String city) {
        System.out.println("List of Parcel Lockers in given City: ");
        System.out.println("                                              ");
        ParcelLockerManager.displayParcelByCity(city);
        System.out.println("                                              ");
    }

    private static void validSenderParcelLocker(String senderParcelLocker) {
        if(!Validation.isThatAString(senderParcelLocker) || Validation.isNotEmptyValidation(senderParcelLocker))
        {
            System.out.println("                                 ");
            System.out.println("         Empty Value             ");
            System.out.println("You have to do Whole Method again");
            System.out.println("                                  ");
            Terminal.start();
        }
    }

    private static void validRecipientParcelLocker(String recipientParcelLocker) {
        if(Validation.isNotEmptyValidation(recipientParcelLocker))
        {
            System.out.println("                                 ");
            System.out.println("         Empty Value             ");
            System.out.println("You have to do Whole Method again");
            System.out.println("                                  ");
            Terminal.start();
        }
    }

    private static void validRecipientName(String recipientName) {
        if(!Validation.isThatAString(recipientName) || Validation.isNotNullValidation(recipientName))
        {
            System.out.println(" Your input is not Sting         ");
            System.out.println("   or      Null Value            ");
            System.out.println("You have to do Whole Method again");
            System.out.println("                                  ");
            Terminal.start();
        }
    }

    private static void validSenderName(String senderName) {
        if(!Validation.isThatAString(senderName) || Validation.isNotNullValidation(senderName))
        {
            System.out.println(" Your input is not String        ");
            System.out.println("    or     Null Value            ");
            System.out.println("You have to do Whole Method again");
            System.out.println("                                  ");
            Terminal.start();
        }
    }
}


