package com.example.cloudanalystt;

import com.example.cloudanalystt.utils.utilsForSerializable.*;
//import jakarta.xml.bind.annotation.XmlRootElement;

//import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

//@XmlRootElement
public class RootObjectToSaveData implements Serializable {
    private List<UserBaseData> listUserBases;
    private List<AppDeploymentConfigurationData> listAppDeploymentConf;
    private List<DataCentresData> listDataCentres;
    private AdvancedData advancedData;

    //------data of comboBoxes in mainConf
    double valueSimulationDuration;
    String simulationDuration;
    String serviceBrokerPolicy;

    public RootObjectToSaveData() {
    }

    public RootObjectToSaveData(List<UserBaseData> listUserBases, List<AppDeploymentConfigurationData> listAppDeploymentConf, List<DataCentresData> listDataCentres, AdvancedData advancedData, double valueSimulationDuration, String simulationDuration, String serviceBrokerPolicy) {
        this.listUserBases = listUserBases;
        this.listAppDeploymentConf = listAppDeploymentConf;
        this.listDataCentres = listDataCentres;
        this.advancedData = advancedData;
        this.valueSimulationDuration = valueSimulationDuration;
        this.simulationDuration = simulationDuration;
        this.serviceBrokerPolicy = serviceBrokerPolicy;
    }

    public double getValueSimulationDuration() {
        return valueSimulationDuration;
    }

    public void setValueSimulationDuration(double valueSimulationDuration) {
        this.valueSimulationDuration = valueSimulationDuration;
    }

    public String getSimulationDuration() {
        return simulationDuration;
    }

    public void setSimulationDuration(String simulationDuration) {
        this.simulationDuration = simulationDuration;
    }

    public String getServiceBrokerPolicy() {
        return serviceBrokerPolicy;
    }

    public void setServiceBrokerPolicy(String serviceBrokerPolicy) {
        this.serviceBrokerPolicy = serviceBrokerPolicy;
    }

    public AdvancedData getAdvancedData() {
        return advancedData;
    }

    public void setAdvancedData(AdvancedData advancedData) {
        this.advancedData = advancedData;
    }

    public List<UserBaseData> getListUserBases() {
        return listUserBases;
    }

    public void setListUserBases(List<UserBaseData> listUserBases) {
        this.listUserBases = listUserBases;
    }

    public List<AppDeploymentConfigurationData> getListAppDeploymentConf() {
        return listAppDeploymentConf;
    }

    public void setListAppDeploymentConf(List<AppDeploymentConfigurationData> listAppDeploymentConf) {
        this.listAppDeploymentConf = listAppDeploymentConf;
    }

    public List<DataCentresData> getListDataCentres() {
        return listDataCentres;
    }

    public void setListDataCentres(List<DataCentresData> listDataCentres) {
        this.listDataCentres = listDataCentres;
    }

    @Override
    public String toString() {
        return "RootObjectToSaveData{" +
                "listUserBases=" + Arrays.asList(listUserBases) +
                ", listAppDeploymentConf=" + Arrays.asList(listAppDeploymentConf) +
                ", listDataCentres=" + Arrays.asList(listDataCentres) +
                ", advancedData=" + advancedData +
                ", valueSimulationDuration=" + valueSimulationDuration +
                ", simulationDuration='" + simulationDuration + '\'' +
                ", serviceBrokerPolicy='" + serviceBrokerPolicy + '\'' +
                '}';
    }
}
