package edu.northeastern.project2;

public class Video extends Media {
    public static final int DVD = 0;
    public static final int BLURAY = 1;

    private int runtime;
    private String rating;
    private int format;

    public Video(String name, int year, int runtime, String rating, int format) {
        super(name, year);
        this.runtime = runtime;
        this.rating = rating;
        this.format = format;
    }

    public int getRuntime() {
        return runtime;
    }

    public String getRating() {
        return rating;
    }

    public int getFormat() {
        return format;
    }

    @Override
    public String toString() {
        String formatStr = (format == DVD) ? "DVD" : "BLURAY";
        return super.toString() + " " + formatStr + " [" + rating + ", " + runtime + " min]";
    }
}