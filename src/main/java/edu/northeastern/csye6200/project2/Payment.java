package edu.northeastern.csye6200.project2;

public class Payment {
    private String cardNo;
    private String name;
    private int expMonth;
    private int expYear;

    /**
     * Constructor to initialize payment information.
     * @param cardNo credit card number
     * @param name cardholder name
     * @param expMonth expiration month
     * @param expYear expiration year
     */
    public Payment(String cardNo, String name, int expMonth, int expYear) {
        this.cardNo = cardNo;
        this.name = name;
        this.expMonth = expMonth;
        this.expYear = expYear;
    }

    /**
     * Gets the card number.
     * @return credit card number
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * Gets the cardholder name.
     * @return cardholder name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the expiration month.
     * @return expiration month
     */
    public int getExpMonth() {
        return expMonth;
    }

    /**
     * Gets the expiration year.
     * @return expiration year
     */
    public int getExpYear() {
        return expYear;
    }

    /**
     * Returns string representation of payment.
     * @return string in format "#CARDNUMBER (NAME), exp MONTH/YEAR"
     */
    @Override
    public String toString() {
        return "#" + cardNo + " (" + name + "), exp " + expMonth + "/" + expYear;
    }
}