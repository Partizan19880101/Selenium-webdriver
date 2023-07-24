package com.herokuapp.theinternet.base;

import static com.herokuapp.theinternet.config.ConfigurationManager.configuration;

import com.epam.reportportal.testng.ReportPortalTestNGListener;
import com.herokuapp.theinternet.config.Configuration;
import com.herokuapp.theinternet.dataproviders.DataProviders;
import com.herokuapp.theinternet.driver.DriverFactory;
import java.lang.reflect.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({ com.herokuapp.theinternet.listeners.TestListener.class, ReportPortalTestNGListener.class})
public class BaseTest extends DataProviders {

    protected WebDriver driver;
    protected Logger log;
    protected Configuration configuration;

    protected String testSuiteName;
    protected String testName;
    protected String testMethodName;

    @BeforeMethod(alwaysRun = true)
    public void preCondition(Method method, ITestContext ctx) {
        configuration = configuration();
        String testName = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);

        driver = new DriverFactory().createInstance(configuration().browser());

        this.testSuiteName = ctx.getSuite().getName();
        this.testName = testName;
        this.testMethodName = method.getName();
    }

    @AfterMethod(alwaysRun = true)
    public void postCondition() {
        log.info("Close driver");
        driver.quit();
    }
}