package edu.northeastern.csye6200.project2;

import java.time.*;

public class DailyRental extends Rental {
    /**
     * promo code
     */
    private double credit;

    /**
     * Constructor with credit.
     *
     * @param media   the rented media
     * @param payment the payment method
     * @param today   the rental date
     * @param fee     the daily fee
     * @param credit  the promotional credit
     */
    public DailyRental(Media media, Payment payment, LocalDate today, double fee, double credit) {
        super(media, payment, today, fee);
        this.credit = credit;
    }

    /**
     * Constructor without credit
     *
     * @param media   the rented media
     * @param payment the payment method
     * @param today   the rental date
     * @param fee     the daily fee
     */
    public DailyRental(Media media, Payment payment, LocalDate today, double fee) {
        this(media, payment, today, fee, 0.0);
    }

    /**
     * Gets the promotional credit.
     *
     * @return the credit amount
     */
    public double getCredit() {
        return credit;
    }

    /**
     * Calculates total fee based on daily rate.
     *
     * @param today the current date
     * @return the total fee after credit
     */
    @Override
    public double getTotalFee(LocalDate today) {
        int days = daysRented(today);
        if (days < 1) {
            days = 1; // Minimum 1 day charge
        }
        return Math.max(0, days * getFee() - credit); // Cannot be negative
    }
}