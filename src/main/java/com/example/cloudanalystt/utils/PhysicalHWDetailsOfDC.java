package com.example.cloudanalystt.utils;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class PhysicalHWDetailsOfDC  implements Serializable {
    private SimpleStringProperty id;
    private SimpleStringProperty memory;
    private SimpleStringProperty storage;
    private SimpleStringProperty availableBandwidth;
    private SimpleStringProperty numOfProcessors;
    private SimpleStringProperty processorSpeed;
    private SimpleStringProperty VMPolicy;

    public PhysicalHWDetailsOfDC(int id, int memory, int storage, int availableBandwidth, int numOfProcessors, int processorSpeed, String VMPolicy) {
        this.id = new SimpleStringProperty(String.valueOf(id));
        this.memory =new SimpleStringProperty(String.valueOf(memory));
        this.storage = new SimpleStringProperty(String.valueOf(storage));
        this.availableBandwidth = new SimpleStringProperty(String.valueOf(availableBandwidth));
        this.numOfProcessors = new SimpleStringProperty(String.valueOf(numOfProcessors));
        this.processorSpeed = new SimpleStringProperty(String.valueOf(processorSpeed));
        this.VMPolicy = new SimpleStringProperty(VMPolicy);
    }

    public PhysicalHWDetailsOfDC() {

    }

    public int getId() {
        return Integer.parseInt(id.get());
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(String.valueOf(id));
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
    public int getStorage() {
        return Integer.parseInt(storage.get());
    }

    public SimpleStringProperty storageProperty() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage.set(String.valueOf(storage));
    }
    public int getAvailableBandwidth() {
        return Integer.parseInt(availableBandwidth.get());
    }

    public SimpleStringProperty availableBandwidthProperty() {
        return availableBandwidth;
    }

    public void setAvailableBandwidth(int availableBandwidth) {
        this.availableBandwidth.set(String.valueOf(availableBandwidth));
    }
    public int getNumOfProcessors() {
        return Integer.parseInt(numOfProcessors.get());
    }

    public SimpleStringProperty numOfProcessorsProperty() {
        return numOfProcessors;
    }

    public void setNumOfProcessors(int numOfProcessors) {
        this.numOfProcessors.set(String.valueOf(numOfProcessors));
    }
    public int getProcessorSpeed() {
        return Integer.parseInt(processorSpeed.get());
    }

    public SimpleStringProperty processorSpeedProperty() {
        return processorSpeed;
    }

    public void setProcessorSpeed(int processorSpeed) {
        this.processorSpeed.set(String.valueOf(processorSpeed));
    }
    public String  getVMPolicy() {
        return VMPolicy.get();
    }

    public SimpleStringProperty VMPolicyProperty() {
        return VMPolicy;
    }

    public void setVMPolicy(String  VMPolicy) {
        this.VMPolicy.set(VMPolicy);
    }
}
