package com.crm.techsan.lead;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.techsan.generics.BaseClass;
@Listeners(com.crm.techsan.generics.ListnerImp.class)
public class Sample extends BaseClass{
@Test (retryAnalyzer=com.crm.techsan.generics.Retry.class)
public void test() {
	Assert.assertTrue(false);
}
}
