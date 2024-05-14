package com.example.cloudanalystt.utils.utilsForSerializable;

import javafx.beans.property.StringProperty;

public class ServersDCData {
    private String name;
    private String prefix;
    private int count;
    private String code;

    public ServersDCData(String name ,String prefix, int count, String code) {
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
