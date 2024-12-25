package AutomationFramework.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationFramework.AbstractComponents.AbstractComponent;

public class landingPage extends AbstractComponent{

	WebDriver driver;

	public landingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement usermail = driver.findElement(By.id("userEmail"));

	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userpassword;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[aria-label=\"Incorrect email or password.\"]")
	WebElement errorMessage;
	
	public void goToLandingPage() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMessage() {
		
		waitForWebElementToVisible(errorMessage);
		String errorMessageText = errorMessage.getText();
		return errorMessageText;
	}
	
	public productCatalogue loginmethod(String usermail, String userpass) {
		userEmail.sendKeys(usermail);
		userpassword.sendKeys(userpass);
		submit.click();
		productCatalogue productCatalogue = new productCatalogue(driver);
		return productCatalogue;
	}
	
	
	
	
	
	
	
	
	
}
