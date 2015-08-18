package net.incuventure.settings;

import net.incuventure.report.settings.domain.Datasource;
import net.incuventure.report.settings.domain.Report;
import net.incuventure.report.settings.domain.ReportConfig;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class TestSettingsBuilder {

    @Test
    public void testCreateConfig() {

        try {

            File file = new File("./rulesx.xml");

            ReportConfig reportConfig = new ReportConfig();

            reportConfig.addDataSource(
                    new Datasource("employeesDS",
                            "com.mysql.jdbc.jdbc2.optional.MysqlDataSource",
                            "localhost",
                            "3306",
                            "employees",
                            "test",
                            "test")
            );

            Report report = new Report("employees", "employeeDS");
            report.addSection("details", "select * from employees");

            reportConfig.addReport(report);


            JAXBContext jaxbContext = JAXBContext.newInstance(ReportConfig.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

//            jaxbMarshaller.marshal(reportConfig, file);
            jaxbMarshaller.marshal(reportConfig, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}
