package com.example.cloudanalystt.utils;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ServersDC {
    private StringProperty name;
    private StringProperty prefix;
    private StringProperty count;
    private String code;

    public ServersDC copy() {
        return new ServersDC(this.name.get(), this.prefix.get(), Integer.parseInt(this.count.get()), this.code);
    }

    public ServersDC(String name,  String prefix, int count, String code) {
        this.name = new SimpleStringProperty(name);
        this.prefix = new SimpleStringProperty(prefix);
        this.count = new SimpleStringProperty(String.valueOf(count));
        this.code = code;
    }

    public ServersDC() {
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPrefix() {
        return prefix.get();
    }

    public StringProperty prefixProperty() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix.set(prefix);
    }

    public int getCount() {
        return Integer.parseInt(count.get());
    }

    public StringProperty countProperty() {
        return count;
    }

    public void setCount(int count) {
        this.count.set(String.valueOf(count));
    }

    @Override
    public String toString() {
        return "ServersDC{" +
                "name=" + name +
                ", prefix=" + prefix +
                ", count=" + count +
                ", code='" + code + '\'' +
                '}';
    }
}
