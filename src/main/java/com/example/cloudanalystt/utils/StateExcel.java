package com.example.cloudanalystt.utils;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StateExcel {
    private StringProperty server;
    private StringProperty state;
    private StringProperty startTime;
    private StringProperty endTime;
    private StringProperty durationTime;

    public StateExcel(String server, String state, float startTime, float endTime, float durationTime) {
        this.server = new SimpleStringProperty(server);
        this.state = new SimpleStringProperty(state);
        this.startTime = new SimpleStringProperty(String.valueOf(startTime));
        this.endTime = new SimpleStringProperty(String.valueOf(endTime));
        this.durationTime = new SimpleStringProperty(String.valueOf(durationTime));
    }

    public float getDurationTime() {
        return Float.parseFloat(durationTime.get());
    }

    public StringProperty durationTimeProperty() {
        return durationTime;
    }

    public void setDurationTime(float durationTime) {
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

    public float getStartTime() {
        return  Float.parseFloat(startTime.get());
    }

    public StringProperty startTimeProperty() {
        return startTime;
    }

    public void setStartTime(float startTime) {
        this.startTime.set(String.valueOf(startTime));
    }

    public float getEndTime() {
        return Float.parseFloat(endTime.get());
    }

    public StringProperty endTimeProperty() {
        return endTime;
    }

    public void setEndTime(float endTime) {
        this.endTime.set(String.valueOf(endTime));
    }
}
