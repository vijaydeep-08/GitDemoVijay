package AutomationFramework.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationFramework.AbstractComponents.AbstractComponent;

public class ordersPage extends AbstractComponent {
	WebDriver driver;

	public ordersPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "tbody td:nth-child(3)")
	List<WebElement> productNames;
	
	@FindBy(css = ".totalRow button")
	WebElement checkoutButton;
	
	public Boolean verifyOrderDisplay(String productName) {
		Boolean match = productNames.stream()
				.anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public checkoutPage goToCheckoutPage() {
		checkoutButton.click();
		checkoutPage checkoutpageobj = new checkoutPage(driver);
		return checkoutpageobj;
	}

	
}
