package com.demoshop.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.ReportUtil;

public class ReportListener implements ITestListener {

	ExtentReports extent = ReportUtil.generateReport();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Pass");
	}
	
	public void onTestFailed(ITestResult result) {
		extentTest.get().log(Status.FAIL, result.getThrowable());
	}
	
	public void onTestFinish(ITestContext context) {
		extent.flush();
	}
}
