package com.example.cloudanalystt.utils.utilsForSerializable;

import javafx.beans.property.SimpleStringProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
public class AppDeploymentConfigurationData  implements Serializable {
    private String dataCenter;
    private int virtualMachines;
    private int imageSize;
    private int memory;
    private int bandwidth;

    public AppDeploymentConfigurationData(){}

    public AppDeploymentConfigurationData(String dataCenter, int virtualMachines, int imageSize, int memory, int bandwidth) {
        this.dataCenter = dataCenter;
        this.virtualMachines = virtualMachines;
        this.imageSize = imageSize;
        this.memory = memory;
        this.bandwidth = bandwidth;
    }

    public String getDataCenter() {
        return dataCenter;
    }

    public void setDataCenter(String dataCenter) {
        this.dataCenter = dataCenter;
    }

    public int getVirtualMachines() {
        return virtualMachines;
    }

    public void setVirtualMachines(int virtualMachines) {
        this.virtualMachines = virtualMachines;
    }

    public int getImageSize() {
        return imageSize;
    }

    public void setImageSize(int imageSize) {
        this.imageSize = imageSize;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(int bandwidth) {
        this.bandwidth = bandwidth;
    }

    @Override
    public String toString() {
        return "AppDeploymentConfigurationData{" +
                "dataCenter='" + dataCenter + '\'' +
                ", virtualMachines=" + virtualMachines +
                ", imageSize=" + imageSize +
                ", memory=" + memory +
                ", bandwidth=" + bandwidth +
                '}';
    }
}
