package org.example;

import org.openqa.selenium.By;
public class PageObject {
    //public static By personalAccountButton = By.xpath("/html/body/div/div/header/nav/a/p");
    private static By personalAccountButton = By.xpath("//p[contains(text(),'Личный Кабинет')]");
    //public static By register = By.xpath("/html/body/div/div/main/div/div/p[1]/a");
    private static By register = By.xpath("//a[contains(text(),'Зарегистрироваться')]");

    //public static By name = By.xpath("/html/body/div/div/main/div/form/fieldset[1]/div/div/input");
    private static By name = By.xpath("//fieldset[1]/div/div/input");
    //public static By email = By.xpath("/html/body/div/div/main/div/form/fieldset[2]/div/div/input");
    private static By email = By.xpath("//fieldset[2]/div/div/input");
    //public static By password = By.xpath("/html/body/div/div/main/div/form/fieldset[3]/div/div/input");
    private static By password = By.xpath("//fieldset[3]/div/div/input");
    //public static By registerButton = By.xpath("/html/body/div/div/main/div/form/button");
    private static By registerButton = By.xpath("//button[contains(text(),'Зарегистрироваться')]");
    //public static By entranceButton = By.xpath("/html/body/div/div/main/div/form/button");
    private static By entranceButton = By.xpath
            ("//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    //public static By emailEntrance = By.xpath("/html/body/div/div/main/div/form/fieldset[1]/div/div/input");
    private static By emailEntrance = By.xpath("//input[@name='name']");
    //public static By passwordEntrance = By.xpath("/html/body/div/div/main/div/form/fieldset[2]/div/div/input");
    private static By passwordEntrance = By.xpath("//input[@name='Пароль']");
    //public static By loginAccountButton = By.xpath("/html/body/div/div/main/section[2]/div/button");
    private static By loginAccountButton = By.xpath("//button[contains(text(),'Войти в аккаунт')]");
    //public static By registerEntranceButton = By.xpath("/html/body/div/div/main/div/div/p/a");
    private static By registerEntranceButton = By.xpath("//a[contains(text(),'Зарегистрироваться')]");
    //public static By forgotPasswordButton = By.xpath("/html/body/div/div/main/div/div/p[2]/a");
    private static By forgotPasswordButton = By.xpath("//a[contains(text(),'Восстановить пароль')]");
    //public static By forgotEntranceButton = By.xpath("/html/body/div/div/main/div/div/p/a");
    private static By forgotEntranceButton = By.xpath("//a[@class='Auth_link__1fOlj']");
    //public static By profileText = By.xpath("/html/body/div/div/main/div/nav/ul/li[1]/a");
    //public static By profileText = By.xpath("/html/body/div/div/main/div/div/div/ul/li[2]/div/div/input");
    private static By profileText = By.xpath
            ("//a[@class='Account_link__2ETsJ text text_type_main-medium text_color_inactive Account_link_active__2opc9']");
    //public static By constructor = By.xpath("/html/body/div/div/header/nav/ul/li[1]/a/p");
    private static By constructor = By.xpath("//p[contains(text(),'Конструктор')]");
    //public static By constructorText = By.xpath("/html/body/div/div/main/section[1]/h1");
    private static By constructorText = By.xpath("//h1[@class='text text_type_main-large mb-5 mt-10']");
    //public static By logo = By.xpath("/html/body/div/div/header/nav/div/a");
    private static By logo = By.xpath("//a[@class='active']//*[name()='svg']");
    //public static By exitButton = By.xpath("/html/body/div/div/main/div/nav/ul/li[3]/button");
    private static By exitButton = By.xpath("//button[contains(text(),'Выход')]");
    private static By inText = By.xpath("/html/body/div/div/main/div/h2");
    //public static By bun = By.xpath("/html/body/div/div/main/section[1]/div[1]/div[1]/span");
    private static By bun = By.xpath("//span[contains(text(),'Булки')]");
    //public static By sauce = By.xpath("/html/body/div/div/main/section[1]/div[1]/div[2]/span");
    private static By sauce = By.xpath("//span[contains(text(),'Соусы')]");
    //public static By filling = By.xpath("/html/body/div/div/main/section[1]/div[1]/div[3]/span");
    private static By filling = By.xpath("//span[contains(text(),'Начинки')]");
    private static By sauceConstructor = By.xpath
            ("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[@class = 'text text_type_main-default' and text()='Соусы']");
    private static By bunConstructor = By.xpath
            ("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[@class = 'text text_type_main-default' and text()='Булки']");
    private static By fillingConstructor = By.xpath
            ("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[@class = 'text text_type_main-default' and text()='Начинки']");

    public static By getPersonalAccountButton() {
        return personalAccountButton;
    }

    public static By getRegister() {
        return register;
    }

    public static By getName() {
        return name;
    }

    public static By getEmail() {
        return email;
    }

    public static By getPassword() {
        return password;
    }

    public static By getRegisterButton() {
        return registerButton;
    }

    public static By getEntranceButton() {
        return entranceButton;
    }

    public static By getEmailEntrance() {
        return emailEntrance;
    }

    public static By getPasswordEntrance() {
        return passwordEntrance;
    }

    public static By getLoginAccountButton() {
        return loginAccountButton;
    }

    public static By getRegisterEntranceButton() {
        return registerEntranceButton;
    }

    public static By getForgotPasswordButton() {
        return forgotPasswordButton;
    }

    public static By getForgotEntranceButton() {
        return forgotEntranceButton;
    }

    public static By getProfileText() {
        return profileText;
    }

    public static By getConstructor() {
        return constructor;
    }

    public static By getConstructorText() {
        return constructorText;
    }

    public static By getLogo() {
        return logo;
    }

    public static By getExitButton() {
        return exitButton;
    }

    public static By getInText() {
        return inText;
    }

    public static By getBun() {
        return bun;
    }

    public static By getSauce() {
        return sauce;
    }

    public static By getFilling() {
        return filling;
    }

    public static By getSauceConstructor() {
        return sauceConstructor;
    }

    public static By getBunConstructor() {
        return bunConstructor;
    }

    public static By getFillingConstructor() {
        return fillingConstructor;
    }
}
