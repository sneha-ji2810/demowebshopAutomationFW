package com.demoshop.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.demoshop.Context.Constants;
public class ReportUtil {

	public static ExtentReports generateReport() {
		//String reportPath= Constants.EXTENTREPORT;
        String reportPath="C:\\Users\\jijin\\git\\demoweb\\DemoWebShopFramework\\Reports\\AutomationReport.html";
		ExtentSparkReporter reporter = new 	ExtentSparkReporter(reportPath);
        reporter.config().setReportName("Obzqurazone DemoWEBAutomation");
        reporter.config().setDocumentTitle("Obsqura Zone");
        
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("QA","Sneha");
        extent.setSystemInfo("Environment","PRE-PROD");
        return extent;
        
		
	}
	
}
