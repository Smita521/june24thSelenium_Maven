package Module1_login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLoginPage {
	//Driver.findelement(By.xpath("")).sendKeys(" ");
@FindBy(xpath = "//input[@id='user-name']") private WebElement UN;
@FindBy(xpath = "//input[@id='password']") private WebElement Pwd;
@FindBy(xpath = "//input[@id='login-button']")   private WebElement Loginbtn;

public SwagLoginPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}

public void getUsername(String username) {
	UN.sendKeys(username);
	}
public void getpassword(String pass) {
	Pwd.sendKeys(pass);
}
public void clickBtn() {
	Loginbtn.click();
}
}
 