package AutomationFramework.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AutomationFramework.AbstractComponents.AbstractComponent;

public class checkoutPage extends AbstractComponent {

	WebDriver driver;

	public checkoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "[placeholder='Select Country']")
	WebElement countryInputField;

	@FindBy(css = ".action__submit")
	WebElement placeOrderButton;

	@FindBy(css = "button.ta-item:nth-child(3)")
	WebElement selectIndia;

	By placeOrder = By.className(".action__submit");

	public void selectCountry() {
		Actions a = new Actions(driver);
		a.sendKeys(countryInputField, "india").build().perform();
		waitForElementToVisible(By.cssSelector("section.ta-results"));
		selectIndia.click();
	}

	public confirmationPage submitOrder() {
		Actions a = new Actions(driver);
		a.moveToElement(placeOrderButton).build().perform();
		//waitForElementToVisible(placeOrder);
		placeOrderButton.click();
		return new confirmationPage(driver);
	}

}
