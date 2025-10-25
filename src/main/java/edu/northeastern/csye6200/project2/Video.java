package edu.northeastern.csye6200.project2;

public class Video extends Media {
    public static final int DVD = 0;
    public static final int BLURAY = 1;

    private int runtime; // in minutes
    private String rating; // G, PG, R, etc
    private int format; // 0, 1

    /**
     * Constructor to initialize video.
     *
     * @param name    the video name
     * @param year    the publication year
     * @param runtime the runtime in minutes
     * @param rating  the content rating
     * @param format  DVD or BLURAY
     */
    public Video(String name, int year, int runtime, String rating, int format) {
        super(name, year);
        this.runtime = runtime;
        this.rating = rating;
        this.format = format;
    }

    /**
     * Gets the runtime.
     *
     * @return runtime in minutes
     */
    public int getRuntime() {
        return runtime;
    }

    /**
     * Gets the rating.
     *
     * @return the content rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * Gets the format.
     *
     * @return DVD or BLURAY constant
     */
    public int getFormat() {
        return format;
    }

    /**
     * Returns string representation of video.
     *
     * @return string in format "NAME (YEAR) FORMAT [RATING, RUNTIME min]"
     */
    @Override
    public String toString() {
        String MediaStr = super.toString();

        String formatStr;
        if (format == Video.DVD) {
            formatStr = "DVD";
        } else {
            formatStr = "BLURAY";
        }

        return MediaStr + " " + formatStr + " [" + rating + ", " + runtime + " min]";
    }
}