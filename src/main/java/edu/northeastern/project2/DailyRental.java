package edu.northeastern.project2;

import java.time.*;

public class DailyRental extends Rental {

    private double credit;

    public DailyRental(Media media, Payment payment, LocalDate today, double fee, double credit) {
        super(media, payment, today, fee);
        this.credit = credit;
    }

    public DailyRental(Media media, Payment payment, LocalDate today, double fee) {
        this(media, payment, today, fee, 0.0);
    }

    public double getCredit() {
        return this.credit;
    }

    @Override
    public double getTotalFee(LocalDate today) {
        int days = this.daysRented(today);
        int billedDays = Math.max(1, days);
        double totalFee = (billedDays * this.fee) - this.credit;
        return Math.max(0.0, totalFee);
    }
}