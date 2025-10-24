package edu.northeastern.project2;

import java.time.*;

public class Media {
    private String name;
    private int year;

    public Media(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Media)) {
            return false;
        }
        Media m = (Media) other;
        return this.name.equals(m.name) && this.year == m.year;
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public String toString() {
        return name + " (" + year + ")";
    }
}