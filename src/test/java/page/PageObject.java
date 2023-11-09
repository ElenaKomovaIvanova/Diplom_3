package page;

import org.openqa.selenium.By;
public class PageObject {
    public static By personalAccountButton = By.xpath("/html/body/div/div/header/nav/a/p");
    public static By personalAccountButton1 = By.xpath("xpath/html/body/div/div/header/nav/a");
    public static By register = By.xpath("/html/body/div/div/main/div/div/p[1]/a");
    public static By name = By.xpath("/html/body/div/div/main/div/form/fieldset[1]/div/div/input");
    public static By email = By.xpath("/html/body/div/div/main/div/form/fieldset[2]/div/div/input");
    public static By password = By.xpath("/html/body/div/div/main/div/form/fieldset[3]/div/div/input");
    public static By registerButton = By.xpath("/html/body/div/div/main/div/form/button");
    public static By entranceButton = By.xpath("/html/body/div/div/main/div/form/button");
    public static By emailEntrance = By.xpath("/html/body/div/div/main/div/form/fieldset[1]/div/div/input");
    public static By passwordEntrance = By.xpath("/html/body/div/div/main/div/form/fieldset[2]/div/div/input");
    public static By loginAccountButton = By.xpath("/html/body/div/div/main/section[2]/div/button");
    public static By registerEntranceButton = By.xpath("/html/body/div/div/main/div/div/p/a");
    public static By forgotPasswordButton = By.xpath("/html/body/div/div/main/div/div/p[2]/a");
    public static By forgotEntranceButton = By.xpath("/html/body/div/div/main/div/div/p/a");
    public static By loginAccountText = By.xpath("/html/body/div/div/main/div/h2");
    public static By profileText = By.xpath("/html/body/div/div/main/div/nav/ul/li[1]/a");
    //public static By profileText = By.xpath("/html/body/div/div/main/div/div/div/ul/li[2]/div/div/input");
    public static By delete = By.xpath("/html/body/div/div/section/div[2]");
    public static By constructor = By.xpath("/html/body/div/div/header/nav/ul/li[1]/a/p");
    public static By constructorText = By.xpath("/html/body/div/div/main/section[1]/h1");
    public static By logo = By.xpath("/html/body/div/div/header/nav/div/a");
    public static By exitButton = By.xpath("/html/body/div/div/main/div/nav/ul/li[3]/button");
    public static By inText = By.xpath("/html/body/div/div/main/div/h2");
    public static By bun = By.xpath("/html/body/div/div/main/section[1]/div[1]/div[1]/span");
    public static By sauce = By.xpath("/html/body/div/div/main/section[1]/div[1]/div[2]/span");
    public static By filling = By.xpath("/html/body/div/div/main/section[1]/div[1]/div[3]/span");
    public static By sauceConstructor = By.xpath
            ("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[@class = 'text text_type_main-default' and text()='Соусы']");
    public static By bunConstructor = By.xpath
            ("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[@class = 'text text_type_main-default' and text()='Булки']");
    public static By fillingConstructor = By.xpath
            ("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[@class = 'text text_type_main-default' and text()='Начинки']");







}
