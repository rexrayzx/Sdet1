package Scripts;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.techsan.generics.ExcelUtilities;

public class DataProviderTestN {
	String sheetName="bookTicketTest";
	String filePath="./Data/testData.xlsx";
	@Test(dataProvider = "getData")
	public void testData(String src, String dst) {
		System.out.println("sorce " +src+ "destination " +dst);
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable{
		ExcelUtilities excel=new ExcelUtilities();
		int rowIndex = excel.getRowCount(sheetName);
		Object[][]objArr=new Object[rowIndex][2];
		for(int i=0; i<rowIndex;i++) {
			objArr[i][0]=excel.getExcelData(sheetName,i, 0);
			objArr[i][1]=excel.getExcelData(sheetName,i, 1);
		}
		return objArr;
	}
}
