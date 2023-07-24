package com.herokuapp.theinternet.editoriframetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.EditoriFramePage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditoriFrameTests extends TestUtilities {

    @Test
    public void defaultEditorValueTest() {
        // open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Scroll to the bottom
        welcomePage.scrollToBottom();

        // Click on WYSIWYG Editor link
        EditoriFramePage editoriFramePage = welcomePage.clickWYSIWYGEditorLink();
        sleep(500); //need for iFrame is ready

        // Get default editor text
        String editorText = editoriFramePage.getEditorText();

        // Verification that new page contains expected text in source
        Assert.assertTrue(editorText.equals("Your content goes here."),
                "Editor default text is not expected. It is: " + editorText);
    }
}