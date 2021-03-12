package com.crm.techsan.generics;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImp implements ITestListener{
	public ExtentReports report;
	public ExtentTest test;

	
	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReporter=new ExtentSparkReporter("./ExtentReport.html");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Techsan");
		report=new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("OS", "Windows 10");
		report.setSystemInfo("Plateform", "Windows");
		report.setSystemInfo("Enviroment", "Testing Enviroment");
		report.setSystemInfo("Reporter", "Rajiv");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		 test = report.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+" Passed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+" Skipped");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName()+" Failed");
		test.log(Status.FAIL, result.getThrowable());
		String date=new JavaUtil().currentdate().replace(" ", "_").replace(":", "_");
		
		try {
			PageUtilities utils=new PageUtilities();
			String Path = utils.takeScreenShot(result.getMethod().getMethodName()+date);
			test.addScreenCaptureFromPath(Path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
