package model;

public class Vehicle {
    private String number;
    private int weight;
    private int passengers;
    private String type;

    public Vehicle() {
    }

    public Vehicle(String number, int weight, int passengers, String type) {
        this.setNumber(number);
        this.setWeight(weight);
        this.setPassengers(passengers);
        this.setType(type);
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String toString(){
       return number+" "+weight+" "+passengers+" "+type;
    }
}
