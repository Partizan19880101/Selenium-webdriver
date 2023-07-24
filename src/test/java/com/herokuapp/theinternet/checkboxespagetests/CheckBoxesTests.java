package com.herokuapp.theinternet.checkboxespagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckBoxesPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxesTests extends TestUtilities {

    @Test
    public void selectingTwoCheckBoxesTest() {
        //Open main Page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on Checkboxes link
        CheckBoxesPage checkboxesPage = welcomePage.clickCheckboxesLink();

        // Select All Checkboxes
        checkboxesPage.selectAllCheckboxes();

        // Verify all checkboxes are checked
        Assert.assertTrue(checkboxesPage.areAllCheckboxesChecked(), "Not all checkboxes are checked");
    }
}
