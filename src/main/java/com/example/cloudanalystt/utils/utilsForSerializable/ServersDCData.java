package com.example.cloudanalystt.utils.utilsForSerializable;

import java.io.Serializable;

public class ServersDCData implements Serializable {
    private String name;
    private String prefix;
    private int count;
    private String code;

    public ServersDCData(String name, String prefix, int count, String code) {
        this.name = name;
        this.prefix = prefix;
        this.count = count;
        this.code = code;
    }

    public ServersDCData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
