package edu.northeastern.project2;

public class Game extends Media {
    private String platform;
    private String rating;
    private int discs;
    private boolean online;

    public Game(String name, int year, String platform, String rating, int discs, boolean online) {
        super(name, year);
        this.platform = platform;
        this.rating = rating;
        this.discs = discs;
        this.online = online;
    }

    public String getPlatform() {
        return platform;
    }

    public String getRating() {
        return rating;
    }

    public int getDiscs() {
        return discs;
    }

    public boolean isOnline() {
        return online;
    }

    @Override
    public String toString() {
        String base = super.toString() + " " + platform + " [" + rating + ", " + discs + " discs";
        if (online) {
            base += ", online";
        }
        base += "]";
        return base;
    }
}