package com.example.cloudanalystt.utils.utilsForSerializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

public class AdvancedData implements Serializable {
    int usGroupingFactorInUB;
    int requestGroupingFactorInDC;
    int executableInstructionLengthPrReq;
    String LBPolicy;

    public AdvancedData() {
    }

    public AdvancedData(int usGroupingFactorInUB, int requestGroupingFactorInDC, int executableInstructionLengthPrReq, String LBPolicy) {
        this.usGroupingFactorInUB = usGroupingFactorInUB;
        this.requestGroupingFactorInDC = requestGroupingFactorInDC;
        this.executableInstructionLengthPrReq = executableInstructionLengthPrReq;
        this.LBPolicy = LBPolicy;
    }

    public int getUsGroupingFactorInUB() {
        return usGroupingFactorInUB;
    }

    public void setUsGroupingFactorInUB(int usGroupingFactorInUB) {
        this.usGroupingFactorInUB = usGroupingFactorInUB;
    }

    public int getRequestGroupingFactorInDC() {
        return requestGroupingFactorInDC;
    }

    public void setRequestGroupingFactorInDC(int requestGroupingFactorInDC) {
        this.requestGroupingFactorInDC = requestGroupingFactorInDC;
    }

    public int getExecutableInstructionLengthPrReq() {
        return executableInstructionLengthPrReq;
    }

    public void setExecutableInstructionLengthPrReq(int executableInstructionLengthPrReq) {
        this.executableInstructionLengthPrReq = executableInstructionLengthPrReq;
    }

    public String getLBPolicy() {
        return LBPolicy;
    }

    public void setLBPolicy(String LBPolicy) {
        this.LBPolicy = LBPolicy;
    }

    @Override
    public String toString() {
        return "AdvancedData{" +
                "usGroupingFactorInUB=" + usGroupingFactorInUB +
                ", requestGroupingFactorInDC=" + requestGroupingFactorInDC +
                ", executableInstructionLengthPrReq=" + executableInstructionLengthPrReq +
                ", LBPolicy='" + LBPolicy + '\'' +
                '}';
    }
}
