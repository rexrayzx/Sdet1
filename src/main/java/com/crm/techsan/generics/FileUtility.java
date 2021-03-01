package com.crm.techsan.generics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @author Rajiv
 *
 */
public class FileUtility {
	/**
	 * To read the data from property file
	 * @param Key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String getPropertyData(String key) throws FileNotFoundException, IOException {
		Properties p=new Properties();
		p.load(new FileInputStream(AutoConstant.propertyFilePath));
		return p.getProperty(key);
	}
	/**
	 * To handle fileupload popup
	 * @param path
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public void fileupload(String path) throws AWTException, InterruptedException {
		StringSelection file=new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_V);
		
	}
}
