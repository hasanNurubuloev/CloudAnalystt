package com.example.cloudanalystt.utils;

public class StateExcelData {
    private String type;
    private String actor;
    private String type1;
    private double startTime;
    private double endTime;
    private double durationTime;
    private int level;
    private String state;

    public StateExcelData(String type, String actor, String type1 , double startTime, double endTime, double durationTime, int level, String state) {
        this.type = type;
        this.actor = actor;
        this.type1 = type1;
        this.startTime = startTime;
        this.endTime = endTime;
        this.durationTime = durationTime;
        this.level = level;
        this.state = state;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public double getStartTime() {
        return startTime;
    }

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    public double getEndTime() {
        return endTime;
    }

    public void setEndTime(double endTime) {
        this.endTime = endTime;
    }

    public double getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(float durationTime) {
        this.durationTime = durationTime;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "StateExcelData{" +
                "type='" + type + '\'' +
                ", actor='" + actor + '\'' +
                ", type1='" + type1 + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", durationTime=" + durationTime +
                ", level=" + level +
                ", state='" + state + '\'' +
                '}';
    }
}
