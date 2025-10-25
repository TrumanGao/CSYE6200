package edu.northeastern.project2;

import java.time.*;

public class RentalBox {
    private Media[] inventory;

    /**
     * Constructor with specified capacity.
     *
     * @param capacity the maximum number of media slots
     */
    public RentalBox(int capacity) {
        inventory = new Media[capacity];
    }

    /**
     * Constructor with default capacity of 100.
     */
    public RentalBox() {
        this(100);
    }

    /**
     * Gets the total capacity.
     *
     * @return the number of slots for storing media
     */
    public int boxCapacity() {
        return inventory.length;
    }

    /**
     * Gets media at specified slot.
     *
     * @param i the slot index
     * @return the media at that slot
     */
    public Media get(int i) {
        return inventory[i];
    }

    /**
     * Checks if media is in stock.
     *
     * @param m the media to check
     * @return true if in stock
     */
    public boolean inStock(Media m) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null && inventory[i].equals(m)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds media to the box.
     *
     * @param m the media to add
     * @return true if added successfully
     */
    public boolean put(Media m) {
        boolean canPut = false;
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = m;
                canPut = true;
                break;
            }
        }
        return canPut;
    }

    /**
     * Rents media from the box.
     *
     * @param m the media to rent
     * @param p the payment method
     * @param l the rental date
     * @return a new Rental object
     */
    public Rental rent(Media m, Payment p, LocalDate l) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null && inventory[i].equals(m)) {
                Media foundMedia = inventory[i];
                inventory[i] = null; // Remove from inventory
                double dailyFee = getDailyFee(foundMedia);
                return new DailyRental(foundMedia, p, l, dailyFee);
            }
        }
        return null;
    }

    /**
     * Processes payment and prints receipt.
     *
     * @param p      the payment method
     * @param amount the amount charged
     */
    public void processPayment(Payment p, double amount) {
        System.out.println("$" + String.format("%.2f", amount) + " paid by " + p.toString());
    }

    /**
     * Drops off a rental.
     *
     * @param r     the rental to drop off
     * @param today the dropoff date
     * @return true if successful
     */
    public boolean dropoff(Rental r, LocalDate today) {
        if (!r.isRented()) {
            return false;
        }

        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = r.getMedia();
                Payment payment = r.getPayment();
                double fee = r.dropoff(today);
                processPayment(payment, fee);
                return true;
            }
        }
        return false;
    }

    /**
     * Determines daily fee based on media type.
     *
     * @param m the media
     * @return the daily fee
     */
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

    /**
     * Returns string representation of box contents.
     *
     * @return all non-empty slots, one per line
     */
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                str += inventory[i].toString();
                str += "\n";
            }
        }
        return str;
    }
}