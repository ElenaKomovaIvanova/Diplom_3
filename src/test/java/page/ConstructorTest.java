package page;

import org.example.Client;
import org.example.PageObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ConstructorTest {
    private WebDriver driver;
    private final String browser = "Firefox";
    //private final String browser = "Chrome";
    private static final String BURGER_URI = "https://stellarburgers.nomoreparties.site/";

    @Before
    public void before() {
        this.driver = Client.browser(browser);
        this.driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
        this.driver.get("https://stellarburgers.nomoreparties.site/");
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }

    @Test
    public void goToBookmarkBunTest() {
        WebElement bun = this.driver.findElement(PageObject.getBun());
        new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(ExpectedConditions.elementToBeClickable(PageObject.getPersonalAccountButton()));
        bun.click();
        Assert.assertTrue(driver.findElement(PageObject.getBunConstructor()).isDisplayed());
    }

    @Test
    public void goToBookmarkSauceTest() {
        WebElement sauce = this.driver.findElement(PageObject.getSauce());
        new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(ExpectedConditions.elementToBeClickable(PageObject.getPersonalAccountButton()));
        sauce.click();
        Assert.assertTrue(driver.findElement(PageObject.getSauceConstructor()).isDisplayed());
    }

    @Test
    public void goToBookmarkFillingTest() {
        WebElement filling = this.driver.findElement(PageObject.getFilling());
        new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(ExpectedConditions.elementToBeClickable(PageObject.getPersonalAccountButton()));
        filling.click();
        Assert.assertTrue(driver.findElement(PageObject.getFillingConstructor()).isDisplayed());
    }

    @After
    public void deleteUser() {
        this.driver.quit();
    }
}
