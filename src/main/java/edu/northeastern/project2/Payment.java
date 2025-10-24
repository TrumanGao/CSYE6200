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
        return cardNo;
    }

    public String getName() {
        return name;
    }

    public int getExpMonth() {
        return expMonth;
    }

    public int getExpYear() {
        return expYear;
    }

    @Override
    public String toString() {
        return "#" + cardNo + " (" + name + "), exp " + expMonth + "/" + expYear;
    }
}