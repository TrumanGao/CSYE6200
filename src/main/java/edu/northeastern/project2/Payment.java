package edu.northeastern.project2;

public class Payment {

    private String cardNo;
    private String name;
    private int expMonth;
    private int expYear;

    public Payment(String cardNo, String name, int expMonth, int expYear) {
        this.cardNo = cardNo;
        this.name = name;
        this.expMonth = expMonth;
        this.expYear = expYear;
    }

    public String getCardNo() {
        return this.cardNo;
    }

    public String getName() {
        return this.name;
    }

    public int getExpMonth() {
        return this.expMonth;
    }

    public int getExpYear() {
        return this.expYear;
    }

    @Override
    public String toString() {
        return "#" + this.cardNo + " (" + this.name + "), exp " + this.expMonth + "/" + this.expYear;
    }
}