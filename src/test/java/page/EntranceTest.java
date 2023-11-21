package page;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.example.Client;
import org.example.PageObject;
import org.example.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class EntranceTest {
    private WebDriver driver;
    private final String browser = "Firefox";
    //private final String browser = "Chrome";
    private static final String BURGER_URI = "https://stellarburgers.nomoreparties.site/";
    private final Client client = new Client();
    String accessToken;
    User user;
    private static final String EMAIL = "zxc@zxc.zxc";
    private static final String PASSWORD = "112233";
    private static final String NAME = "zxczxc";

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
        User user = new User(EMAIL, PASSWORD, NAME);
        client.createUser(user);
    }

    @Test
    public void loginAccountOkTest() {

        new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(ExpectedConditions.elementToBeClickable(PageObject.getPersonalAccountButton()));
        WebElement loginAccountButton = this.driver.findElement(PageObject.getLoginAccountButton());
        loginAccountButton.click();
        accessToken = client.login();
        Assert.assertNotNull(accessToken);
    }

    @Test
    public void personalAccountButtonOkTest() {
        new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(ExpectedConditions.elementToBeClickable(PageObject.getPersonalAccountButton()));
        WebElement loginAccountButton = this.driver.findElement(PageObject.getPersonalAccountButton());
        loginAccountButton.click();
        accessToken = client.login();
        Assert.assertNotNull(accessToken);
    }

    @Test
    public void registrationFormOkTest() {
        new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(ExpectedConditions.elementToBeClickable(PageObject.getPersonalAccountButton()));
        WebElement loginAccountButton = this.driver.findElement(PageObject.getPersonalAccountButton());
        loginAccountButton.click();
        WebElement registerButton = this.driver.findElement(PageObject.getRegisterButton());
        registerButton.click();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement registerEntranceButton = driver.findElement(PageObject.getRegisterEntranceButton());
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", registerEntranceButton);
        registerEntranceButton.click();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        accessToken = client.login();
        Assert.assertNotNull(accessToken);
    }

    @Test
    public void forgotPasswordButtonOkTest() {
        new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(ExpectedConditions.elementToBeClickable(PageObject.getPersonalAccountButton()));
        WebElement loginAccountButton = this.driver.findElement(PageObject.getPersonalAccountButton());
        loginAccountButton.click();
        WebElement registerButton = this.driver.findElement(PageObject.getForgotPasswordButton());
        registerButton.click();
        WebElement forgotEntranceButton = this.driver.findElement(PageObject.getForgotEntranceButton());
        forgotEntranceButton.click();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        accessToken = client.login();
        Assert.assertNotNull(accessToken);
    }

    @After
    public void deleteUser() {
        client.deleteUser(accessToken);
        this.driver.quit();
    }
}
