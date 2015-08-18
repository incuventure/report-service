package net.incuventure.report.settings.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="report-config")
public class ReportConfig {

    @XmlElementWrapper(name="datasources")
    @XmlElement(name="datasource")
    List<Datasource> datasources;

    @XmlElementWrapper(name="reports")
    @XmlElement(name="report")
    List<Report> reports;

    public void addDataSource(Datasource datasource) {
        if(datasources == null) {
            datasources = new ArrayList<Datasource>();
        }

        datasources.add(datasource);
    }

    public void addReport(Report report) {

        if(reports == null) {
            reports = new ArrayList<Report>();
        }

        reports.add(report);

    }


}
