package com.example.cloudanalystt.utils.utilsForSerializable;

import javafx.beans.property.SimpleStringProperty;

//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

public class UserBaseData implements Serializable {
    private String name;
    private int region;
    private int requsetsPrUsPrHr;
    private int dataSzPrRq;
    private int peakHrStart;
    private int peakHrEnd;
    private int avgPkUsrs;
    private int avgPkOffUsrs;


    public UserBaseData() {
    }

    ;

    public UserBaseData(String name, int region, int requsetsPrUsPrHr, int dataSzPrRq, int peakHrStart, int peakHrEnd, int avgPkUsrs, int avgPkOffUsrs) {
        this.name = name;
        this.region = region;
        this.requsetsPrUsPrHr = requsetsPrUsPrHr;
        this.dataSzPrRq = dataSzPrRq;
        this.peakHrStart = peakHrStart;
        this.peakHrEnd = peakHrEnd;
        this.avgPkUsrs = avgPkUsrs;
        this.avgPkOffUsrs = avgPkOffUsrs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public int getRequsetsPrUsPrHr() {
        return requsetsPrUsPrHr;
    }

    public void setRequsetsPrUsPrHr(int requsetsPrUsPrHr) {
        this.requsetsPrUsPrHr = requsetsPrUsPrHr;
    }

    public int getDataSzPrRq() {
        return dataSzPrRq;
    }

    public void setDataSzPrRq(int dataSzPrRq) {
        this.dataSzPrRq = dataSzPrRq;
    }

    public int getPeakHrStart() {
        return peakHrStart;
    }

    public void setPeakHrStart(int peakHrStart) {
        this.peakHrStart = peakHrStart;
    }

    public int getPeakHrEnd() {
        return peakHrEnd;
    }

    public void setPeakHrEnd(int peakHrEnd) {
        this.peakHrEnd = peakHrEnd;
    }

    public int getAvgPkUsrs() {
        return avgPkUsrs;
    }

    public void setAvgPkUsrs(int avgPkUsrs) {
        this.avgPkUsrs = avgPkUsrs;
    }

    public int getAvgPkOffUsrs() {
        return avgPkOffUsrs;
    }

    public void setAvgPkOffUsrs(int avgPkOffUsrs) {
        this.avgPkOffUsrs = avgPkOffUsrs;
    }

    @Override
    public String toString() {
        return "UserBaseData{" +
                "name='" + name + '\'' +
                ", region=" + region +
                ", requsetsPrUsPrHr=" + requsetsPrUsPrHr +
                ", dataSzPrRq=" + dataSzPrRq +
                ", peakHrStart=" + peakHrStart +
                ", peakHrEnd=" + peakHrEnd +
                ", avgPkUsrs=" + avgPkUsrs +
                ", avgPkOffUsrs=" + avgPkOffUsrs +
                '}';
    }
}
