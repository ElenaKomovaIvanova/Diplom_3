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

public class PersonalAccountTest {

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
    public void personalAccountOkTest() {

        new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(ExpectedConditions.elementToBeClickable(PageObject.getPersonalAccountButton()));
        WebElement loginAccountButton = this.driver.findElement(PageObject.getLoginAccountButton());
        loginAccountButton.click();
        accessToken = client.login();
        WebElement personalAccountButton = this.driver.findElement(PageObject.getPersonalAccountButton());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", personalAccountButton);
        personalAccountButton.click();
        WebElement profileText = this.driver.findElement(PageObject.getProfileText());
        String Profile = profileText.getText();
        Assert.assertTrue(Profile.contains("Профиль"));
    }

    @Test
    public void personalAccountConstructorOkTest() {
        new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(ExpectedConditions.elementToBeClickable(PageObject.getPersonalAccountButton()));
        WebElement loginAccountButton = this.driver.findElement(PageObject.getLoginAccountButton());
        loginAccountButton.click();
        accessToken = client.login();
        WebElement personalAccountButton = this.driver.findElement(PageObject.getPersonalAccountButton());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", personalAccountButton);
        new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(ExpectedConditions.visibilityOf(personalAccountButton));
        personalAccountButton.click();
        WebElement constructor = this.driver.findElement(PageObject.getConstructor());
        constructor.click();
        WebElement constructorText = this.driver.findElement(PageObject.getConstructorText());
        String ConstructorText = constructorText.getText();
        Assert.assertTrue(ConstructorText.contains("Соберите бургер"));
    }

    @Test
    public void logoOkTest() {
        new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(ExpectedConditions.elementToBeClickable(PageObject.getPersonalAccountButton()));
        WebElement loginAccountButton = this.driver.findElement(PageObject.getLoginAccountButton());
        loginAccountButton.click();
        accessToken = client.login();
        WebElement personalAccountButton = this.driver.findElement(PageObject.getPersonalAccountButton());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", personalAccountButton);
        new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(ExpectedConditions.visibilityOf(personalAccountButton));
        personalAccountButton.click();
        WebElement logo = this.driver.findElement(PageObject.getLogo());
        logo.click();
        WebElement constructorText = this.driver.findElement(PageObject.getConstructorText());
        String ConstructorText = constructorText.getText();
        Assert.assertTrue(ConstructorText.contains("Соберите бургер"));
    }

    @Test
    public void exitOkTest() {
        new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(ExpectedConditions.elementToBeClickable(PageObject.getPersonalAccountButton()));
        WebElement loginAccountButton = this.driver.findElement(PageObject.getLoginAccountButton());
        loginAccountButton.click();
        accessToken = client.login();
        WebElement personalAccountButton = this.driver.findElement(PageObject.getPersonalAccountButton());
        //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", personalAccountButton);
        personalAccountButton.click();
        WebElement exitButton = this.driver.findElement(PageObject.getExitButton());
        exitButton.click();
        WebElement inText = this.driver.findElement(PageObject.getInText());
        String InText = inText.getText();
        Assert.assertTrue(InText.contains("Вход"));
    }

    @After
    public void deleteUser() {
        client.deleteUser(accessToken);
        this.driver.quit();
    }
}
