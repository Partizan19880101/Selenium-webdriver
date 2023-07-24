package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.dataproviders.CsvDataProviders;
import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTests extends TestUtilities {

	@Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void negativeLoginTest(Map<String, String> testData) {
		// Data
		String no = testData.get("no");
		String username = testData.get("username");
		String password = testData.get("password");
		String expectedMessage = testData.get("expectedMessage");
		String description = testData.get("description");

		log.info("Starting negativeLoginTest #" + no + " for " + description);

		// Open main page
		WelcomePage welcomePage = new WelcomePage(driver, log)
				.openPage();

		// Click on Form Authentication link
		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();

		// execute negative login
		loginPage.negativeLogIn(username, password);

		// wait for error message
		loginPage.waitForErrorMessage();
		String message = loginPage.getErrorMessageText();

		// Verification
		Assert.assertTrue(message.contains(expectedMessage), "Message doesn't contain expected text.");
	}
}
