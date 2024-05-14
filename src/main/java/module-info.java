module com.example.cloudanalystt {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.xml.bind;
    requires org.glassfish.jaxb.runtime;
    requires jakarta.activation;
    requires java.desktop;


    opens com.example.cloudanalystt to javafx.fxml;
    exports com.example.cloudanalystt;
    exports com.example.cloudanalystt.utils;
    opens com.example.cloudanalystt.utils to javafx.fxml;
    exports com.example.cloudanalystt.utils.utilsForSerializable;
    opens com.example.cloudanalystt.utils.utilsForSerializable to javafx.fxml;
}