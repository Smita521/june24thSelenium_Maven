package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.io.FileHandler;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilityClass {
	//@Author Name: Smita Patil
	//This method is use to get Test data from excel sheet
	//need to pass 2 inputs 1:rowIndex 2:colIndex
	public static String getTD(int rowIndex,int colIndex) throws EncryptedDocumentException, IOException
	{
	FileInputStream file=new FileInputStream("C:\\Users\\91997\\eclipse-workspace\\june24thSelenium_Maven\\TestData\\June24.xlsx");
	Sheet sh = WorkbookFactory.create(file).getSheet("DDF");
	String value = sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();
	return value;
	}
	
	public static void captureSS(WebDriver driver,int TCID) throws IOException
	{
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File dest=new File("C:\\Users\\91997\\eclipse-workspace\\june24thSelenium_Maven\\Screenshots\\"+TCID+"TestCaseID.jpg");
	FileHandler.copy(src, dest);
	}
	
	public static String getDataFromPF(String key) throws IOException
	{
	
	//FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\PropertyFile.properties");
	//FileInputStream file=new FileInputStream("C:\\Users\\91997\\eclipse-workspace\\june24thSelenium\\src\\POM_DDF_TestNG_BaseClass_UtilityClass_FailedTCesSS_PropertyFile\\PropertyFile.properties");
	FileInputStream file=new FileInputStream("C:\\Users\\91997\\eclipse-workspace\\june24thSelenium_Maven\\PropertyFile\\PropertyFile.properties");
	Properties p=new Properties();
	p.load(file);
	String value = p.getProperty(key);
	return value;
	}

}
