package com.example.cloudanalystt.utils;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

public class UserBases implements Serializable {
    private SimpleStringProperty name;
    private SimpleStringProperty region;
    private SimpleStringProperty requestsPrUsPrHr;
    private SimpleStringProperty dataSzPrRq;
    private SimpleStringProperty peakHrStart;
    private SimpleStringProperty peakHrEnd;
    private SimpleStringProperty avgPkUsrs;
    private SimpleStringProperty avgPkOffUsrs;

    public UserBases copy() {

        return new UserBases(this.name.get(), Integer.parseInt(this.region.get()), Integer.parseInt(this.requestsPrUsPrHr.get()), Integer.parseInt(this.dataSzPrRq.get()), Integer.parseInt(this.peakHrStart.get()), Integer.parseInt(this.peakHrEnd.get()), Integer.parseInt(this.avgPkUsrs.get()), Integer.parseInt(this.avgPkOffUsrs.get()));
    }

    public UserBases(String name, int region, int requsetsPrUsPrHr, int dataSzPrRq, int peakHrStart, int peakHrEnd, int avgPkUsrs, int avgPkOffUsrs) {
        this.name = new SimpleStringProperty(name);
        this.region = new SimpleStringProperty(String.valueOf(region));
        this.requestsPrUsPrHr = new SimpleStringProperty(String.valueOf(requsetsPrUsPrHr));
        this.dataSzPrRq = new SimpleStringProperty(String.valueOf(dataSzPrRq));
        this.peakHrStart = new SimpleStringProperty(String.valueOf(peakHrStart));
        this.peakHrEnd = new SimpleStringProperty(String.valueOf(peakHrEnd));
        this.avgPkUsrs = new SimpleStringProperty(String.valueOf(avgPkUsrs));
        this.avgPkOffUsrs = new SimpleStringProperty(String.valueOf(avgPkOffUsrs));
    }

    public UserBases() {

    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getName() {
        return name.get();
    }


    public void setName(String name) {
        this.name.set(name);
    }

    public int getRegion() {
        return Integer.parseInt(region.get());
    }


    public SimpleStringProperty regionProperty() {
        return region;
    }

    public void setRegion(int region) {
        this.region.set(String.valueOf(region));
    }

    public int getRequestsPrUsPrHr() {
        return Integer.parseInt(requestsPrUsPrHr.get());
    }

    public SimpleStringProperty requestsPrUsPrHrProperty() {
        return requestsPrUsPrHr;
    }

    public void setRequestsPrUsPrHr(int requestsPrUsPrHr) {
        this.requestsPrUsPrHr.set(String.valueOf(requestsPrUsPrHr));
    }

    public int getDataSzPrRq() {
        return Integer.parseInt(dataSzPrRq.get());
    }

    public SimpleStringProperty dataSzPrRqProperty() {
        return dataSzPrRq;
    }

    public void setDataSzPrRq(int dataSzPrRq) {
        this.dataSzPrRq.set(String.valueOf(dataSzPrRq));
    }

    public int getPeakHrStart() {
        return Integer.parseInt(peakHrStart.get());
    }

    public SimpleStringProperty peakHrStartProperty() {
        return peakHrStart;
    }

    public void setPeakHrStart(int peakHrStart) {
        this.peakHrStart.set(String.valueOf(peakHrStart));
    }

    public int getPeakHrEnd() {
        return Integer.parseInt(peakHrEnd.get());
    }

    public SimpleStringProperty peakHrEndProperty() {
        return peakHrEnd;
    }

    public void setPeakHrEnd(int peakHrEnd) {
        this.peakHrEnd.set(String.valueOf(peakHrEnd));
    }

    public int getAvgPkUsrs() {
        return Integer.parseInt(avgPkUsrs.get());
    }

    public SimpleStringProperty avgPkUsrsProperty() {
        return avgPkUsrs;
    }

    public void setAvgPkUsrs(int avgPkUsrs) {
        this.avgPkUsrs.set(String.valueOf(avgPkUsrs));
    }

    public int getAvgPkOffUsrs() {
        return Integer.parseInt(avgPkOffUsrs.get());
    }

    public SimpleStringProperty avgPkOffUsrsProperty() {
        return avgPkOffUsrs;
    }

    public void setAvgPkOffUsrs(int avgPkOffUsrs) {
        this.avgPkOffUsrs.set(String.valueOf(avgPkOffUsrs));
    }

    @Override
    public String toString() {
        return "UserBases{" +
                "name=" + name +
                ", region=" + region +
                ", requsetsPrUsPrHr=" + requestsPrUsPrHr +
                ", dataSzPrRq=" + dataSzPrRq +
                ", peakHrStart=" + peakHrStart +
                ", peakHrEnd=" + peakHrEnd +
                ", avgPkUsrs=" + avgPkUsrs +
                ", avgPkOffUsrs=" + avgPkOffUsrs +
                '}';
    }
}
