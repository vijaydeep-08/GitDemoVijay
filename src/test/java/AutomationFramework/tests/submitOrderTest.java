package AutomationFramework.tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AutomationFramework.PageObject.cartPage;
import AutomationFramework.PageObject.checkoutPage;
import AutomationFramework.PageObject.confirmationPage;
import AutomationFramework.PageObject.landingPage;
import AutomationFramework.PageObject.ordersPage;
import AutomationFramework.PageObject.productCatalogue;
import AutomationFramework.testComponents.BaseClass;
import AutomationFramework.testComponents.Retry;

public class submitOrderTest extends BaseClass {
	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = { "Purchase" }, retryAnalyzer = Retry.class)
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

		productCatalogue productCatalogue = landingPageObject.loginmethod(input.get("email"), input.get("password"));
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		cartPage cartPageObj = productCatalogue.goToCart();
		Boolean match = cartPageObj.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		checkoutPage checkoutObj = cartPageObj.goToCheckoutPage();
		checkoutObj.selectCountry();
		confirmationPage confirmationpageObj = checkoutObj.submitOrder();
		String confirmMessage = confirmationpageObj.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

	@Test(dependsOnMethods = { "submitOrder" })
	public void orderHistoryTest() {
		productCatalogue productCatalogue = landingPageObject.loginmethod("vikassikarwar427@gmail.com", "Vikas@98");
		ordersPage ordersPageObj = productCatalogue.goToMyOrdersPage();
		Assert.assertTrue(ordersPageObj.verifyOrderDisplay(productName));
	}

	@DataProvider
	public Object[][] getData() throws IOException {
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("email", "vikassikarwar427@gmail.com");
//		map.put("password", "Vikas@98");
//		map.put("product", "ZARA COAT 3");
//		
//		HashMap<String,String> map1 = new HashMap<String,String>();
//		map1.put("email", "varunchouhan430@gmail.com");
//		map1.put("password", "Varun@98");
//		map1.put("product", "ADIDAS ORIGINAL");

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\test\\java\\AutomationFramework\\data\\PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}
