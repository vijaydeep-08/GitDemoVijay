package AutomationFramework.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AutomationFramework.PageObject.cartPage;
import AutomationFramework.PageObject.ordersPage;

public class AbstractComponent {

	WebDriver driver;
	
	
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*= 'cart']")
	WebElement cartbutton;
	
	@FindBy(css="[routerlink=\"/dashboard/myorders\"]")
	WebElement myOrders;
	
	public cartPage goToCart() {
		cartbutton.click();
		cartPage cartPageObj = new cartPage(driver);
		return cartPageObj;
	}
	
	public ordersPage goToMyOrdersPage() {
		myOrders.click();
		ordersPage myOrderObj = new ordersPage(driver);
		return myOrderObj;
		
	}

	public void waitForElementToVisible(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToVisible(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitForElementToDisappear(WebElement findBy) throws InterruptedException {
		Thread.sleep(1000);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.invisibilityOf(findBy));
	}
	
	
	
	
	
	
	
	
	
	
}
