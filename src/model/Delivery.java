package model;

public class Delivery {
    private String number;
    private String type;
    private String name;
    private String leftTime;


    public Delivery() {
    }

    public Delivery(String number, String type, String name, String leftTime) {
        this.setNumber(number);
        this.setType(type);
        this.setName(name);
        this.setLeftTime(leftTime);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeftTime() {
        return leftTime;
    }

    public void setLeftTime(String parkedTime) {
        this.leftTime = parkedTime;
    }

    public String toString(){
        return number+" "+type+" "+name+" "+leftTime;
    }
}
