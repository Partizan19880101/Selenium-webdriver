package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePage {

    private String pageUrl = "http://the-internet.herokuapp.com/";

    private By formAuthenticationLink = By.linkText("Form Authentication");
    private By checkboxesLink = By.linkText("Checkboxes");
    private By dropdownLink = By.linkText("Dropdown");
    private By javaScriptAlertsLink = By.linkText("JavaScript Alerts");
    private By multipleWindowsLink = By.linkText("Multiple Windows");
    private By editorLinkLocator = By.linkText("WYSIWYG Editor");

    public WelcomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Open Welcome page with it's url */
    public WelcomePage openPage() {
        log.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
        return this;
    }

    /** Open Login page by clicking on Form Authentication link*/
    public LoginPage clickFormAuthenticationLink() {
        log.info("Click Form Authentication Link on Welcome page");
        click(formAuthenticationLink);
        return new LoginPage(driver, log);
    }

    /** Open CheckboxesPage by clicking on Checkboxes Link */
    public CheckBoxesPage clickCheckboxesLink() {
        log.info("Clicking Checkboxes link on Welcome Page");
        click(checkboxesLink);
        return new CheckBoxesPage(driver, log);
    }

    /** Clicking Dropdown link on Welcome Page */
    public DropdownPage clickDropdownLink() {
        log.info("Clicking Dropdown link on Welcome Page");
        click(dropdownLink);
        return new DropdownPage(driver, log);
    }

    public JavaScriptAlertsPage clickJavaScriptAlertsLink() {
        log.info("Clicking JavaScript Alerts link on Welcome Page");
        click(javaScriptAlertsLink);
        return new JavaScriptAlertsPage(driver, log);
    }

    public WindowsPage clickMultipleWindowsLink() {
        log.info("Clicking Multiple Windows link on Welcome Page");
        click(multipleWindowsLink);
        return new WindowsPage(driver, log);
    }

    public EditoriFramePage clickWYSIWYGEditorLink() {
        log.info("Clicking WYSIWYG Editor link on Welcome Page");
        click(editorLinkLocator);
        return new EditoriFramePage(driver, log);
    }
}
