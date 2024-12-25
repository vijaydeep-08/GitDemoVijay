package AutomationFramework.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import AutomationFramework.AbstractComponents.AbstractComponent;

public class cartPage extends AbstractComponent {
	WebDriver driver;

	public cartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	@FindBy(css = "div.cartSection h3")
	List<WebElement> cartproducts;
	
	@FindBy(css = ".totalRow button")
	WebElement checkoutButton;
	
	public Boolean verifyProductDisplay(String productName) {
		Boolean match = cartproducts.stream()
				.anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public checkoutPage goToCheckoutPage() {
		checkoutButton.click();
		checkoutPage checkoutpageobj = new checkoutPage(driver);
		return checkoutpageobj;
	}

	
}
