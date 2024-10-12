package com.demoshop.Listeners;

import java.io.IOException;

import org.testng.ITestContext;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.demoshop.utils.PageActions;
import com.demoshop.utils.ReportUtil;

public class ReportListener implements ITestListener {

	ExtentReports extent = ReportUtil.generateReport();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Pass");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().log(Status.FAIL, result.getThrowable());
		try {
			extentTest.get().addScreenCaptureFromPath(PageActions.getScreenShot(result.getMethod().getMethodName()),result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
