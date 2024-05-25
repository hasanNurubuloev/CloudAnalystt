package com.example.cloudanalystt.utils;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class MatrixRegion {
    SimpleStringProperty region;
    SimpleStringProperty region0;
    SimpleStringProperty region1;
    SimpleStringProperty region2;
    SimpleStringProperty region3;
    SimpleStringProperty region4;
    SimpleStringProperty region5;

    public MatrixRegion copy () {
        return new MatrixRegion(Integer.parseInt(this.region.get()), Integer.parseInt(this.region0.get()), Integer.parseInt(this.region1.get()), Integer.parseInt(this.region2.get()), Integer.parseInt(this.region3.get()), Integer.parseInt(this.region4.get()), Integer.parseInt(this.region5.get()));
    }

    public MatrixRegion(int region, int region0, int region1, int region2, int region3, int region4, int region5) {
        this.region = new SimpleStringProperty(String.valueOf(region));
        this.region0 = new SimpleStringProperty(String.valueOf(region0));
        this.region1 = new SimpleStringProperty(String.valueOf(region1));
        this.region2 = new SimpleStringProperty(String.valueOf(region2));
        this.region3 = new SimpleStringProperty(String.valueOf(region3));
        this.region4 = new SimpleStringProperty(String.valueOf(region4));
        this.region5 = new SimpleStringProperty(String.valueOf(region5));
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

    public int getRegion0() {
        return Integer.parseInt(region0.get());
    }

    public SimpleStringProperty region0Property() {
        return region0;
    }

    public void setRegion0(int region0) {
        this.region0.set(String.valueOf(region0));
    }

    public int getRegion1() {
        return Integer.parseInt(region1.get());
    }

    public SimpleStringProperty region1Property() {
        return region1;
    }

    public void setRegion1(int region1) {
        this.region1.set(String.valueOf(region1));
    }

    public int getRegion2() {
        return Integer.parseInt(region2.get());
    }

    public SimpleStringProperty region2Property() {
        return region2;
    }

    public void setRegion2(int region2) {
        this.region2.set(String.valueOf(region2));
    }

    public int getRegion3() {
        return Integer.parseInt(region3.get());
    }

    public SimpleStringProperty region3Property() {
        return region3;
    }

    public void setRegion3(int region3) {
        this.region3.set(String.valueOf(region3));
    }

    public int getRegion4() {
        return Integer.parseInt(region4.get());
    }

    public SimpleStringProperty region4Property() {
        return region4;
    }

    public void setRegion4(int region4) {
        this.region4.set(String.valueOf(region4));
    }

    public int getRegion5() {
        return Integer.parseInt(region5.get());
    }

    public SimpleStringProperty region5Property() {
        return region5;
    }

    public void setRegion5(int region5) {
        this.region5.set(String.valueOf(region5));
    }
}
