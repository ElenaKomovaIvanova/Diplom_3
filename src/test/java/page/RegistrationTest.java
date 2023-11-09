package page;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
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

    @Before
    public void before() {
     this.driver = Client.browser(browser);
     this.driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
    }

   @Test
    public void registrationOk_test() {
       this.driver.get("https://stellarburgers.nomoreparties.site/");
       this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
       WebElement personalAccountButton = this.driver.findElement(PageObject.personalAccountButton);
       new WebDriverWait(driver, Duration.ofSeconds(50)).
           until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/header/nav/a/p")));
       this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
       personalAccountButton.click();
       WebElement register = this.driver.findElement(PageObject.register);
       register.click();
       WebElement name = this.driver.findElement(PageObject.name);
       name.click();
       name.sendKeys("Elena");
       WebElement email = this.driver.findElement(PageObject.email);
       email.click();;
       email.sendKeys("elenap@yandex.ru");
       WebElement password = this.driver.findElement(PageObject.password);
       password.click();
       password.sendKeys("123444");
       WebElement registerButtom= this.driver.findElement(PageObject.registerButton);
       registerButtom.click();
       WebElement entranceButton = this.driver.findElement(PageObject.entranceButton);
       String Entrance = entranceButton.getText();
       Assert.assertTrue(Entrance.contains("Войти"));
   }
    @Test
    public void registrationNoPassword_test() {this.driver.get("https://stellarburgers.nomoreparties.site/");
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebElement personalAccountButton = this.driver.findElement(PageObject.personalAccountButton);
        new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/header/nav/a/p")));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        personalAccountButton.click();
        WebElement register = this.driver.findElement(PageObject.register);
        register.click();
        WebElement name = this.driver.findElement(PageObject.name);
        name.click();
        name.sendKeys("Elena");
        WebElement email = this.driver.findElement(PageObject.email);
        email.click();;
        email.sendKeys("elenah@yandex.ru");
        WebElement password = this.driver.findElement(PageObject.password);
        password.click();
        password.sendKeys("12");
        WebElement registerButtom= this.driver.findElement(PageObject.registerButton);
        registerButtom.click();
        WebElement entranceButton = this.driver.findElement(PageObject.entranceButton);
        String Entrance = entranceButton.getText();
        Assert.assertTrue(Entrance.contains("Войти"));

    }


   @After
   public void deleteUser() {

    WebElement emailEntrance = this.driver.findElement(PageObject.emailEntrance);
    emailEntrance.click();
    emailEntrance.sendKeys("elenap@yandex.ru");
    WebElement passwordEntrance = this.driver.findElement(PageObject.passwordEntrance);
    passwordEntrance.click();
    passwordEntrance.sendKeys("123444");
    WebElement entranceButton = this.driver.findElement(PageObject.entranceButton);
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
