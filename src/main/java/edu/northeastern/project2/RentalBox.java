package edu.northeastern.project2;

import java.time.LocalDate;

public class RentalBox {

    private Media[] mediaSlots;

    public RentalBox(int capacity) {
        this.mediaSlots = new Media[capacity];
    }

    public RentalBox() {
        this(100);
    }

    public int boxCapacity() {
        return this.mediaSlots.length;
    }

    public Media get(int i) {
        if (i >= 0 && i < this.boxCapacity()) {
            return this.mediaSlots[i];
        }
        return null;
    }

    public boolean inStock(Media m) {
        for (Media slot : this.mediaSlots) {
            if (slot != null && slot.equals(m)) {
                return true;
            }
        }
        return false;
    }

    public boolean put(Media m) {
        for (int i = 0; i < this.boxCapacity(); i++) {
            if (this.mediaSlots[i] == null) {
                this.mediaSlots[i] = m;
                return true;
            }
        }
        return false;
    }

    public Rental rent(Media m, Payment p, LocalDate d) {
        for (int i = 0; i < this.boxCapacity(); i++) {
            Media mediaToRent = this.mediaSlots[i];
            if (mediaToRent != null && mediaToRent.equals(m)) {
                this.mediaSlots[i] = null;
                double fee = this.getDailyFee(mediaToRent);
                Rental rental = new DailyRental(mediaToRent, p, d, fee);
                return rental;
            }
        }
        return null;
    }

    public void processPayment(Payment p, double amount) {
        System.out.printf("$%.2f paid by %s\n", amount, p.toString());
    }

    public boolean dropoff(Rental r, LocalDate today) {
        if (!r.isRented()) {
            return false;
        }
        boolean putSuccess = this.put(r.getMedia());
        if (putSuccess) {
            double totalFee = r.dropoff(today);
            this.processPayment(r.getPayment(), totalFee);
            return true;
        } else {
            return false;
        }
    }

    public double getDailyFee(Media m) {
        if (m instanceof Video) {
            Video v = (Video) m;
            if (v.getFormat() == Video.DVD) {
                return 1.50;
            } else if (v.getFormat() == Video.BLURAY) {
                return 2.00;
            }
        } else if (m instanceof Game) {
            return 3.00;
        }

        return 0.00;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Media slot : this.mediaSlots) {
            if (slot != null) {
                sb.append(slot.toString());
                sb.append("\n");
            }
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}