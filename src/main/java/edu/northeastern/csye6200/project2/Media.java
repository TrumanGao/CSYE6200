package edu.northeastern.csye6200.project2;

public class Media {
    private String name;
    private int year;

    /**
     * Constructor to initialize media
     * @param name the name of the media
     * @param year the publication year
     */
    public Media(String name, int year) {
        this.name = name;
        this.year = year;
    }

    /**
     * Gets the name of the media.
     * @return the media name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the publication year.
     * @return the publication year
     */
    public int getYear() {
        return year;
    }

    /**
     * Checks if this media equals another object.
     * Two media are equal if they have the same name and publication year.
     * @param other the object to compare
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Media)) {
            return false;
        }
        Media m = (Media) other;
        return this.name.equals(m.name) && this.year == m.year;
    }

    /**
     * Returns hash code based on name.
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    /**
     * Returns string representation of media.
     * @return string in format "NAME (YEAR)"
     */
    @Override
    public String toString() {
        return name + " (" + year + ")";
    }
}