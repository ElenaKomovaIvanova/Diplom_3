package org.example;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.PageObject;
import org.example.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;

import static io.restassured.RestAssured.given;


public class Client {

    public Client() {

    }

    String accessToken;


    private static final String DELETE_USER = "/api/auth/user";
    private static final String CREATE_USER = "/api/auth/register";
    private static final String EMAIL = "zxc@zxc.zxc";
    private static final String PASSWORD = "112233";
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

    @Step("Запрос по созданию пользователя")
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

    @Step("Запрос по удалению пользователя")
    public ValidatableResponse deleteUser(String accessToken) {

        return given()
                .spec(requestSpecification)
                .header("Authorization", accessToken)
                .delete(DELETE_USER)
                .then()
                .log()
                .all();

    }

    @Step("Запрос по авторизации пользователя")
    public String login() {
        WebElement emailEntrance = this.driver.findElement(PageObject.getEmailEntrance());
        emailEntrance.click();
        emailEntrance.sendKeys(EMAIL);
        WebElement passwordEntrance = this.driver.findElement(PageObject.getPasswordEntrance());
        passwordEntrance.click();
        passwordEntrance.sendKeys(PASSWORD);
        WebElement entranceButton = this.driver.findElement(PageObject.getEntranceButton());
        entranceButton.click();
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        accessToken = localStorage.getItem("accessToken");

        return accessToken;
    }



}
