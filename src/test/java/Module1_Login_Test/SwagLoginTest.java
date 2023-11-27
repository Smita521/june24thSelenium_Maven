package Module1_Login_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import Module1_login.SwagHomePage;
import Module1_login.SwagLoginPage;
import Module1_login.SwagMenuPage;

public class SwagLoginTest extends BaseClass {
	
	SwagLoginPage login;
	SwagHomePage home;
	SwagMenuPage out;
	int TCID;
	
	
	@BeforeClass
	public  void openBrowser() throws InterruptedException, EncryptedDocumentException, IOException {
		initializeBrowser();
		 login= new SwagLoginPage(driver);
		 home =new SwagHomePage(driver);
		 out =new SwagMenuPage(driver);
	}
	
	@BeforeMethod
	public void loginToApp() throws InterruptedException, EncryptedDocumentException, IOException
	{		
		
		login.getUsername(UtilityClass.getDataFromPF("UN"));
		Thread.sleep(2000);
		login.getpassword(UtilityClass.getDataFromPF("PWD"));
		Thread.sleep(2000);
		login.clickBtn();
		
	}
	@Test
	public void VerifyTitle() throws InterruptedException, EncryptedDocumentException, IOException
	{
		TCID=101;
		String actTitle=home.getSwagLabHomePageTitle();
		String verifTitle = UtilityClass.getTD(0, 2);
		//String verifTitle = UtilityClass.getTD(0, 1);
		Assert.assertEquals(actTitle,verifTitle,"Failed: both results are failed");
		
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void logoutFromApp(ITestResult s1) throws InterruptedException, IOException{
		if(s1.getStatus() == ITestResult.FAILURE)
		{
		//code to capture ss
		UtilityClass.captureSS(driver,TCID);
		}
		home.clickMUBtn();
		Thread.sleep(2000);
		out.Logoutbtn();
		Thread.sleep(2000);
		System.out.println("User logout sucessfully");
		driver.close();
	}
	@AfterClass
	public void closeBrowser()
	{
	driver.quit();
	}

}
