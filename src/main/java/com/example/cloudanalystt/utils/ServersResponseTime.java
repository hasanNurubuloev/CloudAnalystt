package com.example.cloudanalystt.utils;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ServersResponseTime {
    private StringProperty server;
    private StringProperty min;
    private StringProperty max;
    private StringProperty avg;

    public ServersResponseTime(String server, float min, float max, float avg) {
        this.server = new SimpleStringProperty(server);
        this.min = new SimpleStringProperty(String.valueOf(min));
        this.max = new SimpleStringProperty(String.valueOf(max));
        this.avg = new SimpleStringProperty(String.valueOf(avg));
    }

    public String getServer() {
        return server.get();
    }

    public StringProperty serverProperty() {
        return server;
    }

    public void setServer(String server) {
        this.server.set(server);
    }

    public float getMin() {
        return Float.parseFloat(min.get());
    }

    public StringProperty minProperty() {
        return min;
    }

    public void setMin(float min) {
        this.min.set(String.valueOf(min));
    }

    public float getMax() {
        return Float.parseFloat(max.get());
    }

    public StringProperty maxProperty() {
        return max;
    }

    public void setMax(float max) {
        this.max.set(String.valueOf(max));
    }

    public float getAvg() {
        return Float.parseFloat(avg.get());
    }

    public StringProperty avgProperty() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg.set(String.valueOf(avg));
    }
}
