package Module2_AddToCart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart {
	
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement AddCart;
	
	public AddToCart(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void clickonAddToCart() {
		AddCart.click();
	}
	
	
}
