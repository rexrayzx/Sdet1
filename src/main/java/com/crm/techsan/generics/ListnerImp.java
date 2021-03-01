package com.crm.techsan.generics;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImp implements ITestListener{

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String date=new JavaUtil().currentdate().replace(" ", "_").replace(":", "_");
		
		try {
			PageUtilities utils=new PageUtilities();
			utils.takeScreenShot(result.getMethod().getMethodName()+date);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
