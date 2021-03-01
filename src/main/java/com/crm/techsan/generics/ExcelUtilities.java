package com.crm.techsan.generics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Rajiv
 *
 */
public class ExcelUtilities {
	String sheetName="bookTicketTest";
	/**
	 * to get the data from excel
	 * @param sheetName
	 * @param rownum
	 * @param columnNum
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */
	public String getExcelData(String sheetName,int rownum,int columnNum) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream(AutoConstant.excelpath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row row = sh.getRow(rownum);
		wb.close();
		return row.getCell(columnNum).getStringCellValue();
	}
	
	/**
	 * to write the data in excel
	 * @param sheetname
	 * @param rowNum
	 * @param colNum
	 * @param data
	 * @throws Throwable
	 * @throws IOException
	 */
	
	public void setExcelData(String sheetname,int rowNum,int colNum, String data) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream(AutoConstant.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(colNum);
		cel.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(AutoConstant.excelpath);
		wb.write(fos);
		wb.close();
	}
	
	/**
	 * to get the number of rows which are containing the data
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */
	
	public int getRowCount(String sheetName) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream(AutoConstant.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		return sh.getLastRowNum();
	}
	
}
