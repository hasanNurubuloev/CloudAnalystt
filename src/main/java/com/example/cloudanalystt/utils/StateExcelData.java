package com.example.cloudanalystt.utils;

public class StateExcelData {
    private String type;
    private String actor;
    private String type1;
    private float startTime;
    private float endTime;
    private float durationTime;
    private int level;
    private String state;

    public StateExcelData(String type, String actor, String type1 , float startTime, float endTime, float durationTime, int level, String state) {
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

    public float getStartTime() {
        return startTime;
    }

    public void setStartTime(float startTime) {
        this.startTime = startTime;
    }

    public float getEndTime() {
        return endTime;
    }

    public void setEndTime(float endTime) {
        this.endTime = endTime;
    }

    public float getDurationTime() {
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
