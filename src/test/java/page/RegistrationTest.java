package page;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.example.Client;
import org.example.PageObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class RegistrationTest {
    private WebDriver driver;
    private final String browser = "Firefox";
    //private final String browser = "Chrome";
    private static final String BURGER_URI = "https://stellarburgers.nomoreparties.site/";
    private static final String EMAIL = "zxc@zxc.zxc";
    private static final String PASSWORD = "112233";
    private static final String NAME = "zxczxc";

    @Before
    public void before() {
        this.driver = Client.browser(browser);
        this.driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
    }

    @Test
    public void registrationOkTest() {
        this.driver.get("https://stellarburgers.nomoreparties.site/");
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebElement personalAccountButton = this.driver.findElement(PageObject.getPersonalAccountButton());
        new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(ExpectedConditions.elementToBeClickable(PageObject.getPersonalAccountButton()));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        personalAccountButton.click();
        WebElement register = this.driver.findElement(PageObject.getRegister());
        register.click();
        WebElement name = this.driver.findElement(PageObject.getName());
        name.click();
        name.sendKeys(NAME);
        WebElement email = this.driver.findElement(PageObject.getEmail());
        email.click();
        email.sendKeys(EMAIL);
        WebElement password = this.driver.findElement(PageObject.getPassword());
        password.click();
        password.sendKeys(PASSWORD);
        WebElement registerButtom = this.driver.findElement(PageObject.getRegisterButton());
        registerButtom.click();
        WebElement entranceButton = this.driver.findElement(PageObject.getEntranceButton());
        String Entrance = entranceButton.getText();
        Assert.assertTrue(Entrance.contains("Войти"));
    }

    @Test
    public void registrationNoPasswordTest() {
        this.driver.get("https://stellarburgers.nomoreparties.site/");
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebElement personalAccountButton = this.driver.findElement(PageObject.getPersonalAccountButton());
        new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(ExpectedConditions.elementToBeClickable(PageObject.getPersonalAccountButton()));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        personalAccountButton.click();
        WebElement register = this.driver.findElement(PageObject.getRegister());
        register.click();
        WebElement name = this.driver.findElement(PageObject.getName());
        name.click();
        name.sendKeys(NAME);
        WebElement email = this.driver.findElement(PageObject.getEmail());
        email.click();
        email.sendKeys(EMAIL);
        WebElement password = this.driver.findElement(PageObject.getPassword());
        password.click();
        password.sendKeys(PASSWORD + "1");
        WebElement registerButtom = this.driver.findElement(PageObject.getRegisterButton());
        registerButtom.click();
        WebElement entranceButton = this.driver.findElement(PageObject.getEntranceButton());
        String Entrance = entranceButton.getText();
        Assert.assertTrue(Entrance.contains("Войти"));
    }

    @After
    public void deleteUser() {

        WebElement emailEntrance = this.driver.findElement(PageObject.getEmailEntrance());
        emailEntrance.click();
        emailEntrance.sendKeys(EMAIL);
        WebElement passwordEntrance = this.driver.findElement(PageObject.getPasswordEntrance());
        passwordEntrance.click();
        passwordEntrance.sendKeys(PASSWORD);
        WebElement entranceButton = this.driver.findElement(PageObject.getEntranceButton());
        entranceButton.click();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        String accessToken = localStorage.getItem("accessToken");
        Client client = new Client();

        RequestSpecification requestSpecification =
                new RequestSpecBuilder().setBaseUri(BURGER_URI)
                        .setContentType(ContentType.JSON)
                        .build();
        client.setRequestSpecification(requestSpecification);

        client.deleteUser(accessToken);

        this.driver.quit();
    }

}
