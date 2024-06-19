package com.example.cloudanalystt.utils.utilsForSerializable;

import javafx.beans.property.SimpleStringProperty;

//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

public class PhysicalHWDetailsOfDCData  implements Serializable {
    private int id;
    private int memory;
    private int storage;
    private int availableBandwidth;
    private int numOfProcessors;
    private int processorSpeed;
    private String VMPolicy;

    public PhysicalHWDetailsOfDCData(){}

    public PhysicalHWDetailsOfDCData(int id, int memory, int storage, int availableBandwidth, int numOfProcessors, int processorSpeed, String VMPolicy) {
        this.id = id;
        this.memory = memory;
        this.storage = storage;
        this.availableBandwidth = availableBandwidth;
        this.numOfProcessors = numOfProcessors;
        this.processorSpeed = processorSpeed;
        this.VMPolicy = VMPolicy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getAvailableBandwidth() {
        return availableBandwidth;
    }

    public void setAvailableBandwidth(int availableBandwidth) {
        this.availableBandwidth = availableBandwidth;
    }

    public int getNumOfProcessors() {
        return numOfProcessors;
    }

    public void setNumOfProcessors(int numOfProcessors) {
        this.numOfProcessors = numOfProcessors;
    }

    public int getProcessorSpeed() {
        return processorSpeed;
    }

    public void setProcessorSpeed(int processorSpeed) {
        this.processorSpeed = processorSpeed;
    }

    public String getVMPolicy() {
        return VMPolicy;
    }

    public void setVMPolicy(String VMPolicy) {
        this.VMPolicy = VMPolicy;
    }

    @Override
    public String toString() {
        return "PhysicalHWDetailsOfDCData{" +
                "id=" + id +
                ", memory=" + memory +
                ", storage=" + storage +
                ", availableBandwidth=" + availableBandwidth +
                ", numOfProcessors=" + numOfProcessors +
                ", processorSpeed=" + processorSpeed +
                ", VMPolicy='" + VMPolicy + '\'' +
                '}';
    }
}
