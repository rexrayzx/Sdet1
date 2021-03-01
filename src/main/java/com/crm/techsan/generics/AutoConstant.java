package com.crm.techsan.generics;
/**
 * 
 * @author Rajiv
 *
 */
public interface AutoConstant {
	String currentpath=System.getProperty("user.dir");
	public int explicitlywaitwait=20;
	public int implicitlywaitwait=10;
	String propertyFilePath=currentpath+"//src/test//resources//data.properties";
	String excelpath=currentpath+"//src/test//resources//TestData.xlsx";
	String jdbchost="jdbc:mysql://localhost:3306/rajivdb\",\"root\",\"rajiv";
	String screenshotpath=currentpath+"//Screenshot//";
}
