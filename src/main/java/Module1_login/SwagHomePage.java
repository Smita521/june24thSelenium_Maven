package Module1_login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagHomePage {
@FindBy(xpath = "//button[@id='react-burger-menu-btn']") private WebElement MUBtn;

WebDriver driver;

public SwagHomePage(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
//public void verifyTitle(String expttitle ) {
//	String acttitle = driver.getTitle();
//
//	if (acttitle.equals(expttitle)) {
//		System.out.println("Test Case Pass");
//	}
//	else {
//		System.out.println("Test Case Fail");
//	}
//}

public String getSwagLabHomePageTitle() {
	String actTitle = driver.getTitle();
	return actTitle;
}

 public void clickMUBtn() {
	 MUBtn.click();
		
 }
}
	