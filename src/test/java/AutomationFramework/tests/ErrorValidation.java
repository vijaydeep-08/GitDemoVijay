package AutomationFramework.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationFramework.testComponents.BaseClass;

public class ErrorValidation extends BaseClass {

	@Test(groups = { "ErrorHandling" })
	public void verifyUserName() throws IOException, InterruptedException {

		// String productName = "ZARA COAT 3";
		landingPageObject.loginmethod("vijaysikarwar427@gmail.com", "Vikas@98");
		Assert.assertEquals("Incorrect email or password.", landingPageObject.getErrorMessage());
	}

	@Test(groups = { "ErrorHandling" })
	public void verifyUserpassword() throws IOException, InterruptedException {

		// String productName = "ZARA COAT 3";
		landingPageObject.loginmethod("vikassikarwar427@gmail.com", "Vikas@90");
		Assert.assertEquals("Incorrect email or password.", landingPageObject.getErrorMessage());
	}

}
