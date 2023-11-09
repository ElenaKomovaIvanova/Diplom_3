package page;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;

import java.io.File;
import java.time.Duration;

import static io.restassured.RestAssured.given;


public class Client {

    public Client() {

    }

    String accessToken;


    private static final String DELETE_USER = "/api/auth/user";
    private static final String CREATE_USER = "/api/auth/register";
    private RequestSpecification requestSpecification;

    public void setRequestSpecification(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    private static WebDriver driver;

    public static WebDriver browser(String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments(new String[]{"--no-sandbox", "--headless", "--disable-dev-shm-usage"});
            driver = new ChromeDriver(options);
        } else {
            FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);
        }
        return driver;
    }


    public ValidatableResponse createUser(User user) {
        return given()
                .spec(requestSpecification)
                .header("Content-type", "application/json")
                .body(user)
                .post(CREATE_USER)
                .then()
                .log()
                .all();
    }

    public ValidatableResponse deleteUser(String accessToken) {

        return given()
                .spec(requestSpecification)
                .header("Authorization", accessToken)
                .delete(DELETE_USER)
                .then()
                .log()
                .all();

    }

    public String login() {
        WebElement emailEntrance = this.driver.findElement(PageObject.emailEntrance);
        emailEntrance.click();
        emailEntrance.sendKeys("vldd@yandex.ru");
        WebElement passwordEntrance = this.driver.findElement(PageObject.passwordEntrance);
        passwordEntrance.click();
        passwordEntrance.sendKeys("123444");
        WebElement entranceButton = this.driver.findElement(PageObject.entranceButton);
        entranceButton.click();
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        accessToken = localStorage.getItem("accessToken");

        return accessToken;
    }



}
