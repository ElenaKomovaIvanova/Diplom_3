package page;

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
    public void bunOk_test() {
        WebElement bun = this.driver.findElement(PageObject.bun);
        new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(ExpectedConditions.elementToBeClickable(By.xpath
                        ("/html/body/div/div/header/nav/a/p")));
        bun.click();
        Assert.assertTrue(driver.findElement(PageObject.bunConstructor) .isDisplayed());

    }

    @Test
    public void sauceOk_test() {
        WebElement sauce = this.driver.findElement(PageObject.sauce);
        new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(ExpectedConditions.elementToBeClickable(By.xpath
                        ("/html/body/div/div/header/nav/a/p")));
        sauce.click();
        Assert.assertTrue(driver.findElement(PageObject.sauceConstructor) .isDisplayed());
    }

    @Test
    public void fillingOk_test() {
        WebElement filling = this.driver.findElement(PageObject.filling);
        new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(ExpectedConditions.elementToBeClickable(By.xpath
                        ("/html/body/div/div/header/nav/a/p")));
        filling.click();
        Assert.assertTrue(driver.findElement(PageObject.fillingConstructor) .isDisplayed());
    }
    @After
    public void deleteUser () {
        this.driver.quit();
    }
}
