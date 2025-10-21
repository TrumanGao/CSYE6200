package edu.northeastern.project2;

public class Game extends Media {

    protected String platform;
    protected String rating;
    protected int discs;
    protected boolean online;

    public Game(String name, int year, String platform, String rating, int discs, boolean online) {
        super(name, year);
        this.platform = platform;
        this.rating = rating;
        this.discs = discs;
        this.online = online;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getRating() {
        return this.rating;
    }

    public int getDiscs() {
        return this.discs;
    }

    public boolean isOnline() {
        return this.online;
    }

    @Override
    public String toString() {
        String onlineString = this.online ? ", online" : "";
        return super.toString() + " " + this.platform + " [" + this.rating + ", " + this.discs + " discs" + onlineString + "]";
    }
}