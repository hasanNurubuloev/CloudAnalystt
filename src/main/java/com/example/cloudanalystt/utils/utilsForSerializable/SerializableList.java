package com.example.cloudanalystt.utils.utilsForSerializable;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

//import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class SerializableList<T> extends ArrayList<T> implements Serializable {

    public SerializableList(int initialCapacity) {
        super(initialCapacity);
    }

    public SerializableList() {
    }

    public SerializableList(Collection<? extends T> c) {
        super(c);
    }
}
