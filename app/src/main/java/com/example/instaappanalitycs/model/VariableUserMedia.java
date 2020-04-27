package com.example.instaappanalitycs.model;

public class VariableUserMedia {
    private String id;
    private int first;
    private String after = "";
    private String shortcode = "";
    private boolean include_reel;

    public VariableUserMedia(){};

    public VariableUserMedia(String id, int first, String after) {
        this.id = id;
        this.first = first;
        this.after = after;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public String getShortcode() {
        return shortcode;
    }

    public void setShortcode(String shortcode) {
        this.shortcode = shortcode;
    }

    public boolean isInclude_reel() {
        return include_reel;
    }

    public void setInclude_reel(boolean include_reel) {
        this.include_reel = include_reel;
    }
}