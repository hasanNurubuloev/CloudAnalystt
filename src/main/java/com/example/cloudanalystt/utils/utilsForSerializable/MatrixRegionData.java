package com.example.cloudanalystt.utils.utilsForSerializable;

import java.io.Serializable;

public class MatrixRegionData implements Serializable {
    int region;
    int region0;
    int region1;
    int region2;
    int region3;
    int region4;
    int region5;

    public MatrixRegionData() {
    }

    public MatrixRegionData(int region, int region0, int region1, int region2, int region3, int region4, int region5) {
        this.region = region;
        this.region0 = region0;
        this.region1 = region1;
        this.region2 = region2;
        this.region3 = region3;
        this.region4 = region4;
        this.region5 = region5;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public int getRegion0() {
        return region0;
    }

    public void setRegion0(int region0) {
        this.region0 = region0;
    }

    public int getRegion1() {
        return region1;
    }

    public void setRegion1(int region1) {
        this.region1 = region1;
    }

    public int getRegion2() {
        return region2;
    }

    public void setRegion2(int region2) {
        this.region2 = region2;
    }

    public int getRegion3() {
        return region3;
    }

    public void setRegion3(int region3) {
        this.region3 = region3;
    }

    public int getRegion4() {
        return region4;
    }

    public void setRegion4(int region4) {
        this.region4 = region4;
    }

    public int getRegion5() {
        return region5;
    }

    public void setRegion5(int region5) {
        this.region5 = region5;
    }
}
