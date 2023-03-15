package com.swiggy.core.listeners;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import java.util.List;

/**
 * Created by: Ashish S on Jun 2021
 * TestNG listener which is used to generate report after execution is over *
 */
public class ReporterListener implements IReporter {
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        IReporter.super.generateReport(xmlSuites, suites, outputDirectory);
        System.out.println("ReporterListener.generateReport: " + xmlSuites.size() + " output dir: " + outputDirectory);
    }
}
