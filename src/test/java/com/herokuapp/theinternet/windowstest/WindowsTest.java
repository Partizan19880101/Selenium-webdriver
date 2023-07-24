package com.herokuapp.theinternet.windowstest;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.NewWindowPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import com.herokuapp.theinternet.pages.WindowsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowsTest extends TestUtilities {

    @Test
    public void newWindowsTest() {
        // open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on multiple windows link
        WindowsPage windowsPage = welcomePage.clickMultipleWindowsLink();

        // Click 'Click here' to new window page
        windowsPage.openNewWindow();

        // Find and switch to new window
        NewWindowPage newWindowPage = windowsPage.switchToNewWindowPage();

        String pageSource = newWindowPage.getCurrentPageSource();

        // Verification that new page contains expected text in source
        Assert.assertTrue(pageSource.contains("New Window"), "New page source doesn't contain expected text");
    }
}
