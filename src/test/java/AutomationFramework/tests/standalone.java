package AutomationFramework.tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import AutomationFramework.PageObject.landingPage;

public class standalone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		landingPage landinpagedriver = new landingPage(driver);

		String productName = "ZARA COAT 3";
		driver.findElement(By.id("userEmail")).sendKeys("vikassikarwar427@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Vikas@98");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("div.ngx-spinner-overlay "))));
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.la-ball-scale-multiple")));
		driver.findElement(By.cssSelector("[routerlink*= 'cart']")).click();

		List<WebElement> cartProducts = driver.findElements(By.cssSelector("div.cartSection h3"));

		Boolean match = cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();

		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("section.ta-results")));
		driver.findElement(By.cssSelector("button.ta-item:nth-child(3)")).click();
		a.moveToElement(driver.findElement(By.cssSelector(".action__submit"))).build().perform();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".action__submit")));
		driver.findElement(By.cssSelector(".action__submit")).click();

		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
	}

}
