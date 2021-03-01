package Scripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	@Test(dataProvider = "getData")
	public void sampleDataTest(String src, String dest) {
		System.out.println("Source==>  "+src+  "Destination==>  "  + dest);
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr=new Object[5][2];
		objArr[0][0]="BLR";
		objArr[0][1]="GOI";
		
		objArr[1][0]="DEL";
		objArr[1][1]="GOI";
		
		objArr[2][0]="BLR";
		objArr[2][1]="DEL";
		
		objArr[3][0]="BLR";
		objArr[3][1]="GOI";
		
		objArr[4][0]="BLR";
		objArr[4][1]="GOI";
		return objArr;
	}
	
}
