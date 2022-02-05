package models;

import java.util.Arrays;
import java.util.UUID;

public class ParcelLocker {
    private UUID id = UUID.randomUUID();
   // private String id = UUID.randomUUID().toString();
    private String name;
    private Address address;
    private Package[] packages = new Package[5];


    public ParcelLocker(UUID id, String name, Address address, Package[] packages) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.packages = packages;
    }

    public ParcelLocker(UUID id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public ParcelLocker(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Package[] getPackages() {
        return packages;
    }

    public void setPackages(Package[] packages) {
        this.packages = packages;
    }


    public void setPackages(String sd, String dd) {
    }

    @Override
    public String toString() {
        return "ParcelLocker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", packages=" + Arrays.toString(packages) +
                '}';
    }
}



