package net.incuventure.report.settings.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Datasource {

    @XmlAttribute
    String name;

    @XmlElement
    String datasourceClassName;

    @XmlElement
    String server;

    @XmlElement
    String port;

    @XmlElement
    String databaseName;

    @XmlElement
    String userid;

    @XmlElement
    String password;

    public Datasource(String name, String datasourceClassName, String server, String port, String databaseName, String userid, String password) {
        this.name = name;
        this.datasourceClassName = datasourceClassName;
        this.server = server;
        this.port = port;
        this.databaseName = databaseName;
        this.userid = userid;
        this.password = password;
    }
}
