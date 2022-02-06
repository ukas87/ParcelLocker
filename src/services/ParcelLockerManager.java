package services;

import models.Address;
import models.Package;
import models.ParcelLocker;

import java.util.UUID;

public class ParcelLockerManager {

    static ParcelLocker[] parcels = new ParcelLocker[8];
    //static Package[] packages = new Package[20];
    //tutaj inicjalizuję liczbę paczkomatów 8; paczki w ParcelLocker 5; o


    //1.Metoda do dodawania ParcelLocker; ADD PL;
    public static void addParcelLocker(ParcelLocker newParcelLocker) {
        //int id = newParcelLocker.getId();
        for (int i = 0; i < parcels.length; i++) {
            if (parcels[i] == null) {
                parcels[i] = newParcelLocker;
                break;
            }
        }
    }

    //2.Metoda do usuwania ParcelLockers; REMOVE;
    public static void removeParcelLocker(UUID id) {
        for (int i = 0; i < parcels.length; i++) {
            if (parcels[i] != null)
                if (parcels[i].getId().equals(id)) {
                    parcels[i] = null;
                } else {
                    System.out.println("Wrong ID number");
                }
        }
    }

    //3.Metoda do pokazywania wszystkich ParcelLockers;
    public static void displayAllParcelsLockers() {
        for (int i = 0; i < parcels.length; i++) {
            //if (parcels[i] != null)  //na czas testowania niaktywne, nie wyświelte inaczej pustej
            {
                System.out.println(parcels[i]);
            }
        }
    }

    //4. Metod do wypisywania Parcel Lockers po zadanym Miesciel
    public static void displayParcelByCity(String city) {
        for (int i = 0; i < parcels.length; i++) {
            if (parcels[i] != null && parcels[i].getAddress().getCity().equals(city)) {
                System.out.println(parcels[i]);
            }
        }
    }

    //5. Metoda do Updatów Parcel Locker;
    public static void updateParcelLocker(UUID id, String name, Address address) {
        for (int i = 0; i < parcels.length; i++) {
            if (parcels[i] != null && parcels[i].getId().equals(id)) {
                parcels[i].setName(name);
                parcels[i].setAddress(address);
            }
        }

    }


    //6, Metoda do Dodawania paczek; nie działa wywala mi się //
    public static void addPackageToParcelLocker(String name, Package.Size size, double weight, String recipient, String sender, String senderPL, String recipientPL, Package.State state) {
        for (int i = 0; i < parcels.length; i++) {
            if (parcels[i] != null && parcels[i].getName().equals(senderPL)) {
                for (int j = 0; j < parcels[i].getPackages().length; j++) {
                    if (parcels[i].getPackages()[j] == null) {
                        parcels[i].getPackages()[j] = new Package(name, size, weight, recipient, sender, senderPL, recipientPL, state);
                    }
                    break;
                }
            }
        }
    }


    //7.usuawni paczek z paczkomatu;
    public static void removePackageFromParcelLocker(UUID id) {
        // UUID uuid = UUID.fromString(id);
        for (int i = 0; i < parcels.length; i++) {
            if (parcels[i] != null) {
                for (int j = 0; j < parcels[i].getPackages().length; j++) {
                    if (parcels[i].getPackages()[j] != null && parcels[i].getPackages()[j].getId().equals(id)) {
                        parcels[i].getPackages()[j] = null;
                    }
                }
            }
        }
    }

    //8.Metoda do wyświetlani wszystkich paczek; po paczkoamacie;
    public static void displayAllPackagesByParcel(UUID id) {
        for (int i = 0; i < parcels.length; i++) {
            if (parcels[i] != null && parcels[i].getId().equals(id)) {
                for (int j = 0; j < parcels[i].getPackages().length; j++) {
                    System.out.println(parcels[i].getPackages()[j]);
                }
            }
        }
    }
    //9.Metoda do Updetowwania

    public static void updatePackagesInParcelLocker(UUID id, String name, Package.Size size, double weight, String recipient, String sender, String senderPL, String recipientPL, Package.State state) {
        for (int i = 0; i < parcels.length; i++) {
            if (parcels[i] != null) {
                for (int j = 0; j < parcels[i].getPackages().length; j++) {
                    if (parcels[i].getPackages()[j] != null && parcels[i].getPackages()[j].getId().equals(id)) {
                        parcels[i].getPackages()[j].setName(name);
                        parcels[i].getPackages()[j].setSize(size);
                        parcels[i].getPackages()[j].setWeight(weight);
                        parcels[i].getPackages()[j].setRecipient(recipient);
                        parcels[i].getPackages()[j].setSender(sender);
                        parcels[i].getPackages()[j].setSenderPL(senderPL);
                        parcels[i].getPackages()[j].setRecipientPL(recipientPL);
                        parcels[i].getPackages()[j].setState(state);
                    }
                }
            }
        }

    }
}

