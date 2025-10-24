package edu.northeastern.project2;

import java.time.*;

public class Rental {
    private Media media;
    private Payment payment;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private double fee;

    public Rental(Media media, Payment payment, LocalDate today, double fee) {
        this.media = media;
        this.payment = payment;
        this.rentDate = today;
        this.fee = fee;
        this.returnDate = null;
    }

    public Media getMedia() {
        return media;
    }

    public Payment getPayment() {
        return payment;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public double getFee() {
        return fee;
    }

    public double dropoff(LocalDate today) {
        if (returnDate == null) {
            returnDate = today;
        }
        return getTotalFee(today);
    }

    public boolean isRented() {
        return returnDate == null;
    }

    public int daysRented(LocalDate today) {
        if (returnDate != null) {
            return Period.between(rentDate, returnDate).getDays();
        }
        return Period.between(rentDate, today).getDays();
    }

    public double getTotalFee(LocalDate today) {
        return fee;
    }

    @Override
    public String toString() {
        return media.toString() + ", rented on " + rentDate + " using " + payment.toString();
    }
}