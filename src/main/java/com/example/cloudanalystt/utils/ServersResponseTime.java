package com.example.cloudanalystt.utils;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ServersResponseTime {
    private StringProperty server;
    private StringProperty min;
    private StringProperty max;
    private StringProperty avg;

    public ServersResponseTime(String server, double min, double max, double avg) {
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

    public double getMin() {
        return Double.parseDouble(min.get());
    }

    public StringProperty minProperty() {
        return min;
    }

    public void setMin(double min) {
        this.min.set(String.valueOf(min));
    }

    public double getMax() {
        return Double.parseDouble(max.get());
    }

    public StringProperty maxProperty() {
        return max;
    }

    public void setMax(double max) {
        this.max.set(String.valueOf(max));
    }

    public double getAvg() {
        return Double.parseDouble(avg.get());
    }

    public StringProperty avgProperty() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg.set(String.valueOf(avg));
    }
}
