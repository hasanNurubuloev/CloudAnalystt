package com.example.cloudanalystt.utils;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StateExcel {
    private StringProperty server;
    private StringProperty state;
    private StringProperty startTime;
    private StringProperty endTime;
    private StringProperty durationTime;

    public StateExcel(String server, String state, double startTime, double endTime, double durationTime) {
        this.server = new SimpleStringProperty(server);
        this.state = new SimpleStringProperty(state);
        this.startTime = new SimpleStringProperty(String.valueOf(startTime));
        this.endTime = new SimpleStringProperty(String.valueOf(endTime));
        this.durationTime = new SimpleStringProperty(String.valueOf(durationTime));
    }

    public double getDurationTime() {
        return Double.parseDouble(durationTime.get());
    }

    public StringProperty durationTimeProperty() {
        return durationTime;
    }

    public void setDurationTime(double durationTime) {
        this.durationTime.set(String.valueOf(durationTime));
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

    public String getState() {
        return state.get();
    }

    public StringProperty stateProperty() {
        return state;
    }

    public void setState(String state) {
        this.state.set(state);
    }

    public double getStartTime() {
        return  Double.parseDouble(startTime.get());
    }

    public StringProperty startTimeProperty() {
        return startTime;
    }

    public void setStartTime(double startTime) {
        this.startTime.set(String.valueOf(startTime));
    }

    public double getEndTime() {
        return Double.parseDouble(endTime.get());
    }

    public StringProperty endTimeProperty() {
        return endTime;
    }

    public void setEndTime(double endTime) {
        this.endTime.set(String.valueOf(endTime));
    }
}
