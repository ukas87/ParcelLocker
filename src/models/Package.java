package models;

import java.util.UUID;

public class Package {

    private UUID id = UUID.randomUUID();
    private String name;
    private Size size;
    private double weight;
    private String recipient;
    private String sender;
    private String senderPL;
    private String recipientPL;
    private State state = State.START;


    public Package(String name, Size size, double weight, String recipient, String sender, String senderPL, String recipientPL) {
        this.name = name;
        this.size = size;
        this.weight = weight;
        this.recipient = recipient;
        this.sender = sender;
        this.senderPL = senderPL;
        this.recipientPL = recipientPL;
    }

    public Package(String name, Size size, double weight, String recipient, String sender, String senderPL, String recipientPL, State state) {
        this.name = name;
        this.size = size;
        this.weight = weight;
        this.recipient = recipient;
        this.sender = sender;
        this.senderPL = senderPL;
        this.recipientPL = recipientPL;
        this.state = state;
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

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSenderPL() {
        return senderPL;
    }

    public void setSenderPL() {
        this.senderPL = senderPL;
    }

    public String getRecipientPL() {
        return recipientPL;
    }

    public void setRecipientPL(String recipientPL) {
        this.recipientPL = recipientPL;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", weight=" + weight +
                ", recipient='" + recipient + '\'' +
                ", sender='" + sender + '\'' +
                ", senderPL=" + senderPL +
                ", recipientPL=" + recipientPL +
                ", state=" + state +
                '}';
    }


    public enum Size{
        S, M, L
        //SMALL, MEDIUM, LARGE, EXTRA_LARGE
    }

    public enum State{
        START, DELIVERED;

      //jak dla mnie na tym etapie potrzeba dwóch stanów, w paczkomacie Starowym, lub Docelowym;
    }

    public void setRecipientParcelLocker(String recipientParcelLocker) {
        this.recipientPL = recipientParcelLocker;
    }

    public void setSenderPL(String senderParcelLocker) {
        this.senderPL = senderParcelLocker;
    }


}
