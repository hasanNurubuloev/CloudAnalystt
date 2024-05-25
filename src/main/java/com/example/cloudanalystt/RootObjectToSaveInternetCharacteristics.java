package com.example.cloudanalystt;

import com.example.cloudanalystt.utils.utilsForSerializable.MatrixRegionData;

import java.io.Serializable;
import java.util.List;

public class RootObjectToSaveInternetCharacteristics  implements Serializable {
    List<MatrixRegionData> listDelayMatrix;
    List<MatrixRegionData> listBandwidthMatrix;

    public RootObjectToSaveInternetCharacteristics(List<MatrixRegionData> listDelayMatrix, List<MatrixRegionData> listBandwidthMatrix) {
        this.listDelayMatrix = listDelayMatrix;
        this.listBandwidthMatrix = listBandwidthMatrix;
    }

    public RootObjectToSaveInternetCharacteristics() {
    }

    public List<MatrixRegionData> getListBandwidthMatrix() {
        return listBandwidthMatrix;
    }

    public void setListBandwidthMatrix(List<MatrixRegionData> listBandwidthMatrix) {
        this.listBandwidthMatrix = listBandwidthMatrix;
    }

    public List<MatrixRegionData> getListDelayMatrix() {
        return listDelayMatrix;
    }

    public void setListDelayMatrix(List<MatrixRegionData> listDelayMatrix) {
        this.listDelayMatrix = listDelayMatrix;
    }
}
