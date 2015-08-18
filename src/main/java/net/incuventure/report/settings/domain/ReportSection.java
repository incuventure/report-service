package net.incuventure.report.settings.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlValue;

public class ReportSection {

    @XmlAttribute
    String name;

    @XmlElement
    String query;

    //List<String> parameters;


    public ReportSection(String name, String query) {
        this.name = name;
        this.query = query;
    }
}
