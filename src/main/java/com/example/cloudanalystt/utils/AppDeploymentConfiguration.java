package com.example.cloudanalystt.utils;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class AppDeploymentConfiguration implements Serializable  {
    private SimpleStringProperty dataCenter;
    private SimpleStringProperty virtualMachines;
    private SimpleStringProperty imageSize;
    private SimpleStringProperty memory;
    private SimpleStringProperty bandwidth;

    public AppDeploymentConfiguration copy() {
        return new AppDeploymentConfiguration(this.dataCenter.get(), Integer.parseInt(this.virtualMachines.get()), Integer.parseInt(this.imageSize.get()), Integer.parseInt(this.memory.get()), Integer.parseInt(this.bandwidth.get()));
    }

    public AppDeploymentConfiguration(String dataCenter, int virtualMachines, int imageSize, int memory, int bandwidth) {
        this.dataCenter = new SimpleStringProperty(dataCenter);
        this.virtualMachines = new SimpleStringProperty(String.valueOf(virtualMachines));
        this.imageSize = new SimpleStringProperty(String.valueOf(imageSize));
        this.memory = new SimpleStringProperty(String.valueOf(memory));
        this.bandwidth = new SimpleStringProperty(String.valueOf(bandwidth));
    }

    public String getDataCenter() {
        return dataCenter.get();
    }

    public SimpleStringProperty dataCenterProperty() {
        return dataCenter;
    }

    public void setDataCenter(String dataCenter) {
        this.dataCenter.set(dataCenter);
    }

    public int getVirtualMachines() {
        return Integer.parseInt(virtualMachines.get());
    }

    public SimpleStringProperty virtualMachinesProperty() {
        return virtualMachines;
    }

    public void setVirtualMachines(int virtualMachines) {
        this.virtualMachines.set(String.valueOf(virtualMachines));
    }

    public int getImageSize() {
        return Integer.parseInt(imageSize.get());
    }

    public SimpleStringProperty imageSizeProperty() {
        return imageSize;
    }

    public void setImageSize(int imageSize) {
        this.imageSize.set(String.valueOf(imageSize));
    }

    public int getMemory() {
        return Integer.parseInt(memory.get());
    }

    public SimpleStringProperty memoryProperty() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory.set(String.valueOf(memory));
    }

    public int getBandwidth() {
        return Integer.parseInt(bandwidth.get());
    }

    public SimpleStringProperty bandwidthProperty() {
        return bandwidth;
    }

    public void setBandwidth(int bandwidth) {
        this.bandwidth.set(String.valueOf(bandwidth));
    }
}
