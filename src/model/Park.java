package model;

public class Park {
    private String number;
    private String type;
    private String slot;
    private String parkedTime;

    public Park() {
    }

    public Park(String number, String type, String slot, String parkedTime) {
        this.setNumber(number);
        this.setType(type);
        this.setSlot(slot);
        this.setParkedTime(parkedTime);
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

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getParkedTime() {
        return parkedTime;
    }

    public void setParkedTime(String parkedTime) {
        this.parkedTime = parkedTime;
    }
        public String toString(){
            return number+" "+type+" "+slot+" "+parkedTime;
            }
        }

