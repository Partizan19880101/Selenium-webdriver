package com.herokuapp.theinternet.pages;

import java.time.Duration;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By userName = By.id("username");
    private By userPassword = By.id("password");
    private By loginButton = By.tagName("button");
    private By errorMessage = By.id("flash");

    private String pageUrl = "http://the-internet.herokuapp.com/";

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Execute log in */
    public SecureAreaPage logIn(String username, String password) {
        log.info("Executing LogIn with username [" + username + "] and password [" + password + "]");
        type(username, userName);
        type(password, userPassword);
        click(loginButton);
        return new SecureAreaPage(driver, log);
    }

    public void negativeLogIn(String username, String password) {
        log.info("Executing Negative LogIn with username [" + username + "] and password [" + password + "]");
        type(username, userName);
        type(password, userPassword);
        click(loginButton);
    }

    /** Wait for error message to be visible on the page */
    public void waitForErrorMessage() {
        waitForVisibilityOf(errorMessage, Duration.ofSeconds(5));
    }

    public String getErrorMessageText() {
        return find(errorMessage).getText();
    }
}
