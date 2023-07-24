package com.herokuapp.theinternet.pages;

import java.time.Duration;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditoriFramePage extends BasePage {

    private By editor = By.id("tinymce");
    private By frame = By.tagName("iframe");

    public EditoriFramePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Get text from TinyMCE WYSIWYG Editor */
    public String getEditorText() {
        waitForVisibilityOf(frame, Duration.ofSeconds(5));
        switchToFrame(frame);
        String text = find(editor).getText();
        log.info("Text from TinyMCE WYSIWYG Editor: " + text);
        return text;
    }
}