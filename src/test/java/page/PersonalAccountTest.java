package page;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
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
        User user = new User("vldd@yandex.ru", "123444", "Marina");
        client.createUser(user);

    }

    @Test
    public void personalAccountOk_test() {

        new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(ExpectedConditions.elementToBeClickable(By.xpath
                        ("/html/body/div/div/header/nav/a/p")));
        WebElement loginAccountButton = this.driver.findElement(PageObject.loginAccountButton);
        loginAccountButton.click();
        accessToken = client.login();
        WebElement personalAccountButton= this.driver.findElement(PageObject.personalAccountButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", personalAccountButton);
        personalAccountButton.click();
        WebElement profileText = this.driver.findElement(PageObject.profileText);
        String Profile = profileText.getText();
        Assert.assertTrue(Profile.contains("Профиль"));
        }

        @Test
        public void personalAccountConstructorOk_test() {
            new WebDriverWait(driver, Duration.ofSeconds(50)).
                    until(ExpectedConditions.elementToBeClickable(By.xpath
                            ("/html/body/div/div/header/nav/a/p")));
            WebElement loginAccountButton = this.driver.findElement(PageObject.loginAccountButton);
            loginAccountButton.click();
            accessToken = client.login();
            WebElement personalAccountButton= this.driver.findElement(PageObject.personalAccountButton);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", personalAccountButton);
            new WebDriverWait(driver, Duration.ofSeconds(50)).
                    until(ExpectedConditions.visibilityOf(personalAccountButton));
            personalAccountButton.click();
            WebElement constructor = this.driver.findElement(PageObject.constructor);
            constructor.click();
            WebElement constructorText= this.driver.findElement(PageObject.constructorText);
            String ConstructorText = constructorText.getText();
            Assert.assertTrue(ConstructorText.contains("Соберите бургер"));
    }

    @Test
    public void logoOk_test() {
        new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(ExpectedConditions.elementToBeClickable(By.xpath
                        ("/html/body/div/div/header/nav/a/p")));
        WebElement loginAccountButton = this.driver.findElement(PageObject.loginAccountButton);
        loginAccountButton.click();
        accessToken = client.login();
        WebElement personalAccountButton= this.driver.findElement(PageObject.personalAccountButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", personalAccountButton);
        new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(ExpectedConditions.visibilityOf(personalAccountButton));
        personalAccountButton.click();
        WebElement logo = this.driver.findElement(PageObject.logo);
        logo.click();
        WebElement constructorText= this.driver.findElement(PageObject.constructorText);
        String ConstructorText = constructorText.getText();
        Assert.assertTrue(ConstructorText.contains("Соберите бургер"));
    }

    @Test
    public void exitOk() {
        new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(ExpectedConditions.elementToBeClickable(By.xpath
                        ("/html/body/div/div/header/nav/a/p")));
        WebElement loginAccountButton = this.driver.findElement(PageObject.loginAccountButton);
        loginAccountButton.click();
        accessToken = client.login();
        WebElement personalAccountButton= this.driver.findElement(PageObject.personalAccountButton);
        //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", personalAccountButton);
        personalAccountButton.click();
        WebElement exitButton = this.driver.findElement(PageObject.exitButton);
        exitButton.click();
        WebElement inText = this.driver.findElement(PageObject.inText);
        String InText = inText.getText();
        Assert.assertTrue(InText.contains("Вход"));


    }


    @After
    public void deleteUser () {
        client.deleteUser(accessToken);
        this.driver.quit();
    }
}
