package com.example.cloudanalystt;

import com.example.cloudanalystt.utils.AppDeploymentConfiguration;
import com.example.cloudanalystt.utils.DataCentres;
import com.example.cloudanalystt.utils.UserBases;
import javafx.collections.ObservableList;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileWriter;
import java.io.IOException;

public class XMLWriter {

    public void createPlatformFile(ObservableList<UserBases> listUserBases, ObservableList<AppDeploymentConfiguration> listAppConf, ObservableList<DataCentres> listDataCenters) {
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
        Element users = null;
        for (int i = 0; i < listUserBases.size(); i++) {
            users = getElement(listUserBases, i);
            zone.addContent(users);
        }

        Element dataCenter = new Element("zone");
        dataCenter.setAttribute("id", "datacenter");
        dataCenter.setAttribute("routing", "None");
        zone.addContent(dataCenter);
        for (int i = 0; i < listDataCenters.size(); i++) {
            Element ds = new Element("host");
            ds.setAttribute("id", "ds" + ++i);
            ds.setAttribute("speed", "1Gf");
            dataCenter.addContent(ds);
        }

        Element blades = new Element("blades");
        blades.setAttribute("id", "blades");
        blades.setAttribute("routing", "Full");
        zone.addContent(blades);

        for (int i = 0; i < listDataCenters.getFirst().getListHwDetailsOfDCS().size(); i++) {
            Element pm = new Element("cluster");
            pm.setAttribute("id", "pm" + ++i);
            pm.setAttribute("prefix", "pm1-");
            pm.setAttribute("radical", "0-10");
            pm.setAttribute("suffix", ".pm");
            pm.setAttribute("speed", "20Gf");
            pm.setAttribute("bw", "1000MBps");
            pm.setAttribute("lat", "100us");
            pm.setAttribute("bb_bw", "1GBps");
            pm.setAttribute("bb_lat", "100us");
            pm.setAttribute("router_id", "pm1-pm_router.pm");
            blades.addContent(pm);
        }

        // Добавляем элемент cluster в элемент zone

        // Создаем элемент link с атрибутами bandwidth и latency
        Element link1 = new Element("link");
        link1.setAttribute("id", "link1");
        link1.setAttribute("bandwidth", "100kBps");
        link1.setAttribute("latency", "10ms");
        Element link2 = new Element("link");
        link2.setAttribute("id", "link2");
        link2.setAttribute("bandwidth", "1000MBps");
        link2.setAttribute("latency", "100us");
        Element link3 = new Element("link");
        link3.setAttribute("id", "link3");
        link3.setAttribute("bandwidth", "100kBps");
        link3.setAttribute("latency", "10ms");

        // Добавляем элемент link в корневой элемент platform
        zone.addContent(link1);
        zone.addContent(link2);
        zone.addContent(link3);

        zone.addContent(createZoneRoute(dataCenter.getAttributeValue("id"), users.getAttributeValue("id"),dataCenter.getChild("host").getAttributeValue("id"), users.getAttributeValue("router_id"), link1.getName()));
        zone.addContent(createZoneRoute(dataCenter.getAttributeValue("id"), blades.getAttributeValue("id"),dataCenter.getChild("host").getAttributeValue("id"), blades.getChild("cluster").getAttributeValue("router_id"), link2.getName()));
        zone.addContent(createZoneRoute(blades.getAttributeValue("id"), users.getAttributeValue("id"),blades.getChild("cluster").getAttributeValue("router_id"), users.getAttributeValue("router_id"), link3.getName()));

        // Создаем объект XMLOutputter для вывода XML
        XMLOutputter xmlOutput = new XMLOutputter();
        xmlOutput.setFormat(Format.getPrettyFormat());

        try {
            System.out.println("Current working directory: " + System.getProperty("user.dir"));

            // Записываем XML документ в файл
            xmlOutput.output(doc, new FileWriter("platform.xml"));
            System.out.println("XML файл успешно создан!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Element getElement(ObservableList<UserBases> listUserBases, int i) {
        Element cluster = new Element("cluster");
        cluster.setAttribute("id", listUserBases.get(i).getName());
        cluster.setAttribute("prefix", "u-");
        cluster.setAttribute("suffix", ".uz");
        cluster.setAttribute("radical", "0-" + listUserBases.get(i).getAvgPkOffUsrs());
        cluster.setAttribute("speed", "1Gf");
        cluster.setAttribute("bw", "125MBps");
        cluster.setAttribute("lat", "50us");
        cluster.setAttribute("router_id", "u-users_router.uz");
        return cluster;
    }

    private Element createZoneRoute(String src, String dst, String gw_src, String gw_dst, String linkId) {
        Element zoneRoute = new Element("zoneRoute");
        zoneRoute.setAttribute("src", src);
        zoneRoute.setAttribute("dst", dst);
        zoneRoute.setAttribute("gw_src", gw_src);
        zoneRoute.setAttribute("gw_dst", gw_dst);

        Element linkCtn = new Element("link_ctn");
        linkCtn.setAttribute("id", linkId);

        zoneRoute.addContent(linkCtn);
        return zoneRoute;
    }

    public void createDeploymentFile (ObservableList<DataCentres> listDataCenters){
        // Создаем корневой элемент platform с атрибутом version
        Element platform = new Element("platform");
        platform.setAttribute("version", "4.1");

        // Создаем документ XML
        Document doc = new Document(platform);

        // Добавляем комментарий
        platform.addContent(new org.jdom2.Comment("Need to read all cloudstations"));

        // Создаем элемент actor с атрибутами host и function
        Element actor = new Element("actor");
        actor.setAttribute("host", "cb1");
        actor.setAttribute("function", "cloudBroker");

        var listServerDC = listDataCenters.getFirst().getListServersDC();
        // Добавляем элементы argument с значениями
        for (String value : new String[]{"1", String.valueOf(listServerDC.getFirst().getCount()), String.valueOf(listServerDC.get(1).getCount()), String.valueOf(listServerDC.get(4).getCount()), String.valueOf(listServerDC.get(3).getCount()), String.valueOf(listServerDC.get(2).getCount()), "2", "1000", "10000", "100000000"}) {
            Element argument = new Element("argument");
            argument.setAttribute("value", value);
            actor.addContent(argument);
        }

        // Добавляем элемент actor в корневой элемент platform
        platform.addContent(actor);

        // Создаем объект XMLOutputter для вывода XML
        XMLOutputter xmlOutput = new XMLOutputter();
        xmlOutput.setFormat(Format.getPrettyFormat());

        try {
            System.out.println("Current working directory: " + System.getProperty("user.dir"));

            // Записываем XML документ в файл
            xmlOutput.output(doc, new FileWriter("deployment.xml"));
            System.out.println("XML файл успешно создан!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
