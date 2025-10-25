package edu.northeastern.csye6200.project2;

public class Game extends Media {
    private String platform;
    private String rating;
    private int discs;
    private boolean online;

    /**
     * Constructor to initialize game.
     *
     * @param name     the game name
     * @param year     the publication year
     * @param platform the gaming platform
     * @param rating   the content rating
     * @param discs    the number of discs
     * @param online   whether it's an online game
     */
    public Game(String name, int year, String platform, String rating, int discs, boolean online) {
        super(name, year);
        this.platform = platform;
        this.rating = rating;
        this.discs = discs;
        this.online = online;
    }

    /**
     * Gets the platform.
     *
     * @return the gaming platform
     */
    public String getPlatform() {
        return platform;
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
     * Gets the number of discs.
     *
     * @return number of discs
     */
    public int getDiscs() {
        return discs;
    }

    /**
     * Checks if game is online.
     *
     * @return true if online, false otherwise
     */
    public boolean isOnline() {
        return online;
    }

    /**
     * Returns string representation of game.
     *
     * @return string with game details
     */
    @Override
    public String toString() {
        String mediaStr = super.toString();

        String base = mediaStr + " " + platform + " [" + rating + ", " + discs + " discs";

        if (online) {
            base += ", online";
        }

        base += "]";
        return base;
    }
}