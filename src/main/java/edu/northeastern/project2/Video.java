package edu.northeastern.project2;

public class Video extends Media {

    public static final int DVD = 0;
    public static final int BLURAY = 1;

    protected int runtime;
    protected String rating;
    protected int format;

    public Video(String name, int year, int runtime, String rating, int format) {
        super(name, year);
        this.runtime = runtime;
        this.rating = rating;
        this.format = format;
    }

    public int getRuntime() {
        return this.runtime;
    }

    public String getRating() {
        return this.rating;
    }

    public int getFormat() {
        return this.format;
    }

    @Override
    public String toString() {
        String formatString = (this.format == DVD) ? "DVD" : "BLURAY";
        return super.toString() + " " + formatString + " [" + this.rating + ", " + this.runtime + " min]";
    }
}