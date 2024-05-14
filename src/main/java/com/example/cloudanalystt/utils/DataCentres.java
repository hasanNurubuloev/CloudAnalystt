package com.example.cloudanalystt.utils;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

import java.io.Serializable;

public class DataCentres  implements Serializable {
    private SimpleStringProperty name;
    private SimpleStringProperty region;
    private SimpleStringProperty arch;
    private SimpleStringProperty OS;
    private SimpleStringProperty VMM;
    private SimpleStringProperty costPerVm;
    private SimpleStringProperty memoryCost;
    private SimpleStringProperty storageCost;
    private SimpleStringProperty dataTransferCost;
    private SimpleStringProperty physicalHWUnits;
    private ObservableList<PhysicalHWDetailsOfDC> listHwDetailsOfDCS;
    private ObservableList<ServersDC> listServersDC;


public DataCentres(String name, int region,String arch, String OS, String VMM, double costPerVm, double memoryCost, double storageCost, double dataTransferCost, int physicalHWUnits,  ObservableList<PhysicalHWDetailsOfDC> listHwDetailsOfDCS, ObservableList<ServersDC> listServersDC) {
        this.name = new SimpleStringProperty(name);
        this.region = new SimpleStringProperty(String.valueOf(region));
        this.arch = new SimpleStringProperty(arch);
        this.OS = new SimpleStringProperty(OS);
        this.VMM = new SimpleStringProperty(VMM);
        this.costPerVm = new SimpleStringProperty(String.valueOf(costPerVm));
        this.memoryCost = new SimpleStringProperty(String.valueOf(memoryCost));
        this.storageCost = new SimpleStringProperty(String.valueOf(storageCost));
        this.dataTransferCost = new SimpleStringProperty(String.valueOf(dataTransferCost));
        this.physicalHWUnits = new SimpleStringProperty(String.valueOf(physicalHWUnits));
        this.listHwDetailsOfDCS = listHwDetailsOfDCS;
        this.listServersDC = listServersDC;
    }

    public ObservableList<ServersDC> getListServersDC() {
        return listServersDC;
    }

    public void setListServersDC(ObservableList<ServersDC> listServersDC) {
        this.listServersDC = listServersDC;
    }

    public ObservableList<PhysicalHWDetailsOfDC> getListHwDetailsOfDCS() {
        return listHwDetailsOfDCS;
    }

    public void setListHwDetailsOfDCS(ObservableList<PhysicalHWDetailsOfDC> listHwDetailsOfDCS) {
        this.listHwDetailsOfDCS = listHwDetailsOfDCS;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
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

    public String getArch() {
        return arch.get();
    }

    public SimpleStringProperty archProperty() {
        return arch;
    }

    public void setArch(String arch) {
        this.arch.set(arch);
    }

    public String getOS() {
        return OS.get();
    }

    public SimpleStringProperty OSProperty() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS.set(OS);
    }

    public String getVMM() {
        return VMM.get();
    }

    public SimpleStringProperty VMMProperty() {
        return VMM;
    }

    public void setVMM(String VMM) {
        this.VMM.set(VMM);
    }

    public Double getCostPerVm() {
        return Double.parseDouble(costPerVm.get());
    }


    public SimpleStringProperty costPerVmProperty() {
        return costPerVm;
    }

    public void setCostPerVm(double region) {
        this.costPerVm.set(String.valueOf(region));
    }

    public double getMemoryCost() {
        return Double.parseDouble(memoryCost.get());
    }

    public SimpleStringProperty memoryCostProperty() {
        return memoryCost;
    }

    public void setMemoryCost(double memoryCost) {
        this.memoryCost.set(String.valueOf(memoryCost));
    }

    public double getStorageCost() {
        return Double.parseDouble(storageCost.get());
    }

    public SimpleStringProperty storageCostProperty() {
        return storageCost;
    }

    public void setStorageCost(double storageCost) {
        this.storageCost.set(String.valueOf(storageCost));
    }

    public double getDataTransferCost() {
        return Double.parseDouble(dataTransferCost.get());
    }

    public SimpleStringProperty dataTransferCostProperty() {
        return dataTransferCost;
    }

    public void setDataTransferCost(double dataTransferCost) {
        this.dataTransferCost.set(String.valueOf(dataTransferCost));
    }

    public int getPhysicalHWUnits() {
        return Integer.parseInt(physicalHWUnits.get());
    }

    public SimpleStringProperty physicalHWUnitsProperty() {
        return physicalHWUnits;
    }

    public void setPhysicalHWUnits(int physicalHWUnits) {
        this.physicalHWUnits.set(String.valueOf(physicalHWUnits));
    }
}
