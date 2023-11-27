package Remove_ItemFromCart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemoveItemFromCart {
	
	@FindBy(xpath = "//button[@id=\"remove-sauce-labs-backpack\"]") private WebElement removeItem;
	@FindBy(xpath = "//a[@class=\"shopping_cart_link\"]") private WebElement cartSymbolElement;
	public RemoveItemFromCart(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void RemoveItem() {
		removeItem.click();
	}
	public void shopping_cart_link() {
		cartSymbolElement.click();
	}
	
}
