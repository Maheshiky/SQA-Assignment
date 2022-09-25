package actitime.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sqa.base.TestBase;
import sqa.pages.HomePage;
import sqa.pages.LoginPage;
import sqa.pages.TimeSheetPage;

import java.util.concurrent.TimeUnit;

public class TimeSheetPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    TimeSheetPage timeSheetPage;

    public TimeSheetPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
        timeSheetPage = homePage.clickOnTimeTrackingLink();
    }

    @Test(priority = 1)
    public void timeTrackingPageTest() {
        boolean flag = timeSheetPage.validateTimeTrackingPage();
        Assert.assertTrue(flag, "Cannot find Page Header");
    }

    @Test(priority = 2)
    public boolean approveTimeSheet() {
        return timeSheetPage.isReadyForApproval();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}