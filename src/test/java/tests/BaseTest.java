package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.*;
import pages.MainPage;
import pages.ProductPage;
import pages.SignInPage;
import pages.SignUpPage;

/**
 * this class represents the base of all tests
 * this will be before each test in the testNG xml
 *
 * @author Shlomi
 */

public class BaseTest implements ITestListener {

    WebDriver driver;
    SignInPage signInPage;
    SignUpPage signUpPage;
    ProductPage productPage;
    MainPage mainPage;

    @Parameters({"browser"})
    @BeforeTest(alwaysRun = true)
    public void setup(String browser, ITestContext context) {

        driver = new ChromeDriver();

        // maximize the browser window
        driver.manage().window().maximize();

        // load pages
        mainPage = new MainPage(driver);
        signInPage = new SignInPage(driver);
        signUpPage = new SignUpPage(driver);
        productPage = new ProductPage(driver);

        // set context of webDriver
        context.setAttribute("driver", driver);

    }

    @AfterTest(alwaysRun = true)
    public void close() {
        driver.quit();

    }

}
