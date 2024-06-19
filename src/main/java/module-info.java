module com.example.cloudanalystt {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.xml.bind;
    requires jakarta.activation;
    requires java.desktop;
    requires org.jdom2;
    requires com.fasterxml.jackson.dataformat.xml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires org.dhatim.fastexcel.reader;

//    requires org.apache.poi.poi;
//    requires org.apache.poi.ooxml;
//    requires org.docx4j.core;
//    requires org.docx4j.openxml_objects;
//    requires jakarta.xml.bind;

    opens com.example.cloudanalystt to javafx.fxml;
    exports com.example.cloudanalystt;
    exports com.example.cloudanalystt.utils;
    opens com.example.cloudanalystt.utils to javafx.fxml;
    exports com.example.cloudanalystt.utils.utilsForSerializable;
    opens com.example.cloudanalystt.utils.utilsForSerializable to javafx.fxml;
    exports com.example.cloudanalystt.ui;
    opens com.example.cloudanalystt.ui to javafx.fxml;
}