package page;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.annotation.Target;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class EntranceTest {
    private WebDriver driver;
    private final String browser = "Firefox";
    //private final String browser = "Chrome";
    private static final String BURGER_URI = "https://stellarburgers.nomoreparties.site/";
    private Client client = new Client();
    String accessToken;
    User user;

     @Before
     public void before() {
         this.driver = Client.browser(browser);
         this.driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
         this.driver.get("https://stellarburgers.nomoreparties.site/");
         RequestSpecification requestSpecification =
                 new RequestSpecBuilder().setBaseUri(BURGER_URI)
                         .setContentType(ContentType.JSON)
                         .build();
         client.setRequestSpecification(requestSpecification);
         User user = new User("mav222200@yandex.ru", "123444", "Marina");
         client.createUser(user);


     }

    @Test
    public void loginAccountOk_test() {

        new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(ExpectedConditions.elementToBeClickable(By.xpath
                        ("/html/body/div/div/header/nav/a/p")));
        WebElement loginAccountButton = this.driver.findElement(PageObject.loginAccountButton);
        loginAccountButton.click();
        accessToken = client.login();
        Assert.assertTrue(accessToken != null);
    }

    @Test
    public void personalAccountButtonOk_test() {
        new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(ExpectedConditions.elementToBeClickable(By.xpath
                        ("/html/body/div/div/header/nav/a/p")));
        WebElement loginAccountButton = this.driver.findElement(PageObject.personalAccountButton);
        loginAccountButton.click();
        accessToken = client.login();
        Assert.assertTrue(accessToken != null);

    }

    @Test
    public void registrationFormOk_test() {
        new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(ExpectedConditions.elementToBeClickable(By.xpath
                        ("/html/body/div/div/header/nav/a/p")));
        WebElement loginAccountButton = this.driver.findElement(PageObject.personalAccountButton);
        loginAccountButton.click();
        WebElement registerButton = this.driver.findElement(PageObject.registerButton);
        registerButton.click();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement registerEntranceButton = driver.findElement(PageObject.registerEntranceButton);
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", registerEntranceButton);
        registerEntranceButton.click();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        accessToken = client.login();
        Assert.assertTrue(accessToken != null);

     }
    @Test
    public void forgotPasswordButtonOk_Test() {
        new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(ExpectedConditions.elementToBeClickable(By.xpath
                        ("/html/body/div/div/header/nav/a/p")));
        WebElement loginAccountButton = this.driver.findElement(PageObject.personalAccountButton);
        loginAccountButton.click();
        WebElement registerButton = this.driver.findElement(PageObject.forgotPasswordButton);
        registerButton.click();
        WebElement forgotEntranceButton = this.driver.findElement(PageObject.forgotEntranceButton);
        forgotEntranceButton.click();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        accessToken = client.login();
        Assert.assertTrue(accessToken != null);

    }

    @After
    public void deleteUser () {
    client.deleteUser(accessToken);
    this.driver.quit();
    }
}
