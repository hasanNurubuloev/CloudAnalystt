package com.example.cloudanalystt;

import com.example.cloudanalystt.utils.AppDeploymentConfiguration;
import com.example.cloudanalystt.utils.UserBases;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import javafx.collections.ObservableList;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import javax.xml.bind.JAXBContext;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class XMLWriter {

    public void saveToXML(ObservableList<UserBases> listUserBases, ObservableList<AppDeploymentConfiguration> listAppConf) {
        Element platform = new Element("platform");
        platform.setAttribute("version", "4.1");

        // Создаем документ XML
        Document doc = new Document(platform);

        // Создаем элемент zone с атрибутами id и routing
        Element zone = new Element("zone");
        zone.setAttribute("id", "world");
        zone.setAttribute("routing", "Full");

        // Добавляем элемент zone в корневой элемент platform
        platform.addContent(zone);

        // Создаем элемент cluster с атрибутами id, prefix и другими
        for (int i = 0; i < listUserBases.size(); i++) {

            Element cluster = getElement(listUserBases, listAppConf, i);
            zone.addContent(cluster);
        }

        // Добавляем элемент cluster в элемент zone

        // Создаем элемент link с атрибутами bandwidth и latency
        Element link = new Element("link");
        link.setAttribute("id", "link1");
        link.setAttribute("bandwidth", "100kBps");
        link.setAttribute("latency", "10ms");

        // Добавляем элемент link в корневой элемент platform
        platform.addContent(link);

        // Создаем объект XMLOutputter для вывода XML
        XMLOutputter xmlOutput = new XMLOutputter();
        xmlOutput.setFormat(Format.getPrettyFormat());

        try {
            System.out.println("Current working directory: " + System.getProperty("user.dir"));

            // Записываем XML документ в файл
            xmlOutput.output(doc, new FileWriter("output.xml"));
            System.out.println("XML файл успешно создан!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Element getElement(ObservableList<UserBases> listUserBases, ObservableList<AppDeploymentConfiguration> listAppConf, int i) {
        Element cluster = new Element("cluster");
        cluster.setAttribute("id", listUserBases.get(i).getName());
        cluster.setAttribute("prefix", "u-");
        cluster.setAttribute("suffix", ".uz");
        cluster.setAttribute("radical", "0-10");
        cluster.setAttribute("speed", "1Gf");
        cluster.setAttribute("bw", String.valueOf(listAppConf.get(i).getBandwidth()));
        cluster.setAttribute("lat", "50us");
        cluster.setAttribute("router_id", "u-users_router.uz");
        return cluster;
    }
}
