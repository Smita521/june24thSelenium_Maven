package Module1_Login_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
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
import Module2_AddToCart.AddToCart;
import Remove_ItemFromCart.RemoveItemFromCart;

public class SwagLoginTest extends BaseClass {
	
	SwagLoginPage login;
	SwagHomePage home;
	SwagMenuPage out;
	int TCID;
	AddToCart addcart;
	RemoveItemFromCart removeItemFromCart;
	
	
	
	@BeforeClass
	public  void openBrowser() throws InterruptedException, EncryptedDocumentException, IOException {
		initializeBrowser();
		 login= new SwagLoginPage(driver);
		 home =new SwagHomePage(driver);
		 out =new SwagMenuPage(driver);
		 addcart=new AddToCart(driver);
		 removeItemFromCart=new RemoveItemFromCart(driver);
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
		Reporter.log("Verify Title",true);
		Thread.sleep(2000);
	}
	
	@Test(priority = 1)
	public void AddToCart() throws InterruptedException {
		TCID=102;
		Reporter.log("add to cart",true);
		Thread.sleep(3000);
		addcart.clickonAddToCart();
		Thread.sleep(3000);
		removeItemFromCart.RemoveItem();
		Thread.sleep(3000);
	}
	
	@Test(priority = 2)
	public void removeCartItem() throws InterruptedException {
		Thread.sleep(3000);
		TCID=103;
		addcart.clickonAddToCart();
		Thread.sleep(3000);
		removeItemFromCart.shopping_cart_link();
		Reporter.log("remove item from Cart",true);
		Thread.sleep(3000);
		removeItemFromCart.RemoveItem();
		Thread.sleep(3000);
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
	}
	@AfterClass
	public void closeBrowser()
	{
	driver.quit();
	}

}
