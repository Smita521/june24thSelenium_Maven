package Module1_login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SwagMenuPage {
@FindBy(xpath = "//a[@id='logout_sidebar_link']") private WebElement LogOut;

public SwagMenuPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public void Logoutbtn()
{
	LogOut.click();
}

}
