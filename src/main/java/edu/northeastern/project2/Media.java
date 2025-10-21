package edu.northeastern.project2;

public class Media {

    protected String name;

    protected int year;

    public Media(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return this.name;
    }

    public int getYear() {
        return this.year;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Media) {
            Media otherMedia = (Media) other;
            return this.name.equals(otherMedia.getName()) && this.year == otherMedia.getYear();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

    @Override
    public String toString() {
        return this.name + " (" + this.year + ")";
    }
}