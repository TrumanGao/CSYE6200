package edu.northeastern.project2;

import java.time.*;

public class RentalBox {
    private Media[] inventory;

    public RentalBox(int capacity) {
        inventory = new Media[capacity];
    }

    public RentalBox() {
        this(100);
    }

    public int boxCapacity() {
        return inventory.length;
    }

    public Media get(int i) {
        return inventory[i];
    }

    public boolean inStock(Media m) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null && inventory[i].equals(m)) {
                return true;
            }
        }
        return false;
    }

    public boolean put(Media m) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = m;
                return true;
            }
        }
        return false;
    }

    public Rental rent(Media m, Payment p, LocalDate d) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null && inventory[i].equals(m)) {
                Media foundMedia = inventory[i];
                inventory[i] = null;
                double dailyFee = getDailyFee(foundMedia);
                return new DailyRental(foundMedia, p, d, dailyFee);
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

        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = r.getMedia();
                double totalFee = r.dropoff(today);
                processPayment(r.getPayment(), totalFee);
                return true;
            }
        }
        return false;
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
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                sb.append(inventory[i].toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}