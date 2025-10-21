package edu.northeastern.project2;

import java.time.*;

public class Rental {

    protected Media media;
    protected Payment payment;
    protected LocalDate rentDate;
    protected double fee;
    protected LocalDate dropoffDate;

    public Rental(Media media, Payment payment, LocalDate today, double fee) {
        this.media = media;
        this.payment = payment;
        this.rentDate = today;
        this.fee = fee;
        this.dropoffDate = null;
    }

    public Media getMedia() {
        return this.media;
    }

    public Payment getPayment() {
        return this.payment;
    }

    public LocalDate getRentDate() {
        return this.rentDate;
    }

    public double getFee() {
        return this.fee;
    }

    public double dropoff(LocalDate today) {
        if (this.dropoffDate == null) {
            this.dropoffDate = today;
        }
        return this.getTotalFee(today);
    }

    public boolean isRented() {
        return this.dropoffDate == null;
    }

    public int daysRented(LocalDate today) {
        LocalDate endDate = this.isRented() ? today : this.dropoffDate;
        return Period.between(this.rentDate, endDate).getDays();
    }

    public double getTotalFee(LocalDate today) {
        return this.fee;
    }

    @Override
    public String toString() {
        return this.media.toString() + ", rented on " + this.rentDate.toString() + " using " + this.payment.toString();
    }
}