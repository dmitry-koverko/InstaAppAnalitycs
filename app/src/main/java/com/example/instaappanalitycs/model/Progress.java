package com.example.instaappanalitycs.model;

import com.google.gson.annotations.SerializedName;

public class Progress {

    @SerializedName("progress")
    private boolean progress;

    @SerializedName("value")
    private double value;

    public boolean isProgress() {
        return progress;
    }

    public void setProgress(boolean progress) {
        this.progress = progress;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
