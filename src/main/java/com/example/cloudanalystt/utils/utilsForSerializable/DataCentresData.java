package com.example.cloudanalystt.utils.utilsForSerializable;

import com.example.cloudanalystt.utils.PhysicalHWDetailsOfDC;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
//
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

public class DataCentresData  implements Serializable {
    private String name;
    private int region;
    private String arch;
    private String OS;
    private String VMM;
    private double costPerVm;
    private double memoryCost;
    private double storageCost;
    private double dataTransferCost;
    private int physicalHWUnits;
    private SerializableList<PhysicalHWDetailsOfDCData> listHwDetailsOfDCS;
    private SerializableList<ServersDCData> listServersDC;


    public DataCentresData(){}

    public DataCentresData(String name, int region, String arch, String OS, String VMM, double costPerVm, double memoryCost, double storageCost, double dataTransferCost, int physicalHWUnits, SerializableList<PhysicalHWDetailsOfDCData> listHwDetailsOfDCS, SerializableList<ServersDCData> listServersDC) {
        this.name = name;
        this.region = region;
        this.arch = arch;
        this.OS = OS;
        this.VMM = VMM;
        this.costPerVm = costPerVm;
        this.memoryCost = memoryCost;
        this.storageCost = storageCost;
        this.dataTransferCost = dataTransferCost;
        this.physicalHWUnits = physicalHWUnits;
        this.listHwDetailsOfDCS = listHwDetailsOfDCS;
        this.listServersDC = listServersDC;
    }

    public SerializableList<ServersDCData> getListServersDC() {
        return listServersDC;
    }

    public void setListServersDC(SerializableList<ServersDCData> listServersDC) {
        this.listServersDC = listServersDC;
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

    public String getArch() {
        return arch;
    }

    public void setArch(String arch) {
        this.arch = arch;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public String getVMM() {
        return VMM;
    }

    public void setVMM(String VMM) {
        this.VMM = VMM;
    }

    public double getCostPerVm() {
        return costPerVm;
    }

    public void setCostPerVm(double costPerVm) {
        this.costPerVm = costPerVm;
    }

    public double getMemoryCost() {
        return memoryCost;
    }

    public void setMemoryCost(double memoryCost) {
        this.memoryCost = memoryCost;
    }

    public double getStorageCost() {
        return storageCost;
    }

    public void setStorageCost(double storageCost) {
        this.storageCost = storageCost;
    }

    public double getDataTransferCost() {
        return dataTransferCost;
    }

    public void setDataTransferCost(double dataTransferCost) {
        this.dataTransferCost = dataTransferCost;
    }

    public int getPhysicalHWUnits() {
        return physicalHWUnits;
    }

    public void setPhysicalHWUnits(int physicalHWUnits) {
        this.physicalHWUnits = physicalHWUnits;
    }

    public SerializableList<PhysicalHWDetailsOfDCData> getListHwDetailsOfDCS() {
        return listHwDetailsOfDCS;
    }

    public void setListHwDetailsOfDCS(SerializableList<PhysicalHWDetailsOfDCData> listHwDetailsOfDCS) {
        this.listHwDetailsOfDCS = listHwDetailsOfDCS;
    }

    @Override
    public String toString() {
        return "DataCentresData{" +
                "name='" + name + '\'' +
                ", region=" + region +
                ", arch='" + arch + '\'' +
                ", OS='" + OS + '\'' +
                ", VMM='" + VMM + '\'' +
                ", costPerVm=" + costPerVm +
                ", memoryCost=" + memoryCost +
                ", storageCost=" + storageCost +
                ", dataTransferCost=" + dataTransferCost +
                ", physicalHWUnits=" + physicalHWUnits +
                ", listHwDetailsOfDCS=" + listHwDetailsOfDCS +
                '}';
    }
}
