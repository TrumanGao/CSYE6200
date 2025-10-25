package edu.northeastern.project2;

import java.time.*;

public class Rental {
    private Media media;
    private Payment payment;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private double fee;

    /**
     * Constructor to initialize rental.
     * @param media the rented media
     * @param payment the payment method
     * @param today the rental date
     * @param fee the rental fee
     */
    public Rental(Media media, Payment payment, LocalDate today, double fee) {
        this.media = media;
        this.payment = payment;
        this.rentDate = today;
        this.fee = fee;
        this.returnDate = null; // Initially not returned
    }

    /**
     * Gets the rented media.
     * @return the media object
     */
    public Media getMedia() {
        return media;
    }

    /**
     * Gets the payment method.
     * @return the payment object
     */
    public Payment getPayment() {
        return payment;
    }

    /**
     * Gets the rental date.
     * @return the rental date
     */
    public LocalDate getRentDate() {
        return rentDate;
    }

    /**
     * Gets the rental fee.
     * @return the fee amount
     */
    public double getFee() {
        return fee;
    }

    /**
     * Drops off the rental and calculates total fee.
     * @param today the dropoff date
     * @return the total rental fee
     */
    public double dropoff(LocalDate today) {
        if (returnDate == null) {
            returnDate = today;
        }
        return getTotalFee(today);
    }

    /**
     * Checks if media is currently rented.
     * @return true if rented, false if returned
     */
    public boolean isRented() {
        return returnDate == null;
    }

    /**
     * Calculates days rented.
     * @param today the current date
     * @return number of days rented
     */
    public int daysRented(LocalDate today) {
        if (returnDate != null) {
            return Period.between(rentDate, returnDate).getDays();
        }
        return Period.between(rentDate, today).getDays();
    }

    /**
     * Calculates total fee (flat rate for base Rental).
     * @param today the current date
     * @return the total fee
     */
    public double getTotalFee(LocalDate today) {
        return fee;
    }

    /**
     * Returns string representation of rental.
     * @return rental details as string
     */
    @Override
    public String toString() {
        return media.toString() + ", rented on " + rentDate + " using " + payment.toString();
    }
}