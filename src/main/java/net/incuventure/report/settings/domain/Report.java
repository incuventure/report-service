package net.incuventure.report.settings.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

public class Report {

    @XmlAttribute
    String name;

    @XmlAttribute
    String datasourceName;

    @XmlElementWrapper(name="sections")
    @XmlElement(name="section")
    List<ReportSection> sections;

    public Report(String name, String datasourceName) {
        this.name = name;
        this.datasourceName = datasourceName;
    }

    public void addSection(String name, String query) {
        if(sections == null) {
            sections = new ArrayList<ReportSection>();
        }

        sections.add(new ReportSection(name, query));
    }
}
